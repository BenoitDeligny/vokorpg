package vokorpgback.feature.character.domain.model.gear;

import java.util.List;

public class MagicItem extends Item {
    boolean isRelic;

    public MagicItem(String name, ItemCategory itemCategory, List<Trait> traits, String description, boolean isRelic) {
        super(name, itemCategory, traits, description);
        this.isRelic = isRelic;
    }

    @Override
    public boolean isHelmet() {
        return itemCategory.equals(ItemCategory.HELMET);
    }

    @Override
    public boolean isMask() {
        return itemCategory.equals(ItemCategory.MASK);
    }

    @Override
    public boolean isNecklace() {
        return itemCategory.equals(ItemCategory.NECKLACE);
    }

    @Override
    public boolean isCloak() {
        return itemCategory.equals(ItemCategory.CLOAK);
    }

    @Override
    public boolean isCostume() {
        return itemCategory.equals(ItemCategory.COSTUME);
    }

    @Override
    public boolean isArmor() {
        return itemCategory.equals(ItemCategory.ARMOR);
    }

    @Override
    public boolean isShield() {
        return itemCategory.equals(ItemCategory.SHIELD);
    }

    @Override
    public boolean isWeapon() {
        return itemCategory.equals(ItemCategory.WEAPON);
    }

    @Override
    public boolean isWristband() {
        return itemCategory.equals(ItemCategory.WRISTBAND);
    }

    @Override
    public boolean isGloves() {
        return itemCategory.equals(ItemCategory.GLOVES);
    }

    @Override
    public boolean isRing() {
        return itemCategory.equals(ItemCategory.RING);
    }

    @Override
    public boolean isBelt() {
        return itemCategory.equals(ItemCategory.BELT);
    }

    @Override
    public boolean isBoots() {
        return itemCategory.equals(ItemCategory.BOOTS);
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
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        MagicItem other = (MagicItem) obj;
        if (isRelic != other.isRelic) return false;
        return true;
    }
}
