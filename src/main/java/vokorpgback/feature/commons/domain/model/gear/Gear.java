package vokorpgback.feature.commons.domain.model.gear;

import vokorpgback.commons.Validation;

import java.util.List;

import static vokorpgback.feature.commons.domain.model.gear.ItemType.*;

public record Gear(
        Item helmet,
        Item mask,
        Item necklace,
        Item cloak,
        Item costume,
        Item armor,
        Item shield,
        Weapon primaryWeapon,
        Weapon secondaryWeapon,
        Item wristband,
        Item gloves,
        Item ring,
        Item belt,
        Item boots
) {
    public Gear {
        // validation
        Validation.require(isHelmet(helmet), "You should have a Helmet on your head.");
        Validation.require(isMask(mask), "You should have a Mask on your face.");
        Validation.require(isNecklace(necklace), "You should have a Necklace on your neck.");
        Validation.require(isCloak(cloak), "You should have a Cloak on your back.");
        Validation.require(isCostume(costume), "You should have a Costume on your body.");
        Validation.require(isArmor(armor), "You should have a Armor on your chest.");
        Validation.require(isShield(shield), "You should have a Shield on your second hand.");
        Validation.require(isWeapon(primaryWeapon), "You should have a Weapon on your primary hand.");
        Validation.require(isWeapon(secondaryWeapon), "You should have a Weapon on your backpack.");
        Validation.require(isWristband(wristband), "You should have a Wristband on your wrist.");
        Validation.require(isGloves(gloves), "You should have a gloves on your hands.");
        Validation.require(isRing(ring), "You should have a Ring on your finger.");
        Validation.require(isBelt(belt), "You should have a Belt on your body.");
        Validation.require(isBoots(boots), "You should have a Boots on your feet.");
    }

    public int computeMightBonusFromGear() {
        return getGearItems()
                .stream()
                .filter(this::hasTrait)
                .filter(this::hasMightTraitType)
                .mapToInt(item -> item.getTrait().modifier())
                .sum();
    }

    public int computeDamageBonusFromGear() {
        return getGearItems()
                .stream()
                .filter(this::hasTrait)
                .filter(this::hasDamageTraitType)
                .mapToInt(item -> item.getTrait().modifier())
                .sum();
    }

    public int computeActionBonusFromGear() {
        return getGearItems()
                .stream()
                .filter(this::hasTrait)
                .filter(this::hasActionTraitType)
                .mapToInt(item -> item.getTrait().modifier())
                .sum();
    }

    public List<Item> getGearItems() {
        return List.of(
                helmet(),
                mask(),
                necklace(),
                cloak(),
                costume(),
                armor(),
                shield(),
                primaryWeapon(),
                secondaryWeapon(),
                wristband(),
                gloves(),
                ring(),
                belt(),
                boots()
        );
    }

    private boolean hasTrait(Item item) {
        return item.getTrait() != null;
    }

    private boolean hasActionTraitType(Item item) {
        return item.getTrait().type() == TraitType.ACTION;
    }

    private boolean hasDamageTraitType(Item item) {
        return item.getTrait().type() == TraitType.DAMAGE;
    }

    private boolean hasMightTraitType(Item item) {
        return item.getTrait().type() == TraitType.MIGHT;
    }

    private boolean isHelmet(Item item) {
        return item.getType() == HELMET;
    }

    private boolean isMask(Item item) {
        return item.getType() == MASK;
    }

    private boolean isNecklace(Item item) {
        return item.getType() == NECKLACE;
    }

    private boolean isCloak(Item item) {
        return item.getType() == CLOAK;
    }

    private boolean isCostume(Item item) {
        return item.getType() == COSTUME;
    }

    private boolean isArmor(Item item) {
        return item.getType() == ARMOR;
    }

    private boolean isShield(Item item) {
        return item.getType() == SHIELD;
    }

    private boolean isWeapon(Weapon item) {
        return item.getType() == WEAPON;
    }

    private boolean isWristband(Item item) {
        return item.getType() == WRISTBAND;
    }

    private boolean isGloves(Item item) {
        return item.getType() == GLOVES;
    }

    private boolean isRing(Item item) {
        return item.getType() == RING;
    }

    private boolean isBelt(Item item) {
        return item.getType() == BELT;
    }

    private boolean isBoots(Item item) {
        return item.getType() == BOOTS;
    }
}
