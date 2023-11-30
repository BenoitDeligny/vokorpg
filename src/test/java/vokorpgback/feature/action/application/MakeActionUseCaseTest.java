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
            "1, 1, 5, 0",
            "3, 2, 2, 1",
            "5, 4, 3, 3",
    })
    void handle_should_returnTrue_when_actionSucceed(int playerFirstRoll, int playerSecondRoll, int characterAbilityScore, int characterKnowledgeScore) {
        // given
        int difficulty = 7;
        CharacterActionScore characterActionScore = new CharacterActionScore(playerFirstRoll, playerSecondRoll, characterAbilityScore, characterKnowledgeScore);

        // when
        boolean isSuccessful = useCase.handle(difficulty, characterActionScore);

        // then
        Assertions.assertThat(isSuccessful).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1, 0",
            "3, 2, 1, 0",
            "2, 1, 2, 1",
    })
    void handle_should_returnFalse_when_actionFails(int playerFirstRoll, int playerSecondRoll, int characterAbilityScore, int characterKnowledgeScore) {
        // given
        int difficulty = 7;
        CharacterActionScore characterActionScore = new CharacterActionScore(playerFirstRoll, playerSecondRoll, characterAbilityScore, characterKnowledgeScore);


        // when
        boolean isSuccessful = useCase.handle(difficulty, characterActionScore);

        // then
        Assertions.assertThat(isSuccessful).isFalse();
    }
}