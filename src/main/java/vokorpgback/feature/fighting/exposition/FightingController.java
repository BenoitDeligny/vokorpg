package vokorpgback.feature.fighting.exposition;

import java.util.List;
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
import vokorpgback.feature.commons.domain.model.Fight;
import vokorpgback.feature.fighting.application.FightingUseCase;
import vokorpgback.feature.fighting.domain.CombatResult;
import vokorpgback.feature.fighting.domain.FightingCharacter;
import vokorpgback.feature.fighting.domain.FightingMonster;
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
    public ResponseEntity<FightingResponse> fightAgainstMonsters(@Valid @RequestBody FightingRequest fightingRequest) {

        CombatResult combatResult = fightUseCase.handle(
                toDomain(
                        fightingRequest.getFightingCharacter(),
                        fightingRequest.getMonsters()
                )
        );

        return ResponseEntity.of(toFightingResponse(combatResult));
    }

    private Fight toDomain(FightingCharacterDto characterDto, List<FightingMonsterDto> monsters) {
        return new Fight(
                toCharacterDomain(characterDto),
                monsters.stream()
                        .map(this::toMonsterDomain)
                        .toList()
        );
    }

    private FightingCharacter toCharacterDomain(FightingCharacterDto dto) {
        return new FightingCharacter(
                dto.getMaxFightingPower(),
                dto.getRemainingFightingPower(),
                dto.getAgility()
        );
    }

    private FightingMonster toMonsterDomain(FightingMonsterDto dto) {
        return new FightingMonster(
                dto.getMaxFightingPower(),
                dto.getRemainingFightingPower()
        );
    }

    private Optional<FightingResponse> toFightingResponse(CombatResult combatResult) {

        return Optional.of(new FightingResponse(
                new FightingCharacterDto(
                        combatResult.fightingCharacter().maxFightingPower(),
                        combatResult.fightingCharacter().remainingFightingPower(),
                        combatResult.fightingCharacter().agility()
                ),
                combatResult.fightingMonsters().stream()
                        .map(fightingMonster -> new FightingMonsterDto(
                                fightingMonster.maxFightingPower(),
                                fightingMonster.remainingFightingPower()
                        ))
                        .toList()
        ));
    }
}