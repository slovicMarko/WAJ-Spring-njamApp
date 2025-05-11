package hr.tvz.slovic.njamapp.restorani.repository;

import hr.tvz.slovic.njamapp.restorani.domain.RadnoVrijeme;
import hr.tvz.slovic.njamapp.restorani.domain.Restoran;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Primary
@Repository
public class RestoranJdbcRepository implements RestoranRepository {

    private static final String SELECT_ALL = "SELECT * FROM restoran";

    private static final String SELECT_OTVOREN_I_DOSTAVA = SELECT_ALL
            + " WHERE trenutno_otvoren is true and vlastita_dostava is true";

    private static final String FILTRIRAJ_PO_IMENU = SELECT_ALL
            + " WHERE LOWER(ime) LIKE LOWER(CONCAT('%', ?, '%'))";


    String MAX_ID_RESTORAN = "SELECT COALESCE(MAX(id), 0) FROM restoran";
    String MAX_ID_RESTORAN_RADNO_VRIJEME = "SELECT COALESCE(MAX(id), 0) FROM restoran_radno_vrijeme";


    private static final String SQL_INSERT_RESTORAN = "INSERT INTO restoran (id, ime, adresa, broj_telefona, email, trenutno_otvoren, prosjecno_vrijeme_dostave, prosjecna_ocjena, maksimalan_broj_narudzbi, michelin_star, kratak_opis, web_stranica, vlastita_dostava) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_INSERT_RESTORAN_RADNO_VRIJEME = "INSERT INTO restoran_radno_vrijeme (id, restoran_id, dan, radno_vrijeme_id) " +
            "VALUES (?, ?, ?, ?)";

    private RadnoVrijemeRepositoryJdbc radnoVrijemeRepositoryJdbc;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public RestoranJdbcRepository(JdbcTemplate jdbcTemplate, RadnoVrijemeRepositoryJdbc radnoVrijemeRepositoryJdbc) {
        this.jdbcTemplate = jdbcTemplate;
        this.radnoVrijemeRepositoryJdbc = radnoVrijemeRepositoryJdbc;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("restoran")
                .usingGeneratedKeyColumns("id");
    }

    private Restoran mapRowToRestoran(ResultSet rs, int rowNum) throws SQLException {
        Long restoranId = rs.getLong("id");
        String restoranIme = rs.getString("ime");
        String restoranAdresa = rs.getString("adresa");
        String restoranBrojTelefona = rs.getString("broj_telefona");
        String restoranEmail = rs.getString("email");
        boolean trenutnoOtvoren = rs.getBoolean("trenutno_otvoren");
        Integer prosjecnoVrijemeDostave = rs.getInt("prosjecno_vrijeme_dostave");
        Integer prosjecnaOcjena = rs.getInt("prosjecna_ocjena");
        Integer maksimalanBrojNarudzbi = rs.getInt("maksimalan_broj_narudzbi");
        Integer michelinStar = rs.getInt("michelin_star");
        String kratakOpis = rs.getString("kratak_opis");
        String webStranica = rs.getString("web_stranica");
        boolean vlastitaDostava = rs.getBoolean("vlastita_dostava");

        Map<String, RadnoVrijeme> radnoVrijeme = radnoVrijemeRepositoryJdbc.findById(restoranId);

        return new Restoran(restoranId,
                restoranIme,
                restoranAdresa,
                restoranBrojTelefona,
                restoranEmail,
                radnoVrijeme,
                trenutnoOtvoren,
                prosjecnoVrijemeDostave,
                prosjecnaOcjena,
                maksimalanBrojNarudzbi,
                michelinStar,
                kratakOpis,
                webStranica,
                vlastitaDostava);
    }


    @Override
    public List<Restoran> findAll() {
        return jdbcTemplate.query(SELECT_ALL, this::mapRowToRestoran);
    }

    public List<Restoran> findAllOpen() {
        String sql = "SELECT * FROM restoran WHERE trenutno_otvoren = TRUE";
        return jdbcTemplate.query(sql, this::mapRowToRestoran);
    }

    @Override
    public List<Restoran> filtriranoPoImenu() {
        return null;
    }

    @Override
    public Optional<Restoran> findRestoranByID(Long id) {
        String sql = "SELECT * FROM restoran WHERE id = ?";
        List<Restoran> restorani = jdbcTemplate.query(sql, this::mapRowToRestoran, id);
        return restorani.isEmpty() ? Optional.empty() : Optional.of(restorani.get(0));
    }

