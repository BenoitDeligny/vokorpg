package vokorpgback.feature.fight.domain;

public record FightingCharacter(
        int fightingPower,
        int circumstanceModifier) {

    public int computeTotalFightingPower() {
        return fightingPower + circumstanceModifier;
    }

}
