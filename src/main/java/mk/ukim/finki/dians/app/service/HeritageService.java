package mk.ukim.finki.dians.app.service;

import mk.ukim.finki.dians.app.model.Heritage;

import java.util.List;
import java.util.Optional;

public interface HeritageService {
     List<Heritage> findAll();
     List<String> findAllCities();
     List<String> findAllCategories();
     Optional<Heritage> findById(Long id);
     void save(String name, String city, String category, Double lat, Double lon);
     void update(Long id, String name, String city, String category, Double lat, Double lon);
     List<Heritage> search(String name, String city, String category);
     void deleteHeritages(List<Long> heritageIds);
}
