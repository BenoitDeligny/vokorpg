package vokorpgback.feature.commons.domain.model.character;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.dice.OfficialDiceFactory;

import static org.assertj.core.api.Assertions.assertThat;
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
        assertThat(legendaryCharacter.name()).isEqualTo("MyCharacter");
        assertThat(legendaryCharacter.age()).isEqualTo(20);

        assertThat(legendaryCharacter.strength()).isEqualTo(7);
        assertThat(legendaryCharacter.agility()).isEqualTo(7);
        assertThat(legendaryCharacter.perception()).isEqualTo(7);

        assertThat(legendaryCharacter.powers()).isEmpty();

        assertThat(legendaryCharacter.knowledge()).isEmpty();

        assertThat(legendaryCharacter.maxNaturalMight()).isEqualTo(21);
        assertThat(legendaryCharacter.maxTotalMight()).isEqualTo(21);
        assertThat(legendaryCharacter.remainingMight()).isEqualTo(21);
        assertThat(legendaryCharacter.characterCombatChart()).isEqualTo(CharacterCombatChart.TWO);
    }

    @Test
    void generateCharacterInEasyMode_withLoadedDice() {
        // given
        LoadedDiceFactory loadedDiceFactory = new LoadedDiceFactory();

        // when
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(EASY, loadedDiceFactory, "MyCharacter");

        // then
        assertThat(legendaryCharacter.name()).isEqualTo("MyCharacter");
        assertThat(legendaryCharacter.age()).isEqualTo(20);

        assertThat(legendaryCharacter.strength()).isEqualTo(10);
        assertThat(legendaryCharacter.agility()).isEqualTo(10);
        assertThat(legendaryCharacter.perception()).isEqualTo(10);

        assertThat(legendaryCharacter.powers()).isEmpty();

        assertThat(legendaryCharacter.knowledge()).isEmpty();

        assertThat(legendaryCharacter.maxNaturalMight()).isEqualTo(30);
        assertThat(legendaryCharacter.maxTotalMight()).isEqualTo(33);
        assertThat(legendaryCharacter.remainingMight()).isEqualTo(33);
        assertThat(legendaryCharacter.characterCombatChart()).isEqualTo(CharacterCombatChart.THREE);
    }

    @RepeatedTest(100)
    void generateCharacterInNormalMode_withOfficialDice() {
        // given
        OfficialDiceFactory officialDiceFactory = new OfficialDiceFactory();

        // when
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(NORMAL, officialDiceFactory, "MyCharacter");

        // then
        assertThat(legendaryCharacter.name()).isEqualTo("MyCharacter");
        assertThat(legendaryCharacter.age()).isBetween(15, 20);

        assertThat(legendaryCharacter.strength()).isBetween(2, 7);
        assertThat(legendaryCharacter.agility()).isBetween(2, 7);
        assertThat(legendaryCharacter.perception()).isBetween(2, 7);

        assertThat(legendaryCharacter.powers()).isEmpty();

        assertThat(legendaryCharacter.knowledge()).isEmpty();

        assertThat(legendaryCharacter.maxNaturalMight()).isBetween(6, 21);
        assertThat(legendaryCharacter.maxTotalMight()).isBetween(6, 21);
        assertThat(legendaryCharacter.remainingMight()).isBetween(6, 21);
        assertThat(legendaryCharacter.characterCombatChart()).isBetween(CharacterCombatChart.ZERO, CharacterCombatChart.TWO);
    }

    @RepeatedTest(100)
    void generateCharacterInEasyMode_withOfficialDice() {
        // given
        OfficialDiceFactory officialDiceFactory = new OfficialDiceFactory();

        // when
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(EASY, officialDiceFactory, "MyCharacter");

        // then
        assertThat(legendaryCharacter.name()).isEqualTo("MyCharacter");
        assertThat(legendaryCharacter.age()).isBetween(15, 20);

        assertThat(legendaryCharacter.strength()).isBetween(5, 10);
        assertThat(legendaryCharacter.agility()).isBetween(5, 10);
        assertThat(legendaryCharacter.perception()).isBetween(5, 10);

        assertThat(legendaryCharacter.powers()).isEmpty();

        assertThat(legendaryCharacter.knowledge()).isEmpty();

        assertThat(legendaryCharacter.maxNaturalMight()).isBetween(15, 30);
        assertThat(legendaryCharacter.maxTotalMight()).isBetween(18, 33);
        assertThat(legendaryCharacter.remainingMight()).isBetween(18, 33);
        assertThat(legendaryCharacter.characterCombatChart()).isBetween(CharacterCombatChart.ONE, CharacterCombatChart.THREE);
    }
}