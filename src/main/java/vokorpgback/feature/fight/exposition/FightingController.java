package vokorpgback.feature.fight.exposition;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import vokorpgback.feature.fight.application.FightingUseCase;
import vokorpgback.feature.fight.domain.CombatChart;
import vokorpgback.feature.fight.exposition.dto.FightingDto;

@RestController
@RequestMapping("")
public class FightingController {

    private FightingUseCase fightUseCase;

    public FightingController(FightingUseCase fightUseCase) {
        this.fightUseCase = fightUseCase;
    }

    // TODO
    // controller should not return domain object ?
    @PostMapping(value = "/fight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CombatChart> fightAgainstMonsters(@Valid @RequestBody FightingDto fightingDto) {

        return ResponseEntity.of(fightUseCase
                .handle(
                        fightingDto.getFightingCharacter(),
                        fightingDto.getMonsters(),
                        fightingDto.getNumberOfMonstersFaced()));
    }
}
