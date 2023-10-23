package vokorpgback.feature.fight.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.model.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacterFactory;
import vokorpgback.feature.fight.domain.model.Encounter;
import vokorpgback.feature.fight.domain.model.EncounterFactory;
import vokorpgback.feature.commons.domain.model.opponent.Opponent;
import vokorpgback.feature.commons.domain.model.opponent.OpponentFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FightUseCaseTest {

    private FightUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new FightUseCase();
    }

    @Test
    void LegendaryCharacter_shouldInflictXDamageToOpponents() {
        // given
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, new LoadedDiceFactory(), "Winner");
        Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 8);
        Encounter encounter = EncounterFactory.generateEncounter(5, opponent);

        // when
        useCase.handle(legendaryCharacter, encounter);

        // then
        assertEquals(encounter.opponent().fightingMight().remainingMight(), 5);
    }

//    @Test
//    void handle_should_win() {
//        // given
//        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, new LoadedDiceFactory(), "Winner");
//        Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 8);
//        Encounter encounter = EncounterFactory.generateEncounter(5, opponent);
//
//        // when
//        boolean combatResult = useCase.handle(legendaryCharacter, encounter);
//
//        // then
//        assertTrue(combatResult);
//    }
//
//    @Test
//    void handle_should_lose() {
//        // given
//        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, new LoadedDiceFactory(), "Winner");
//        Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 15);
//        Encounter encounter = EncounterFactory.generateEncounter(5, opponent);
//
//        // when
//        boolean combatResult = useCase.handle(legendaryCharacter, encounter);
//
//        // then
//        assertFalse(combatResult);
//    }

}