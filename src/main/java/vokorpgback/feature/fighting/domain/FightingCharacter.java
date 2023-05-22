package vokorpgback.feature.fighting.domain;

public record FightingCharacter(
                int maxFightingPower,
                int remainingFightingPower,
                int damageDices) {

        public boolean isDead() {
                return remainingFightingPower <= 0;
        }
}
