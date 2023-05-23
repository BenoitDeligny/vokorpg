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

        Optional<LegendaryCharacter> characterCreated = createCharacterUseCase.handle(
                characterCreationRequest.getName(),
                characterCreationRequest.getMode());

        return ResponseEntity.of(toCharacterCreationResponse(characterCreated));
    }

    // TODO
    // add an update method

    // TODO
    // add specific exception
    private Optional<CharacterCreationResponse> toCharacterCreationResponse(Optional<LegendaryCharacter> character) {
        if (character.isEmpty()) {
            throw new RuntimeException("No character was created");
        }

        return Optional.of(new CharacterCreationResponse(
                character.get().name(),
                character.get().age(),
                character.get().abilities().strength().value(),
                character.get().abilities().agility().value(),
                character.get().abilities().perception().value(),
                character.get().totalPower()));
    }
}
