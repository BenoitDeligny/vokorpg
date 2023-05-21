package vokorpgback.fight.application;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vokorpgback.commons.FakeDiceRoll;
import vokorpgback.feature.fight.application.FightingUseCase;
import vokorpgback.feature.fight.domain.CombatChart;
import vokorpgback.feature.fight.exposition.dto.FightingCharacterDto;
import vokorpgback.feature.fight.exposition.dto.FightingMonsterDto;

public class FightUseCaseTest {

    private FightingUseCase useCase;

    private FakeDiceRoll fakeDiceRoll;

    @BeforeEach
    void setUp() {
        fakeDiceRoll = new FakeDiceRoll();
        useCase = new FightingUseCase(fakeDiceRoll);
    }

    @Test
    void handle_shouldReturnDefeated() {
        // given
        FightingCharacterDto fightingCharacter = new FightingCharacterDto();
        fightingCharacter.setFightingPower(5);
        fightingCharacter.setCircumstanceModifier(0);

        FightingMonsterDto fightingMonster1 = new FightingMonsterDto();
        fightingMonster1.setFightingPower(9);

        FightingMonsterDto fightingMonster2 = new FightingMonsterDto();
        fightingMonster2.setFightingPower(999);

        List<FightingMonsterDto> fightingMonsters = List.of(fightingMonster1, fightingMonster2);

        int numberOfMonstersFaced = 1;

        // when
        Optional<CombatChart> combatResult = useCase.handle(fightingCharacter, fightingMonsters, numberOfMonstersFaced);

        // then
        Assertions.assertThat(combatResult.get()).isEqualTo(CombatChart.DEFEATED);
    }

    @Test
    void handle_shouldReturnSeriouslyInjured() {
        // given
        FightingCharacterDto fightingCharacter = new FightingCharacterDto();
        fightingCharacter.setFightingPower(5);
        fightingCharacter.setCircumstanceModifier(0);

        FightingMonsterDto fightingMonster1 = new FightingMonsterDto();
        fightingMonster1.setFightingPower(8);

        FightingMonsterDto fightingMonster2 = new FightingMonsterDto();
        fightingMonster2.setFightingPower(999);

        List<FightingMonsterDto> fightingMonsters = List.of(fightingMonster1, fightingMonster2);

        int numberOfMonstersFaced = 1;

        // when
        Optional<CombatChart> combatResult = useCase.handle(fightingCharacter, fightingMonsters, numberOfMonstersFaced);

        // then
        Assertions.assertThat(combatResult.get()).isEqualTo(CombatChart.SERIOUSLY_INJURED);
    }

    @Test
    void handle_shouldReturnInjured() {
        // given
        FightingCharacterDto fightingCharacter = new FightingCharacterDto();
        fightingCharacter.setFightingPower(7);
        fightingCharacter.setCircumstanceModifier(0);

        FightingMonsterDto fightingMonster1 = new FightingMonsterDto();
        fightingMonster1.setFightingPower(5);

        FightingMonsterDto fightingMonster2 = new FightingMonsterDto();
        fightingMonster2.setFightingPower(999);

        List<FightingMonsterDto> fightingMonsters = List.of(fightingMonster1, fightingMonster2);

        int numberOfMonstersFaced = 1;

        // when
        Optional<CombatChart> combatResult = useCase.handle(fightingCharacter, fightingMonsters, numberOfMonstersFaced);

        // then
        Assertions.assertThat(combatResult.get()).isEqualTo(CombatChart.INJURED);
    }

    @Test
    void handle_shouldReturnDraw() {
        // given
        FightingCharacterDto fightingCharacter = new FightingCharacterDto();
        fightingCharacter.setFightingPower(10);
        fightingCharacter.setCircumstanceModifier(0);

        FightingMonsterDto fightingMonster1 = new FightingMonsterDto();
        fightingMonster1.setFightingPower(5);

        FightingMonsterDto fightingMonster2 = new FightingMonsterDto();
        fightingMonster2.setFightingPower(999);

        List<FightingMonsterDto> fightingMonsters = List.of(fightingMonster1, fightingMonster2);

        int numberOfMonstersFaced = 1;

        // when
        Optional<CombatChart> combatResult = useCase.handle(fightingCharacter, fightingMonsters, numberOfMonstersFaced);

        // then
        Assertions.assertThat(combatResult.get()).isEqualTo(CombatChart.DRAW);
    }

    @Test
    void handle_shouldReturnBearlyVictorious() {
        // given
        FightingCharacterDto fightingCharacter = new FightingCharacterDto();
        fightingCharacter.setFightingPower(12);
        fightingCharacter.setCircumstanceModifier(0);

        FightingMonsterDto fightingMonster1 = new FightingMonsterDto();
        fightingMonster1.setFightingPower(5);

        FightingMonsterDto fightingMonster2 = new FightingMonsterDto();
        fightingMonster2.setFightingPower(999);

        List<FightingMonsterDto> fightingMonsters = List.of(fightingMonster1, fightingMonster2);

        int numberOfMonstersFaced = 1;

        // when
        Optional<CombatChart> combatResult = useCase.handle(fightingCharacter, fightingMonsters, numberOfMonstersFaced);

        // then
        Assertions.assertThat(combatResult.get()).isEqualTo(CombatChart.BEARLY_VICTORIOUS);
    }

