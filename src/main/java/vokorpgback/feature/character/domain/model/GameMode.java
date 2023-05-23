package vokorpgback.feature.character.domain.model;

public enum GameMode {
    EASY(4),
    NORMAL(1);

    private int abilitiesModifier;

    private GameMode(int abilitiesModifier) {
        this.abilitiesModifier = abilitiesModifier;
    }

    public int getAbilitiesModifier() {
        return abilitiesModifier;
    }
}
