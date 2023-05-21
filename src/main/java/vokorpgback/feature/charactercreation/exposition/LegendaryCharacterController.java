package vokorpgback.feature.charactercreation.exposition;

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
import vokorpgback.feature.charactercreation.application.CreateLegendaryCharacterUseCase;
import vokorpgback.feature.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.feature.charactercreation.exposition.dto.LegendaryCharacterRequest;
import vokorpgback.feature.charactercreation.exposition.dto.LegendaryCharacterResponse;

@RestController
@RequestMapping("")
public class LegendaryCharacterController {

    private CreateLegendaryCharacterUseCase createLegendaryCharacterUseCase;

    public LegendaryCharacterController(CreateLegendaryCharacterUseCase createLegendaryCharacterUseCase) {
        this.createLegendaryCharacterUseCase = createLegendaryCharacterUseCase;
    }

    @PostMapping(value = "/legendaryCharacter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LegendaryCharacterResponse> createLegendaryCharacter(
            @Valid @RequestBody LegendaryCharacterRequest legendaryCharacterRequest) {
                
        Optional<LegendaryCharacter> legendaryCharacterCreated = createLegendaryCharacterUseCase
                .handle(legendaryCharacterRequest.getName());

        return ResponseEntity.of(toResponse(legendaryCharacterCreated));
    }

    // TODO
    // add specific exception
    private Optional<LegendaryCharacterResponse> toResponse(Optional<LegendaryCharacter> legendaryCharacter) {
        if (legendaryCharacter.isEmpty()) {
            throw new RuntimeException("No character was created");
        }

        return Optional.ofNullable(new LegendaryCharacterResponse(
                legendaryCharacter.get().name(),
                legendaryCharacter.get().age(),
                legendaryCharacter.get().abilities().strength().value(),
                legendaryCharacter.get().abilities().agility().value(),
                legendaryCharacter.get().abilities().perception().value()));
    }
}
