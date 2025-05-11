package hr.tvz.slovic.njamapp.restorani.service;

import hr.tvz.slovic.njamapp.restorani.domain.Restoran;
import hr.tvz.slovic.njamapp.restorani.dto.RestoranDTO;
import hr.tvz.slovic.njamapp.restorani.command.RestoranCommand;
import hr.tvz.slovic.njamapp.restorani.repository.RestoranRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RestoranServiceImpl implements RestoranService {
    private final RestoranRepository restoranRepository;



    public RestoranServiceImpl(RestoranRepository restoranRepository) {
        this.restoranRepository = restoranRepository;
    }

    @Override
    public List<RestoranDTO> findAll() {
        return restoranRepository.findAll().stream()
                .map(r -> new RestoranDTO(r.getId(), r.getIme(), r.getAdresa(), r.isTrenutnoOtvoren(), r.getProsjecnaOcjena(), r.getWebStranica(), r.isVlastitaDostava(), 20, r.getMaksimalanBrojNarudzbi()))
                .collect(Collectors.toList());
    }

    public List<RestoranDTO> findAllOpen() {
        return restoranRepository.findAllOpen().stream()
                .map(r -> new RestoranDTO(r.getId(), r.getIme(), r.getAdresa(), r.isTrenutnoOtvoren(), r.getProsjecnaOcjena(), r.getWebStranica(), r.isVlastitaDostava(), 20, r.getMaksimalanBrojNarudzbi()))
                .collect(Collectors.toList());
    }

    @Override
    public RestoranDTO findRestoranByID(Long id) {
        return restoranRepository.findRestoranByID(id)
                .map(r -> new RestoranDTO(r.getId(), r.getIme(), r.getAdresa(), r.isTrenutnoOtvoren(), r.getProsjecnaOcjena(), r.getWebStranica(), r.isVlastitaDostava(), 20, r.getMaksimalanBrojNarudzbi()))
                .orElse(null);
    }

    @Override
    public List<RestoranDTO> findRestoranByName(String name) {
        return restoranRepository.findAll().stream()
                .filter(restoran -> restoran.getIme().equalsIgnoreCase(name))
                .map(restoran -> new RestoranDTO(restoran.getId(),
                        restoran.getIme(),
                        restoran.getAdresa(),
                        restoran.isTrenutnoOtvoren(),
                        restoran.getProsjecnaOcjena(),
                        restoran.getWebStranica(),
                        restoran.isVlastitaDostava(),
                        20,
                        restoran.getMaksimalanBrojNarudzbi()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RestoranDTO> findNajblizi(String adresa, Double minOcjena) {
        Random random = new Random();

        return restoranRepository.findAll().stream()
                .map(r -> {
                    double randomOcjena;
                    do {
                        randomOcjena = 1.0 + (5.0 - 1.0) * random.nextDouble();
                    } while (randomOcjena <= minOcjena);

                    return new RestoranDTO(r.getId(), r.getIme(), r.getAdresa(), r.isTrenutnoOtvoren(), r.getProsjecnaOcjena(), r.getWebStranica(), r.isVlastitaDostava(), 20, r.getMaksimalanBrojNarudzbi());
                })
                .collect(Collectors.toList());
    }
    @Override
    public List<RestoranDTO> findNajbolji(Double ocjena) {
        return restoranRepository.findAll().stream()
                .filter(r -> r.getProsjecnaOcjena() >= ocjena)
                .sorted(Comparator.comparingDouble(Restoran::getProsjecnaOcjena).reversed())
                .map(r -> new RestoranDTO(r.getId(), r.getIme(), r.getAdresa(), r.isTrenutnoOtvoren(), r.getProsjecnaOcjena(), r.getWebStranica(), r.isVlastitaDostava(), 20, r.getMaksimalanBrojNarudzbi()))
                .collect(Collectors.toList());
    }

    public boolean postojiRestoran(String ime, String adresa) {
        return restoranRepository.findAll().stream()
                .anyMatch(r -> r.getIme().equalsIgnoreCase(ime) && r.getAdresa().equalsIgnoreCase(adresa));
    }

    public void dodajRestoran(RestoranCommand restoranCommand) {
        Restoran restoran = new Restoran(restoranCommand);
        restoranRepository.save(restoran);
    }

    @Override
    public List<RestoranDTO> filtriraj(Integer number) {
        return restoranRepository.findAll().stream()
                .filter(r -> r.getProsjecnaOcjena().equals(number))
                .map(r -> new RestoranDTO(r.getId(), r.getIme(), r.getAdresa(), r.isTrenutnoOtvoren(), r.getProsjecnaOcjena(), r.getWebStranica(), r.isVlastitaDostava(), 20, r.getMaksimalanBrojNarudzbi()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RestoranDTO> otvorenSDostavom() {
        return restoranRepository.otvorenAndImaVlastituDostavu().stream()
                .map(r -> new RestoranDTO(r.getId(), r.getIme(), r.getAdresa(), r.isTrenutnoOtvoren(), r.getProsjecnaOcjena(), r.getWebStranica(), r.isVlastitaDostava(), 20, r.getMaksimalanBrojNarudzbi()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Restoran> filtriranoPoImenu(String ime) {
        return null;
    }

    @Override
    public boolean obrisiRestoran(Long id) {
        return restoranRepository.obrisiRestoran(id);
    }

}