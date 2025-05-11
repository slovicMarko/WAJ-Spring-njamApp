package hr.tvz.slovic.njamapp.restorani.repository;

import hr.tvz.slovic.njamapp.restorani.domain.RadnoVrijeme;

import java.util.Map;

public interface RadnoVrijemeRepository {
    Map<String, RadnoVrijeme> findById(Long id);
}
