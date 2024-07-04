package vokorpg.domain.monster

import vokorpg.domain.Dice
import vokorpg.domain.Gear
import vokorpg.domain.Item.Armor.Companion.mightArmor
import vokorpg.domain.Item.Shield.Companion.mightShield
import vokorpg.domain.Item.Weapon.Companion.damageWeapon
import vokorpg.domain.Might
import vokorpg.domain.Might.Companion.initialized
import vokorpg.domain.hero.HeroCombatChart
import vokorpg.domain.monster.MonsterCombatChart.Companion.chartBy


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

    infix fun damagedBy(damages: Int) = copy(might = might.decreasedLifePoints(damages))
    infix fun healedBy(heal: Int) = copy(might = might.increasedLifePoints(heal))
    fun attacks() = combatDicePool().sumOf { dice -> dice.sixSidedRoll() } + gear.totalDamagesBonus()
    private fun combatDicePool(): List<Dice> = List(chartBy(might).numberOfDice) { Dice }

}