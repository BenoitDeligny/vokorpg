package vokorpgback.feature.fighting.exposition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FightingControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void fightAgainstMonsters() throws Exception {
    // given
    String requestBody = """
        {
          "characterFighter": {
            "maxFightingPower": 150,
            "remainingFightingPower": 150
          },
          "monsters": [
            {
              "maxFightingPower": 150,
              "remainingFightingPower": 150
            }
          ]
        }
        """;

    String responseBody = """
        {
          "characterFighter": {
            "maxFightingPower": 150,
            "remainingFightingPower": 150
          },
          "monsters": [
            {
              "maxFightingPower": 150,
              "remainingFightingPower": 150
            }
          ]
        }
        """;

    // when
    // then
    mockMvc.perform(
        post("/fight")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
        .andExpect(status().isOk())
        .andExpect(content().json(responseBody))
        .andReturn();
  }
}