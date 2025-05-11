package hr.tvz.slovic.njamapp.restorani.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum RadnoVrijeme {
    JUTARNJA_SMJENA("08:00 - 14:00"),
    POPODNEVNA_SMJENA("14:00 - 22:00"),
    CIJELI_DAN("08:00 - 22:00"),
    NERADNI_DAN("Zatvoreno");

    private final String vrijeme;

    RadnoVrijeme(String vrijeme) {
        this.vrijeme = vrijeme;
    }

}
