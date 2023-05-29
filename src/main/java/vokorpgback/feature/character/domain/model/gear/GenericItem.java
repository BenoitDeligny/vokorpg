package vokorpgback.feature.character.domain.model.gear;

import java.util.Collections;

public class GenericItem extends Item {

    public GenericItem() {
        super("Generic item", Category.GENERIC, Collections.emptyList(), "A useless item");
    }

    @Override
    public boolean isHelmet() {
        return true;
    }

    @Override
    public boolean isMask() {
        return true;
    }

    @Override
    public boolean isNecklace() {
        return true;
    }

    @Override
    public boolean isCloak() {
        return true;
    }

    @Override
    public boolean isCostume() {
        return true;
    }

    @Override
    public boolean isArmor() {
        return true;
    }

    @Override
    public boolean isShield() {
        return true;
    }

    @Override
    public boolean isWeapon() {
        return true;
    }

    @Override
    public boolean isWristband() {
        return true;
    }

    @Override
    public boolean isGloves() {
        return true;
    }

    @Override
    public boolean isRing() {
        return true;
    }

    @Override
    public boolean isBelt() {
        return true;
    }

    @Override
    public boolean isBoots() {
        return true;
    }
}
