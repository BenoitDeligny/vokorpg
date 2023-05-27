package vokorpgback.commons;

public final class Validation {

    private Validation() {
    }

    public static void require(boolean isValid, String message) {
        if (!isValid) {
            throw new IllegalArgumentException(message);
        }
    }
}
