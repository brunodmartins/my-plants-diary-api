package github.com.brunodmartins.myplantsdiaryapi.service;

import github.com.brunodmartins.myplantsdiaryapi.domain.Plant;
import github.com.brunodmartins.myplantsdiaryapi.repository.PlantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PlantService {

    private final PlantRepository repository;

    public void save(Plant plant) {
      log.info("Saving new plant {}", plant);
      repository.save(plant);
    }

}
