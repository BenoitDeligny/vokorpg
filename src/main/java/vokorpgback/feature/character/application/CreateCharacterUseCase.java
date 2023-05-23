package vokorpgback.feature.character.application;

import java.util.Optional;

import vokorpgback.feature.character.domain.model.Abilities;
import vokorpgback.feature.character.domain.model.Ability;
import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.domain.model.GameMode;
import vokorpgback.feature.character.domain.port.CharacterStorage;
import vokorpgback.utils.diceroll.DiceRoll;

public class CreateCharacterUseCase {

    private final CharacterStorage repository;

    private final DiceRoll diceRoll;

    private final int BASE_AGE = 14;

    public CreateCharacterUseCase(CharacterStorage repository, DiceRoll diceRoll) {
        this.repository = repository;
        this.diceRoll = diceRoll;
    }

    public Optional<LegendaryCharacter> handle(String name, String mode) {
        return Optional.of(repository.create(toDomain(name, mode)));
    }

    private LegendaryCharacter toDomain(String name, String mode) {
        
        GameMode gameMode = GameMode.valueOf(mode.toUpperCase());
        
        Abilities abilitiesCreated = computeAbilities(gameMode);

        return new LegendaryCharacter(
                name,
                computeAge(),
                abilitiesCreated,
                abilitiesCreated.computeTotalPower());
    }

    private int computeAge() {
        return BASE_AGE + diceRoll.ageRoll();
    }

    private Abilities computeAbilities(GameMode gameMode) {
        return new Abilities(
                new Ability(diceRoll.strengthRoll() + gameMode.getAbilitiesModifier()),
                new Ability(diceRoll.agilityRoll() + gameMode.getAbilitiesModifier()),
                new Ability(diceRoll.perceptionRoll() + gameMode.getAbilitiesModifier()));
    }
}