    @Transactional(rollbackFor = SQLException.class)
    @Override
    public void save(Restoran restoran) {

        if (restoran.getId() == null) {
            Long nextId = getNextId(MAX_ID_RESTORAN);
            restoran.setId(nextId);

            jdbcTemplate.update(SQL_INSERT_RESTORAN,
                    restoran.getId(),
                    restoran.getIme(),
                    restoran.getAdresa(),
                    restoran.getBrojTelefona(),
                    restoran.getEmail(),
                    restoran.isTrenutnoOtvoren(),
                    restoran.getProsjecnoVrijemeDostave(),
                    restoran.getProsjecnaOcjena(),
                    restoran.getMaksimalanBrojNarudzbi(),
                    restoran.getMichelinStar(),
                    restoran.getKratakOpis(),
                    restoran.getWebStranica(),
                    restoran.isVlastitaDostava()
            );

            if (restoran.getRadnoVrijeme() != null && !restoran.getRadnoVrijeme().isEmpty()) {
                Map<String, RadnoVrijeme> radnoVrijeme = restoran.getRadnoVrijeme();

                for (Map.Entry<String, RadnoVrijeme> entry : radnoVrijeme.entrySet()) {
                    String dan = entry.getKey();
                    dan = dan.replaceAll("'", "").toUpperCase();
                    RadnoVrijeme radno = entry.getValue();

                    Long nextRadnoVrijemeId = getNextId(MAX_ID_RESTORAN_RADNO_VRIJEME);
                    Long radnoVrijemeId = (long) (radno.ordinal() + 1);

                    jdbcTemplate.update(SQL_INSERT_RESTORAN_RADNO_VRIJEME,
                            nextRadnoVrijemeId,
                            restoran.getId(),
                            dan,
                            radnoVrijemeId
                    );
                }
            }


        } else {
            String sql = "UPDATE restoran SET ime = ?, adresa = ?, broj_telefona = ?, email = ?, trenutno_otvoren = ?, prosjecno_vrijeme_dostave = ?, prosjecna_ocjena = ?, maksimalan_broj_narudzbi = ?, michelin_star = ?, kratak_opis = ?, web_stranica = ?, vlastita_dostava = ? WHERE id = ?";
            jdbcTemplate.update(sql,
                    restoran.getIme(),
                    restoran.getAdresa(),
                    restoran.getBrojTelefona(),
                    restoran.getEmail(),
                    restoran.isTrenutnoOtvoren(),
                    restoran.getProsjecnoVrijemeDostave(),
                    restoran.getProsjecnaOcjena(),
                    restoran.getMaksimalanBrojNarudzbi(),
                    restoran.getMichelinStar(),
                    restoran.getKratakOpis(),
                    restoran.getWebStranica(),
                    restoran.isVlastitaDostava(),
                    restoran.getId()
            );
        }
    }

    private Map<String, Object> restoranToMap(Restoran restoran) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ime", restoran.getIme());
        parameters.put("adresa", restoran.getAdresa());
        parameters.put("broj_telefona", restoran.getBrojTelefona());
        parameters.put("email", restoran.getEmail());
        parameters.put("trenutno_otvoren", restoran.isTrenutnoOtvoren());
        parameters.put("prosjecno_vrijeme_dostave", restoran.getProsjecnoVrijemeDostave());
        parameters.put("prosjecna_ocjena", restoran.getProsjecnaOcjena());
        parameters.put("maksimalan_broj_narudzbi", restoran.getMaksimalanBrojNarudzbi());
        parameters.put("michelin_star", restoran.getMichelinStar());
        parameters.put("kratak_opis", restoran.getKratakOpis());
        parameters.put("web_stranica", restoran.getWebStranica());
        parameters.put("vlastita_dostava", restoran.isVlastitaDostava());
        return parameters;
    }


    @Override
    public boolean obrisiRestoran(Long id) {
        String sql = "DELETE FROM restoran WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0;
    }

    @Override
    public List<Restoran> otvorenAndImaVlastituDostavu() {

        return jdbcTemplate.query(SELECT_OTVOREN_I_DOSTAVA, this::mapRowToRestoran);
    }

    public Long getMaxId(String sql) {
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    public Long getNextId(String sql) {
        Long maxId = getMaxId(sql);
        return maxId + 1;
    }
}
