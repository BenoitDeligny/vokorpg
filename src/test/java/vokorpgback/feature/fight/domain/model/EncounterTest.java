package vokorpgback.feature.fight.domain.model;

import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.dice.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.opponent.Opponent;
import vokorpgback.feature.commons.domain.model.opponent.OpponentFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EncounterTest {

    LoadedDiceFactory diceFactory = new LoadedDiceFactory();

    @Test
    void legendaryCharacter_shouldFightTwoOpponents_thenBothOpponentsTakeDamages() {
        // given
        int characterDamages = 12;
        int characterCombatDice = 2;
        Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 25, diceFactory);
        Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 2, diceFactory);

        // when
        encounter.assignDamages(characterDamages, characterCombatDice);

        // then
        assertTrue(encounter.livingOpponents().stream().allMatch(o -> o.fightingMight().remainingMight() > 0));
        assertTrue(encounter.livingOpponents().stream().allMatch(o -> o.fightingMight().remainingMight() == 13));
    }

    @Test
    void legendaryCharacter_shouldFightThreeOpponents_thenOnlyTwoOpponentsTakeDamages() {
        // given
        int characterDamages = 12;
        int characterCombatDice = 2;
        Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 25, diceFactory);
        Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 3, diceFactory);

        // when
        encounter.assignDamages(characterDamages, characterCombatDice);

        // then
        assertTrue(encounter.livingOpponents().stream().allMatch(o -> o.fightingMight().remainingMight() > 0));
        assertTrue(encounter.livingOpponents().stream().limit(characterCombatDice).allMatch(o -> o.fightingMight().remainingMight() == 13));
        assertTrue(encounter.livingOpponents().stream().skip(characterCombatDice).allMatch(o -> o.fightingMight().remainingMight() == 25));
    }
}