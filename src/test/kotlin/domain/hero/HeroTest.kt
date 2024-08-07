package domain.hero

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.ranges.shouldBeIn
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import core.domain.sharedkernel.Gear
import core.domain.sharedkernel.Item.Armor.Companion.mightArmor
import core.domain.sharedkernel.Item.Weapon.Companion.damageWeapon
import core.domain.sharedkernel.Might
import core.domain.hero.Abilities
import core.domain.hero.Ability
import core.domain.hero.Hero
import core.domain.hero.Hero.Companion.randomInEasyMode
import core.domain.hero.Hero.Companion.randomInNormalMode
import core.domain.hero.Identity.Companion.withRandomAge

class HeroTest {
    @Nested
    inner class HeroCreation {
        // Property Based Testing
        @RepeatedTest(1000)
        fun `create new Hero with random attributes in NORMAL mode`() {
            // given
            // when
            // then
            randomInNormalMode("MyHero")
                .apply {
                    identity.name shouldBe "MyHero"
                    identity.age.value shouldBeIn 15..20
                    abilities.strength.value shouldBeIn 2..7
                    abilities.agility.value shouldBeIn 2..7
                    abilities.perception.value shouldBeIn 2..7
                    might.level shouldBeIn 7..22
                    might.lifePoints shouldBeEqual might.level
                }
        }

        @RepeatedTest(1000)
        fun `create new Hero with random attributes in EASY mode`() {
            // given
            // when
            // then
            randomInEasyMode("MyHero")
                .apply {
                    identity.name shouldBe "MyHero"
                    identity.age.value shouldBeIn 15..20
                    abilities.strength.value shouldBeIn 5..10
                    abilities.agility.value shouldBeIn 5..10
                    abilities.perception.value shouldBeIn 5..10
                    might.level shouldBeIn 16..31
                    might.lifePoints shouldBeEqual might.level
                }
        }
    }

    @Nested
    inner class HeroTakesDamaged {
        @Test
        fun `hero takes damages and lives`() {
            // given
            // when
            val hero = aNewHero().run { this damagedBy 5 }

            // then
            hero.might.level shouldBe 15
            hero.might.lifePoints shouldBe 10
            hero.dead() shouldBe false
        }

        @Test
        fun `hero takes damages and dies`() {
            // given
            // when
            val hero = aNewHero().run { this damagedBy 15 }

            // then
            hero.might.level shouldBe 15
            hero.might.lifePoints shouldBe 0
            hero.dead() shouldBe true
        }

        @Test
        fun `hero can't be take more damages than remaining might`() {
            // given
            // when
            val hero = aNewHero().run { this damagedBy 25 }

            // then
            hero.might.level shouldBe 15
            hero.might.lifePoints shouldBe 0
        }
    }

    @Nested
    inner class HeroIsHealed {
        @Test
        fun `hero is healed`() {
            // given
            // when
            val hero = aDamagedHero().run { this healedBy 5 }

            // then
            hero.might.level shouldBe 15
            hero.might.lifePoints shouldBe 10
        }

        @Test
        fun `hero cannot be heal more than might level`() {
            // given
            // when
            val hero = aNewHero().run { this healedBy 5 }

            // then
            hero.might.level shouldBe 15
            hero.might.lifePoints shouldBe 15
        }
    }

    @Nested
    inner class HeroIsStuffed {
        @Test
        fun `hero wears an armor`() {
            // given
            // when
            val hero = anArmoredHero()

            // then
            hero.might.level shouldBe 30
            hero.might.lifePoints shouldBe 30
        }

        @Test
        fun `hero put on an armor`() {
            // given
            val armor = mightArmor(mightModifier = 5)

            // when
            val hero = aNewHero().run { this putOn armor }

            // then
            hero.might.level shouldBe 20
            hero.might.lifePoints shouldBe 20
        }

        @Test
        fun `hero takes out an armor`() {
            // given
            // when
            val hero = anArmoredHero().run { this takesOut gear.armor }

            // then
            hero.might.level shouldBe 15
            hero.might.lifePoints shouldBe 15
        }

        @Test
        fun `hero don't die when removes a piece of gear`() {
            // given
            // when
            val hero = anArmoredHero()
                .run { this damagedBy 20 }
                .run { this takesOut gear.armor }

            // then
            hero.might.level shouldBe 15
            hero.might.lifePoints shouldBe 1
        }
    }

    @Nested
    inner class HeroIsAttacking {
        @RepeatedTest(100)
        fun `a new hero attacks`() {
            // given
            val hero = aNewHero()

            // when
            // then
            hero.attacks() shouldBeIn 1..6
        }

        @RepeatedTest(100)
        fun `an armored hero attacks`() {
            // given
            val hero = anArmoredHero()

            // when
            // then
            hero.attacks() shouldBeIn 2..12
        }

        @RepeatedTest(100)
        fun `a armed hero attacks`() {
            // given
            val hero = anArmedHero()

            // when
            // then
            hero.attacks() shouldBeIn 6..11
        }
    }

    @Nested
    inner class Fails {
        @Test
        fun `should throw bad name exception`() {
            shouldThrow<IllegalArgumentException> {
                randomInNormalMode("MyHer0")
            }
                .apply { message shouldBe "Name must contains only letters." }

        }

        @Test
        fun `should throw strength exception`() {
            shouldThrow<IllegalArgumentException> {
                Hero(
                    identity = withRandomAge("MyHero"),
                    abilities = Abilities(
                        strength = Ability(0),
                        agility = Ability(1),
                        perception = Ability(1)
                    )
                )
            }
                .apply { message shouldBe "An ability should be positive. Value = 0." }
        }

        @Test
        fun `should throw agility exception`() {
            shouldThrow<IllegalArgumentException> {
                Hero(
                    identity = withRandomAge("MyHero"),
                    abilities = Abilities(
                        strength = Ability(0),
                        agility = Ability(1),
                        perception = Ability(1)
                    )
                )
            }
                .apply { message shouldBe "An ability should be positive. Value = 0." }
        }

        @Test
        fun `should throw perception exception`() {
            shouldThrow<IllegalArgumentException> {
                Hero(
                    identity = withRandomAge("MyHero"),
                    abilities = Abilities(
                        strength = Ability(0),
                        agility = Ability(1),
                        perception = Ability(1)
                    )
                )
            }
                .apply { message shouldBe "An ability should be positive. Value = 0." }

        }
    }
}

private fun aNewHero() = Hero(
    identity = withRandomAge(name = "MyHero"),
    abilities = Abilities(
        strength = Ability(5),
        agility = Ability(5),
        perception = Ability(5)
    )
)

private fun aDamagedHero() = Hero(
    identity = withRandomAge(name = "MyHero"),
    abilities = Abilities(
        strength = Ability(5),
        agility = Ability(5),
        perception = Ability(5)
    ),
    might = Might(level = 15, lifePoints = 5)
)

private fun anArmoredHero() = Hero(
    identity = withRandomAge(name = "MyHero"),
    abilities = Abilities(
        strength = Ability(5),
        agility = Ability(5),
        perception = Ability(5)
    ),
    gear = Gear(armor = mightArmor(15))
)

private fun anArmedHero() = Hero(
    identity = withRandomAge(name = "MyHero"),
    abilities = Abilities(
        strength = Ability(5),
        agility = Ability(5),
        perception = Ability(5)
    ),
    gear = Gear(weapon = damageWeapon(5))
)