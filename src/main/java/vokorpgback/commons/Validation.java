package vokorpgback.commons;

public final class Validation {

    private Validation() {
    }

    public static void require(boolean isValid, String message) {
        if (!isValid) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> T validateNotNull(T attribute, String message) {
        if (attribute == null) {
            throw new IllegalArgumentException(message);
        }
        return attribute;
    }
}
