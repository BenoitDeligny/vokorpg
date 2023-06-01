package vokorpgback.feature.character.domain.model.ability;

import java.lang.reflect.Field;
import java.lang.reflect.RecordComponent;

public record Abilities(Strength strength, Agility agility, Perception perception) {

    // TODO
    // ask Sylvain if it's something ok (but i bet not)
    // est-ce que ça a quelque chose à foutre ici ?
    public int computeSumOfAbilities() {
        int sum = 0;

        RecordComponent[] recordComponents = this.getClass().getRecordComponents();

        for (RecordComponent recordComponent : recordComponents) {
            Field field = getField(recordComponent);
            Ability ability = getAbilityFromField(field);
            switch (ability) {
                case Strength s -> sum += s.value();
                case Agility a -> sum += a.value();
                case Perception p -> sum += p.value();
                default -> sum += 0;
            }
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
