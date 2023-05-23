package vokorpgback.feature.fight.application;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vokorpgback.commons.FakeDiceRollService;
import vokorpgback.feature.fighting.application.FightingUseCase;
import vokorpgback.feature.fighting.domain.FightingMonster;
import vokorpgback.feature.fighting.exposition.dto.FightingCharacterDto;
import vokorpgback.feature.fighting.exposition.dto.FightingMonsterDto;

public class FightUseCaseTest {

    private FightingUseCase useCase;

    private FakeDiceRollService fakeDiceRoll;

    @BeforeEach
    void setUp() {
        fakeDiceRoll = new FakeDiceRollService();
        useCase = new FightingUseCase(fakeDiceRoll);
    }

    // TODO
    // this is not the final testing
    // should implement the full response
    @Test
    void handle_should_killThreeMonsters() {
        // given
        FightingCharacterDto fightingCharacterDto = new FightingCharacterDto();
        fightingCharacterDto.setMaxFightingPower(15);
        fightingCharacterDto.setRemainingFightingPower(15);
        fightingCharacterDto.setDamageDices(3);

        FightingMonsterDto fightingMonsterDto = new FightingMonsterDto();
        fightingMonsterDto.setMaxFightingPower(3);
        fightingMonsterDto.setRemainingFightingPower(3);

        FightingMonsterDto fightingMonsterDto2 = new FightingMonsterDto();
        fightingMonsterDto2.setMaxFightingPower(3);
        fightingMonsterDto2.setRemainingFightingPower(3);

        FightingMonsterDto fightingMonsterDto3 = new FightingMonsterDto();
        fightingMonsterDto3.setMaxFightingPower(3);
        fightingMonsterDto3.setRemainingFightingPower(3);

        FightingMonsterDto fightingMonsterDto4 = new FightingMonsterDto();
        fightingMonsterDto4.setMaxFightingPower(3);
        fightingMonsterDto4.setRemainingFightingPower(3);

        int numberOfMonstersFaced = fightingCharacterDto.getDamageDices();

        FightingMonster expectedFightingMonster = new FightingMonster(3, 3, 0);

        // when
        Optional<List<FightingMonster>> remainingFightingMonsters = useCase.handle(fightingCharacterDto,
                List.of(fightingMonsterDto, fightingMonsterDto2, fightingMonsterDto3, fightingMonsterDto4),
                numberOfMonstersFaced);

        // then
        Assertions.assertThat(remainingFightingMonsters.get()).containsExactly(expectedFightingMonster);
    }

    @Test
    void handle_should_notKillMonster() {
        // given
        FightingCharacterDto fightingCharacterDto = new FightingCharacterDto();
        fightingCharacterDto.setMaxFightingPower(5);
        fightingCharacterDto.setRemainingFightingPower(5);
        fightingCharacterDto.setDamageDices(3);

        FightingMonsterDto fightingMonsterDto = new FightingMonsterDto();
        fightingMonsterDto.setMaxFightingPower(25);
        fightingMonsterDto.setRemainingFightingPower(25);

        FightingMonsterDto fightingMonsterDto2 = new FightingMonsterDto();
        fightingMonsterDto2.setMaxFightingPower(25);
        fightingMonsterDto2.setRemainingFightingPower(25);

        FightingMonsterDto fightingMonsterDto3 = new FightingMonsterDto();
        fightingMonsterDto3.setMaxFightingPower(25);
        fightingMonsterDto3.setRemainingFightingPower(25);

        FightingMonsterDto fightingMonsterDto4 = new FightingMonsterDto();
        fightingMonsterDto4.setMaxFightingPower(25);
        fightingMonsterDto4.setRemainingFightingPower(25);

        int numberOfMonstersFaced = fightingCharacterDto.getDamageDices();

        FightingMonster expectedFightingMonster = new FightingMonster(25, 16, 0);
        FightingMonster expectedFightingMonster2 = new FightingMonster(25, 16, 0);
        FightingMonster expectedFightingMonster3 = new FightingMonster(25, 16, 0);
        FightingMonster expectedFightingMonster4 = new FightingMonster(25, 25, 0);

        // when
        Optional<List<FightingMonster>> remainingFightingMonsters = useCase.handle(fightingCharacterDto,
                List.of(fightingMonsterDto, fightingMonsterDto2, fightingMonsterDto3, fightingMonsterDto4),
                numberOfMonstersFaced);

        // then
        Assertions.assertThat(remainingFightingMonsters.get()).containsExactly(
                expectedFightingMonster,
                expectedFightingMonster2,
                expectedFightingMonster3,
                expectedFightingMonster4);
    }
}
