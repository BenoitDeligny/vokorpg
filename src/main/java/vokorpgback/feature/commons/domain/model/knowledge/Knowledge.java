package vokorpgback.feature.commons.domain.model.knowledge;

public class Knowledge {
    private final KnowledgeType type;
    private int masteryLevel;

    public Knowledge(KnowledgeType type, int masteryLevel) {
        this.type = type;
        this.masteryLevel = masteryLevel;
    }

    public KnowledgeType getType() {
        return type;
    }

    public int getMasteryLevel() {
        return masteryLevel;
    }

    public void masteryLevelUp() {
        this.masteryLevel = masteryLevel + 1;
    }
}
