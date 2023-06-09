package vokorpgback.feature.commons.domain.model;

public enum CharacterCombatChart {
    ZERO(0, 1, 6, 1),
    ONE(1, 7, 18, 3),
    TWO(2, 19, 30, 7),
    THREE(3, 31, 54, 10),
    FOUR(4, 55, 78, 14),
    FIVE(5, 79, 114, 17),
    SIX(6, 115, 150, 21),
    SEVEN(7, 151, 192, 24),
    EIGHT(8, 193, 234, 28),
    NINE(9, 235, 282, 31),
    TEN(10, 283, Integer.MAX_VALUE, 35);

    private final int numberOfDice;
    private final int minTotalPower;
    private final int maxTotalPower;
    private final int averageDamage;

    CharacterCombatChart(int numberOfDice, int minTotalPower, int maxTotalPower, int averageDamage) {
        this.numberOfDice = numberOfDice;
        this.minTotalPower = minTotalPower;
        this.maxTotalPower = maxTotalPower;
        this.averageDamage = averageDamage;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public int getMinTotalPower() {
        return minTotalPower;
    }

    public int getMaxTotalPower() {
        return maxTotalPower;
    }

    public int getAverageDamage() {
        return averageDamage;
    }
}
