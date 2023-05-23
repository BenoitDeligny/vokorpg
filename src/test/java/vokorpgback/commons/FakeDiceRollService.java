package vokorpgback.commons;

import vokorpgback.utils.diceroll.DiceRoll;

public record FakeDiceRollService(
        int ageRoll,
        int otherRol
) implements DiceRoll {

    // think about seed
    @Override
    public int diceRolls(int numberOfDice) {
        return 3 * numberOfDice;
    }

    // TODO
    // remove those methods
    // add public in implementation that call the diceRolls one
    @Override
    public int ageRoll() {
        return ageRoll;
    }

    @Override
    public int strengthRoll() {
        return 3;
    }

    @Override
    public int agilityRoll() {
        return 4;
    }

    @Override
    public int perceptionRoll() {
        return 5;
    }

    @Override
    public int attackRoll() {
        return 3;
    }

    @Override
    public int abilityIncreaseRoll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'abilityIncreaseRoll'");
    }

    @Override
    public int powerRoll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'powerRoll'");
    }

    @Override
    public int knowledgeRoll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'knowledgeRoll'");
    }

    @Override
    public int relicRoll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'relicRoll'");
    }

}
