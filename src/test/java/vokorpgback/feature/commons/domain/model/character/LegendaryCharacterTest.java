package vokorpgback.feature.commons.domain.model.character;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.dice.OfficialDiceFactory;

import static vokorpgback.feature.commons.domain.model.GameMode.EASY;
import static vokorpgback.feature.commons.domain.model.GameMode.NORMAL;

class LegendaryCharacterTest {

    @Test
    void generateCharacterInNormalMode_withLoadedDice() {
        // given
        LoadedDiceFactory loadedDiceFactory = new LoadedDiceFactory();

        // when
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(NORMAL, loadedDiceFactory, "MyCharacter");

        // then
        Assertions.assertThat(legendaryCharacter.identity().name()).isEqualTo("MyCharacter");
        Assertions.assertThat(legendaryCharacter.identity().age()).isEqualTo(20);

        Assertions.assertThat(legendaryCharacter.strength().value()).isEqualTo(7);
        Assertions.assertThat(legendaryCharacter.agility().value()).isEqualTo(7);
        Assertions.assertThat(legendaryCharacter.perception().value()).isEqualTo(7);

        Assertions.assertThat(legendaryCharacter.powers()).isEmpty();

        Assertions.assertThat(legendaryCharacter.knowledge()).isEmpty();

        Assertions.assertThat(legendaryCharacter.fightingMight().maxNaturalMight()).isEqualTo(21);
        Assertions.assertThat(legendaryCharacter.fightingMight().maxTotalMight()).isEqualTo(21);
        Assertions.assertThat(legendaryCharacter.fightingMight().remainingMight()).isEqualTo(21);
        Assertions.assertThat(legendaryCharacter.fightingMight().characterCombatChart()).isEqualTo(CharacterCombatChart.TWO);
    }

    @Test
    void generateCharacterInEasyMode_withLoadedDice() {
        // given
        LoadedDiceFactory loadedDiceFactory = new LoadedDiceFactory();

        // when
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(EASY, loadedDiceFactory, "MyCharacter");

        // then
        Assertions.assertThat(legendaryCharacter.identity().name()).isEqualTo("MyCharacter");
        Assertions.assertThat(legendaryCharacter.identity().age()).isEqualTo(20);

        Assertions.assertThat(legendaryCharacter.strength().value()).isEqualTo(10);
        Assertions.assertThat(legendaryCharacter.agility().value()).isEqualTo(10);
        Assertions.assertThat(legendaryCharacter.perception().value()).isEqualTo(10);

        Assertions.assertThat(legendaryCharacter.powers()).isEmpty();

        Assertions.assertThat(legendaryCharacter.knowledge()).isEmpty();

        Assertions.assertThat(legendaryCharacter.fightingMight().maxNaturalMight()).isEqualTo(30);
        Assertions.assertThat(legendaryCharacter.fightingMight().maxTotalMight()).isEqualTo(33);
        Assertions.assertThat(legendaryCharacter.fightingMight().remainingMight()).isEqualTo(33);
        Assertions.assertThat(legendaryCharacter.fightingMight().characterCombatChart()).isEqualTo(CharacterCombatChart.THREE);
    }

    @RepeatedTest(50)
    void generateCharacterInNormalMode_withOfficialDice() {
        // given
        OfficialDiceFactory officialDiceFactory = new OfficialDiceFactory();

        // when
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(NORMAL, officialDiceFactory, "MyCharacter");

        // then
        Assertions.assertThat(legendaryCharacter.identity().name()).isEqualTo("MyCharacter");
        Assertions.assertThat(legendaryCharacter.identity().age()).isBetween(15, 20);

        Assertions.assertThat(legendaryCharacter.strength().value()).isBetween(2, 7);
        Assertions.assertThat(legendaryCharacter.agility().value()).isBetween(2, 7);
        Assertions.assertThat(legendaryCharacter.perception().value()).isBetween(2, 7);

        Assertions.assertThat(legendaryCharacter.powers()).isEmpty();

        Assertions.assertThat(legendaryCharacter.knowledge()).isEmpty();

        Assertions.assertThat(legendaryCharacter.fightingMight().maxNaturalMight()).isBetween(6, 21);
        Assertions.assertThat(legendaryCharacter.fightingMight().maxTotalMight()).isBetween(6, 21);
        Assertions.assertThat(legendaryCharacter.fightingMight().remainingMight()).isBetween(6, 21);
        Assertions.assertThat(legendaryCharacter.fightingMight().characterCombatChart()).isBetween(CharacterCombatChart.ZERO, CharacterCombatChart.TWO);
    }

    @RepeatedTest(50)
    void generateCharacterInEasyMode_withOfficialDice() {
        // given
        OfficialDiceFactory officialDiceFactory = new OfficialDiceFactory();

        // when
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(EASY, officialDiceFactory, "MyCharacter");

        // then
        Assertions.assertThat(legendaryCharacter.identity().name()).isEqualTo("MyCharacter");
        Assertions.assertThat(legendaryCharacter.identity().age()).isBetween(15, 20);

        Assertions.assertThat(legendaryCharacter.strength().value()).isBetween(5, 10);
        Assertions.assertThat(legendaryCharacter.agility().value()).isBetween(5, 10);
        Assertions.assertThat(legendaryCharacter.perception().value()).isBetween(5, 10);

        Assertions.assertThat(legendaryCharacter.powers()).isEmpty();

        Assertions.assertThat(legendaryCharacter.knowledge()).isEmpty();

        Assertions.assertThat(legendaryCharacter.fightingMight().maxNaturalMight()).isBetween(15, 30);
        Assertions.assertThat(legendaryCharacter.fightingMight().maxTotalMight()).isBetween(18, 33);
        Assertions.assertThat(legendaryCharacter.fightingMight().remainingMight()).isBetween(18, 33);
        Assertions.assertThat(legendaryCharacter.fightingMight().characterCombatChart()).isBetween(CharacterCombatChart.ONE, CharacterCombatChart.TWO);
    }
}