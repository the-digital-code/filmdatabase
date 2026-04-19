package thedigital.filmdatabase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thedigital.filmdatabase.model.Genre;
import thedigital.filmdatabase.model.Rating;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Director is required")
    private String director;

    @NotNull(message = "Genre is required")
    private Genre genre;

    @NotNull(message = "Rating is required")
    private Rating rating;

    @PastOrPresent(message = "Release date cannot be in the future")
    private LocalDate releaseDate;
}
