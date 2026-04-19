package thedigital.filmdatabase.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The title of the film, e.g., "Inception". */
    private String title;

    /** The director of the film. */
    private String director;

    /** The genre of the film. */
    @Enumerated(EnumType.STRING)
    private Genre genre;

    /** The star rating of the film. */
    @Enumerated(EnumType.STRING)
    private Rating rating;

    /** The release date of the film. */
    private LocalDate releaseDate;

}
