package vokorpgback.feature.character.application;

import java.util.ArrayList;
import java.util.List;

import vokorpgback.feature.character.domain.model.Abilities;
import vokorpgback.feature.character.domain.model.Ability;
import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.domain.port.CharacterStorage;
import vokorpgback.feature.character.infra.entity.CharacterEntity;

public class InMemoryCharacterRepository implements CharacterStorage {

    private final List<CharacterEntity> inMemoryDatabase = new ArrayList<CharacterEntity>();

    @Override
    public LegendaryCharacter create(LegendaryCharacter character) {
        inMemoryDatabase.add(new CharacterEntity(
                character.name(),
                character.age(),
                character.abilities().strength().value(),
                character.abilities().agility().value(),
                character.abilities().perception().value(),
                character.abilities().computeTotalPower()));

        return character;
    }

    @Override
    public LegendaryCharacter update(LegendaryCharacter character) {
        CharacterEntity characterToUpdate = inMemoryDatabase.stream()
                .filter(savedCharacter -> character.name().equals(savedCharacter.getName()))
                .findAny()
                .orElse(null);

        // TODO
        // refacto this using .map()
        // fix setters
        int indexToUpdate = inMemoryDatabase.indexOf(characterToUpdate);

//        characterToUpdate.setAge(character.age());
//        characterToUpdate.setStrength(character.abilities().strength().value());
//        characterToUpdate.setAgility(character.abilities().agility().value());
//        characterToUpdate.setPerception(character.abilities().perception().value());
//        characterToUpdate.setTotalPower(character.abilities().computeTotalPower());

        inMemoryDatabase.set(indexToUpdate, characterToUpdate);

        return new LegendaryCharacter(
                characterToUpdate.getName(),
                characterToUpdate.getAge(),
                new Abilities(
                        new Ability(characterToUpdate.getStrength()),
                        new Ability(characterToUpdate.getAgility()),
                        new Ability(characterToUpdate.getPerception())),
                characterToUpdate.getTotalPower());
    }

    public List<CharacterEntity> getInMemoryDatabase() {
        return inMemoryDatabase;
    }
}
