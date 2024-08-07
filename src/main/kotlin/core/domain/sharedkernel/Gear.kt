package core.domain.sharedkernel

import core.domain.sharedkernel.Item.*

data class Gear(
    val armor: Armor = Armor.NONE,
    val belt: Belt = Belt.NONE,
    val boots: Boots = Boots.NONE,
    val cloak: Cloak = Cloak.NONE,
    val consumables: List<Consumable> = Consumable.NONE,
    val costume: Costume = Costume.NONE,
    val gloves: Gloves = Gloves.NONE,
    val helmet: Helmet = Helmet.NONE,
    val mask: Mask = Mask.NONE,
    val necklace: Necklace = Necklace.NONE,
    val weapon: Weapon = Weapon.NONE,
    val ring: Ring = Ring.NONE,
    val shield: Shield = Shield.NONE,
    val wristbands: Wristbands = Wristbands.NONE,
    // TODO: how to add multiple similar items ?
//    val rightRing: Ring = Ring.NONE,
//    val secondaryWeapon: Weapon = Weapon.NONE,
) {
    companion object {
        val NONE = Gear()

        // TODO: naming
        val NORMAL_MODE_STARTING_PACK = Gear(
            armor = Armor.BASIC,
            weapon = Weapon.BASIC
        )

        // TODO: naming
        val EASY_MODE_STARTING_PACK = Gear(
            armor = Armor.BASIC,
            boots = Boots.BASIC,
            weapon = Weapon.BASIC
        )
    }

    fun totalMightBonus() = armor.mightModifier +
            belt.mightModifier +
            boots.mightModifier +
            cloak.mightModifier +
            costume.mightModifier +
            gloves.mightModifier +
            helmet.mightModifier +
            mask.mightModifier +
            necklace.mightModifier +
            weapon.mightModifier +
            ring.mightModifier +
            shield.mightModifier +
            wristbands.mightModifier

    fun totalDamagesBonus() = armor.damageModifier +
            belt.damageModifier +
            boots.damageModifier +
            cloak.damageModifier +
            costume.damageModifier +
            gloves.damageModifier +
            helmet.damageModifier +
            mask.damageModifier +
            necklace.damageModifier +
            weapon.damageModifier +
            ring.damageModifier +
            shield.damageModifier +
            wristbands.damageModifier

    fun totalHealBonus() = armor.healModifier +
            belt.healModifier +
            boots.healModifier +
            cloak.healModifier +
            costume.healModifier +
            gloves.healModifier +
            helmet.healModifier +
            mask.healModifier +
            necklace.healModifier +
            weapon.healModifier +
            ring.healModifier +
            shield.healModifier +
            wristbands.healModifier

    // TODO: naming --> builders (return something) are nouns // manipulators (return void) are verbs
    fun removes(item: Item): Gear = when (item) {
        is Armor -> copy(armor = Armor.NONE)
        is Belt -> copy(belt = Belt.NONE)
        is Boots -> copy(boots = Boots.NONE)
        is Cloak -> copy(cloak = Cloak.NONE)
        is Consumable -> copy(consumables = Consumable.NONE)
        is Costume -> copy(costume = Costume.NONE)
        is Gloves -> copy(gloves = Gloves.NONE)
        is Helmet -> copy(helmet = Helmet.NONE)
        is Mask -> copy(mask = Mask.NONE)
        is Necklace -> copy(necklace = Necklace.NONE)
        is Ring -> copy(ring = Ring.NONE)
        is Shield -> copy(shield = Shield.NONE)
        is Weapon -> copy(weapon = Weapon.NONE)
        is Wristbands -> copy(wristbands = Wristbands.NONE)
    }

    // TODO: naming --> builders (return something) are nouns // manipulators (return void) are verbs
    fun wears(item: Item): Gear = when (item) {
        is Armor -> copy(armor = item)
        is Belt -> copy(belt = item)
        is Boots -> copy(boots = item)
        is Cloak -> copy(cloak = item)
        is Consumable -> copy(consumables = Consumable.NONE)
        is Costume -> copy(costume = item)
        is Gloves -> copy(gloves = item)
        is Helmet -> copy(helmet = item)
        is Mask -> copy(mask = item)
        is Necklace -> copy(necklace = item)
        is Ring -> copy(ring = item)
        is Shield -> copy(shield = item)
        is Weapon -> copy(weapon = item)
        is Wristbands -> copy(wristbands = item)
    }
}

