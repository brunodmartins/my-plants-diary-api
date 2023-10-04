package github.com.brunodmartins.myplantsdiaryapi.dto;

import github.com.brunodmartins.myplantsdiaryapi.domain.Plant;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PlantRequest(
        @NotEmpty String name,
        @NotNull LocalDate acquireDate) {

    public Plant toPlant() {
        return Plant.builder()
                .name(this.name)
                .acquireDate(this.acquireDate)
                .build();
    }
}
