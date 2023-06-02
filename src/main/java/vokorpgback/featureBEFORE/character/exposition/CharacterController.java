package vokorpgback.featureBEFORE.character.exposition;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vokorpgback.feature.character.application.CreateCharacterUseCase;
import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.featureBEFORE.character.domain.model.gear.Gear;
import vokorpgback.featureBEFORE.character.domain.model.gear.Item;
import vokorpgback.featureBEFORE.character.exposition.dto.*;
import vokorpgback.feature.commons.domain.model.GameMode;

import java.util.List;
import java.util.Optional;

// TODO
// https://www.baeldung.com/exception-handling-for-rest-with-spring
@RestController
@RequestMapping("")
public class CharacterController {

    private final CreateCharacterUseCase createCharacterUseCase;

    public CharacterController(CreateCharacterUseCase createLegendaryCharacterUseCase) {
        this.createCharacterUseCase = createLegendaryCharacterUseCase;
    }

    @PostMapping(
            value = "/character",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CharacterCreationResponse> createCharacter(@Valid @RequestBody CharacterCreationRequest characterCreationRequest) {

        LegendaryCharacter characterCreated = createCharacterUseCase.handle(
                toDomain(
                        characterCreationRequest.getName(),
                        characterCreationRequest.getMode())
        );

        return ResponseEntity.of(toCharacterCreationResponse(characterCreated));
    }

    private LegendaryCharacter toDomain(String name, String mode) {
        try {
            return LegendaryCharacter.generateCharacter(name, GameMode.valueOf(mode.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The mode you choose does not exists.", e);
        }
    }

    private Optional<CharacterCreationResponse> toCharacterCreationResponse(LegendaryCharacter character) {
        return Optional.of(
                new CharacterCreationResponse(
                        character.name(),
                        character.age(),
                        toAbilitiesDto(character.abilities()),
                        character.totalPower(),
                        // TODO
                        // renvoyer chaque emplacement séparement
                        toGearDto(character.gear())));
    }

    private AbilitiesDto toAbilitiesDto(Abilities abilities) {
        return new AbilitiesDto(abilities.strength().value(), abilities.agility().value(), abilities.perception().value());
    }

    private GearDto toGearDto(Gear gear) {
        return new GearDto(
                List.of(
                        toItemDto(gear.helmet()),
                        toItemDto(gear.mask()),
                        toItemDto(gear.necklace()),
                        toItemDto(gear.cloak()),
                        toItemDto(gear.costume()),
                        toItemDto(gear.armor()),
                        toItemDto(gear.shield()),
                        toItemDto(gear.primaryWeapon()),
                        toItemDto(gear.secondaryWeapon()),
                        toItemDto(gear.wristband()),
                        toItemDto(gear.gloves()),
                        toItemDto(gear.ring()),
                        toItemDto(gear.belt()),
                        toItemDto(gear.boots())
                )
        );
    }

    private ItemDto toItemDto(Item item) {
        return new ItemDto(
                item.getName(),
                item.getCategory().name(),
                item.getTraits().stream().map(trait -> trait.traitDescription()).toList(),
                item.getDescription()
        );
    }
}
