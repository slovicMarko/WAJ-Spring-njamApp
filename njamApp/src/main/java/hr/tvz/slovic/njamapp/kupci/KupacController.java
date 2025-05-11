package hr.tvz.slovic.njamapp.kupci;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kupci")
public class KupacController {

    private final KupacService kupacService;

    public KupacController(KupacService kupacService) {
        this.kupacService = kupacService;
    }

    @GetMapping
    public List<KupacDTO> getAllKupci() {
        return kupacService.findAllKupciDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KupacDTO> getKupacByID(@PathVariable Long id) {
        Optional<KupacDTO> kupci = kupacService.findKupacDTOByID(id);
        return kupci.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/dodaj")
    public ResponseEntity<String> dodajRestoran(@Valid @RequestBody KupacCommand kupacCommand) {
        if (kupacService.postojiLiKorisnik(kupacCommand.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Kupac s tim usernameom već postoji.");
        }
        kupacService.save(kupacCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body("Kupac uspješno dodan.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> obrisiRestoran(@PathVariable Long id) {
        boolean obrisan = kupacService.deleteKupac(id);
        if (obrisan) {
            return ResponseEntity.ok("Kupac uspješno obrisan.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kupac nije pronađen.");
    }
}