sealed interface Item {
    val mightModifier: Int
    val damageModifier: Int
    val healModifier: Int

    data class Armor(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Armor(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Armor(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightArmor(mightModifier: Int) = Armor(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageArmor(damageModifier: Int) = Armor(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healArmor(healModifier: Int) = Armor(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }

    data class Belt(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Belt(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Belt(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightBelt(mightModifier: Int) = Belt(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageBelt(damageModifier: Int) = Belt(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healBelt(healModifier: Int) = Belt(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }

    data class Boots(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Boots(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Boots(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightBoots(mightModifier: Int) = Boots(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageBoots(damageModifier: Int) = Boots(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healBoots(healModifier: Int) = Boots(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }

    data class Cloak(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Cloak(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Cloak(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightCloak(mightModifier: Int) = Cloak(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageCloak(damageModifier: Int) = Cloak(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healCloak(healModifier: Int) = Cloak(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }

    data class Consumable(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = emptyList<Consumable>()
        }
    }

    data class Costume(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Costume(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Costume(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightCostume(mightModifier: Int) = Costume(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageCostume(damageModifier: Int) = Costume(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healCostume(healModifier: Int) = Costume(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }

    data class Gloves(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Gloves(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Gloves(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightGloves(mightModifier: Int) = Gloves(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageGloves(damageModifier: Int) = Gloves(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healGloves(healModifier: Int) = Gloves(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }

    data class Helmet(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Helmet(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Helmet(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightHelmet(mightModifier: Int) = Helmet(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageHelmet(damageModifier: Int) = Helmet(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healHelmet(healModifier: Int) = Helmet(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }

    data class Mask(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Mask(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Mask(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightMask(mightModifier: Int) = Mask(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageMask(damageModifier: Int) = Mask(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healMask(healModifier: Int) = Mask(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }

    data class Necklace(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Necklace(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Necklace(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightNecklace(mightModifier: Int) = Necklace(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageNecklace(damageModifier: Int) = Necklace(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healNecklace(healModifier: Int) = Necklace(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }

    data class Weapon(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Weapon(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Weapon(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightWeapon(mightModifier: Int) = Weapon(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageWeapon(damageModifier: Int) = Weapon(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healWeapon(healModifier: Int) = Weapon(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }

    data class Ring(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Ring(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Ring(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightRing(mightModifier: Int) = Ring(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageRing(damageModifier: Int) = Ring(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healRing(healModifier: Int) = Ring(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }

    data class Shield(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Shield(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Shield(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightShield(mightModifier: Int) = Shield(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageShield(damageModifier: Int) = Shield(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healShield(healModifier: Int) = Shield(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }

    data class Wristbands(
        override val mightModifier: Int,
        override val damageModifier: Int,
        override val healModifier: Int,
    ) : Item {
        companion object {
            val NONE = Wristbands(mightModifier = 0, damageModifier = 0, healModifier = 0)
            val BASIC = Wristbands(mightModifier = 1, damageModifier = 0, healModifier = 0)
            fun mightWristbands(mightModifier: Int) = Wristbands(mightModifier = mightModifier, damageModifier = 0, healModifier = 0)
            fun damageWristbands(damageModifier: Int) = Wristbands(mightModifier = 0, damageModifier = damageModifier, healModifier = 0)
            fun healWristbands(healModifier: Int) = Wristbands(mightModifier = 0, damageModifier = 0, healModifier = healModifier)
        }
    }
}