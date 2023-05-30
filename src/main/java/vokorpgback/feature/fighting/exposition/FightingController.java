package vokorpgback.feature.fighting.exposition;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import vokorpgback.feature.commons.domain.model.GameDice;
import vokorpgback.feature.fighting.application.FightingUseCase;
import vokorpgback.feature.fighting.application.FleeingUseCase;
import vokorpgback.feature.fighting.domain.CombatResult;
import vokorpgback.feature.fighting.domain.Fight;
import vokorpgback.feature.fighting.domain.FightStatus;
import vokorpgback.feature.fighting.domain.fighter.CharacterFighter;
import vokorpgback.feature.fighting.domain.fighter.MonsterFighter;
import vokorpgback.feature.fighting.exposition.dto.FightingCharacterDto;
import vokorpgback.feature.fighting.exposition.dto.FightingMonsterDto;
import vokorpgback.feature.fighting.exposition.dto.FightingRequest;
import vokorpgback.feature.fighting.exposition.dto.FightingResponse;

import java.util.List;
import java.util.Optional;

// TODO
// https://www.baeldung.com/exception-handling-for-rest-with-spring
@RestController
@RequestMapping("")
public class FightingController {

    private final FightingUseCase fightUseCase;
    private final FleeingUseCase fleeingUseCase;

    public FightingController(FightingUseCase fightUseCase, FleeingUseCase fleeingUseCase) {
        this.fightUseCase = fightUseCase;
        this.fleeingUseCase = fleeingUseCase;
    }

    @PostMapping(value = "/fight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FightingResponse> fightAgainstMonsters(
            @Valid @RequestBody FightingRequest fightingRequest) {

        if (fightingRequest.attemptToFlee() && fleeingUseCase.handle()) {
            return ResponseEntity.of(
                    toFightingResponse(
                            new CombatResult(
                                    toCharacterDomain(fightingRequest.getCharacterFighter()),
                                    fightingRequest.getMonsters().stream()
                                            .map(this::toMonsterDomain)
                                            .toList(),
                                    FightStatus.FLED
                            )
                    )
            );
        }
        CombatResult combatResult = fightUseCase.handle(
                toDomain(
                        fightingRequest.getCharacterFighter(),
                        fightingRequest.getMonsters()));

        return ResponseEntity.of(toFightingResponse(combatResult));
    }

    private Fight toDomain(FightingCharacterDto characterDto, List<FightingMonsterDto> monsters) {
        return new Fight(
                toCharacterDomain(characterDto),
                monsters.stream()
                        .map(this::toMonsterDomain)
                        .toList());
    }

    private CharacterFighter toCharacterDomain(FightingCharacterDto dto) {
        return new CharacterFighter(
                dto.getMaxFightingPower(),
                dto.getRemainingFightingPower(),
                dto.getAgility(),
                new GameDice(6));
    }

    private MonsterFighter toMonsterDomain(FightingMonsterDto dto) {
        return new MonsterFighter(
                dto.getMaxFightingPower(),
                dto.getRemainingFightingPower(),
                new GameDice(6));
    }

    private Optional<FightingResponse> toFightingResponse(CombatResult combatResult) {
        // TODO
        // retourner autre chose en cas de fuite ?
        return Optional.of(new FightingResponse(
                new FightingCharacterDto(
                        combatResult.characterFighter().getMaxFightingPower(),
                        combatResult.characterFighter().getRemainingFightingPower(),
                        combatResult.characterFighter().getAgility()),
                combatResult.monsterFighters().stream()
                        .map(fightingMonster -> new FightingMonsterDto(
                                fightingMonster.getMaxFightingPower(),
                                fightingMonster.getRemainingFightingPower()))
                        .toList(),
                combatResult.fightStatus().name()));
    }
}