package vokorpgback.feature.character.domain.model;

public record Abilities(
                Ability strength,
                Ability agility,
                Ability perception) {

        public int computeTotalPower() {
                return strength.value() + agility.value() + perception.value();
        }
}
