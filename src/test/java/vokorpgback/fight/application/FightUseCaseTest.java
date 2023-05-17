package vokorpgback.fight.application;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vokorpgback.charactercreation.domain.model.Abilities;
import vokorpgback.charactercreation.domain.model.Ability;
import vokorpgback.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.fight.domain.CombatChart;
import vokorpgback.fight.domain.Monster;

public class FightUseCaseTest {

    private FightUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new FightUseCase();
    }

    @Test
    void handle_shouldReturnDefeated() {
        // given
        LegendaryCharacter legendaryCharacter = new LegendaryCharacter(
                "Name",
                18,
                new Abilities(
                        new Ability(7),
                        new Ability(7),
                        new Ability(7)
                )
        );

        List<Monster> monsters = List.of(
            new Monster(15)
        );

        int attackRoll = 2;

        // when
        // result = (7+2) - 15 = -6
        CombatChart combatResult = useCase.handle(legendaryCharacter, monsters, attackRoll);

        // then
        Assertions.assertThat(combatResult).isEqualTo(CombatChart.DEFEATED);
    }

    @Test
    void handle_shouldReturnSeriouslyInjured() {
        // given
        LegendaryCharacter legendaryCharacter = new LegendaryCharacter(
                "Name",
                18,
                new Abilities(
                        new Ability(7),
                        new Ability(7),
                        new Ability(7)
                )
        );

        List<Monster> monsters = List.of(
            new Monster(7)
        );

        int attackRoll = 1;

        // when
        // result = (7+1) - 7 = 1
        CombatChart combatResult = useCase.handle(legendaryCharacter, monsters, attackRoll);

        // then
        Assertions.assertThat(combatResult).isEqualTo(CombatChart.SERIOUSLY_INJURED);
    }

    @Test
    void handle_shouldReturnInjured() {
        // given
        LegendaryCharacter legendaryCharacter = new LegendaryCharacter(
                "Name",
                18,
                new Abilities(
                        new Ability(7),
                        new Ability(7),
                        new Ability(7)
                )
        );

        List<Monster> monsters = List.of(
            new Monster(7)
        );

        int attackRoll = 4;

        // when
        // result = (7+4) - 7 = 4
        CombatChart combatResult = useCase.handle(legendaryCharacter, monsters, attackRoll);

        // then
        Assertions.assertThat(combatResult).isEqualTo(CombatChart.INJURED);
    }
    
    @Test
    void handle_shouldReturnDraw() {
        // given
        LegendaryCharacter legendaryCharacter = new LegendaryCharacter(
                "Name",
                18,
                new Abilities(
                        new Ability(7),
                        new Ability(7),
                        new Ability(7)
                )
        );

        List<Monster> monsters = List.of(
            new Monster(7)
        );

        int attackRoll = 6;

        // when
        // result = (7+6) - 7 = 6
        CombatChart combatResult = useCase.handle(legendaryCharacter, monsters, attackRoll);

        // then
        Assertions.assertThat(combatResult).isEqualTo(CombatChart.DRAW);
    }


    @Test
    void handle_shouldReturnBearlyVictorious() {
        // given
        LegendaryCharacter legendaryCharacter = new LegendaryCharacter(
                "Name",
                18,
                new Abilities(
                        new Ability(10),
                        new Ability(7),
                        new Ability(7)
                )
        );

        List<Monster> monsters = List.of(
            new Monster(7)
        );

        int attackRoll = 6;

        // when
        // result = (10+6) - 7 = 9
        CombatChart combatResult = useCase.handle(legendaryCharacter, monsters, attackRoll);

        // then
        Assertions.assertThat(combatResult).isEqualTo(CombatChart.BEARLY_VICTORIOUS);
    }

    @Test
    void handle_shouldReturnAlmostVictorious() {
        // given
        LegendaryCharacter legendaryCharacter = new LegendaryCharacter(
                "Name",
                18,
                new Abilities(
                        new Ability(14),
                        new Ability(7),
                        new Ability(7)
                )
        );

        List<Monster> monsters = List.of(
            new Monster(7)
        );

        int attackRoll = 6;

        // when
        // result = (12+6) - 7 = 13
        CombatChart combatResult = useCase.handle(legendaryCharacter, monsters, attackRoll);

        // then
        Assertions.assertThat(combatResult).isEqualTo(CombatChart.ALMOST_VICTORIOUS);
    }

    @Test
    void handle_shouldReturnVictorious() {
        // given
        LegendaryCharacter legendaryCharacter = new LegendaryCharacter(
                "Name",
                18,
                new Abilities(
                        new Ability(16),
                        new Ability(7),
                        new Ability(7)
                )
        );

        List<Monster> monsters = List.of(
            new Monster(7)
        );

        int attackRoll = 6;

        // when
        // result = (16+6) - 7 = 15
        CombatChart combatResult = useCase.handle(legendaryCharacter, monsters, attackRoll);

        // then
        Assertions.assertThat(combatResult).isEqualTo(CombatChart.VICTORIOUS);
    }
}
