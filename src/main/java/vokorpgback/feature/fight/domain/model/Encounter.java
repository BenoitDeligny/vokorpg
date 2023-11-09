package vokorpgback.feature.fight.domain.model;

import vokorpgback.feature.commons.domain.model.dice.Dice;
import vokorpgback.feature.commons.domain.model.opponent.Opponent;

import java.util.List;
import java.util.Map;

public class Encounter {
    private final Map<Boolean, List<Opponent>> opponents;
    private final Dice dice;

    public Encounter(Map<Boolean, List<Opponent>> opponents, Dice dice) {
        this.opponents = opponents;
        this.dice = dice;
    }

    public void assignDamages(int damages, int numberOfCombatDice) {
        List<Opponent> livingOpponents = opponents.get(true);
        List<Opponent> deadOpponents = opponents.get(false);

        livingOpponents.stream()
                .limit(numberOfCombatDice)
                .filter(opponent -> {
                    opponent.takeDamages(damages);
                    return opponent.isDead();
                })
                .forEach(deadOpponents::add);

        deadOpponents.forEach(livingOpponents::remove);
    }

    public int computeOpponentsTotalDamages() {
        List<Opponent> livingOpponents = opponents.get(true);

        return switch (livingOpponents.size()) {
            case 0 -> 0;
            case 1 -> livingOpponents.get(0).rollDamages();
            default -> livingOpponents.get(0).rollDamages() + dice.roll();
        };
    }

    public List<Opponent> livingOpponents() {
        return opponents.get(true);
    }

    public List<Opponent> deadOpponents() {
        return opponents.get(false);
    }
}
