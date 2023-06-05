package vokorpgback.feature.character.domain.model;

import vokorpgback.feature.character.domain.model.item.*;

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
