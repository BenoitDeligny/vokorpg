package vokorpgback.feature.character.exposition;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import vokorpgback.feature.character.application.CreateCharacterUseCase;
import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.exposition.dto.CharacterCreationRequest;
import vokorpgback.feature.character.exposition.dto.CharacterCreationResponse;
import vokorpgback.feature.commons.domain.model.GameMode;

@RestController
@RequestMapping("")
public class CharacterController {

    private final CreateCharacterUseCase createCharacterUseCase;

    public CharacterController(CreateCharacterUseCase createLegendaryCharacterUseCase) {
        this.createCharacterUseCase = createLegendaryCharacterUseCase;
    }

    @PostMapping(value = "/character", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CharacterCreationResponse> createCharacter(
            @Valid @RequestBody CharacterCreationRequest characterCreationRequest) {

        LegendaryCharacter characterCreated = createCharacterUseCase.handle(toDomain(
                characterCreationRequest.getName(),
                characterCreationRequest.getMode()));

        return ResponseEntity.of(toCharacterCreationResponse(characterCreated));
    }

    private LegendaryCharacter toDomain(String name, String mode) {
        GameMode gameMode = GameMode.valueOf(mode.toUpperCase());

        return LegendaryCharacter.generateCharacter(name, gameMode);
    }

    private Optional<CharacterCreationResponse> toCharacterCreationResponse(LegendaryCharacter character) {
        return Optional.of(new CharacterCreationResponse(
                character.name(),
                character.age(),
                character.abilities().strength().value(),
                character.abilities().agility().value(),
                character.abilities().perception().value(),
                character.totalPower()));
    }
}
