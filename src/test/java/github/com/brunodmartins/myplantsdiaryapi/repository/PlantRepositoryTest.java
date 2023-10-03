package github.com.brunodmartins.myplantsdiaryapi.repository;

import github.com.brunodmartins.myplantsdiaryapi.domain.Plant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
public class PlantRepositoryTest {

    @Autowired
    private PlantRepository repository;

    @Test
    @DisplayName("Test saving a plant into database")
    public void savePlant() {
        Plant plant = Plant.builder()
                .name("Test plant")
                .acquireDate(LocalDate.now())
                .build();
        repository.save(plant);
        Assertions.assertThat(plant.getId()).isGreaterThan(0L);
    }
}
