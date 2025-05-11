package hr.tvz.slovic.njamapp.kupci;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class KupacCommand {

    @NotNull(message = "ID ne smije biti null.")
    private Long id;

    @NotBlank(message = "Korisničko ime ne smije biti prazno.")
    @Size(min = 3, max = 20, message = "Korisničko ime mora imati između 3 i 20 znakova.")
    private String username;

    @NotBlank(message = "Ime ne smije biti prazno.")
    @Pattern(regexp = "^[A-Za-zčćžšđČĆŽŠĐ-]{2,50}$", message = "Ime može sadržavati samo slova i mora imati između 2 i 50 znakova.")
    private String ime;

    @NotBlank(message = "Prezime ne smije biti prazno.")
    @Pattern(regexp = "^[A-Za-zčćžšđČĆŽŠĐ-]{2,50}$", message = "Prezime može sadržavati samo slova i mora imati između 2 i 50 znakova.")
    private String prezime;

    @NotNull(message = "Godine ne smiju biti null.")
    @Min(value = 18, message = "Kupac mora imati najmanje 18 godina.")
    private Integer godine;

    @NotBlank(message = "Email adresa ne smije biti prazna.")
    @Email(message = "Email adresa mora biti ispravna.")
    private String email;

    @NotBlank(message = "Adresa ne smije biti prazna.")
    private String adresa;

    @NotBlank(message = "Grad ne smije biti prazan.")
    private String grad;

    @Future(message = "Datum mora biti u budućnosti.")
    private LocalDate datumIsteka;

    @Digits(integer = 10, fraction = 2, message = "Balans mora biti broj s najviše 10 znamenki i 2 decimalna mjesta.")
    private Double balans;

    public KupacCommand(Long id, String username, String ime, String prezime, Integer godine, String email, String adresa, String grad, LocalDate datumIsteka, Double balans) {
        this.id = id;
        this.username = username;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.email = email;
        this.adresa = adresa;
        this.grad = grad;
        this.datumIsteka = datumIsteka;
        this.balans = balans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Integer getGodine() {
        return godine;
    }

    public void setGodine(Integer godine) {
        this.godine = godine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public LocalDate getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(LocalDate datumIsteka) {
        this.datumIsteka = datumIsteka;
    }

    public Double getBalans() {
        return balans;
    }

    public void setBalans(Double balans) {
        this.balans = balans;
    }
}
