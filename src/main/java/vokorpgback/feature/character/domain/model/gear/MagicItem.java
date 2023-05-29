package vokorpgback.feature.character.domain.model.gear;

import java.util.List;

public class MagicItem extends Item {
        boolean isRelic;

        public MagicItem(String name, Category category, List<Trait> traits, String description, boolean isRelic) {
                super(name, category, traits, description);
                this.isRelic = isRelic;
        }

        @Override
        public boolean isHelmet() {
                return category.equals(Category.HELMET);
        }

        @Override
        public boolean isMask() {
                return category.equals(Category.MASK);
        }

        @Override
        public boolean isNecklace() {
                return category.equals(Category.NECKLACE);
        }

        @Override
        public boolean isCloak() {
                return category.equals(Category.CLOAK);
        }

        @Override
        public boolean isCostume() {
                return category.equals(Category.COSTUME);
        }

        @Override
        public boolean isArmor() {
                return category.equals(Category.ARMOR);
        }

        @Override
        public boolean isShield() {
                return category.equals(Category.SHIELD);
        }

        @Override
        public boolean isWeapon() {
                return category.equals(Category.WEAPON);
        }

        @Override
        public boolean isWristband() {
                return category.equals(Category.WRISTBAND);
        }

        @Override
        public boolean isGloves() {
                return category.equals(Category.GLOVES);
        }

        @Override
        public boolean isRing() {
                return category.equals(Category.RING);
        }

        @Override
        public boolean isBelt() {
                return category.equals(Category.BELT);
        }

        @Override
        public boolean isBoots() {
                return category.equals(Category.BOOTS);
        }

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = super.hashCode();
                result = prime * result + (isRelic ? 1231 : 1237);
                return result;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (!super.equals(obj))
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                MagicItem other = (MagicItem) obj;
                if (isRelic != other.isRelic)
                        return false;
                return true;
        }

}
