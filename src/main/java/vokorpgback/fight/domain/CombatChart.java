package vokorpgback.fight.domain;

public enum CombatChart {

    DEFEATED(Integer.MIN_VALUE, -1),
    SERIOUSLY_INJURED(0, 3),
    INJURED(4, 5),
    DRAW(6, 8),
    BEARLY_VICTORIOUS(9, 11),
    ALMOST_VICTORIOUS(12, 14),
    VICTORIOUS(15, Integer.MAX_VALUE);

    private int lowLimit;
    private int highLimit;

    private CombatChart(int lowLimit, int highLimit) {
        this.lowLimit = lowLimit;
        this.highLimit = highLimit;
    }

    public int getLowLimit() {
        return lowLimit;
    }

    public int getHighLimit() {
        return highLimit;
    }
    
}
