package github.com.brunodmartins.myplantsdiaryapi.controller;

import github.com.brunodmartins.myplantsdiaryapi.domain.Plant;
import github.com.brunodmartins.myplantsdiaryapi.dto.PlantRequest;
import github.com.brunodmartins.myplantsdiaryapi.service.PlantService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plants")
@Slf4j
@AllArgsConstructor
public class PlantController {

    private final PlantService service;

    @GetMapping("/{id}")
    public Plant get(@PathVariable Long id) {
        Plant result = new Plant();
        result.setId(id);
        return result;
    }

    @PostMapping()
    public ResponseEntity<Plant> post(@Validated @RequestBody PlantRequest request) {
        var plant = request.toPlant();
        service.save(plant);
        return ResponseEntity.status(HttpStatus.CREATED).body(plant);
    }
}
