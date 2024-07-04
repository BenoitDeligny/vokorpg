package core.domain.fight

import core.domain.fight.Fighter.*
import core.domain.hero.Hero
import core.domain.monster.Monster

data class Fight(
    val hero: Hero,
    val monster: Monster
) {
    private val heroInitiative = hero.initiative()
    private val monsterInitiative = monster.initiative()

    fun foo(): List<Fighter> {
        val fighters: List<Fighter> = listOf(HeroFighter(hero), MonsterFighter(monster))
            .sortedByDescending { fighter -> when(fighter) {
                is HeroFighter -> heroInitiative
                is MonsterFighter -> monsterInitiative
            } }

        return fighters
    }
}

sealed interface Fighter{
    data class HeroFighter(val hero: Hero) : Fighter
    data class MonsterFighter(val monster: Monster) : Fighter
}