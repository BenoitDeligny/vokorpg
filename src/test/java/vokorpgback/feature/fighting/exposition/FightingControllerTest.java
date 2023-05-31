package vokorpgback.feature.fighting.exposition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import vokorpgback.feature.fighting.application.FightingUseCase;
import vokorpgback.feature.fighting.domain.CombatResult;
import vokorpgback.feature.fighting.domain.FightStatus;
import vokorpgback.feature.fighting.domain.fighter.CharacterFighter;
import vokorpgback.feature.fighting.domain.fighter.MonsterFighter;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// TODO
// https://www.baeldung.com/exception-handling-for-rest-with-spring
@WebMvcTest(FightingController.class)
class FightingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FightingUseCase useCase;

    @Test
    void fightAgainstMonsters_should_getCombatResultOfOngoing() throws Exception {
        // given
        String requestBody =
                """
                        {
                          "characterFighter": {
                            "maxFightingPower": 15,
                            "remainingFightingPower": 15,
                            "agility": 3,
                            "attemptToFlee": false
                          },
                          "monsters": [
                            {
                              "maxFightingPower": 17,
                              "remainingFightingPower": 17
                            }
                          ]
                        }
                            """;

        CombatResult combatResult =
                new CombatResult(
                        new CharacterFighter(15, 12, 3),
                        List.of(new MonsterFighter(17, 13)),
                        FightStatus.ONGOING);

        // when
        when(useCase.handle(any())).thenReturn(combatResult);

        // then
        String responseBody =
                """
                          {
                            "character": {
                                "maxFightingPower": 15,
                                "remainingFightingPower": 12,
                                "agility": 3
                            },
                            "monsters": [
                                {
                                    "maxFightingPower": 17,
                                    "remainingFightingPower": 13
                                }
                            ],
                            "fightStatus": "ONGOING"
                        }
                            """;

        mockMvc
                .perform(post("/fight").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(responseBody))
                .andReturn();
    }

    @Test
    void fightAgainstMonsters_should_attemptToFleeFight() throws Exception {
        // given
        String requestBody =
                """
                        {
                          "characterFighter": {
                            "maxFightingPower": 15,
                            "remainingFightingPower": 15,
                            "agility": 3,
                            "attemptToFlee": true
                          },
                          "monsters": [
                            {
                              "maxFightingPower": 17,
                              "remainingFightingPower": 17
                            }
                          ]
                        }
                            """;

        CombatResult combatResult =
                new CombatResult(
                        new CharacterFighter(15, 15, 3), List.of(new MonsterFighter(17, 17)), FightStatus.FLED);

        // when
        when(useCase.handle(any())).thenReturn(combatResult);

        // then
        String responseBody =
                """
                          {
                            "character": {
                                "maxFightingPower": 15,
                                "remainingFightingPower": 15,
                                "agility": 3
                            },
                            "monsters": [
                                {
                                    "maxFightingPower": 17,
                                    "remainingFightingPower": 17
                                }
                            ],
                            "fightStatus": "FLED"
                        }
                            """;

        mockMvc
                .perform(post("/fight").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(responseBody))
                .andReturn();
    }

    @Test
    void fightAgainstMonsters_should_getBadRequest() throws Exception {
        // given
        String requestBody =
                """
                        {
                          "monsters": [
                            {
                              "maxFightingPower": 17,
                              "remainingFightingPower": 17
                            }
                          ]
                        }
                        """;

        // when
        // then
        mockMvc
                .perform(post("/fight").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isBadRequest())
                .andReturn();
    }
}
