package hr.tvz.slovic.njamapp.restorani.command;

import hr.tvz.slovic.njamapp.restorani.domain.RadnoVrijeme;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestoranCommand {

    @NotBlank(message = "Ime restorana ne smije biti prazno.")
    @Pattern(regexp = "^[A-Za-z0-9čćžšđ ČĆŽŠĐ]{3,50}$", message = "Ime može sadržavati slova (uključujući č,ć,ž,š,đ), brojeve i razmak (3-50 znakova)")
    private String ime;
    @NotBlank(message = "Adresa restorana ne smije biti prazna.")
    private String adresa;
    @NotBlank(message = "Broj telefona ne smije biti prazan.")
    private String brojTelefona;
    @NotBlank(message = "Email adresa ne smije biti prazna.")
    private String email;
    private Map<String, RadnoVrijeme> radnoVrijeme;
    private boolean trenutnoOtvoren;
    private Integer prosjecnoVrijemeDostave;
    private Integer prosjecnaOcjena;
    @PositiveOrZero(message = "Broj narudžbi mora biti pozitivan ili nula.")
    private Integer maksimalanBrojNarudzbi;
    @PositiveOrZero(message = "Michelin zvjezdice moraju biti 0 ili više.")
    private Integer michelinStar;
    @NotBlank(message = "Kratak opis ne smije biti prazan")
    @Size(max = 255, message = "Kratak opis ne smije biti duži od 255 znakova")
    private String kratakOpis;
    @Size(max = 255, message = "Link web stranice ne smije biti duži od 255 znakova")
    private String webStranica;
    private boolean vlastitaDostava;


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
