package vokorpgback.utils.diceroll;

public interface DiceRoll {

    int diceRolls(int numberOfDice);

    // TODO
    // remove those methods
    // add public in implementation that call the diceRolls one
    int ageRoll();

    int strengthRoll();

    int agilityRoll();

    int perceptionRoll();

    @Deprecated
    int attackRoll();

    @Deprecated
    int abilityIncreaseRoll();

    @Deprecated
    int powerRoll();

    @Deprecated
    int knowledgeRoll();

    @Deprecated
    int relicRoll();
}
