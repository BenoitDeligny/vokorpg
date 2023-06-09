package vokorpgback.feature.commons.application;

import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.model.item.*;

import java.util.Collections;

import static java.util.Collections.emptyList;

public class GearFactory {

    private GearFactory() {

    }

    public static Gear generateGear(GameMode gameMode) {
        return switch (gameMode) {
            case EASY -> generateEasyModeGear();
            default -> generateNormalModeGear();
        };
    }

    private static Gear generateEasyModeGear() {
        return new Gear(
                generateHelmet(),
                generateMask(),
                generateNecklace(),
                generateCloak(),
                generateCostume(),
                generateArmor(),
                new Shield("Enchanted wood shield", Collections.emptyList(), "A simple but enchanted wood shield", false),
                new Weapon("Enchanted wood sword", Collections.emptyList(), "A simple but enchanted wood sword", false),
                generateWeapon(),
                generateWristband(),
                generateGloves(),
                generateRing(),
                generateBelt(),
                generateBoots()
        );
    }

    private static Gear generateNormalModeGear() {
        return new Gear(
                generateHelmet(),
                generateMask(),
                generateNecklace(),
                generateCloak(),
                generateCostume(),
                generateArmor(),
                generateShield(),
                generateWeapon(),
                generateWeapon(),
                generateWristband(),
                generateGloves(),
                generateRing(),
                generateBelt(),
                generateBoots()
        );
    }

    private static Helmet generateHelmet() {
        return new Helmet(
                "Basic Helmet",
                emptyList(),
                "A basic, simple and useless Helmet",
                false
        );
    }

    private static Mask generateMask() {
        return new Mask(
                "Basic Mask",
                emptyList(),
                "A basic, simple and useless Mask",
                false
        );
    }

    private static Necklace generateNecklace() {
        return new Necklace(
                "Basic Necklace",
                emptyList(),
                "A basic, simple and useless Necklace",
                false
        );
    }

    private static Cloak generateCloak() {
        return new Cloak(
                "Basic Cloak",
                emptyList(),
                "A basic, simple and useless Cloak",
                false
        );
    }

    private static Costume generateCostume() {
        return new Costume(
                "Basic Costume",
                emptyList(),
                "A basic, simple and useless Costume",
                false
        );
    }

    private static Armor generateArmor() {
        return new Armor(
                "Basic Armor",
                emptyList(),
                "A basic, simple and useless Armor",
                false
        );
    }

    private static Shield generateShield() {
        return new Shield(
                "Basic Shield",
                emptyList(),
                "A basic, simple and useless Shield",
                false
        );
    }

    private static Weapon generateWeapon() {
        return new Weapon(
                "Basic Weapon",
                emptyList(),
                "A basic, simple and useless Weapon",
                false
        );
    }

    private static Wristband generateWristband() {
        return new Wristband(
                "Basic Wristband",
                emptyList(),
                "A basic, simple and useless Wristband",
                false
        );
    }

    private static Gloves generateGloves() {
        return new Gloves(
                "Basic Gloves",
                emptyList(),
                "A basic, simple and useless Gloves",
                false
        );
    }

    private static Ring generateRing() {
        return new Ring(
                "Basic Ring",
                emptyList(),
                "A basic, simple and useless Ring",
                false
        );
    }

    private static Belt generateBelt() {
        return new Belt(
                "Basic Belt",
                emptyList(),
                "A basic, simple and useless Belt",
                false
        );
    }

    private static Boots generateBoots() {
        return new Boots(
                "Basic Boots",
                emptyList(),
                "A basic, simple and useless Boots",
                false
        );
    }
}
