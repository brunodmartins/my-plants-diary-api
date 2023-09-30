package github.com.brunodmartins.myplantsdiaryapi.controller;

import github.com.brunodmartins.myplantsdiaryapi.domain.Plant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plants")
public class PlantController {

    @GetMapping("/{id}")
    public Plant get(@PathVariable String id) {
        return new Plant(id);
    }
}
