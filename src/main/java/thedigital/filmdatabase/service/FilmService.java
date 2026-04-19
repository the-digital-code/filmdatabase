package thedigital.filmdatabase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thedigital.filmdatabase.dto.FilmDto;
import thedigital.filmdatabase.model.Film;
import thedigital.filmdatabase.model.Genre;
import thedigital.filmdatabase.model.Rating;
import thedigital.filmdatabase.persistence.FilmRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    /** Create a new film. */
    public FilmDto create(FilmDto dto) {
        Film film = toEntity(dto);
        return toDto(filmRepository.save(film));
    }

    /** Get all films. */
    public List<FilmDto> getAll() {
        return filmRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    /** Get a single film by ID. */
    public FilmDto getById(Long id) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found with id: " + id));
        return toDto(film);
    }

    /** Update an existing film. */
    public FilmDto update(Long id, FilmDto dto) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found with id: " + id));
        film.setTitle(dto.getTitle());
        film.setDirector(dto.getDirector());
        film.setGenre(dto.getGenre());
        film.setRating(dto.getRating());
        film.setReleaseDate(dto.getReleaseDate());
        return toDto(filmRepository.save(film));
    }

    /** Delete a film by ID. */
    public void delete(Long id) {
        filmRepository.deleteById(id);
    }

    /** Search films by genre. */
    public List<FilmDto> getByGenre(Genre genre) {
        return filmRepository.findByGenre(genre)
                .stream().map(this::toDto).collect(Collectors.toList());
    }

    /** Search films by rating. */
    public List<FilmDto> getByRating(Rating rating) {
        return filmRepository.findByRating(rating)
                .stream().map(this::toDto).collect(Collectors.toList());
    }

    /** Search films by title keyword. */
    public List<FilmDto> searchByTitle(String keyword) {
        return filmRepository.findByTitleContainingIgnoreCase(keyword)
                .stream().map(this::toDto).collect(Collectors.toList());
    }

    // --- Mapping helpers ---

    private FilmDto toDto(Film film) {
        return new FilmDto(
                film.getId(),
                film.getTitle(),
                film.getDirector(),
                film.getGenre(),
                film.getRating(),
                film.getReleaseDate()
        );
    }

    private Film toEntity(FilmDto dto) {
        Film film = new Film();
        film.setTitle(dto.getTitle());
        film.setDirector(dto.getDirector());
        film.setGenre(dto.getGenre());
        film.setRating(dto.getRating());
        film.setReleaseDate(dto.getReleaseDate());
        return film;
    }
}
