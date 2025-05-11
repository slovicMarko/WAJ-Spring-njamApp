package hr.tvz.slovic.njamapp.restorani.service;

import hr.tvz.slovic.njamapp.restorani.domain.Restoran;
import hr.tvz.slovic.njamapp.restorani.dto.RestoranDTO;
import hr.tvz.slovic.njamapp.restorani.command.RestoranCommand;

import java.util.List;

public interface RestoranService {
    List<RestoranDTO> findAll();
    List<RestoranDTO> findAllOpen();
    RestoranDTO findRestoranByID(Long id);
    List<RestoranDTO> findRestoranByName(String name);
    List<RestoranDTO> findNajblizi(String adresa, Double minOcjena);
    List<RestoranDTO> findNajbolji(Double ocjena);
    boolean postojiRestoran(String ime, String adresa);
    void dodajRestoran(RestoranCommand restoranCommand);
    boolean obrisiRestoran(Long id);
    List<RestoranDTO> filtriraj(Integer number);
    List<RestoranDTO> otvorenSDostavom();
    List<Restoran> filtriranoPoImenu(String ime);

}
