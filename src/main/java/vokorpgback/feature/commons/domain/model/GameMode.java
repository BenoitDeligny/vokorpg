package vokorpgback.feature.commons.domain.model;

public enum GameMode {
    // TODO
    // the modifier should be handle in the factory abstract
    EASY(4),
    NORMAL(1);

    private final int abilitiesModifier;

    GameMode(int abilitiesModifier) {
        this.abilitiesModifier = abilitiesModifier;
    }

    public int getAbilitiesModifier() {
        return abilitiesModifier;
    }
}
