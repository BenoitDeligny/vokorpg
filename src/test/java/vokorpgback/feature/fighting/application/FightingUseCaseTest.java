package vokorpgback.feature.fighting.application;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vokorpgback.feature.fighting.domain.CombatResult;
import vokorpgback.feature.fighting.domain.FightingCharacter;
import vokorpgback.feature.fighting.domain.FightingMonster;
import vokorpgback.feature.fighting.exposition.dto.FightingCharacterDto;
import vokorpgback.feature.fighting.exposition.dto.FightingMonsterDto;

public class FightingUseCaseTest {

    private FightingUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new FightingUseCase();
    }

    // TODO
    // MOCK DICE ROLL
    // make other tests
    @Test
    void handle_should_killMonsters() {
        // given
        FightingCharacterDto fightingCharacterDto = new FightingCharacterDto();
        fightingCharacterDto.setMaxFightingPower(15);
        fightingCharacterDto.setRemainingFightingPower(15);
        fightingCharacterDto.setCombatDice(3);

        FightingMonsterDto fightingMonsterDto = new FightingMonsterDto();
        fightingMonsterDto.setMaxFightingPower(3);
        fightingMonsterDto.setRemainingFightingPower(3);
        fightingMonsterDto.setCombatDice(1);

        FightingMonsterDto fightingMonsterDto2 = new FightingMonsterDto();
        fightingMonsterDto2.setMaxFightingPower(3);
        fightingMonsterDto2.setRemainingFightingPower(3);
        fightingMonsterDto2.setCombatDice(1);

        FightingMonsterDto fightingMonsterDto3 = new FightingMonsterDto();
        fightingMonsterDto3.setMaxFightingPower(3);
        fightingMonsterDto3.setRemainingFightingPower(3);
        fightingMonsterDto3.setCombatDice(1);

        FightingMonsterDto fightingMonsterDto4 = new FightingMonsterDto();
        fightingMonsterDto4.setMaxFightingPower(3);
        fightingMonsterDto4.setRemainingFightingPower(3);
        fightingMonsterDto4.setCombatDice(1);

        int numberOfMonstersFaced = fightingCharacterDto.getCombatDice();

        FightingCharacter expectedFightingCharacter = new FightingCharacter(15, 12, 3);
        FightingMonster expectedFightingMonster = new FightingMonster(3, 3, 1);

        // when
        Optional<CombatResult> combatResult = useCase.handle(fightingCharacterDto,
                List.of(fightingMonsterDto, fightingMonsterDto2, fightingMonsterDto3, fightingMonsterDto4),
                numberOfMonstersFaced);

        // then
        Assertions.assertThat(combatResult.get().fightingCharacter()).isEqualTo(expectedFightingCharacter);
        Assertions.assertThat(combatResult.get().fightingMonsters()).containsExactly(expectedFightingMonster);
    }

    @Test
    void handle_should_notKillMonster() {
        // given
        FightingCharacterDto fightingCharacterDto = new FightingCharacterDto();
        fightingCharacterDto.setMaxFightingPower(15);
        fightingCharacterDto.setRemainingFightingPower(15);
        fightingCharacterDto.setCombatDice(3);

        FightingMonsterDto fightingMonsterDto = new FightingMonsterDto();
        fightingMonsterDto.setMaxFightingPower(25);
        fightingMonsterDto.setRemainingFightingPower(25);
        fightingMonsterDto.setCombatDice(1);

        FightingMonsterDto fightingMonsterDto2 = new FightingMonsterDto();
        fightingMonsterDto2.setMaxFightingPower(25);
        fightingMonsterDto2.setRemainingFightingPower(25);
        fightingMonsterDto2.setCombatDice(1);

        FightingMonsterDto fightingMonsterDto3 = new FightingMonsterDto();
        fightingMonsterDto3.setMaxFightingPower(25);
        fightingMonsterDto3.setRemainingFightingPower(25);
        fightingMonsterDto3.setCombatDice(1);

        FightingMonsterDto fightingMonsterDto4 = new FightingMonsterDto();
        fightingMonsterDto4.setMaxFightingPower(25);
        fightingMonsterDto4.setRemainingFightingPower(25);
        fightingMonsterDto4.setCombatDice(1);

        int numberOfMonstersFaced = fightingCharacterDto.getCombatDice();

        FightingCharacter expectedFightingCharacter = new FightingCharacter(15, 3, 3);
        FightingMonster expectedFightingMonster = new FightingMonster(25, 16, 1);
        FightingMonster expectedFightingMonster2 = new FightingMonster(25, 16, 1);
        FightingMonster expectedFightingMonster3 = new FightingMonster(25, 16, 1);
        FightingMonster expectedFightingMonster4 = new FightingMonster(25, 25, 1);

        // when
        Optional<CombatResult> combatResult = useCase.handle(fightingCharacterDto,
                List.of(fightingMonsterDto, fightingMonsterDto2, fightingMonsterDto3, fightingMonsterDto4),
                numberOfMonstersFaced);

        // then
        Assertions.assertThat(combatResult.get().fightingCharacter()).isEqualTo(expectedFightingCharacter);
        Assertions.assertThat(combatResult.get().fightingMonsters())
                .containsExactly(
                        expectedFightingMonster,
                        expectedFightingMonster2,
                        expectedFightingMonster3,
                        expectedFightingMonster4);
    }
}