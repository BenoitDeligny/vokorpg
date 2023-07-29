package vokorpgback.feature.commons.domain.model.gear;

import vokorpgback.feature.commons.domain.model.GameMode;

import java.util.Collections;
import java.util.List;

public class BackPackFactory {

    private BackPackFactory() {

    }

    public static BackPack generateBackPack(GameMode gameMode) {
        return switch (gameMode) {
            case EASY -> generateEasyBackPack();
            case NORMAL -> generateNormalBackPack();
        };
    }

    private static BackPack generateEasyBackPack() {
        return new BackPack(
                List.of(
                        new Consumable(
                                "Magical bays",
                                ItemType.CONSUMABLE,
                                new Trait(TraitType.HEAL, 2),
                                "Few little bays that you can eat.",
                                false,
                                3
                        )
                )
        );
    }

    private static BackPack generateNormalBackPack() {
        return new BackPack(
                Collections.emptyList()
        );
    }
}
