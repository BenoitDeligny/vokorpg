package vokorpgback.feature.commons.domain.model.gear;

import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.model.knowledge.KnowledgeType;

import static vokorpgback.feature.commons.domain.model.gear.ItemType.*;
import static vokorpgback.feature.commons.domain.model.gear.TraitType.*;

public class GearFactory {

    private GearFactory() {

    }

    public static Gear generateBasicGear(GameMode gameMode) {
        return switch (gameMode) {
            case EASY -> generateEasyModeGear();
            case NORMAL -> generateNormalModeGear();
        };
    }

    private static Gear generateEasyModeGear() {
        return new Gear(
                generateBasicHelmet(),
                generateBasicMask(),
                generateBasicNecklace(),
                generateBasicCloak(),
                generateBasicCostume(),
                generateBasicArmor(),
                new Item("Enchanted wood shield", SHIELD, new Trait(MIGHT, 3), "A simple but enchanted wood shield", false),
                new Weapon("Enchanted wood sword",  WEAPON, new Trait(DAMAGE, 1), "A simple but enchanted wood sword", false, KnowledgeType.SWORDSMANSHIP),
                generateBasicWeapon(),
                generateBasicWristband(),
                generateBasicGloves(),
                generateBasicRing(),
                generateBasicBelt(),
                generateBasicBoots()
        );
    }

    private static Gear generateNormalModeGear() {
        return new Gear(
                generateBasicHelmet(),
                generateBasicMask(),
                generateBasicNecklace(),
                generateBasicCloak(),
                generateBasicCostume(),
                generateBasicArmor(),
                generateBasicShield(),
                generateBasicWeapon(),
                generateBasicWeapon(),
                generateBasicWristband(),
                generateBasicGloves(),
                generateBasicRing(),
                generateBasicBelt(),
                generateBasicBoots()
        );
    }

    private static Item generateBasicHelmet() {
        return new Item(
                "Basic Helmet",
                HELMET,
                null,
                "A basic, simple and useless Helmet",
                false
        );
    }

    private static Item generateBasicMask() {
        return new Item(
                "Basic Mask",
                MASK,
                null,
                "A basic, simple and useless Mask",
                false
        );
    }

    private static Item generateBasicNecklace() {
        return new Item(
                "Basic Necklace",
                NECKLACE,
                null,
                "A basic, simple and useless Necklace",
                false
        );
    }

    private static Item generateBasicCloak() {
        return new Item(
                "Basic Cloak",
                CLOAK,
                null,
                "A basic, simple and useless Cloak",
                false
        );
    }

    private static Item generateBasicCostume() {
        return new Item(
                "Basic Costume",
                COSTUME,
                null,
                "A basic, simple and useless Costume",
                false
        );
    }

    private static Item generateBasicArmor() {
        return new Item(
                "Basic Armor",
                ARMOR,
                null,
                "A basic, simple and useless Armor",
                false
        );
    }

    private static Item generateBasicShield() {
        return new Item(
                "Basic Shield",
                SHIELD,
                null,
                "A basic, simple and useless Shield",
                false
        );
    }

    private static Weapon generateBasicWeapon() {
        return new Weapon(
                "Basic Weapon",
                WEAPON,
                null,
                "A basic, simple and useless Weapon",
                false,
                KnowledgeType.SWORDSMANSHIP);
    }

    private static Item generateBasicWristband() {
        return new Item(
                "Basic Wristband",
                WRISTBAND,
                null,
                "A basic, simple and useless Wristband",
                false
        );
    }

    private static Item generateBasicGloves() {
        return new Item(
                "Basic Gloves",
                GLOVES,
                null,
                "A basic, simple and useless Gloves",
                false
        );
    }

    private static Item generateBasicRing() {
        return new Item(
                "Basic Ring",
                RING,
                null,
                "A basic, simple and useless Ring",
                false
        );
    }

    private static Item generateBasicBelt() {
        return new Item(
                "Basic Belt",
                BELT,
                null,
                "A basic, simple and useless Belt",
                false
        );
    }

    private static Item generateBasicBoots() {
        return new Item(
                "Basic Boots",
                BOOTS,
                null,
                "A basic, simple and useless Boots",
                false
        );
    }
}
