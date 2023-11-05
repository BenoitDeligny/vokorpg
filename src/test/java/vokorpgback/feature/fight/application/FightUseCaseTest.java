package vokorpgback.feature.fight.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.model.dice.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacterFactory;
import vokorpgback.feature.fight.domain.model.Encounter;
import vokorpgback.feature.fight.domain.model.EncounterFactory;
import vokorpgback.feature.commons.domain.model.opponent.Opponent;
import vokorpgback.feature.commons.domain.model.opponent.OpponentFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FightUseCaseTest {

    private FightUseCase useCase;
    LoadedDiceFactory diceFactory = new LoadedDiceFactory();

    @BeforeEach
    void setUp() {
        useCase = new FightUseCase();
    }

    // TODO: gather tests by behaviour (character is winning - full life and not - and opponents are winning - full life and not -
    // Add as many assertion that needed
    // Maybe keep old steps by steps tests in comment ?

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

    @Test
    void legendaryCharacter_shouldKillOpponent() {
        // given
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
        Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 12, diceFactory);
        Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 1, diceFactory);

        // when
        useCase.handle(legendaryCharacter, encounter);

        // then
        assertTrue(legendaryCharacter.remainingMight() > 0);
        assertEquals(21, legendaryCharacter.remainingMight());
        assertTrue(encounter.livingOpponents().isEmpty());
        assertEquals(1, encounter.deadOpponents().size());
    }

    @Test
    void opponent_shouldNotRollDamages_whenDead() {
        // given
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, diceFactory, "Winner");
        Opponent opponent = OpponentFactory.generateOpponent("Bad guy", 12, diceFactory);
        Encounter encounter = EncounterFactory.generateEncounter(opponent, opponent.fightingMight().maxNaturalMight(), 1, diceFactory);

        // when
        useCase.handle(legendaryCharacter, encounter);

        // then
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
        useCase.handle(legendaryCharacter, encounter);

        // then
        assertTrue(encounter.livingOpponents().isEmpty());
        assertEquals(1, encounter.deadOpponents().size());
        assertEquals(15, legendaryCharacter.remainingMight());
    }
}