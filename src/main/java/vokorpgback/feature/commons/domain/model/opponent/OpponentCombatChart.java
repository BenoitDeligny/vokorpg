package vokorpgback.feature.commons.domain.model.opponent;

public enum OpponentCombatChart {
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
    private final int minTotalMight;
    private final int maxTotalMight;
    private final int averageDamage;

    OpponentCombatChart(int numberOfDice, int minTotalMight, int maxTotalMight, int averageDamage) {
        this.numberOfDice = numberOfDice;
        this.minTotalMight = minTotalMight;
        this.maxTotalMight = maxTotalMight;
        this.averageDamage = averageDamage;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public int getMinTotalMight() {
        return minTotalMight;
    }

    public int getMaxTotalMight() {
        return maxTotalMight;
    }

    public int getAverageDamage() {
        return averageDamage;
    }
}
