package vokorpgback.feature.fight.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacterFactory;
import vokorpgback.feature.commons.domain.model.dice.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.opponent.Opponent;
import vokorpgback.feature.commons.domain.model.opponent.OpponentFactory;
import vokorpgback.feature.fight.domain.model.CombatResult;
import vokorpgback.feature.fight.domain.model.CombatState;
import vokorpgback.feature.fight.domain.model.Encounter;
import vokorpgback.feature.fight.domain.model.EncounterFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static vokorpgback.feature.fight.domain.model.CombatState.*;

class QuickFightUseCaseTest {

    private QuickFightUseCase useCase;
    LoadedDiceFactory diceFactory = new LoadedDiceFactory();

    @BeforeEach
    void setUp() {
        useCase = new QuickFightUseCase();
    }

    @Nested
    class Fight {
        @Test
        void legendaryCharacter_shouldWinTheFight() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 13, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 1, diceFactory);

            // when
            CombatResult combatResult = useCase.handle(legendaryCharacter, encounter);

            // then
            assertEquals(WON, combatResult.combatState());
            assertTrue(combatResult.encounter().livingOpponents().isEmpty());
            assertEquals(1, combatResult.encounter().deadOpponents().size());
            assertEquals(15, combatResult.legendaryCharacter().remainingMight());
        }

        @Test
        void opponents_shouldWinTheFight() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 13, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 5, diceFactory);

            // when
            CombatResult combatResult = useCase.handle(legendaryCharacter, encounter);

            // then
            assertEquals(LOST, combatResult.combatState());
            assertTrue(combatResult.legendaryCharacter().isDead());
            assertEquals(2, combatResult.encounter().deadOpponents().size());
            assertEquals(3, combatResult.encounter().livingOpponents().size());
            assertTrue(encounter.livingOpponents().stream().allMatch(o -> o.fightingMight().remainingMight() == o.fightingMight().maxNaturalMight()));
        }
    }

    @Nested
    class ToMoveOut {

        // TODO: this should be test in EncounterTest
        @Test
        void legendaryCharacter_shouldFightTwoOpponents_thenBothOpponentsTakeDamages() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 25, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 2, diceFactory);

            // when
            useCase.handle(legendaryCharacter, encounter);

            // then
            assertTrue(encounter.livingOpponents().stream().allMatch(o -> o.fightingMight().remainingMight() > 0));
            assertTrue(encounter.livingOpponents().stream().allMatch(o -> o.fightingMight().remainingMight() == 1));
        }

        // TODO: this should be test in EncounterTest
        @Test
        void legendaryCharacter_shouldFightThreeOpponents_thenOnlyTwoOpponentsTakeDamages() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 25, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 3, diceFactory);

            // when
            useCase.handle(legendaryCharacter, encounter);

            // then
            assertTrue(encounter.livingOpponents().stream().allMatch(o -> o.fightingMight().remainingMight() > 0));
            assertTrue(encounter.livingOpponents().stream().limit(legendaryCharacter.characterCombatDice()).allMatch(o -> o.fightingMight().remainingMight() == 1));
            assertTrue(encounter.livingOpponents().stream().skip(legendaryCharacter.characterCombatDice()).allMatch(o -> o.fightingMight().remainingMight() == 25));
        }
    }
}