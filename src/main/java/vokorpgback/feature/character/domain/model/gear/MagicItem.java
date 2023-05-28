package vokorpgback.feature.character.domain.model.gear;

import java.util.List;

public record MagicItem(
                String name,
                Category category,
                Quality quality,
                List<Trait> traits,
                String description) {

        public boolean isHelmet() {
                return category.equals(Category.HELMET);
        }

        public boolean isMask() {
                return category.equals(Category.MASK);
        }

        public boolean isNecklace() {
                return category.equals(Category.NECKLACE);
        }

        public boolean isCloak() {
                return category.equals(Category.CLOAK);
        }

        public boolean isCostume() {
                return category.equals(Category.COSTUME);
        }

        public boolean isArmor() {
                return category.equals(Category.ARMOR);
        }

        public boolean isShield() {
                return category.equals(Category.SHIELD);
        }

        public boolean isWeapon() {
                return category.equals(Category.WEAPON);
        }

        public boolean isWristband() {
                return category.equals(Category.WRISTBAND);
        }

        public boolean isGloves() {
                return category.equals(Category.GLOVES);
        }

        public boolean isRing() {
                return category.equals(Category.RING);
        }

        public boolean isBelt() {
                return category.equals(Category.BELT);
        }

        public boolean isBoots() {
                return category.equals(Category.BOOTS);
        }

}
