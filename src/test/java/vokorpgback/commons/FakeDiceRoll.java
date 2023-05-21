package vokorpgback.commons;

import vokorpgback.utils.diceroll.DiceRoll;

public class FakeDiceRoll implements DiceRoll {

    @Override
    public int ageRoll() {
        return 18;
    }

    @Override
    public int strengthRoll() {
        return 4;
    }

    @Override
    public int agilityRoll() {
        return 6;
    }

    @Override
    public int perceptionRoll() {
        return 2;
    }

    @Override
    public int attackRoll() {
        return 3;
    }

}
