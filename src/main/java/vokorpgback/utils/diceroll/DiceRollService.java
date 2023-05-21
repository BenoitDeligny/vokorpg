package vokorpgback.utils.diceroll;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class DiceRollService implements DiceRoll {

    private Random roll = new Random();

    @Override
    public int ageRoll() {
        return 11 + (roll.nextInt(6) + 1);
    }

    @Override
    public int strengthRoll() {
        return 1 + (roll.nextInt(6) + 1);
    }

    @Override
    public int agilityRoll() {
        return 1 + (roll.nextInt(6) + 1);
    }

    @Override
    public int perceptionRoll() {
        return 1 + (roll.nextInt(6) + 1);
    }

    @Override
    public int attackRoll() {
        return roll.nextInt(6) + 1;
    }

    @Override
    public int abilityIncreaseRoll() {
        int roll1 = roll.nextInt(6) + 1;
        int roll2 = roll.nextInt(6) + 1;
        int roll3 = roll.nextInt(6) + 1;

        return roll1 + roll2 + roll3;
    }

    @Override
    public int powerRoll() {
        int roll1 = roll.nextInt(6) + 1;
        int roll2 = roll.nextInt(6) + 1;

        return roll1 + roll2;
    }

    @Override
    public int knowledgeRoll() {
        int roll1 = roll.nextInt(6) + 1;
        int roll2 = roll.nextInt(6) + 1;

        return roll1 + roll2;
    }

    @Override
    public int relicRoll() {
        return roll.nextInt(6) + 1;
    }
}
