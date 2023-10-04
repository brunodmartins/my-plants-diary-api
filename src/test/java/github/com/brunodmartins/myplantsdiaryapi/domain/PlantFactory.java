package github.com.brunodmartins.myplantsdiaryapi.domain;

import java.time.LocalDate;

public class PlantFactory {

    public static final Long PLANT_ID = 19L;

    public static Plant newPlant() {
        return Plant.builder()
                .name("Test plant")
                .acquireDate(LocalDate.now())
                .build();
    }
}
