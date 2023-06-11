package vokorpgback.feature.commons.domain.model.character.ability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbilitiesTest {

    @Test
    void generateAbility() {
        // given
        // when
        // then
        assertDoesNotThrow(() -> new Strength(3));
        assertDoesNotThrow(() -> new Agility(1));
        assertDoesNotThrow(() -> new Perception(5));
    }

    @Test
    void generateAbility_should_fails_when_negativeValue() {
        // given
        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> new Strength(-4));
        assertThrows(IllegalArgumentException.class, () -> new Agility(0));
        assertThrows(IllegalArgumentException.class, () -> new Perception(-1));
        assertDoesNotThrow(() -> new Perception(5));
    }
}