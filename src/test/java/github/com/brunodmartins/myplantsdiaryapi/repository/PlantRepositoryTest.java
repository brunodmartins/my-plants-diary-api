package github.com.brunodmartins.myplantsdiaryapi.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static github.com.brunodmartins.myplantsdiaryapi.domain.PlantFactory.newPlant;

@DataJpaTest
public class PlantRepositoryTest {

    @Autowired
    private PlantRepository repository;

    @Test
    @DisplayName("Test saving a plant into database")
    public void savePlant() {
        var plant = newPlant();
        repository.save(plant);
        Assertions.assertThat(plant.getId()).isGreaterThan(0L);
    }
}
