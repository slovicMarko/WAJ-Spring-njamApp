package hr.tvz.slovic.njamapp.restorani.domain;

import hr.tvz.slovic.njamapp.restorani.command.RestoranCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
public class Restoran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    private String adresa;
    private String brojTelefona;
    private String email;
    private Map<String, RadnoVrijeme> radnoVrijeme;
    private boolean trenutnoOtvoren;
    private Integer prosjecnoVrijemeDostave;
    private Integer prosjecnaOcjena;
    private Integer maksimalanBrojNarudzbi;
    private Integer michelinStar;
    private String kratakOpis;
    private String webStranica;
    private boolean vlastitaDostava;

    public Restoran(RestoranCommand restoran) {
        this.id = null;
        this.ime = restoran.getIme();
        this.adresa = restoran.getAdresa();
        this.brojTelefona = restoran.getBrojTelefona();
        this.email = restoran.getEmail();
        this.radnoVrijeme = restoran.getRadnoVrijeme();
        this.trenutnoOtvoren = restoran.isTrenutnoOtvoren();
        this.prosjecnoVrijemeDostave = restoran.getProsjecnoVrijemeDostave();
        this.prosjecnaOcjena = restoran.getProsjecnaOcjena();
        this.maksimalanBrojNarudzbi = restoran.getMaksimalanBrojNarudzbi();
        this.michelinStar = restoran.getMichelinStar();
        this.kratakOpis = restoran.getKratakOpis();
        this.webStranica = restoran.getWebStranica();
        this.vlastitaDostava = restoran.isVlastitaDostava();
    }

    public Restoran(Long id, String ime, String adresa, String brojTelefona, String email, Map<String, RadnoVrijeme> radnoVrijeme, boolean trenutnoOtvoren, Integer prosjecnoVrijemeDostave, Integer prosjecnaOcjena, Integer maksimalanBrojNarudzbi, Integer michelinStar, String kratakOpis, String webStranica, boolean vlastitaDostava) {
        this.id = id;
        this.ime = ime;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.radnoVrijeme = radnoVrijeme;
        this.trenutnoOtvoren = trenutnoOtvoren;
        this.prosjecnoVrijemeDostave = prosjecnoVrijemeDostave;
        this.prosjecnaOcjena = prosjecnaOcjena;
        this.maksimalanBrojNarudzbi = maksimalanBrojNarudzbi;
        this.michelinStar = michelinStar;
        this.kratakOpis = kratakOpis;
        this.webStranica = webStranica;
        this.vlastitaDostava = vlastitaDostava;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, RadnoVrijeme> getRadnoVrijeme() {
        return radnoVrijeme;
    }

    public void setRadnoVrijeme(Map<String, RadnoVrijeme> radnoVrijeme) {
        this.radnoVrijeme = radnoVrijeme;
    }

    public boolean isTrenutnoOtvoren() {
        return trenutnoOtvoren;
    }

    public void setTrenutnoOtvoren(boolean trenutnoOtvoren) {
        this.trenutnoOtvoren = trenutnoOtvoren;
    }

    public Integer getProsjecnoVrijemeDostave() {
        return prosjecnoVrijemeDostave;
    }

    public void setProsjecnoVrijemeDostave(Integer prosjecnoVrijemeDostave) {
        this.prosjecnoVrijemeDostave = prosjecnoVrijemeDostave;
    }

    public Integer getProsjecnaOcjena() {
        return prosjecnaOcjena;
    }

    public void setProsjecnaOcjena(Integer prosjecnaOcjena) {
        this.prosjecnaOcjena = prosjecnaOcjena;
    }

    public Integer getMaksimalanBrojNarudzbi() {
        return maksimalanBrojNarudzbi;
    }

    public void setMaksimalanBrojNarudzbi(Integer maksimalanBrojNarudzbi) {
        this.maksimalanBrojNarudzbi = maksimalanBrojNarudzbi;
    }

    public Integer getMichelinStar() {
        return michelinStar;
    }

    public void setMichelinStar(Integer michelinStar) {
        this.michelinStar = michelinStar;
    }

    public String getKratakOpis() {
        return kratakOpis;
    }

    public void setKratakOpis(String kratakOpis) {
        this.kratakOpis = kratakOpis;
    }

    public String getWebStranica() {
        return webStranica;
    }

    public void setWebStranica(String webStranica) {
        this.webStranica = webStranica;
    }

    public boolean isVlastitaDostava() {
        return vlastitaDostava;
    }

    public void setVlastitaDostava(boolean vlastitaDostava) {
        this.vlastitaDostava = vlastitaDostava;
    }
}
