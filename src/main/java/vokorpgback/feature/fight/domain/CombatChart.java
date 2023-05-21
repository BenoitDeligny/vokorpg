package vokorpgback.feature.fight.domain;

public enum CombatChart {

    DEFEATED(Integer.MIN_VALUE, -1, 0),
    SERIOUSLY_INJURED(0, 3, -6),
    INJURED(4, 5, -3),
    DRAW(6, 8, 0),
    BEARLY_VICTORIOUS(9, 11, +3),
    ALMOST_VICTORIOUS(12, 14, +6),
    VICTORIOUS(15, Integer.MAX_VALUE, 0);

    private int lowLimit;
    private int highLimit;
    private int circumstanceModifier;

    private CombatChart(int lowLimit, int highLimit, int circumstanceModifier) {
        this.lowLimit = lowLimit;
        this.highLimit = highLimit;
        this.circumstanceModifier = circumstanceModifier;
    }

    public int getLowLimit() {
        return lowLimit;
    }

    public int getHighLimit() {
        return highLimit;
    }

    public int getCircumstanceModifier() {
        return circumstanceModifier;
    }
}
