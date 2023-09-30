package github.com.brunodmartins.myplantsdiaryapi.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HeartbeatController.class)
public class HeartbeatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test application Heartbeat")
    @SneakyThrows
    public void testHeartbeat() {
        mockMvc.perform(MockMvcRequestBuilders.get("/ping"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
