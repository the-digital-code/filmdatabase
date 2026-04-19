package thedigital.filmdatabase.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import thedigital.filmdatabase.model.Film;
import thedigital.filmdatabase.persistence.FilmRepository;

import java.io.InputStream;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final FilmRepository filmRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        if (filmRepository.count() == 0) {
            log.info("Loading films from JSON...");
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/films.json")) {
                List<Film> films = objectMapper.readValue(inputStream, new TypeReference<List<Film>>() {});
                filmRepository.saveAll(films);
                log.info("Successfully loaded {} films.", films.size());
            } catch (Exception e) {
                log.error("Failed to load films: {}", e.getMessage());
            }
        } else {
            log.info("Films already exist in database, skipping import.");
        }
    }
}
