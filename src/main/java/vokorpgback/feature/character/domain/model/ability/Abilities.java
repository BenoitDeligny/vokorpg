package vokorpgback.feature.character.domain.model.ability;

import vokorpgback.commons.Validation;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

import java.lang.reflect.Field;
import java.lang.reflect.RecordComponent;

public record Abilities(Ability strength, Ability agility, Ability perception) {

    public Abilities {
        Validation.require(strength.isPositive(), "Strength must be positive.");
        Validation.require(agility.isPositive(), "Agility must be positive.");
        Validation.require(perception.isPositive(), "Perception must be positive.");
    }

    public static Abilities generateAbilities(GameMode gameMode, Dice dice) {
        return new Abilities(
                Ability.generateAbility(dice, gameMode),
                Ability.generateAbility(dice, gameMode),
                Ability.generateAbility(dice, gameMode)
        );
    }

    public int computeSumOfAbilities() {
        int sum = 0;

        RecordComponent[] recordComponents = this.getClass().getRecordComponents();

        for (RecordComponent recordComponent : recordComponents) {
            Field field = getField(recordComponent);
            Ability ability = getAbilityFromField(field);
            sum += ability.value();
        }

        return sum;
    }

    private Field getField(RecordComponent recordComponent) {
        try {
            return this.getClass().getDeclaredField(recordComponent.getAccessor().getName());
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException("The field %s does not exist.", e);
        }
    }

    private Ability getAbilityFromField(Field field) {
        try {
            return (Ability) field.get(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("You can not access to this field", e);
        }
    }
}
