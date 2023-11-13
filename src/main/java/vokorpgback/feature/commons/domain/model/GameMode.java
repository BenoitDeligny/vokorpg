package vokorpgback.feature.commons.domain.model;

public enum GameMode {
    // it could be an abstract factory
    // it could take the mode and then using real factories with modifiers
    // cause for now we only have the ability modifier, but we could have something else
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
