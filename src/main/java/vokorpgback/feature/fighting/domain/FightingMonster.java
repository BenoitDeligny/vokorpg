package vokorpgback.feature.fighting.domain;

public record FightingMonster(
        int maxFightingPower,
        int remainingFightingPower,
        int damageDice) {

    public boolean isDead() {
        return remainingFightingPower <= 0;
    }
}
