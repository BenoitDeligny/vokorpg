package core.domain.hero

import core.domain.sharedkernel.Dice
import core.domain.sharedkernel.GameMode.EASY
import core.domain.sharedkernel.GameMode.NORMAL

data class Abilities(
    val strength: Ability,
    val agility: Ability,
    val perception: Ability
) {
    companion object {
        // TODO: naming
        fun randomInNormalMode() = Abilities(
            strength = Ability.randomInNormalMode(),
            agility = Ability.randomInNormalMode(),
            perception = Ability.randomInNormalMode()
        )

        // TODO: naming
        fun randomInEasyMode() = Abilities(
            strength = Ability.randomInEasyMode(),
            agility = Ability.randomInEasyMode(),
            perception = Ability.randomInEasyMode()
        )
    }

    // TODO: override operator plus ?
    fun sum() = strength.value + agility.value + perception.value
}

@JvmInline
value class Ability(val value: Int) {
    companion object {
        private val dice = Dice

        // TODO: naming
        fun randomInNormalMode() = Ability(dice.sixSidedRoll() + NORMAL.abilityModifier)
        fun randomInEasyMode() = Ability(dice.sixSidedRoll() + EASY.abilityModifier)
    }

    init {
        require(value > 0) { "An ability should be positive. Value = $value." }
    }

    operator fun plus(other: Int) = value + other
}