package vokorpgback.feature.character.infra;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vokorpgback.feature.character.infra.entity.CharacterEntity;
import vokorpgback.feature.character.infra.entity.CharacterEntity.CharacterIdentity;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.model.dice.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacterFactory;

@SpringBootTest
class CharacterH2StorageTest {
    private CharacterH2Storage storage;

    @Autowired
    private CharacterRepository jpaRepository;

    @BeforeEach
    void setUp() {
        storage = new CharacterH2Storage(jpaRepository);
    }

    @Test
    void save_shouldSave() {
        // given
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, new LoadedDiceFactory(), "Character");
        CharacterEntity expectedEntity = new CharacterEntity(
                new CharacterIdentity(legendaryCharacter.uuid(),"Character",legendaryCharacter.age()), 7, 7, 7, 21, 21, 21
        );

        // when
        storage.save(legendaryCharacter);

        // then
        Assertions.assertThat(jpaRepository.findAll()).contains(expectedEntity);
    }
}