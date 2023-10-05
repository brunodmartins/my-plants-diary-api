package github.com.brunodmartins.myplantsdiaryapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import github.com.brunodmartins.myplantsdiaryapi.domain.Plant;
import github.com.brunodmartins.myplantsdiaryapi.dto.PlantRequest;
import github.com.brunodmartins.myplantsdiaryapi.service.PlantService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static github.com.brunodmartins.myplantsdiaryapi.domain.PlantFactory.PLANT_ID;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlantController.class)
@ExtendWith(MockitoExtension.class)
public class PlantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PlantService service;

    @Test
    @DisplayName("Should return a new plant upon a GET request")
    @SneakyThrows
    public void testGetPlant(){
        mockMvc.perform(MockMvcRequestBuilders.get("/plants/" + PLANT_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(PLANT_ID));
    }

    @Test
    @DisplayName("Should save a new plant upon a POST request")
    @SneakyThrows
    public void testPostPlant() {
        Mockito.doAnswer(ans -> {
            Plant plant = ans.getArgument(0);
            plant.setId(PLANT_ID);
            return ans;
        }).when(service).save(any(Plant.class));
        mockMvc.perform(MockMvcRequestBuilders.post("/plants")
                        .content(objectMapper.writeValueAsBytes(new PlantRequest("my-plant", LocalDate.now())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(PLANT_ID));
    }

    @Test
    @DisplayName("Should return BAD_REQUEST upon a invalid POST request")
    @SneakyThrows
    public void testPostPlantBadRequest() {
        mockMvc.perform(MockMvcRequestBuilders.post("/plants")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
