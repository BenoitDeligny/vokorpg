package vokorpgback.fight.application;

import static vokorpgback.fight.domain.CombatChart.ALMOST_VICTORIOUS;
import static vokorpgback.fight.domain.CombatChart.BEARLY_VICTORIOUS;
import static vokorpgback.fight.domain.CombatChart.DEFEATED;
import static vokorpgback.fight.domain.CombatChart.DRAW;
import static vokorpgback.fight.domain.CombatChart.INJURED;
import static vokorpgback.fight.domain.CombatChart.SERIOUSLY_INJURED;
import static vokorpgback.fight.domain.CombatChart.VICTORIOUS;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import vokorpgback.fight.domain.CombatChart;
import vokorpgback.fight.exposition.dto.FightingCharacterDto;
import vokorpgback.fight.exposition.dto.FightingMonsterDto;

@Service
public class FightUseCase {

    // TODO
    // use domain objects
    // add the choice of how many monster the character want to fight at the same
    // time
    public Optional<CombatChart> handle(
            FightingCharacterDto fightingCharacterDto,
            List<FightingMonsterDto> monsters) {
        return Optional.of(computeFightingResult(
                computeLegendaryCharacterFightingPower(fightingCharacterDto),
                computeMonstersFightingPower(monsters)));
    }

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

    private int computeLegendaryCharacterFightingPower(
            FightingCharacterDto fightingCharacterDto) {
        return fightingCharacterDto.computeTotalFightingPower();
    }

    private int computeMonstersFightingPower(List<FightingMonsterDto> monsters) {
        return monsters.stream().map(FightingMonsterDto::getFightingPower)
                .collect(Collectors.summingInt(Integer::intValue));
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
