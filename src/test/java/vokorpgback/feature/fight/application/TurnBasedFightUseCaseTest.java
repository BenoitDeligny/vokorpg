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

import static org.junit.jupiter.api.Assertions.*;

class TurnBasedFightUseCaseTest {
    private TurnBasedFightUseCase useCase;
    LoadedDiceFactory diceFactory = new LoadedDiceFactory();

    @BeforeEach
    void setUp() {
        useCase = new TurnBasedFightUseCase();
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
            CombatResult combatResult = useCase.handle(legendaryCharacter, encounter, false);

            // then
            assertEquals(CombatState.WON, combatResult.combatState());
            assertTrue(combatResult.encounter().livingOpponents().isEmpty());
            assertEquals(1, combatResult.encounter().deadOpponents().size());
            assertEquals(combatResult.legendaryCharacter().maxNaturalMight(), combatResult.legendaryCharacter().remainingMight());
        }

        @Test
        void opponent_shouldKillLegendaryCharacter() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 500, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 1, diceFactory);

            // when
            CombatResult combatResult = useCase.handle(legendaryCharacter, encounter, false);

            // then
            assertEquals(CombatState.LOST, combatResult.combatState());
            assertTrue(combatResult.legendaryCharacter().isDead());
            assertTrue(combatResult.encounter().livingOpponents().get(0).fightingMight().remainingMight() > 0);
            assertEquals(488, combatResult.encounter().livingOpponents().get(0).fightingMight().remainingMight());
        }

        @Test
        void fight_shouldContinue() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 25, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 1, diceFactory);

            // when
            CombatResult combatResult = useCase.handle(legendaryCharacter, encounter, false);

            // then
            assertEquals(CombatState.IN_PROGRESS, combatResult.combatState());
            assertEquals(9, combatResult.legendaryCharacter().remainingMight());
            assertEquals(13, combatResult.encounter().livingOpponents().get(0).fightingMight().remainingMight());
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
            CombatResult combatResult = useCase.handle(legendaryCharacter, encounter, true);

            // then
            assertEquals(CombatState.FLED, combatResult.combatState());
            assertEquals(combatResult.legendaryCharacter().remainingMight(), legendaryCharacter.maxNaturalMight());
            assertEquals(2, combatResult.encounter().livingOpponents().size());
            assertTrue(encounter.livingOpponents().stream().allMatch(o -> o.fightingMight().remainingMight() == o.fightingMight().maxNaturalMight()));
        }

        @Test
        void legendaryCharacter_shouldNotFleeTheFight_thenFightAsNormal() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 25, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 1, diceFactory);

            // when
            CombatResult combatResult = useCase.handle(legendaryCharacter, encounter, true);

            // then
            assertEquals(CombatState.IN_PROGRESS, combatResult.combatState());
            assertEquals(9, combatResult.legendaryCharacter().remainingMight());
            assertEquals(13, combatResult.encounter().livingOpponents().get(0).fightingMight().remainingMight());
        }
    }
}