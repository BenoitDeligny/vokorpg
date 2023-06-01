package vokorpgback.featureBEFORE.fighting.exposition;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vokorpgback.feature.commons.domain.model.OfficialDice;
import vokorpgback.featureBEFORE.fighting.application.FightingUseCase;
import vokorpgback.featureBEFORE.fighting.domain.CombatResult;
import vokorpgback.featureBEFORE.fighting.domain.Fight;
import vokorpgback.featureBEFORE.fighting.domain.fighter.CharacterFighter;
import vokorpgback.featureBEFORE.fighting.domain.fighter.MonsterFighter;
import vokorpgback.featureBEFORE.fighting.exposition.dto.FightingCharacterDto;
import vokorpgback.featureBEFORE.fighting.exposition.dto.FightingMonsterDto;
import vokorpgback.featureBEFORE.fighting.exposition.dto.FightingRequest;
import vokorpgback.featureBEFORE.fighting.exposition.dto.FightingResponse;

import java.util.List;
import java.util.Optional;

// TODO
// https://www.baeldung.com/exception-handling-for-rest-with-spring
@RestController
@RequestMapping("")
public class FightingController {

    private final FightingUseCase fightUseCase;

    public FightingController(FightingUseCase fightUseCase) {
        this.fightUseCase = fightUseCase;
    }

    @PostMapping(
            value = "/fight",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FightingResponse> fightAgainstMonsters(@Valid @RequestBody FightingRequest fightingRequest) {

        CombatResult combatResult = fightUseCase.handle(
                toDomain(
                        fightingRequest.getCharacterFighter(),
                        fightingRequest.getMonsters(),
                        fightingRequest.getCharacterFighter().attemptToFlee()
                )
        );

        return ResponseEntity.of(toFightingResponse(combatResult));
    }

    private Fight toDomain(FightingCharacterDto characterDto, List<FightingMonsterDto> monsters, boolean attemptToFlee) {
        return new Fight(
                toCharacterDomain(characterDto),
                monsters.stream().map(this::toMonsterDomain).toList(),
                attemptToFlee);
    }

    private CharacterFighter toCharacterDomain(FightingCharacterDto dto) {
        return new CharacterFighter(
                dto.getMaxFightingPower(),
                dto.getRemainingFightingPower(),
                dto.getAgility(),
                new OfficialDice(6));
    }

    private MonsterFighter toMonsterDomain(FightingMonsterDto dto) {
        return new MonsterFighter(dto.getMaxFightingPower(), dto.getRemainingFightingPower(), new OfficialDice(6));
    }

    private Optional<FightingResponse> toFightingResponse(CombatResult combatResult) {
        return Optional.of(
                new FightingResponse(
                        new FightingCharacterDto(
                                combatResult.characterFighter().getMaxFightingPower(),
                                combatResult.characterFighter().getRemainingFightingPower(),
                                combatResult.characterFighter().getAgility()),
                        combatResult.monsterFighters().stream()
                                .map(fightingMonster ->
                                        new FightingMonsterDto(
                                                fightingMonster.getMaxFightingPower(),
                                                fightingMonster.getRemainingFightingPower())
                                )
                                .toList(),
                        combatResult.fightStatus().name()
                )
        );
    }
}
