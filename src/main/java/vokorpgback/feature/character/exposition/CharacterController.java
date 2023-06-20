package vokorpgback.feature.character.exposition;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import vokorpgback.feature.character.application.CreateCharacterUseCase;
import vokorpgback.feature.character.exposition.dto.CharacterCreationRequest;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacterFactory;
import vokorpgback.feature.commons.domain.model.dice.OfficialDiceFactory;

@RestController
public class CharacterController {

    private final CreateCharacterUseCase createCharacterUseCase;

    public CharacterController(CreateCharacterUseCase createCharacterUseCase) {
        this.createCharacterUseCase = createCharacterUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CharacterCreationResponse> createCharacter(
            @Valid @RequestBody CharacterCreationRequest request
    ) {

        LegendaryCharacter legendaryCharacter = createCharacterUseCase.handle(
                LegendaryCharacterFactory.generateLegendaryCharacter(
                        toGameModeDomain(request.getGameMode()),
                        new OfficialDiceFactory(),
                        request.getName()
                )
        );

        return ResponseEntity.ofNullable();
    }

    private GameMode toGameModeDomain(String gameModeDto) {
        return GameMode.valueOf(gameModeDto);
    }

    private CharacterCreationresponse toResponse(LegendaryCharacter legendaryCharacter) {

    }
}
