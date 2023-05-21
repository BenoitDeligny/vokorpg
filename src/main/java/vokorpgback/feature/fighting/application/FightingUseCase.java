package vokorpgback.feature.fighting.application;

import static vokorpgback.feature.fighting.domain.CombatChart.ALMOST_VICTORIOUS;
import static vokorpgback.feature.fighting.domain.CombatChart.BEARLY_VICTORIOUS;
import static vokorpgback.feature.fighting.domain.CombatChart.DEFEATED;
import static vokorpgback.feature.fighting.domain.CombatChart.DRAW;
import static vokorpgback.feature.fighting.domain.CombatChart.INJURED;
import static vokorpgback.feature.fighting.domain.CombatChart.SERIOUSLY_INJURED;
import static vokorpgback.feature.fighting.domain.CombatChart.VICTORIOUS;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import vokorpgback.feature.fighting.domain.CombatChart;
import vokorpgback.feature.fighting.domain.FightingCharacter;
import vokorpgback.feature.fighting.domain.FightingMonster;
import vokorpgback.feature.fighting.exposition.dto.FightingCharacterDto;
import vokorpgback.feature.fighting.exposition.dto.FightingMonsterDto;
import vokorpgback.utils.diceroll.DiceRoll;

public class FightingUseCase {

    private DiceRoll diceRoll;

    public FightingUseCase(DiceRoll diceRoll) {
        this.diceRoll = diceRoll;
    }

    public Optional<CombatChart> handle(
            FightingCharacterDto fightingCharacterDto,
            List<FightingMonsterDto> monsters,
            int numberOfMonstersFaced) {
        return Optional.of(
                computeFightingResult(
                        computeLegendaryCharacterFightingPower(toFightingCharacter(fightingCharacterDto)),
                        computeMonstersTotalFightingPower(toFightingMonsters(monsters), numberOfMonstersFaced)));
    }

    private int computeLegendaryCharacterFightingPower(FightingCharacter fightingCharacter) {
        return fightingCharacter.computeTotalFightingPower() + diceRoll.attackRoll();
    }

    private FightingCharacter toFightingCharacter(FightingCharacterDto dto) {
        return new FightingCharacter(dto.getFightingPower(), dto.getCircumstanceModifier());
    }

    private int computeMonstersTotalFightingPower(List<FightingMonster> monsters, int numberOfMonstersFaced) {
        List<FightingMonster> monstersFaced = monsters.subList(0, numberOfMonstersFaced);

        return monstersFaced
                .stream()
                .map(FightingMonster::fightingPower)
                .collect(Collectors.summingInt(Integer::intValue));
    }

    private List<FightingMonster> toFightingMonsters(List<FightingMonsterDto> dtoList) {
        return dtoList
                .stream()
                .map(this::toFightingMonster)
                .toList();
    }

    private FightingMonster toFightingMonster(FightingMonsterDto dto) {
        return new FightingMonster(dto.getFightingPower());
    }

    // TODO
    // all methods below should be in the enum ?
    private CombatChart computeFightingResult(int legendaryCharacterFightingPower, int monstersFightingPower) {
        int result = legendaryCharacterFightingPower - monstersFightingPower;

        if (isInDefeatedLimits(result)) {
            return DEFEATED;
        }

        if (isInSeriouslyInjuredLimits(result)) {
            return SERIOUSLY_INJURED;
        }

        if (isInInjuredLimits(result)) {
            return INJURED;
        }

        if (isInDrawLimits(result)) {
            return DRAW;
        }

        if (isInBearlyVictoriousLimits(result)) {
            return BEARLY_VICTORIOUS;
        }

        if (isInAlmotsVictoriousLimits(result)) {
            return ALMOST_VICTORIOUS;
        }

        if (isInVictoriousLimits(result)) {
            return VICTORIOUS;
        }

        return DRAW;
    }

    private boolean isInDefeatedLimits(int result) {
        return result <= DEFEATED.getHighLimit();
    }

    private boolean isInSeriouslyInjuredLimits(int result) {
        return (result >= SERIOUSLY_INJURED.getLowLimit() && result <= SERIOUSLY_INJURED.getHighLimit());
    }

    private boolean isInInjuredLimits(int result) {
        return (result >= INJURED.getLowLimit() && result <= INJURED.getHighLimit());
    }

    private boolean isInDrawLimits(int result) {
        return (result >= DRAW.getLowLimit() && result <= DRAW.getHighLimit());
    }

    private boolean isInBearlyVictoriousLimits(int result) {
        return (result >= BEARLY_VICTORIOUS.getLowLimit() && result <= BEARLY_VICTORIOUS.getHighLimit());
    }

    private boolean isInAlmotsVictoriousLimits(int result) {
        return (result >= ALMOST_VICTORIOUS.getLowLimit() && result <= ALMOST_VICTORIOUS.getHighLimit());
    }

    private boolean isInVictoriousLimits(int result) {
        return result >= VICTORIOUS.getLowLimit();
    }
}
