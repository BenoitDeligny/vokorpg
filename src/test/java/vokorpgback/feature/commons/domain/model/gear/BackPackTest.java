package vokorpgback.feature.commons.domain.model.gear;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static vokorpgback.feature.commons.domain.model.GameMode.EASY;
import static vokorpgback.feature.commons.domain.model.GameMode.NORMAL;
import static vokorpgback.feature.commons.domain.model.gear.TraitType.HEAL;

class BackPackTest {

    @Test
    void generateBackPack() {
        // given
        BackPack normalBackPack = BackPackFactory.generateBackPack(NORMAL);
        BackPack easyBackPack = BackPackFactory.generateBackPack(EASY);

        // when
        // then
        Assertions.assertThat(normalBackPack.consumables()).isEmpty();
        Assertions.assertThat(easyBackPack.consumables()).containsExactly(
                new Consumable(
                        "Magical bays",
                        ItemType.CONSUMABLE,
                        new Trait(HEAL, 2),
                        "Few little bays that you can eat.",
                        false,
                        3
                ));
    }
}