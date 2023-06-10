package vokorpgback.feature.commons.domain.model.gear;

import vokorpgback.feature.commons.domain.model.knowledge.KnowledgeType;

public class Weapon extends Item {
    private final KnowledgeType mainKnowledgeType;

    public Weapon(String name, ItemType type, Trait trait, String description, boolean isRelic, KnowledgeType mainKnowledgeType) {
        super(name, type, trait, description, isRelic);
        this.mainKnowledgeType = mainKnowledgeType;
    }

    public KnowledgeType getMainKnowledge() {
        return mainKnowledgeType;
    }
}
