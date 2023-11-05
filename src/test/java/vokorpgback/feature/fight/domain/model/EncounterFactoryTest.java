package vokorpgback.feature.fight.domain.model;

import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.dice.LoadedDiceFactory;
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

    @Test
    void opponent_shouldInflict12Damages() {
        // given
        Opponent opponentType = OpponentFactory.generateOpponent("Bad Guy", 25, new LoadedDiceFactory());
        int numberOfOpponent = 1;

        // when
        Encounter encounter = EncounterFactory.generateEncounter(opponentType, opponentType.fightingMight().maxNaturalMight(), numberOfOpponent, new LoadedDiceFactory());

        // then
        assertEquals(12, encounter.computeOpponentsTotalDamages());
    }

    @Test
    void encounterOpponents_shouldRollOneMoreDamagesDice_whenMultipleOpponents() {
        // given
        Opponent opponentType = OpponentFactory.generateOpponent("Bad Guy", 25, new LoadedDiceFactory());
        int numberOfOpponent = 2;

        // when
        Encounter encounter = EncounterFactory.generateEncounter(opponentType, opponentType.fightingMight().maxNaturalMight(), numberOfOpponent, new LoadedDiceFactory());

        // then
        assertEquals(18, encounter.computeOpponentsTotalDamages());
    }
}