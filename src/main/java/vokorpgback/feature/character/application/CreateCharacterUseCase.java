package vokorpgback.feature.character.application;

import java.util.Optional;

import vokorpgback.feature.character.domain.model.Abilities;
import vokorpgback.feature.character.domain.model.Ability;
import vokorpgback.feature.character.domain.model.Character;
import vokorpgback.feature.character.domain.model.GameMode;
import vokorpgback.feature.character.domain.port.CharacterRepository;
import vokorpgback.utils.diceroll.DiceRoll;

public class CreateCharacterUseCase {

    private CharacterRepository repository;

    private DiceRoll diceRoll;

    public CreateCharacterUseCase(CharacterRepository repository, DiceRoll diceRoll) {
        this.repository = repository;
        this.diceRoll = diceRoll;
    }

    public Optional<Character> handle(String name, String mode) {
        return Optional.of(repository.create(toDomain(name, mode)));
    }

    private Character toDomain(String name, String mode) {
        // TODO
        // should game mode be mapped here ?
        // add validation of the game mode
        GameMode gameMode = GameMode.valueOf(mode.toUpperCase());

        return new Character(
                name,
                diceRoll.ageRoll(),
                new Abilities(
                        // TODO
                        // not sure the best way to do the easy mode modification
                        new Ability(diceRoll.strengthRoll() + gameMode.getAbilitiesModifier()),
                        new Ability(diceRoll.agilityRoll() + gameMode.getAbilitiesModifier()),
                        new Ability(diceRoll.perceptionRoll() + gameMode.getAbilitiesModifier())));
    }
}
