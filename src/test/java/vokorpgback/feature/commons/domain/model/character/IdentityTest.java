package vokorpgback.feature.commons.domain.model.character;

import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.character.ability.Strength;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class IdentityTest {

    @Test
    void generateIdentity() {
        assertDoesNotThrow(() -> new Identity(UUID.randomUUID(), "MyCharacterName", 17));
    }

    @Test
    void generateIdentity_should_fails_when_nameIsInvalid() {
        assertThrows(IllegalArgumentException.class,() -> new Identity(UUID.randomUUID(), "MyCh4racterName", 17));
        assertThrows(IllegalArgumentException.class,() -> new Identity(UUID.randomUUID(), "My CharacterName", 17));
        assertThrows(IllegalArgumentException.class,() -> new Identity(UUID.randomUUID(), "M%CharacterName", 17));
        assertThrows(IllegalArgumentException.class,() -> new Identity(UUID.randomUUID(), "MyChäracterName", 17));
    }

    @Test
    void generateIdentity_should_fails_when_ageIsNotBetween15And20() {
        assertThrows(IllegalArgumentException.class,() -> new Identity(UUID.randomUUID(), "MyCharacterName", 14));
        assertThrows(IllegalArgumentException.class,() -> new Identity(UUID.randomUUID(), "MyCharacterName", 21));
    }
}