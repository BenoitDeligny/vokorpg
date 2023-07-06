package vokorpgback.feature.commons.domain.model.character.gear;

public record Trait(
        TraitType type,
        int modifier
) {

    // TODO
    // implement bonus
    // find type of bonus (add damage, add power, special effect, ...)
    // ability bonus
    // knowledge bonus
    // deplacement sur la carte
    // remove states (poison, etc)
    // isRelic or not
}
