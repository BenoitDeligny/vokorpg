package core.domain.fight

import core.domain.hero.Hero
import core.domain.monster.Monster
import org.junit.jupiter.api.Test

class FightTest {
    @Test
    fun `should sort fighters by initiative`() {
        // given
        val hero = Hero.randomInNormalMode("hero")
        val monster = Monster.mediumMonster()
        val fight = Fight(hero, monster)

        // when
        val fighters = fight.foo()

        // then

    }
}