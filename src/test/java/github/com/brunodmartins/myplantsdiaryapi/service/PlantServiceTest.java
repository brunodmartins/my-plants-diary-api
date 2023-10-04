package github.com.brunodmartins.myplantsdiaryapi.service;

import github.com.brunodmartins.myplantsdiaryapi.repository.PlantRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static github.com.brunodmartins.myplantsdiaryapi.domain.PlantFactory.newPlant;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlantServiceTest {

    @Mock
    private PlantRepository repository;

    @InjectMocks
    private PlantService service;

    @Test
    @DisplayName("Should save a plant without errors")
    public void testSavePlant(){
        var plant = newPlant();
        when(repository.save(eq(plant))).thenReturn(plant);
        service.save(plant);
    }

    @Test
    @DisplayName("Should save a plant and throw an error")
    public void testSavePlantError(){
        var plant = newPlant();
        when(repository.save(eq(plant))).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> service.save(plant));
    }
}
