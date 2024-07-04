package core.domain.monster

import core.domain.sharedkernel.Dice
import core.domain.sharedkernel.Gear
import core.domain.sharedkernel.Item.Armor.Companion.mightArmor
import core.domain.sharedkernel.Item.Shield.Companion.mightShield
import core.domain.sharedkernel.Item.Weapon.Companion.damageWeapon
import core.domain.sharedkernel.Might
import core.domain.sharedkernel.Might.Companion.initialized
import core.domain.monster.MonsterCombatChart.Companion.chartBy


data class Monster(
    val name: String,
    val might: Might,
    val gear: Gear,
) {

    companion object {
        // TODO: temporary until list of monsters is in database
        fun weakMonster() = Monster(
            name = "Weak Monster",
            might = initialized(10),
            gear = Gear()
        )

        fun mediumMonster() = Monster(
            name = "Medium Monster",
            might = initialized(30),
            gear = Gear(
                armor = mightArmor(2),
                weapon = damageWeapon(2),
                shield = mightShield(2)
            )
        )

        fun strongMonster() = Monster(
            name = "Strong Monster",
            might = initialized(60),
            gear = Gear(
                armor = mightArmor(5),
                weapon = damageWeapon(5),
                shield = mightShield(5)
            )
        )
    }

    fun initiative() = (might.level / 3) + dicePoolRoll()
    fun attacks() = dicePoolRoll() + gear.totalDamagesBonus()
    infix fun damagedBy(damages: Int) = copy(might = might.decreasedLifePoints(damages))
    infix fun healedBy(heal: Int) = copy(might = might.increasedLifePoints(heal))
    private fun combatDicePool(): List<Dice> = List(chartBy(might).numberOfDice) { Dice }
    private fun dicePoolRoll() = combatDicePool().sumOf { dice -> dice.sixSidedRoll() }
}