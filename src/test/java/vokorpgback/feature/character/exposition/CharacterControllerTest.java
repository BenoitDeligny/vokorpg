package vokorpgback.feature.character.exposition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import vokorpgback.feature.character.application.CreateCharacterUseCase;
import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.domain.model.ability.Abilities;
import vokorpgback.feature.character.domain.model.ability.Ability;
import vokorpgback.feature.character.domain.model.gear.Gear;
import vokorpgback.feature.commons.domain.model.GameMode;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// TODO
// https://www.baeldung.com/exception-handling-for-rest-with-spring
@WebMvcTest(CharacterController.class)
class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateCharacterUseCase useCase;

    @Test
    void createCharacter_should_create() throws Exception {
        // given
        String requestBody = """
                {
                    "name": "Pouet",
                    "mode": "normal"
                }
                    """;

        LegendaryCharacter expectedCharacter = new LegendaryCharacter(
                "Pouet",
                18,
                new Abilities(
                        new Ability(4),
                        new Ability(5),
                        new Ability(6)),
                15,
                Gear.generateDefaultGear(GameMode.NORMAL));

        // when
        when(useCase.handle(any())).thenReturn(expectedCharacter);

        // then
        String responseBody = """
                {
                    "name": "Pouet",
                    "age": 18,
                    "abilities": [
                        "strength": 4,
                        "agility": 5,
                        "perception": 6,
                    ]
                    "totalPower": 15
                }
                    """;

        mockMvc.perform(post("/character")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(responseBody))
                .andReturn();
    }

    @Test
    void createCharacter_should_getBadRequest() throws Exception {
        // given
        String requestBody = """
                {
                    "name": "Pouet",
                    "mode": "SUPA_EASY"
                }
                    """;

        // when
        // then

        mockMvc.perform(post("/character")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andReturn();
    }
}
