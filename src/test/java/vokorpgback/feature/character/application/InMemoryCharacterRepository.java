package vokorpgback.feature.character.application;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.domain.port.CharacterStorage;
import vokorpgback.feature.character.infra.entity.CharacterEntity;
import vokorpgback.feature.commons.domain.model.GameMode;

public class InMemoryCharacterRepository implements CharacterStorage {

        private final List<CharacterEntity> inMemoryDatabase = new ArrayList<CharacterEntity>();

        @Override
        public LegendaryCharacter create(LegendaryCharacter character) {
                inMemoryDatabase.add(
                                new CharacterEntity(
                                                character.name(),
                                                character.age(),
                                                character.abilities().strength().value(),
                                                character.abilities().agility().value(),
                                                character.abilities().perception().value(),
                                                character.totalPower()));

                return character;
        }

        @Override
        public LegendaryCharacter update(LegendaryCharacter character) {
                // TODO
                // add logic
                return LegendaryCharacter.generateCharacter("Name", GameMode.NORMAL);
        }

        public List<CharacterEntity> getInMemoryDatabase() {
                return inMemoryDatabase;
        }
}
