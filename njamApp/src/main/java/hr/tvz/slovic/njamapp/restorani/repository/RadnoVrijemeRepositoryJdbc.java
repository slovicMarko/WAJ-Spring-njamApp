package hr.tvz.slovic.njamapp.restorani.repository;

import hr.tvz.slovic.njamapp.restorani.domain.RadnoVrijeme;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RadnoVrijemeRepositoryJdbc implements RadnoVrijemeRepository {

    private static final String SELECT_DAN_RADNO_VRIJEME = """
            SELECT DISTINCT rrv.id, rrv.dan, rv.naziv
            FROM public.RADNO_VRIJEME rv
            JOIN restoran_radno_vrijeme rrv ON rv.id = rrv.radno_vrijeme_id
            WHERE rrv.restoran_id = ?
            ORDER BY rrv.id;
            """;


    private final JdbcTemplate jdbcTemplate;

    public RadnoVrijemeRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map<String, RadnoVrijeme> findById(Long id) {
        return findRadnoVrijemeZaRestoran(id);
    }

    public Map<String, RadnoVrijeme> findRadnoVrijemeZaRestoran(Long restoranId) {
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(SELECT_DAN_RADNO_VRIJEME);
            ps.setLong(1, restoranId);
            return ps;
        }, rs -> {
            Map<String, RadnoVrijeme> map = new HashMap<>();

            while (rs.next()) {
                String dan = rs.getString("dan");
                RadnoVrijeme radnoVrijeme = RadnoVrijeme.valueOf(rs.getString("naziv"));
                map.put(dan, radnoVrijeme);
            }

            return map;
        });
    }
}
