package vokorpgback.feature.commons.domain.model.gear;

import vokorpgback.feature.commons.domain.model.GameMode;

import java.util.Collections;
import java.util.List;

import static vokorpgback.feature.commons.domain.model.gear.TraitType.HEAL;

public class BackPackFactory {

    private BackPackFactory() {

    }

    public static BackPack generateBackPack(GameMode gameMode) {
        return switch (gameMode) {
            case EASY -> generateEasyBackPack();
            default -> generateNormalBackPack();
        };
    }

    private static BackPack generateEasyBackPack() {
        return new BackPack(
                List.of(
                        new Consumable(
                                "Magical bays",
                                ItemType.CONSUMABLE,
                                new Trait(HEAL, 2),
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
