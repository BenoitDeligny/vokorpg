package vokorpgback.feature.commons.domain.model.might;

public abstract class FightingMight {
    int maxNaturalMight;
    int remainingMight;

    protected FightingMight(int maxNaturalMight, int remainingMight) {
        this.maxNaturalMight = maxNaturalMight;
        this.remainingMight = remainingMight;
    }

    public int maxNaturalMight() {
        return maxNaturalMight;
    }

    public int remainingMight() {
        return remainingMight;
    }
}
