package vokorpgback.feature.commons.domain.model.gear;

import vokorpgback.commons.Validation;
import vokorpgback.feature.commons.domain.model.knowledge.KnowledgeType;

public class Weapon extends Item {
    private final KnowledgeType mainKnowledgeType;

    public Weapon(String name, ItemType type, Trait trait, String description, boolean isRelic, KnowledgeType mainKnowledgeType) {
        super(name, type, trait, description, isRelic);

        Validation.require(isWeaponType(type), "Weapon should be of weapon type.");
        this.mainKnowledgeType = mainKnowledgeType;
    }

    private boolean isWeaponType(ItemType itemType) {
        return itemType == ItemType.WEAPON;
    }

    public KnowledgeType getMainKnowledge() {
        return mainKnowledgeType;
    }
}
