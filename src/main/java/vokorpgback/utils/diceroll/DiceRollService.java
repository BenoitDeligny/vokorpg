package vokorpgback.utils.diceroll;

import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class DiceRollService implements DiceRoll {

    private Random roll = new Random();

    @Override
    public int diceRolls(int numberOfDice) {
        return IntStream.range(0, numberOfDice)
            .map(i -> roll.nextInt(6) + 1)
            .sum();
    }

    // TODO
    // remove those methods
    // add public in implementation that call the diceRolls one
    @Override
    public int ageRoll() {
        return (roll.nextInt(6) + 1);
    }

    @Override
    public int strengthRoll() {
        return (roll.nextInt(6) + 1);
    }

    @Override
    public int agilityRoll() {
        return (roll.nextInt(6) + 1);
    }

    @Override
    public int perceptionRoll() {
        return (roll.nextInt(6) + 1);
    }

    @Override
    @Deprecated
    public int attackRoll() {
        return roll.nextInt(6) + 1;
    }

    @Override
    @Deprecated
    public int abilityIncreaseRoll() {
        int roll1 = roll.nextInt(6) + 1;
        int roll2 = roll.nextInt(6) + 1;
        int roll3 = roll.nextInt(6) + 1;

        return roll1 + roll2 + roll3;
    }

    @Override
    @Deprecated
    public int powerRoll() {
        int roll1 = roll.nextInt(6) + 1;
        int roll2 = roll.nextInt(6) + 1;

        return roll1 + roll2;
    }

    @Override
    @Deprecated
    public int knowledgeRoll() {
        int roll1 = roll.nextInt(6) + 1;
        int roll2 = roll.nextInt(6) + 1;

        return roll1 + roll2;
    }

    @Override
    @Deprecated
    public int relicRoll() {
        return roll.nextInt(6) + 1;
    }
}
