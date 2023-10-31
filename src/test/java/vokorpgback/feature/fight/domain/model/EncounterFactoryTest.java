package vokorpgback.feature.fight.domain.model;

import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.opponent.Opponent;
import vokorpgback.feature.commons.domain.model.opponent.OpponentFactory;

import static org.junit.jupiter.api.Assertions.*;

class EncounterFactoryTest {

    @Test
    void encounterFactory_shouldCreateMultipleOpponents() {
        // given
        Opponent opponentType = OpponentFactory.generateOpponent("Bad Guy", 25, new LoadedDiceFactory());
        int numberOfOpponent = 5;

        // when
        Encounter encounter = EncounterFactory.generateEncounter(opponentType, opponentType.fightingMight().maxNaturalMight(), numberOfOpponent, new LoadedDiceFactory());

        // then
        assertEquals(5, encounter.livingOpponents().size());
    }
}