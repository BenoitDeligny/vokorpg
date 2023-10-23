package vokorpgback.feature.commons.domain.model.character;

import vokorpgback.commons.Validation;

import java.util.UUID;

public record Identity(UUID uuid, String name, int age) {

    public Identity {
        Validation.require(containsOnlyLetters(name), "Name should only contain letters.");
        Validation.require(isAgeBetween15And20(age), "Age must be between 15 and 20.");
    }

    private boolean containsOnlyLetters(String name) {
        return name.matches("[a-zA-Z]+");
    }
    private boolean isAgeBetween15And20(int age) {
        return age >= 15 && age <= 20;
    }
}
