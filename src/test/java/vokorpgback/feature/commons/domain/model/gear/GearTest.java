package vokorpgback.feature.commons.domain.model.gear;

import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.knowledge.KnowledgeType;

import static org.junit.jupiter.api.Assertions.*;
import static vokorpgback.feature.commons.domain.model.GameMode.EASY;
import static vokorpgback.feature.commons.domain.model.GameMode.NORMAL;
import static vokorpgback.feature.commons.domain.model.gear.ItemType.*;

class GearTest {

    @Test
    void generateGear() {
        // given
        Gear normalGear = GearFactory.generateBasicGear(NORMAL);
        Gear easyGear = GearFactory.generateBasicGear(EASY);

        // when
        // then
        assertDoesNotThrow(() -> normalGear);
        assertDoesNotThrow(() -> easyGear);
        assertEquals(0, normalGear.computeMightBonusFromGear());
        assertEquals(3, easyGear.computeMightBonusFromGear());
        assertEquals(1, easyGear.computeDamageBonusFromGear());
    }

    @Test
    void generateGear_should_fails_whenBadItemType() {
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(CONSUMABLE),
                generateItem(MASK),
                generateItem(NECKLACE),
                generateItem(CLOAK),
                generateItem(COSTUME),
                generateItem(ARMOR),
                generateItem(SHIELD),
                generateWeapon(WEAPON),
                generateWeapon(WEAPON),
                generateItem(WRISTBAND),
                generateItem(GLOVES),
                generateItem(RING),
                generateItem(BELT),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(CONSUMABLE),
                generateItem(NECKLACE),
                generateItem(CLOAK),
                generateItem(COSTUME),
                generateItem(ARMOR),
                generateItem(SHIELD),
                generateWeapon(WEAPON),
                generateWeapon(WEAPON),
                generateItem(WRISTBAND),
                generateItem(GLOVES),
                generateItem(RING),
                generateItem(BELT),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(MASK),
                generateItem(CONSUMABLE),
                generateItem(CLOAK),
                generateItem(COSTUME),
                generateItem(ARMOR),
                generateItem(SHIELD),
                generateWeapon(WEAPON),
                generateWeapon(WEAPON),
                generateItem(WRISTBAND),
                generateItem(GLOVES),
                generateItem(RING),
                generateItem(BELT),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(MASK),
                generateItem(NECKLACE),
                generateItem(CONSUMABLE),
                generateItem(COSTUME),
                generateItem(ARMOR),
                generateItem(SHIELD),
                generateWeapon(WEAPON),
                generateWeapon(WEAPON),
                generateItem(WRISTBAND),
                generateItem(GLOVES),
                generateItem(RING),
                generateItem(BELT),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(MASK),
                generateItem(NECKLACE),
                generateItem(CLOAK),
                generateItem(CONSUMABLE),
                generateItem(ARMOR),
                generateItem(SHIELD),
                generateWeapon(WEAPON),
                generateWeapon(WEAPON),
                generateItem(WRISTBAND),
                generateItem(GLOVES),
                generateItem(RING),
                generateItem(BELT),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(MASK),
                generateItem(NECKLACE),
                generateItem(CLOAK),
                generateItem(COSTUME),
                generateItem(CONSUMABLE),
                generateItem(SHIELD),
                generateWeapon(WEAPON),
                generateWeapon(WEAPON),
                generateItem(WRISTBAND),
                generateItem(GLOVES),
                generateItem(RING),
                generateItem(BELT),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(MASK),
                generateItem(NECKLACE),
                generateItem(CLOAK),
                generateItem(COSTUME),
                generateItem(ARMOR),
                generateItem(CONSUMABLE),
                generateWeapon(WEAPON),
                generateWeapon(WEAPON),
                generateItem(WRISTBAND),
                generateItem(GLOVES),
                generateItem(RING),
                generateItem(BELT),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(MASK),
                generateItem(NECKLACE),
                generateItem(CLOAK),
                generateItem(COSTUME),
                generateItem(ARMOR),
                generateItem(SHIELD),
                generateWeapon(CONSUMABLE),
                generateWeapon(WEAPON),
                generateItem(WRISTBAND),
                generateItem(GLOVES),
                generateItem(RING),
                generateItem(BELT),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(MASK),
                generateItem(NECKLACE),
                generateItem(CLOAK),
                generateItem(COSTUME),
                generateItem(ARMOR),
                generateItem(SHIELD),
                generateWeapon(WEAPON),
                generateWeapon(CONSUMABLE),
                generateItem(WRISTBAND),
                generateItem(GLOVES),
                generateItem(RING),
                generateItem(BELT),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(MASK),
                generateItem(NECKLACE),
                generateItem(CLOAK),
                generateItem(COSTUME),
                generateItem(ARMOR),
                generateItem(SHIELD),
                generateWeapon(WEAPON),
                generateWeapon(WEAPON),
                generateItem(CONSUMABLE),
                generateItem(GLOVES),
                generateItem(RING),
                generateItem(BELT),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(MASK),
                generateItem(NECKLACE),
                generateItem(CLOAK),
                generateItem(COSTUME),
                generateItem(ARMOR),
                generateItem(SHIELD),
                generateWeapon(WEAPON),
                generateWeapon(WEAPON),
                generateItem(WRISTBAND),
                generateItem(CONSUMABLE),
                generateItem(RING),
                generateItem(BELT),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(MASK),
                generateItem(NECKLACE),
                generateItem(CLOAK),
                generateItem(COSTUME),
                generateItem(ARMOR),
                generateItem(SHIELD),
                generateWeapon(WEAPON),
                generateWeapon(WEAPON),
                generateItem(WRISTBAND),
                generateItem(GLOVES),
                generateItem(CONSUMABLE),
                generateItem(BELT),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(MASK),
                generateItem(NECKLACE),
                generateItem(CLOAK),
                generateItem(COSTUME),
                generateItem(ARMOR),
                generateItem(SHIELD),
                generateWeapon(WEAPON),
                generateWeapon(WEAPON),
                generateItem(WRISTBAND),
                generateItem(GLOVES),
                generateItem(RING),
                generateItem(CONSUMABLE),
                generateItem(BOOTS)
        ));
        assertThrows(IllegalArgumentException.class, () -> new Gear(
                generateItem(HELMET),
                generateItem(MASK),
                generateItem(NECKLACE),
                generateItem(CLOAK),
                generateItem(COSTUME),
                generateItem(ARMOR),
                generateItem(SHIELD),
                generateWeapon(WEAPON),
                generateWeapon(WEAPON),
                generateItem(WRISTBAND),
                generateItem(GLOVES),
                generateItem(RING),
                generateItem(BELT),
                generateItem(CONSUMABLE)
        ));
    }

    private Item generateItem(ItemType itemType) {
        return new Item(
                "Item",
                itemType,
                null,
                "",
                false
        );
    }

    private Weapon generateWeapon(ItemType itemType) {
        return new Weapon(
                "Item",
                itemType,
                null,
                "",
                false,
                KnowledgeType.SWORDSMANSHIP
        );
    }
}