package com.example.library_films_backend;

import com.example.library_films_backend.model.FilmsItem;
import com.example.library_films_backend.model.StyleFilm;
import com.example.library_films_backend.repository.FilmsRepository;
import jakarta.transaction.Transactional;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = {StyleFilmIdTest.Initializer.class})
public class StyleFilmIdTest {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("runtime")
            .withDatabaseName("jdbc:postgresql://194.67.105.79:5432/java_filmsSergo_db")
            .withUsername("java_filmsalexsergo_user")
            .withPassword("12345");

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    StyleFilm styleFilm = Mockito.mock(StyleFilm.class);
    FilmsRepository filmsRepository = Mockito.mock(FilmsRepository.class);
    FilmsItem filmsItem = Mockito.mock(FilmsItem.class);

    @Test
    @Transactional
    public void getStyleFilmNameById() {

    /*    FilmsItem filmsItem1
        String expectedName = "Астрал";
        String actualName =
                styleFilm.getId(19);*/
    }
}