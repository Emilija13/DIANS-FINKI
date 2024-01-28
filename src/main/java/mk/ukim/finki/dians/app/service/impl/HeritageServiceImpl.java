package mk.ukim.finki.dians.app.service.impl;

import mk.ukim.finki.dians.app.model.Heritage;
import mk.ukim.finki.dians.app.repository.HeritageRepository;
import mk.ukim.finki.dians.app.service.HeritageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeritageServiceImpl implements HeritageService {

    @Autowired
    private HeritageRepository heritageRepository;


    public List<Heritage> findAll() {
        return heritageRepository.findAll();
    }


    public List<String> findAllCities() {
        return heritageRepository.findAllCities();
    }
    public List<String> findAllCategories() {
        return heritageRepository.findAllCategories();
    }
    public Optional<Heritage> findById(Long id){return heritageRepository.findById(id);}
    public void save(String name, String city, String category, Double lat, Double lon){
        Heritage heritage = new Heritage(name, city, category, lat, lon);
        heritageRepository.save(heritage);
    }

    public void update(Long id, String name, String city, String category, Double lat, Double lon){
        if(heritageRepository.findById(id).isPresent()){
            Heritage heritage = new Heritage(id, name, city, category, lat, lon);
            heritageRepository.save(heritage);
        }
    }

    public List<Heritage> search(String name, String city, String category) {
       return heritageRepository.search(name, city, category);
    }
    public void deleteHeritages(List<Long> heritageIds) {
        for (Long heritageId : heritageIds) {
            heritageRepository.deleteById(heritageId);
        }
    }

}