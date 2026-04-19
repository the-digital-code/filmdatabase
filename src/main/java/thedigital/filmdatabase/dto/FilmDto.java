package thedigital.filmdatabase.dto;

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

    private Long id;
    private String title;
    private String director;
    private Genre genre;
    private Rating rating;
    private LocalDate releaseDate;
}
