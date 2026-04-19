package thedigital.filmdatabase.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thedigital.filmdatabase.dto.FilmDto;
import thedigital.filmdatabase.model.Genre;
import thedigital.filmdatabase.model.Rating;
import thedigital.filmdatabase.service.FilmService;

import java.util.List;

@RestController
@RequestMapping("/api/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    /** GET /api/films — retrieve all films */
    @GetMapping
    public ResponseEntity<List<FilmDto>> getAll() {
        return ResponseEntity.ok(filmService.getAll());
    }

    /** GET /api/films/{id} — retrieve a single film */
    @GetMapping("/{id}")
    public ResponseEntity<FilmDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.getById(id));
    }

    /** POST /api/films — create a new film */
    @PostMapping
    public ResponseEntity<FilmDto> create(@RequestBody FilmDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmService.create(dto));
    }

    /** PUT /api/films/{id} — update an existing film */
    @PutMapping("/{id}")
    public ResponseEntity<FilmDto> update(@PathVariable Long id, @RequestBody FilmDto dto) {
        return ResponseEntity.ok(filmService.update(id, dto));
    }

    /** DELETE /api/films/{id} — delete a film */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filmService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /** GET /api/films/search?title=... — search by title keyword */
    @GetMapping("/search")
    public ResponseEntity<List<FilmDto>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(filmService.searchByTitle(title));
    }

    /** GET /api/films/genre/{genre} — filter by genre */
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<FilmDto>> getByGenre(@PathVariable Genre genre) {
        return ResponseEntity.ok(filmService.getByGenre(genre));
    }

    /** GET /api/films/rating/{rating} — filter by rating */
    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<FilmDto>> getByRating(@PathVariable Rating rating) {
        return ResponseEntity.ok(filmService.getByRating(rating));
    }
}
