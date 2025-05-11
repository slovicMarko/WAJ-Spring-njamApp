package hr.tvz.slovic.njamapp.restorani.repository;

import hr.tvz.slovic.njamapp.restorani.domain.Restoran;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MockRestoranRepositoryImpl implements RestoranRepository {

    private List<Restoran> restorani = new ArrayList<>();
//    private List<Restoran> restorani = new ArrayList<>(List.of(
//            new Restoran(1L, "Restoran 1", "Adresa 1", "098123456", "restoran1@email.com",
//                    Map.of("PONEDJELJAK", RadnoVrijeme.JUTARNJA_SMJENA,
//                            "UTORAK", RadnoVrijeme.POPODNEVNA_SMJENA,
//                            "SRIJEDA", RadnoVrijeme.JUTARNJA_SMJENA,
//                            "CETVRTAK", RadnoVrijeme.POPODNEVNA_SMJENA,
//                            "PETAK", RadnoVrijeme.JUTARNJA_SMJENA,
//                            "SUBOTA", RadnoVrijeme.NERADNI_DAN,
//                            "NEDJELJA", RadnoVrijeme.NERADNI_DAN),
//                    true, 30, 4, 50, 4, "Restoran 1"),
//
//            new Restoran(2L, "Restoran 2", "Adresa 2", "097654321", "restoran2@email.com",
//                    Map.of("PONEDELJAK", RadnoVrijeme.CIJELI_DAN,
//                            "UTORAK", RadnoVrijeme.POPODNEVNA_SMJENA,
//                            "SRIJEDA", RadnoVrijeme.CIJELI_DAN,
//                            "CETVRTAK", RadnoVrijeme.POPODNEVNA_SMJENA,
//                            "PETAK", RadnoVrijeme.NERADNI_DAN,
//                            "SUBOTA", RadnoVrijeme.NERADNI_DAN,
//                            "NEDJELJA", RadnoVrijeme.NERADNI_DAN),
//                    false, 25, 2, 30, 4, "Restoran 2"),
//
//            new Restoran(3L, "Restoran 3", "Adresa 3", "099111222", "restoran3@email.com",
//                    Map.of("PONEDELJAK", RadnoVrijeme.POPODNEVNA_SMJENA,
//                            "UTORAK", RadnoVrijeme.JUTARNJA_SMJENA,
//                            "SRIJEDA", RadnoVrijeme.CIJELI_DAN,
//                            "CETVRTAK", RadnoVrijeme.CIJELI_DAN,
//                            "PETAK", RadnoVrijeme.JUTARNJA_SMJENA,
//                            "SUBOTA", RadnoVrijeme.POPODNEVNA_SMJENA,
//                            "NEDJELJA", RadnoVrijeme.NERADNI_DAN),
//                    true, 20, 1, 45, 4, "Restoran 3"),
//
//            new Restoran(4L, "Restoran 4", "Adresa 4", "091333444", "restoran4@email.com",
//                    Map.of("PONEDELJAK", RadnoVrijeme.JUTARNJA_SMJENA,
//                            "UTORAK", RadnoVrijeme.POPODNEVNA_SMJENA,
//                            "SRIJEDA", RadnoVrijeme.NERADNI_DAN,
//                            "CETVRTAK", RadnoVrijeme.CIJELI_DAN,
//                            "PETAK", RadnoVrijeme.POPODNEVNA_SMJENA,
//                            "SUBOTA", RadnoVrijeme.CIJELI_DAN,
//                            "NEDJELJA", RadnoVrijeme.JUTARNJA_SMJENA),
//                    true, 15, 4, 40, 4, "Restoran 4"),
//
//            new Restoran(5L, "Restoran 5", "Adresa 5", "095555666", "restoran5@email.com",
//                    Map.of("PONEDELJAK", RadnoVrijeme.CIJELI_DAN,
//                            "UTORAK", RadnoVrijeme.CIJELI_DAN,
//                            "SRIJEDA", RadnoVrijeme.CIJELI_DAN,
//                            "CETVRTAK", RadnoVrijeme.POPODNEVNA_SMJENA,
//                            "PETAK", RadnoVrijeme.POPODNEVNA_SMJENA,
//                            "SUBOTA", RadnoVrijeme.NERADNI_DAN,
//                            "NEDJELJA", RadnoVrijeme.NERADNI_DAN),
//                    false, 18, 5, 35, 4, "Restoran 5")
//    ));

    @Override
    public List<Restoran> findAll() {
        return restorani;
    }

    @Override
    public List<Restoran> findAllOpen() {
        return restorani.stream()
                .filter(Restoran::isTrenutnoOtvoren)
                .collect(Collectors.toList());
    }

    @Override
    public List<Restoran> filtriranoPoImenu() {
        return null;
    }

    @Override
    public Optional<Restoran> findRestoranByID(Long id) {
        return restorani.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    @Override
    public void save(Restoran restoran) {
        restorani.add(restoran);
        System.out.println(1234);
    }

    @Override
    public boolean obrisiRestoran(Long id) {
        Optional<Restoran> restoran = findRestoranByID(id);
        if (restoran.isPresent()) {
            restorani.remove(restoran.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Restoran> otvorenAndImaVlastituDostavu() {
        return null;
    }
}
