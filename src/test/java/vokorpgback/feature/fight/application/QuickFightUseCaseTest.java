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
import vokorpgback.feature.fight.domain.model.Encounter;
import vokorpgback.feature.fight.domain.model.EncounterFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static vokorpgback.feature.fight.domain.model.CombatResult.*;

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
        void legendaryCharacter_shouldKillOpponentAndNotTakeDamages() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 12, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 1, diceFactory);

            // when
            useCase.handle(legendaryCharacter, encounter);

            // then
            assertTrue(encounter.livingOpponents().isEmpty());
            assertEquals(1, encounter.deadOpponents().size());
            assertEquals(legendaryCharacter.maxNaturalMight(), legendaryCharacter.remainingMight());
        }

        @Test
        void opponent_shouldKillLegendaryCharacter() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 500, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 1, diceFactory);

            // when
            useCase.handle(legendaryCharacter, encounter);

            // then
            assertTrue(legendaryCharacter.isDead());
            assertTrue(encounter.livingOpponents().get(0).fightingMight().remainingMight() > 0);
            assertEquals(488, encounter.livingOpponents().get(0).fightingMight().remainingMight());
        }

        @Test
        void legendaryCharacter_shouldWinTheFight() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 13, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 1, diceFactory);

            // when
            CombatResult combatResult = useCase.handle(legendaryCharacter, encounter);

            // then
            assertTrue(encounter.livingOpponents().isEmpty());
            assertEquals(1, encounter.deadOpponents().size());
            assertEquals(15, legendaryCharacter.remainingMight());
            assertEquals(WIN, combatResult);
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
            assertTrue(legendaryCharacter.isDead());
            assertEquals(LOSE, combatResult);
        }
    }

    @Nested
    class TryToFlee {
        @Test
        void legendaryCharacter_shouldFleeTheFight_thenNoFight() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 5, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 2, diceFactory);

            // when
            CombatResult combatResult = useCase.handle(legendaryCharacter, encounter);

            // then
            assertEquals(FLEE, combatResult);
            assertEquals(legendaryCharacter.maxNaturalMight(), legendaryCharacter.remainingMight());
            assertTrue(encounter.livingOpponents().stream().allMatch(o -> o.fightingMight().remainingMight() == o.fightingMight().maxNaturalMight()));
        }

        @Test
        void legendaryCharacter_shouldNotFleeTheFight_thenFightAsNormalAndWin() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 12, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 1, diceFactory);

            // when
            CombatResult combatResult = useCase.handle(legendaryCharacter, encounter);

            // then
            assertEquals(WIN, combatResult);
        }

        @Test
        void legendaryCharacter_shouldNotFleeTheFight_thenFightAsNormalAndLose() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 500, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 1, diceFactory);

            // when
            CombatResult combatResult = useCase.handle(legendaryCharacter, encounter);

            // then
            assertEquals(LOSE, combatResult);
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