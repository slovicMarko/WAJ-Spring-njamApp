package hr.tvz.slovic.njamapp.restorani.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestoranDTO {
    private Long id;
    private String ime;
    private String adresa;
    private boolean trenutnoOtvoren;
    private double opterecenost;
    private int ocjena;
    private String webStranica;
    private boolean vlastitaDostava;

    public RestoranDTO(Long id, String ime, String adresa, boolean trenutnoOtvoren, int ocjena, String webStranica,
                       boolean vlastitaDostava, int brojNarudzbi, int maxNarudzbi) {
        this.id = id;
        this.ime = ime;
        this.adresa = adresa;
        this.trenutnoOtvoren = trenutnoOtvoren;
        this.ocjena = ocjena;
        this.webStranica = webStranica;
        this.vlastitaDostava = vlastitaDostava;
        this.opterecenost = (double) brojNarudzbi / maxNarudzbi * 100;
    }
}
