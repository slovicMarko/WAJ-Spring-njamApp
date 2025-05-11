package hr.tvz.slovic.njamapp.restorani.repository;

import hr.tvz.slovic.njamapp.restorani.domain.Restoran;

import java.util.List;
import java.util.Optional;

public interface RestoranRepository {
    List<Restoran> findAll();
    List<Restoran> findAllOpen();
    List<Restoran> filtriranoPoImenu();
    Optional<Restoran> findRestoranByID(Long id);
    void save(Restoran restoran);
    boolean obrisiRestoran(Long id);
    List<Restoran> otvorenAndImaVlastituDostavu();


}
