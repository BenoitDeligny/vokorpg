package vokorpgback.feature.commons.domain.model;

public enum MonsterCombatDice {
    ZERO(0, 1, 8, 1),
    ONE(1, 9, 24, 3),
    TWO(2, 25, 40, 7),
    THREE(3, 41, 64, 10),
    FOUR(4, 65, 88, 14),
    FIVE(5, 89, 124, 17),
    SIX(6, 125, 172, 21),
    SEVEN(7, 173, 220, 24),
    EIGHT(8, 221, 276, 28),
    NINE(9, 277, 332, 31),
    TEN(10, 333, Integer.MAX_VALUE, 35);

    private final int numberOfDice;
    private final int minTotalPower;
    private final int maxTotalPower;
    private final int averageDamage;

    MonsterCombatDice(int numberOfDice, int minTotalPower, int maxTotalPower, int averageDamage) {
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
