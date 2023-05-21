package vokorpgback.feature.charactercreation.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import vokorpgback.feature.character.domain.model.Abilities;
import vokorpgback.feature.character.domain.model.Ability;
import vokorpgback.feature.character.domain.model.Character;
import vokorpgback.feature.character.domain.port.CharacterRepository;
import vokorpgback.feature.character.infra.entity.CharacterEntity;

public class InMemoryCharacterRepository implements CharacterRepository {

    private List<CharacterEntity> inMemoryDatabase = new ArrayList<CharacterEntity>();

    @Override
    public Character create(Character character) {
        inMemoryDatabase.add(new CharacterEntity(
                character.name(),
                character.age(),
                character.abilities().strength().value(),
                character.abilities().agility().value(),
                character.abilities().perception().value()));

        return character;
    }

    @Override
    public Character update(Character character) {
        CharacterEntity characterToUpdate = inMemoryDatabase.stream()
                .filter(savedCharacter -> character.name().equals(savedCharacter.getName()))
                .findAny()
                .orElse(null);

        // TODO
        // refacto this using .map()
        int indexToUpdate = inMemoryDatabase.indexOf(characterToUpdate);
        characterToUpdate.setAgility(15);
        inMemoryDatabase.set(indexToUpdate, characterToUpdate);

        return new Character(
                characterToUpdate.getName(),
                characterToUpdate.getAge(),
                new Abilities(
                        new Ability(characterToUpdate.getStrength()),
                        new Ability(characterToUpdate.getAgility()),
                        new Ability(characterToUpdate.getPerception())));
    }

    public List<CharacterEntity> getInMemoryDatabase() {
        return inMemoryDatabase;
    }
}
