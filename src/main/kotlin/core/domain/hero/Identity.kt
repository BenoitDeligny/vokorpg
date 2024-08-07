package core.domain.hero

import core.domain.sharedkernel.Dice
import core.domain.hero.Age.Companion.random

data class Identity(
    val name: String,
    val age: Age,
) {
    companion object {
        fun withRandomAge(name: String) = Identity(name = name, age = random())
    }

    init {
        require(name.all { it.isLetter() }) { "Name must contains only letters." }
        require(age in 15..20) { "Age must be between 15 and 20. Age = $age." }
    }

    operator fun IntRange.contains(age: Age): Boolean {
        return age.value in this
    }
}

@JvmInline
value class Age(val value: Int) {
    companion object {
        private val dice = Dice

        // TODO: naming
        fun random() = Age(14 + dice.sixSidedRoll())
    }
}