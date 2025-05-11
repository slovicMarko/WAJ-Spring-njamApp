package hr.tvz.slovic.njamapp.kupci;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Kupac {
    private Long id;
    private String username;
    private String ime;
    private String prezime;
    private Integer godine;
    private String email;
    private String adresa;
    private String grad;
    private LocalDate datumIsteka;
    private Double balans;


    public Kupac(KupacCommand kupacCommand) {
        this.id = kupacCommand.getId();
        this.username = kupacCommand.getUsername();
        this.ime = kupacCommand.getIme();
        this.prezime = kupacCommand.getPrezime();
        this.godine = kupacCommand.getGodine();
        this.email = kupacCommand.getEmail();
        this.adresa = kupacCommand.getGrad();
        this.grad = kupacCommand.getGrad();
        this.datumIsteka = kupacCommand.getDatumIsteka();
        this.balans = kupacCommand.getBalans();
    }

    public String getImeIPrezime() {
        return ime + " " + prezime;
    }

    public Kupac(Long id, String username, String ime, String prezime, Integer godine, String email, String adresa, String grad, LocalDate datumIsteka, Double balans) {
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

