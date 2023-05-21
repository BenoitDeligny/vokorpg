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
import vokorpgback.feature.fighting.domain.CombatChart;
import vokorpgback.feature.fighting.exposition.dto.FightingRequest;
import vokorpgback.feature.fighting.exposition.dto.FightingResponse;

@RestController
@RequestMapping("")
public class FightingController {

    private FightingUseCase fightUseCase;

    public FightingController(FightingUseCase fightUseCase) {
        this.fightUseCase = fightUseCase;
    }

    @PostMapping(value = "/fight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FightingResponse> fightAgainstMonsters(@Valid @RequestBody FightingRequest fightingRequest) {

        Optional<CombatChart> combatResult = fightUseCase.handle(
                fightingRequest.getFightingCharacter(),
                fightingRequest.getMonsters(),
                fightingRequest.getNumberOfMonstersFaced());

        // TODO
        // add specific exception
        if (combatResult.isEmpty()) {
            throw new RuntimeException("No combat result");
        }

        int remainingMonsters = computeRemainingMonsters(fightingRequest, combatResult.get());

        return ResponseEntity.of(toResponse(combatResult.get(), remainingMonsters));
    }

    private int computeRemainingMonsters(FightingRequest request, CombatChart combatChart) {
        if (combatChart.equals(CombatChart.VICTORIOUS)) {
            return request.getMonsters().size() - request.getNumberOfMonstersFaced();
        }
        return request.getMonsters().size();
    }

    private Optional<FightingResponse> toResponse(CombatChart combatChart, int remainingMonsters) {

        return Optional.of(new FightingResponse(
                combatChart.name(),
                combatChart.getCircumstanceModifier(),
                remainingMonsters));
    }
}