    @Test
    void handle_shouldReturnAlmostVictorious() {
        // given
        FightingCharacterDto fightingCharacter = new FightingCharacterDto();
        fightingCharacter.setFightingPower(14);
        fightingCharacter.setCircumstanceModifier(0);

        FightingMonsterDto fightingMonster1 = new FightingMonsterDto();
        fightingMonster1.setFightingPower(5);

        FightingMonsterDto fightingMonster2 = new FightingMonsterDto();
        fightingMonster2.setFightingPower(999);

        List<FightingMonsterDto> fightingMonsters = List.of(fightingMonster1, fightingMonster2);

        int numberOfMonstersFaced = 1;

        // when
        Optional<CombatChart> combatResult = useCase.handle(fightingCharacter, fightingMonsters, numberOfMonstersFaced);

        // then
        Assertions.assertThat(combatResult.get()).isEqualTo(CombatChart.ALMOST_VICTORIOUS);
    }

    @Test
    void handle_shouldReturnVictorious() {
        // given
        FightingCharacterDto fightingCharacter = new FightingCharacterDto();
        fightingCharacter.setFightingPower(16);
        fightingCharacter.setCircumstanceModifier(0);

        FightingMonsterDto fightingMonster1 = new FightingMonsterDto();
        fightingMonster1.setFightingPower(3);

        FightingMonsterDto fightingMonster2 = new FightingMonsterDto();
        fightingMonster2.setFightingPower(999);

        List<FightingMonsterDto> fightingMonsters = List.of(fightingMonster1, fightingMonster2);

        int numberOfMonstersFaced = 1;

        // when
        Optional<CombatChart> combatResult = useCase.handle(fightingCharacter, fightingMonsters, numberOfMonstersFaced);

        // then
        Assertions.assertThat(combatResult.get()).isEqualTo(CombatChart.VICTORIOUS);
    }

    @Test
    void handle_shouldReturnDefeated_whenFightsAgainstMultipleMonsters() {
        // given
        FightingCharacterDto fightingCharacter = new FightingCharacterDto();
        fightingCharacter.setFightingPower(10);
        fightingCharacter.setCircumstanceModifier(0);

        FightingMonsterDto fightingMonster1 = new FightingMonsterDto();
        fightingMonster1.setFightingPower(7);

        FightingMonsterDto fightingMonster2 = new FightingMonsterDto();
        fightingMonster2.setFightingPower(7);

        List<FightingMonsterDto> fightingMonsters = List.of(fightingMonster1, fightingMonster2);

        int numberOfMonstersFaced = 2;

        // when
        Optional<CombatChart> combatResult = useCase.handle(fightingCharacter, fightingMonsters, numberOfMonstersFaced);

        // then
        Assertions.assertThat(combatResult.get()).isEqualTo(CombatChart.DEFEATED);
    }

    @Test
    void handle_shouldReturnDraw_whenFightsAgainstMultipleMonsters() {
        // given
        FightingCharacterDto fightingCharacter = new FightingCharacterDto();
        fightingCharacter.setFightingPower(18);
        fightingCharacter.setCircumstanceModifier(0);

        FightingMonsterDto fightingMonster1 = new FightingMonsterDto();
        fightingMonster1.setFightingPower(7);

        FightingMonsterDto fightingMonster2 = new FightingMonsterDto();
        fightingMonster2.setFightingPower(7);

        List<FightingMonsterDto> fightingMonsters = List.of(fightingMonster1, fightingMonster2);

        int numberOfMonstersFaced = 2;

        // when
        Optional<CombatChart> combatResult = useCase.handle(fightingCharacter, fightingMonsters, numberOfMonstersFaced);

        // then
        Assertions.assertThat(combatResult.get()).isEqualTo(CombatChart.DRAW);
    }

    @Test
    void handle_shouldReturnVictorious_whenFightsAgainstMultipleMonsters() {
        // given
        FightingCharacterDto fightingCharacter = new FightingCharacterDto();
        fightingCharacter.setFightingPower(30);
        fightingCharacter.setCircumstanceModifier(0);

        FightingMonsterDto fightingMonster1 = new FightingMonsterDto();
        fightingMonster1.setFightingPower(7);

        FightingMonsterDto fightingMonster2 = new FightingMonsterDto();
        fightingMonster2.setFightingPower(7);

        List<FightingMonsterDto> fightingMonsters = List.of(fightingMonster1, fightingMonster2);

        int numberOfMonstersFaced = 2;

        // when
        Optional<CombatChart> combatResult = useCase.handle(fightingCharacter, fightingMonsters, numberOfMonstersFaced);

        // then
        Assertions.assertThat(combatResult.get()).isEqualTo(CombatChart.VICTORIOUS);
    }
}
