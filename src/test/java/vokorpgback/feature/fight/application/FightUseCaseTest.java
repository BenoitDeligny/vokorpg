package vokorpgback.feature.fight.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.model.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacterFactory;
import vokorpgback.feature.commons.domain.model.dice.OfficialDiceFactory;
import vokorpgback.feature.commons.domain.port.DiceFactory;

import static org.junit.jupiter.api.Assertions.*;

class FightUseCaseTest {

    private FightUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new FightUseCase();
    }

    @Test
    void handle_should_win() {
        // given
        LegendaryCharacter winner = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, new LoadedDiceFactory(), "Winner");

        // when
        useCase.handle();

        // then
    }

}