package core.domain.fight

import core.domain.fight.FightingTeam.HeroesTeam
import core.domain.fight.FightingTeam.MonstersTeam
import core.domain.hero.Hero
import core.domain.monster.Monster

data class Fight(
    val heroesTeam: HeroesTeam,
    val monstersTeam: MonstersTeam,
) {
}

sealed interface FightingTeam {
    data class HeroesTeam(val heroes: List<Hero>) : FightingTeam

    data class MonstersTeam(val monsters: List<Monster>) : FightingTeam
}