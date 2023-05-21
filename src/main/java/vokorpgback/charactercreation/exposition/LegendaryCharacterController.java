package vokorpgback.charactercreation.exposition;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import vokorpgback.charactercreation.application.CreateLegendaryCharacterUseCase;
import vokorpgback.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.charactercreation.exposition.dto.LegendaryCharacterDto;

@RestController
@RequestMapping("")
public class LegendaryCharacterController {

    private CreateLegendaryCharacterUseCase createLegendaryCharacterUseCase;

    public LegendaryCharacterController(CreateLegendaryCharacterUseCase createLegendaryCharacterUseCase) {
        this.createLegendaryCharacterUseCase = createLegendaryCharacterUseCase;
    }

    // TODO
    // add validation @NonNull and @Validated
    // controller should not send domain object ?
    @PostMapping(value = "/legendaryCharacter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LegendaryCharacter> createLegendaryCharacter(
            @RequestBody LegendaryCharacterDto legendaryCharacterDto) {
        Optional<LegendaryCharacter> legendaryCharacterCreated = createLegendaryCharacterUseCase
                .handle(legendaryCharacterDto.getName());

        return ResponseEntity.of(legendaryCharacterCreated);
    }
}
