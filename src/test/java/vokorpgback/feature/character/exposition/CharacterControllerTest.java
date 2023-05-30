package vokorpgback.feature.character.exposition;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

// TODO
// https://www.baeldung.com/exception-handling-for-rest-with-spring
@WebMvcTest(CharacterController.class)
class CharacterControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private CreateCharacterUseCase useCase;

  @Test
  void createCharacter_should_createNormal() throws Exception {
    // given
    String requestBody =
        """
                {
                    "name": "Pouet",
                    "mode": "normal"
                }
                    """;

    LegendaryCharacter expectedCharacter =
        new LegendaryCharacter(
            "Pouet",
            18,
            new Abilities(new Ability(4), new Ability(5), new Ability(6)),
            15,
            Gear.generateDefaultGear(GameMode.NORMAL));

    // when
    when(useCase.handle(any())).thenReturn(expectedCharacter);

    // then
    String responseBody =
        """
            {
                "name": "Pouet",
                "age": 18,
                "abilities": {
                    "strength": 4,
                    "agility": 5,
                    "perception": 6
                },
                "totalPower": 15,
                "gear": {
                    "items": [
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        }
                    ]
                }
            }
                    """;

    mockMvc
        .perform(post("/character").contentType(MediaType.APPLICATION_JSON).content(requestBody))
        .andExpect(status().isOk())
        .andExpect(content().json(responseBody))
        .andReturn();
  }

  @Test
  void createCharacter_should_createEasy() throws Exception {
    // given
    String requestBody =
        """
                {
                    "name": "Pouet",
                    "mode": "easy"
                }
                    """;

    LegendaryCharacter expectedCharacter =
        new LegendaryCharacter(
            "Pouet",
            18,
            new Abilities(new Ability(7), new Ability(9), new Ability(10)),
            26,
            Gear.generateDefaultGear(GameMode.EASY));

    // when
    when(useCase.handle(any())).thenReturn(expectedCharacter);

    // then
    String responseBody =
        """
            {
                "name": "Pouet",
                "age": 18,
                "abilities": {
                    "strength": 7,
                    "agility": 9,
                    "perception": 10
                },
                "totalPower": 26,
                "gear": {
                    "items": [
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Sacred Knife",
                            "category": "WEAPON",
                            "traits": [
                                "A simple enchanted knife"
                            ],
                            "description": "A simple enchanted knife"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        },
                        {
                            "name": "Generic item",
                            "category": "GENERIC",
                            "traits": [],
                            "description": "A useless item"
                        }
                    ]
                }
            }
                    """;

    mockMvc
        .perform(post("/character").contentType(MediaType.APPLICATION_JSON).content(requestBody))
        .andExpect(status().isOk())
        .andExpect(content().json(responseBody))
        .andReturn();
  }

  @Test
  void createCharacter_should_getBadRequest() throws Exception {
    // given
    String requestBody =
        """
                {
                    "name": "Pouet",
                    "mode": "SUPA_EASY"
                }
                    """;

    // when
    // then

    mockMvc
        .perform(post("/character").contentType(MediaType.APPLICATION_JSON).content(requestBody))
        .andExpect(status().isBadRequest())
        .andReturn();
  }
}
