package vokorpgback.feature.action.application;

import vokorpgback.feature.action.domain.CharacterActionScore;

public class MakeActionUseCase {

    // TODO: replace by LegendaryCharacter
    public boolean handle(int difficultyThreshold, CharacterActionScore characterActionScore) {
        return characterActionScore.computeTotalScore() >= difficultyThreshold;
    }
}
