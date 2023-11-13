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
import vokorpgback.feature.fight.domain.model.FightState;
import vokorpgback.feature.fight.domain.model.Encounter;
import vokorpgback.feature.fight.domain.model.EncounterFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static vokorpgback.feature.fight.domain.model.FightResult.*;

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
            FightState fightState = useCase.handle(legendaryCharacter, encounter);

            // then
            assertEquals(WON, fightState.fightResult());
            assertTrue(fightState.encounter().livingOpponents().isEmpty());
            assertEquals(1, fightState.encounter().deadOpponents().size());
            assertEquals(15, fightState.legendaryCharacter().remainingMight());
        }

        @Test
        void opponents_shouldWinTheFight() {
            // given
            LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
            Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 13, diceFactory);
            Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 5, diceFactory);

            // when
            FightState fightState = useCase.handle(legendaryCharacter, encounter);

            // then
            assertEquals(LOST, fightState.fightResult());
            assertTrue(fightState.legendaryCharacter().isDead());
            assertEquals(2, fightState.encounter().deadOpponents().size());
            assertEquals(3, fightState.encounter().livingOpponents().size());
            assertTrue(encounter.livingOpponents().stream().allMatch(o -> o.fightingMight().remainingMight() == o.fightingMight().maxNaturalMight()));
        }
    }
}