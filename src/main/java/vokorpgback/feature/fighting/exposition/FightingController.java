package vokorpgback.feature.fighting.exposition;

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
import vokorpgback.feature.fighting.application.FightingUseCase;
import vokorpgback.feature.fighting.domain.CombatResult;
import vokorpgback.feature.fighting.exposition.dto.FightingCharacterDto;
import vokorpgback.feature.fighting.exposition.dto.FightingMonsterDto;
import vokorpgback.feature.fighting.exposition.dto.FightingRequest;
import vokorpgback.feature.fighting.exposition.dto.FightingResponse;

@RestController
@RequestMapping("")
public class FightingController {

    private final FightingUseCase fightUseCase;

    public FightingController(FightingUseCase fightUseCase) {
        this.fightUseCase = fightUseCase;
    }

    @PostMapping(value = "/fight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    // TODO
    // add validation on DTO @NonNull / @NonEmpty ...
    public ResponseEntity<FightingResponse> fightAgainstMonsters(@Valid @RequestBody FightingRequest fightingRequest) {

        Optional<CombatResult> combatResult = fightUseCase.handle(
                fightingRequest.getFightingCharacter(),
                fightingRequest.getMonsters(),
                fightingRequest.getFightingCharacter().getDamageDice());

        // TODO
        // add specific exception
        if (combatResult.isEmpty()) {
            throw new RuntimeException("No combat result");
        }

        return ResponseEntity.of(toFightingResponse(combatResult.get()));
    }

    private Optional<FightingResponse> toFightingResponse(CombatResult combatResult) {

        return Optional.of(new FightingResponse(
                new FightingCharacterDto(
                        combatResult.fightingCharacter().maxFightingPower(),
                        combatResult.fightingCharacter().remainingFightingPower(),
                        combatResult.fightingCharacter().damageDices()),
                combatResult.fightingMonsters().stream()
                        .map(fightingMonster -> new FightingMonsterDto(
                                fightingMonster.maxFightingPower(),
                                fightingMonster.remainingFightingPower(),
                                fightingMonster.damageDice()))
                        .toList()
        ));
    }
}