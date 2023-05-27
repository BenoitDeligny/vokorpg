package vokorpgback.feature.fighting.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.fighting.domain.fighter.MonsterFighter;

class MonsterFighterTest {
    @Test
    void FightingMonster_should_beDead() {
        // given
        MonsterFighter character = new MonsterFighter(100, 0);

        // then
        Assertions.assertThat(character.isDead()).isTrue();
    }

    @Test
    void FightingMonster_should_beAlive() {
        // given
        MonsterFighter character = new MonsterFighter(100, 50);

        // then
        Assertions.assertThat(character.isDead()).isFalse();
    }
}