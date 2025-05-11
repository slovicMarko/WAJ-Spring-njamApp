package hr.tvz.slovic.njamapp.restorani.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


public class Review {
//    @Id
    private Long id;
    private String naslov;
    private String tekst;
    private Integer ocjena;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Integer getOcjena() {
        return ocjena;
    }

    public void setOcjena(Integer ocjena) {
        this.ocjena = ocjena;
    }
}
