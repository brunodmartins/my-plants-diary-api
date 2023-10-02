package github.com.brunodmartins.myplantsdiaryapi.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Plant {

    private Long id;

    private String name;

    private LocalDate acquireDate;
}
