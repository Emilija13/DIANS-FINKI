package mk.ukim.finki.dians.app.repository;

import mk.ukim.finki.dians.app.model.Heritage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeritageRepository extends JpaRepository<Heritage, Long> {
    @Query("SELECT h FROM Heritage h WHERE " +
            "(:name IS NULL OR h.name LIKE %:name%) AND " +
            "(:city IS NULL OR h.city LIKE %:city%) AND " +
            "(:category IS NULL OR h.category LIKE %:category%)")
    List<Heritage> search(
            String name,
            String city,
            String category
    );

    Optional<Heritage> findById(Long id);

    @Query("SELECT DISTINCT h.city FROM Heritage h")
    List<String> findAllCities();

    @Query("SELECT DISTINCT h.category FROM Heritage h")
    List<String> findAllCategories();
    void deleteById(Long id);
}
