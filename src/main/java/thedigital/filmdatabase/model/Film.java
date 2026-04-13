package thedigital.filmdatabase.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Film {

    // The Title of the film, such as action, comedy, drama, etc.
    @Getter
    @Setter
    private String title;

    // The director of the film.
    @Getter
    @Setter
    private String director;

    // The Genre of the film, such as action, comedy, drama, etc.
    @Getter
    @Setter
    private Genre genre;

    // The rating of the film, such as one star, two stars, three stars, four stars,
    // or five stars.
    @Getter
    @Setter
    private Rating rating;

    // The release date of the film, in the format of "YYYY-MM-DD".
    @Getter
    @Setter
    private String releaseDate;

}
