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
}
