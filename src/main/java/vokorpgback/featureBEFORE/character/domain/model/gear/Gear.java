package vokorpgback.featureBEFORE.character.domain.model.gear;

import java.util.List;
import vokorpgback.commons.Validation;
import vokorpgback.feature.commons.domain.model.GameMode;

public record Gear(
    Helmet helmet,
    Mask mask,
    Necklace necklace,
    Cloak cloak,
    Costume costume,
    Armor armor,
    Shield shield,
    Weapon primaryWeapon,
    Weapon secondaryWeapon,
    Wristband wristband,
    Gloves gloves,
    Ring ring,
    Belt belt,
    Boots boots) {

}
