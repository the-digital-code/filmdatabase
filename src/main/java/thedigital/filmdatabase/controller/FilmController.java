package thedigital.filmdatabase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
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
@Tag(name = "Film", description = "The Film Management API")
public class FilmController {

    private final FilmService filmService;

    /** GET /api/films — retrieve all films */
    @GetMapping
    @Operation(summary = "Get all films", description = "Retrieve a list of all films in the database")
    public ResponseEntity<List<FilmDto>> getAll() {
        return ResponseEntity.ok(filmService.getAll());
    }

    /** GET /api/films/{title} — retrieve a single film */
    @GetMapping("/{title}")
    @Operation(summary = "Get film by title", description = "Retrieve a single film by its unique title")
    public ResponseEntity<FilmDto> getByTitle(@PathVariable String title) {
        return ResponseEntity.ok(filmService.getByTitle(title));
    }

    /** POST /api/films — create a new film */
    @PostMapping
    @Operation(summary = "Create a new film", description = "Add a new film to the database")
    public ResponseEntity<FilmDto> create(@Valid @RequestBody FilmDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmService.create(dto));
    }

    /** PUT /api/films/{id} — update an existing film */
    @PutMapping("/{id}")
    @Operation(summary = "Update a film", description = "Update the details of an existing film by its ID")
    public ResponseEntity<FilmDto> update(@PathVariable Long id, @Valid @RequestBody FilmDto dto) {
        return ResponseEntity.ok(filmService.update(id, dto));
    }

    /** DELETE /api/films/{id} — delete a film */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a film", description = "Remove a film from the database by its id")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filmService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /** GET /api/films/search?title=... — search by title keyword */
    @GetMapping("/search")
    @Operation(summary = "Search films by title", description = "Search for films whose titles contain the specified keyword")
    public ResponseEntity<List<FilmDto>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(filmService.searchByTitle(title));
    }

    /** GET /api/films/genre/{genre} — filter by genre */
    @GetMapping("/genre/{genre}")
    @Operation(summary = "Get films by genre", description = "Retrieve a list of films filtered by a specific genre")
    public ResponseEntity<List<FilmDto>> getByGenre(@PathVariable Genre genre) {
        return ResponseEntity.ok(filmService.getByGenre(genre));
    }

    /** GET /api/films/rating/{rating} — filter by rating */
    @GetMapping("/rating/{rating}")
    @Operation(summary = "Get films by rating", description = "Retrieve a list of films filtered by a specific rating")
    public ResponseEntity<List<FilmDto>> getByRating(@PathVariable Rating rating) {
        return ResponseEntity.ok(filmService.getByRating(rating));
    }
}
