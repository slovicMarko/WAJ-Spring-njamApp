package hr.tvz.slovic.njamapp.kupci;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KupacRepository {

    List<Kupac> findAllKupci();
    List<KupacDTO> findAllKupciDTO();

    Optional<KupacDTO> findKupacDTOByID(Long id);
    Optional<Kupac> findKupacByID(Long id);
    void save(KupacCommand kupac);

    boolean deleteKupac(Long id);
}
