package vokorpgback.charactercreation.application;

import java.util.Optional;

import vokorpgback.charactercreation.domain.model.Abilities;
import vokorpgback.charactercreation.domain.model.Ability;
import vokorpgback.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.charactercreation.domain.port.LegendaryCharacterRepository;
import vokorpgback.utils.diceroll.DiceRoll;

public class CreateLegendaryCharacterUseCase {

    private LegendaryCharacterRepository repository;

    private DiceRoll diceRoll;

    public CreateLegendaryCharacterUseCase(LegendaryCharacterRepository repository, DiceRoll diceRoll) {
        this.repository = repository;
        this.diceRoll = diceRoll;
    }

    public Optional<LegendaryCharacter> handle(String name) {
        return Optional.of(repository.create(toDomain(name)));
    }

    private LegendaryCharacter toDomain(String name) {
        return new LegendaryCharacter(
                name,
                diceRoll.ageRoll(),
                new Abilities(
                        new Ability(diceRoll.strengthRoll()),
                        new Ability(diceRoll.agilityRoll()),
                        new Ability(diceRoll.perceptionRoll())));
    }
}
