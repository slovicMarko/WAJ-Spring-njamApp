package hr.tvz.slovic.njamapp.kupci;

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
public class KupacDTO {
    private String imeIPrezime;
    private Integer godine;
    private String email;

    public KupacDTO(Kupac kupac) {
        this.imeIPrezime = kupac.getImeIPrezime();
        this.godine = kupac.getGodine();
        this.email = kupac.getEmail();
    }

}
