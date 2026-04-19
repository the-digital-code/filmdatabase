package thedigital.filmdatabase.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thedigital.filmdatabase.model.Film;
import thedigital.filmdatabase.model.Genre;
import thedigital.filmdatabase.model.Rating;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByGenre(Genre genre);

    List<Film> findByRating(Rating rating);

    List<Film> findByTitleContainingIgnoreCase(String title);

    Optional<Film> findByTitle(String title);
}
