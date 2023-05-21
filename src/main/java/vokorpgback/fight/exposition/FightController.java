package vokorpgback.fight.exposition;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import vokorpgback.fight.application.FightingUseCase;
import vokorpgback.fight.domain.CombatChart;
import vokorpgback.fight.exposition.dto.FightingDto;

@RestController
@RequestMapping("")
public class FightController {

    private FightingUseCase fightUseCase;

    public FightController(FightingUseCase fightUseCase) {
        this.fightUseCase = fightUseCase;
    }

    // TODO
    // add validation @NonNull and @Validated
    // controller should not return domain object ?
    @PostMapping(value = "/fight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CombatChart> fightAgainstMonsters(
            @RequestBody FightingDto fightingDto) {
        return ResponseEntity.of(fightUseCase
                .handle(
                        fightingDto.getFightingCharacter(),
                        fightingDto.getMonsters(),
                        fightingDto.getNumberOfMonstersFaced()));
    }

}
