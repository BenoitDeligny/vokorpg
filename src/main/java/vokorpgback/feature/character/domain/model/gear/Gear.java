package vokorpgback.feature.character.domain.model.gear;

import java.util.Optional;

import vokorpgback.commons.Validation;

public record Gear(
                Optional<MagicItem> helmet,
                Optional<MagicItem> mask,
                Optional<MagicItem> necklace,
                Optional<MagicItem> cloak,
                Optional<MagicItem> costume,
                Optional<MagicItem> armor,
                Optional<MagicItem> shield,
                Optional<MagicItem> primaryWeapon,
                Optional<MagicItem> secondaryWeapon,
                Optional<MagicItem> wristband,
                Optional<MagicItem> gloves,
                Optional<MagicItem> ring,
                Optional<MagicItem> belt,
                Optional<MagicItem> boots) {

        // TODO
        // check how to do it better
        public Gear {
                Validation.require(helmet.get().isHelmet(), "This item should be a helmet.");
                Validation.require(mask.get().isMask(), "This item should be a mask.");
                Validation.require(necklace.get().isNecklace(), "This item should be a necklace.");
                Validation.require(cloak.get().isCloak(), "This item should be a cloak.");
                Validation.require(costume.get().isCostume(), "This item should be a costume.");
                Validation.require(armor.get().isArmor(), "This item should be an armor.");
                Validation.require(shield.get().isShield(), "This item should be a shield.");
                Validation.require(primaryWeapon.get().isWeapon(), "This item should be a weapon.");
                Validation.require(secondaryWeapon.get().isWeapon(), "This item should be a weapon.");
                Validation.require(wristband.get().isWristband(), "This item should be a wristband.");
                Validation.require(gloves.get().isGloves(), "This item should be gloves.");
                Validation.require(ring.get().isRing(), "This item should be a ring.");
                Validation.require(belt.get().isBelt(), "This item should be a belt.");
                Validation.require(boots.get().isBoots(), "This item should be boots.");
        }
}
