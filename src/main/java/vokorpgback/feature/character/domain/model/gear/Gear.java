package vokorpgback.feature.character.domain.model.gear;

import java.util.List;
import vokorpgback.commons.Validation;
import vokorpgback.feature.commons.domain.model.GameMode;

public record Gear(
    Item helmet,
    Item mask,
    Item necklace,
    Item cloak,
    Item costume,
    Item armor,
    Item shield,
    Item primaryWeapon,
    Item secondaryWeapon,
    Item wristband,
    Item gloves,
    Item ring,
    Item belt,
    Item boots) {

  public Gear {
    Validation.require(helmet.isHelmet(), "This item should be a helmet.");
    Validation.require(mask.isMask(), "This item should be a mask.");
    Validation.require(necklace.isNecklace(), "This item should be a necklace.");
    Validation.require(cloak.isCloak(), "This item should be a cloak.");
    Validation.require(costume.isCostume(), "This item should be a costume.");
    Validation.require(armor.isArmor(), "This item should be an armor.");
    Validation.require(shield.isShield(), "This item should be a shield.");
    Validation.require(primaryWeapon.isWeapon(), "This item should be a weapon.");
    Validation.require(secondaryWeapon.isWeapon(), "This item should be a weapon.");
    Validation.require(wristband.isWristband(), "This item should be a wristband.");
    Validation.require(gloves.isGloves(), "This item should be gloves.");
    Validation.require(ring.isRing(), "This item should be a ring.");
    Validation.require(belt.isBelt(), "This item should be a belt.");
    Validation.require(boots.isBoots(), "This item should be boots.");
  }

  public static Gear generateDefaultGear(GameMode mode) {
    if (mode.equals(GameMode.EASY)) {
      return new Gear(
          new GenericItem(),
          new GenericItem(),
          new GenericItem(),
          new GenericItem(),
          new GenericItem(),
          new GenericItem(),
          new GenericItem(),
          new MagicItem(
              "Sacred Knife",
              ItemCategory.WEAPON,
              List.of(new Trait("A simple enchanted knife")),
              "A simple enchanted knife",
              false),
          new GenericItem(),
          new GenericItem(),
          new GenericItem(),
          new GenericItem(),
          new GenericItem(),
          new GenericItem());
    }

    return new Gear(
        new GenericItem(),
        new GenericItem(),
        new GenericItem(),
        new GenericItem(),
        new GenericItem(),
        new GenericItem(),
        new GenericItem(),
        new GenericItem(),
        new GenericItem(),
        new GenericItem(),
        new GenericItem(),
        new GenericItem(),
        new GenericItem(),
        new GenericItem());
  }
}
