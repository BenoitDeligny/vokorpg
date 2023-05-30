package vokorpgback.feature.character.domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.domain.model.gear.ItemCategory;
import vokorpgback.feature.character.domain.model.gear.GenericItem;
import vokorpgback.feature.character.domain.model.gear.MagicItem;
import vokorpgback.feature.character.domain.model.gear.Trait;
import vokorpgback.feature.commons.domain.model.GameMode;

// TODO
// those tests start to be ugly
class LegendaryCharacterTest {

    @RepeatedTest(100)
    void generateCharacter_when_normalMode() {
        // given
        GameMode gameMode = GameMode.NORMAL;

        // when
        LegendaryCharacter expectedCharacter = LegendaryCharacter.generateCharacter("Name", gameMode);

        // then
        Assertions.assertThat(expectedCharacter.name()).isEqualTo("Name");
        Assertions.assertThat(expectedCharacter.age()).isBetween(15, 20);

        Assertions.assertThat(expectedCharacter.abilities().strength().value()).isBetween(2, 7);
        Assertions.assertThat(expectedCharacter.abilities().agility().value()).isBetween(2, 7);
        Assertions.assertThat(expectedCharacter.abilities().perception().value()).isBetween(2, 7);
        Assertions.assertThat(expectedCharacter.totalPower()).isBetween(6, 21);

        Assertions.assertThat(expectedCharacter.gear().helmet()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().mask()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().necklace()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().cloak()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().costume()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().armor()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().shield()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().primaryWeapon()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().secondaryWeapon()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().wristband()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().gloves()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().ring()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().belt()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().boots()).isEqualTo(new GenericItem());
    }

    @RepeatedTest(100)
    void generateCharacter_when_easyMode() {
        // given
        GameMode gameMode = GameMode.EASY;

        // when
        LegendaryCharacter expectedCharacter = LegendaryCharacter.generateCharacter("Name", gameMode);

        // then
        Assertions.assertThat(expectedCharacter.name()).isEqualTo("Name");
        Assertions.assertThat(expectedCharacter.age()).isBetween(15, 20);

        Assertions.assertThat(expectedCharacter.abilities().strength().value()).isBetween(5, 10);
        Assertions.assertThat(expectedCharacter.abilities().agility().value()).isBetween(5, 10);
        Assertions.assertThat(expectedCharacter.abilities().perception().value()).isBetween(5, 10);
        Assertions.assertThat(expectedCharacter.totalPower()).isBetween(15, 30);

        Assertions.assertThat(expectedCharacter.gear().helmet()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().mask()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().necklace()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().cloak()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().costume()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().armor()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().shield()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().primaryWeapon()).isEqualTo(
                new MagicItem(
                        "Sacred Knife",
                        ItemCategory.WEAPON,
                        List.of(new Trait("A simple enchanted knife")),
                        "A simple enchanted knife",
                        false));
        Assertions.assertThat(expectedCharacter.gear().secondaryWeapon()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().wristband()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().gloves()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().ring()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().belt()).isEqualTo(new GenericItem());
        Assertions.assertThat(expectedCharacter.gear().boots()).isEqualTo(new GenericItem());
    }
}
