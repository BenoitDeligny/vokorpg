package vokorpgback.feature.fighting.application;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vokorpgback.feature.fighting.domain.Fight;
import vokorpgback.commons.LoadedDice;
import vokorpgback.feature.fighting.domain.CombatResult;
import vokorpgback.feature.fighting.domain.fighter.CharacterFighter;
import vokorpgback.feature.fighting.domain.fighter.MonsterFighter;

class FightingUseCaseTest {

    private FightingUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new FightingUseCase();
    }

    @Test
    void handle_should_fightOneMonsterAndKill() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(15, 15, 3, new LoadedDice(4));
        MonsterFighter monsterFighter = new MonsterFighter(3, 3, new LoadedDice(3));

        Fight actualFight = new Fight(
                characterFighter,
                List.of(monsterFighter));

        // when
        CombatResult combatResult = useCase.handle(actualFight);

        // then
        Assertions.assertThat(combatResult.monsterFighters()).isEmpty();
        Assertions.assertThat(combatResult.characterFighter().getRemainingFightingPower()).isEqualTo(15);
    }

    @Test
    void handle_should_fightOneMonsterAndNotKill() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(15, 15, 3, new LoadedDice(4));
        MonsterFighter monsterFighter = new MonsterFighter(18, 18, new LoadedDice(4));

        Fight actualFight = new Fight(
                characterFighter,
                List.of(monsterFighter));

        // when
        CombatResult combatResult = useCase.handle(actualFight);

        // then
        Assertions.assertThat(combatResult.monsterFighters()).hasSize(1);
        Assertions.assertThat(combatResult.monsterFighters().get(0).getRemainingFightingPower()).isEqualTo(14);
        Assertions.assertThat(combatResult.characterFighter().getRemainingFightingPower()).isEqualTo(11);
    }

    @Test
    void handle_should_fightMultipleMonstersAndKillPartOf() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(15, 15, 2, new LoadedDice(4));
        MonsterFighter monsterFighter = new MonsterFighter(18, 2, new LoadedDice(4));
        MonsterFighter monsterFighter2 = new MonsterFighter(18, 2, new LoadedDice(2));
        MonsterFighter monsterFighter3 = new MonsterFighter(18, 18, new LoadedDice(3));

        Fight actualFight = new Fight(
                characterFighter,
                List.of(monsterFighter, monsterFighter2, monsterFighter3));

        // when
        CombatResult combatResult = useCase.handle(actualFight);

        // then
        Assertions.assertThat(combatResult.monsterFighters()).hasSize(1);
        Assertions.assertThat(combatResult.monsterFighters().get(0).getRemainingFightingPower()).isEqualTo(18);
        Assertions.assertThat(combatResult.characterFighter().getRemainingFightingPower()).isEqualTo(12);
    }

    @Test
    void handle_should_fightMultipleMonstersAndNotKill() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(15, 15, 2, new LoadedDice(4));
        MonsterFighter monsterFighter = new MonsterFighter(18, 18, new LoadedDice(4));
        MonsterFighter monsterFighter2 = new MonsterFighter(18, 18, new LoadedDice(2));
        MonsterFighter monsterFighter3 = new MonsterFighter(18, 18, new LoadedDice(3));

        Fight actualFight = new Fight(
                characterFighter,
                List.of(monsterFighter, monsterFighter2, monsterFighter3));

        // when
        CombatResult combatResult = useCase.handle(actualFight);

        // then
        Assertions.assertThat(combatResult.monsterFighters()).hasSize(3);
        Assertions.assertThat(combatResult.monsterFighters().get(0).getRemainingFightingPower()).isEqualTo(14);
        Assertions.assertThat(combatResult.monsterFighters().get(1).getRemainingFightingPower()).isEqualTo(14);
        Assertions.assertThat(combatResult.monsterFighters().get(2).getRemainingFightingPower()).isEqualTo(18);
        Assertions.assertThat(combatResult.characterFighter().getRemainingFightingPower()).isEqualTo(5);
    }
}