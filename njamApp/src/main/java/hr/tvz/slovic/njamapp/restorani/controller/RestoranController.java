package hr.tvz.slovic.njamapp.restorani.controller;

import hr.tvz.slovic.njamapp.restorani.domain.Restoran;
import hr.tvz.slovic.njamapp.restorani.dto.RestoranDTO;
import hr.tvz.slovic.njamapp.restorani.command.RestoranCommand;
import hr.tvz.slovic.njamapp.restorani.repository.RestoranJdbcRepository;
import hr.tvz.slovic.njamapp.restorani.service.RestoranService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/restorani")
public class RestoranController {
    private final RestoranService restoranService;
    private final RestoranJdbcRepository restoranJdbcRepository;

    public RestoranController(RestoranService restoranService, RestoranJdbcRepository restoranJdbcRepository) {
        this.restoranService = restoranService;
        this.restoranJdbcRepository = restoranJdbcRepository;
    }

    @GetMapping
    public List<RestoranDTO> getAllRestorani() {
        return restoranService.findAll();
    }

    @GetMapping("/svi")
    public List<Restoran> getAll() {
        return restoranJdbcRepository.findAll();
    }

    @GetMapping("/zvjezdice")
    public List<RestoranDTO> getRestoraniPoZvjezdicama(@RequestParam Integer number) {
        return restoranService.filtriraj(number);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestoranDTO> getRestoranByID(@PathVariable Long id) {
        Optional<RestoranDTO> restoran = Optional.ofNullable(restoranService.findRestoranByID(id));
        return restoran.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



    @GetMapping("/restorani/pretraga")
    public List<Restoran> pretraziRestorane(@RequestParam String ime) {
        return restoranService.filtriranoPoImenu(ime);
    }

    @GetMapping("/otvoren-s-dostavom")
    public ResponseEntity<List<RestoranDTO>> otvorenSDostavom() {
        List<RestoranDTO> restorani = restoranService.otvorenSDostavom();
        if (restorani.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(restorani);
    }

    @GetMapping("/najbolji")
    public List<RestoranDTO> getNajboljiRestorani(@RequestParam Double ocjena) {
        return restoranService.findNajbolji(ocjena);
    }

    @GetMapping("/svi-otvoreni")
    public List<RestoranDTO> getSviOtvoreni() {
        return restoranService.findAllOpen();
    }

    @GetMapping("/najblizi")
    public List<RestoranDTO> getNajbliziRestorani(
            @RequestParam String adresa,
            @RequestParam Double minOcjena) {

        return restoranService.findNajblizi(adresa, minOcjena);
    }

    @PostMapping("/dodaj")
    public ResponseEntity<String> dodajRestoran(@Valid @RequestBody RestoranCommand restoranCommand) {
        if (restoranService.postojiRestoran(restoranCommand.getIme(), restoranCommand.getAdresa())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Restoran s tom adresom već postoji.");
        }
        restoranService.dodajRestoran(restoranCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body("Restoran uspješno dodan.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> obrisiRestoran(@PathVariable Long id) {
        boolean obrisan = restoranService.obrisiRestoran(id);
        if (obrisan) {
            return ResponseEntity.ok("Restoran uspješno obrisan.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restoran nije pronađen.");
    }


}