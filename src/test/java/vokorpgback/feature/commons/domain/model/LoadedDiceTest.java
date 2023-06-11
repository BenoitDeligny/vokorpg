package vokorpgback.feature.commons.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoadedDiceTest {

    @Test
    void rollLoadedDice() {
        // given
        LoadedDice loadedDice = new LoadedDice(3);

        // when
        // then
        assertEquals(3, loadedDice.roll());
    }
}