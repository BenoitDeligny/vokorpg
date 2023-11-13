package vokorpgback.feature.action.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import vokorpgback.feature.action.domain.CharacterActionScore;

class MakeActionUseCaseTest {

    private MakeActionUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new MakeActionUseCase();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 5, 0, 1",
            "3, 2, 2, 1, 1",
            "5, 4, 3, 3, 1",
    })
    void handle_should_returnTrue_when_actionSucceed(int playerFirstRoll, int playerSecondRoll, int characterAbilityScore, int characterKnowledgeScore, int characterGearScore) {
        // given
        int difficulty = 8;
        CharacterActionScore characterActionScore = new CharacterActionScore(playerFirstRoll, playerSecondRoll, characterAbilityScore, characterKnowledgeScore, characterGearScore);

        // when
        boolean isSuccessful = useCase.handle(difficulty, characterActionScore);

        // then
        Assertions.assertThat(isSuccessful).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1, 0, 0",
            "3, 2, 1, 0, 0",
            "2, 1, 2, 1, 0",
    })
    void handle_should_returnFalse_when_actionFails(int playerFirstRoll, int playerSecondRoll, int characterAbilityScore, int characterKnowledgeScore, int characterGearScore) {
        // given
        int difficulty = 7;
        CharacterActionScore characterActionScore = new CharacterActionScore(playerFirstRoll, playerSecondRoll, characterAbilityScore, characterKnowledgeScore, characterGearScore);


        // when
        boolean isSuccessful = useCase.handle(difficulty, characterActionScore);

        // then
        Assertions.assertThat(isSuccessful).isFalse();
    }
}