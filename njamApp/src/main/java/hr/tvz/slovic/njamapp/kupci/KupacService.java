package hr.tvz.slovic.njamapp.kupci;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KupacService implements KupacRepository{

    List<Kupac> kupci = new ArrayList<>(List.of(
            new Kupac(1L, "ivan_h", "Ivan", "Horvat", 28, "ivan.horvat@example.com", "Trg bana Jelačića 1", "Zagreb", LocalDate.of(2026, 5, 10), 1500.50),
            new Kupac(2L, "ana_k", "Ana", "Kovačević", 34, "ana.kovacevic@example.com", "Ilica 2", "Split", LocalDate.of(2027, 3, 15), 2000.75),
            new Kupac(3L, "petar_b", "Petar", "Babić", 40, "petar.babic@example.com", "Ulica kralja Tomislava 3", "Rijeka", LocalDate.of(2025, 8, 20), 300.00),
            new Kupac(4L, "marija_n", "Marija", "Novak", 25, "marija.novak@example.com", "Avenija Dubrovnik 4", "Osijek", LocalDate.of(2028, 1, 5), 5000.00),
            new Kupac(5L, "luka_p", "Luka", "Perić", 30, "luka.peric@example.com", "Zagrebačka ulica 5", "Zadar", LocalDate.of(2029, 6, 30), 1250.25)
    ));

    @Override
    public List<Kupac> findAllKupci() {
        return kupci;
    }

    @Override
    public List<KupacDTO> findAllKupciDTO() {
        return kupci.stream()
                .map(KupacDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<KupacDTO> findKupacDTOByID(Long id) {
        return kupci.stream()
                .filter(kupac -> kupac.getId().equals(id))
                .map(KupacDTO::new)
                .findFirst();
    }

    @Override
    public Optional<Kupac> findKupacByID(Long id) {
        return kupci.stream()
                .filter(kupac -> kupac.getId().equals(id))
                .findFirst();
    }

    @Override
    public void save(KupacCommand kupacCommand) {
        kupci.add(new Kupac(kupacCommand));
    }

    @Override
    public boolean deleteKupac(Long id) {
        Optional<Kupac> kupac = findKupacByID(id);
        if (kupac.isPresent()) {
            kupci.remove(kupac.get());
            return true;
        }
        return false;
    }

    public boolean postojiLiKorisnik(String noviKorisnikUsername) {
        return kupci.stream()
                .anyMatch(kupac -> kupac.getUsername().equals(noviKorisnikUsername));
    }
}
