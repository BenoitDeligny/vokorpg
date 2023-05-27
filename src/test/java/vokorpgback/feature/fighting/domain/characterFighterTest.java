package vokorpgback.feature.fighting.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.fighting.domain.fighter.CharacterFighter;

class CharacterFighterTest {

    @Test
    void fightingCharacter_should_beDead() {
        // given
        CharacterFighter character = new CharacterFighter(100, 0, 3);

        // then
        Assertions.assertThat(character.isDead()).isTrue();
    }

    @Test
    void fightingCharacter_should_beAlive() {
        // given
        CharacterFighter character = new CharacterFighter(100, 5, 30);

        // then
        Assertions.assertThat(character.isDead()).isFalse();
    }

}
