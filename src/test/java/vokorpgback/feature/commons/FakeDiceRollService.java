package vokorpgback.feature.commons;

import vokorpgback.utils.diceroll.DiceRoll;

public class FakeDiceRollService implements DiceRoll {

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
