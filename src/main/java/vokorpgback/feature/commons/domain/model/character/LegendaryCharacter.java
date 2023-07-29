package vokorpgback.feature.commons.domain.model.character;

import vokorpgback.commons.Validation;
import vokorpgback.feature.commons.domain.model.Ability.Ability;
import vokorpgback.feature.commons.domain.model.Ability.Agility;
import vokorpgback.feature.commons.domain.model.Ability.Perception;
import vokorpgback.feature.commons.domain.model.Ability.Strength;
import vokorpgback.feature.commons.domain.model.Power;
import vokorpgback.feature.commons.domain.model.gear.BackPack;
import vokorpgback.feature.commons.domain.model.gear.Gear;
import vokorpgback.feature.commons.domain.model.knowledge.Knowledge;

import java.util.List;

public class LegendaryCharacter {
    private final Identity identity;
    private final Strength strength;
    private final Agility agility;
    private final Perception perception;
    private final Gear gear;
    private final List<Power> powers;
    private final List<Knowledge> knowledge;
    private final FightingMight fightingMight;
    private final BackPack backPack;

    public LegendaryCharacter(Identity identity, Strength strength, Agility agility, Perception perception, Gear gear, List<Power> powers, List<Knowledge> knowledge, BackPack backPack) {
        this.identity = identity;
        this.strength = strength;
        this.agility = agility;
        this.perception = perception;
        this.gear = gear;
        this.powers = powers;
        this.knowledge = knowledge;
        this.fightingMight = computeFightingMight(strength, agility, perception, gear);
        this.backPack = backPack;
    }

    private static FightingMight computeFightingMight(Ability strength, Ability agility, Ability perception, Gear gear) {
        int maxNaturalPower = strength.value() + agility.value() + perception.value();
        int maxTotalPower = strength.value() + agility.value() + perception.value() + gear.computeMightBonusFromGear(); // TODO add knowledge, powers bonus

        return new FightingMight(
                maxNaturalPower,
                maxTotalPower,
                maxTotalPower,
                computeCombatChart(maxTotalPower)
        );
    }

    private static CharacterCombatChart computeCombatChart(int maxFightingMight) {
        for (CharacterCombatChart characterCombatChart : CharacterCombatChart.values()) {
            if (maxFightingMight >= characterCombatChart.getMinTotalMight() && maxFightingMight <= characterCombatChart.getMaxTotalMight()) {
                return characterCombatChart;
            }
        }
        return CharacterCombatChart.ZERO;
    }

    public String name() {
        return identity.name();
    }

    public int age() {
        return identity.age();
    }

    public int strength() {
        return strength.value();
    }

    public int agility() {
        return agility.value();
    }

    public int perception() {
        return perception.value();
    }

    public Gear gear() {
        return gear;
    }

    public List<Power> powers() {
        return powers;
    }

    public List<Knowledge> knowledge() {
        return knowledge;
    }

    public int maxNaturalMight() {
        return fightingMight.maxNaturalMight();
    }

    public int maxTotalMight() {
        return fightingMight.maxTotalMight();
    }

    public int remainingMight() {
        return fightingMight.remainingMight();
    }

    public CharacterCombatChart characterCombatChart() {
        return fightingMight.characterCombatChart();
    }

    public int characterCombatDice() {
        return fightingMight.characterCombatChart().getNumberOfDice();
    }

    public BackPack backPack() {
        return backPack;
    }

    record Identity(String name,int age) {

        Identity {
            Validation.require(containsOnlyLetters(name), "Name should only contain letters.");
            Validation.require(isAgeBetween15And20(age), "Age must be between 15 and 20.");
        }

        private boolean containsOnlyLetters(String name) {
            return name.matches("[a-zA-Z]+");
        }
        private boolean isAgeBetween15And20(int age) {
            return age >= 15 && age <= 20;
        }
    }

    record FightingMight(
            int maxNaturalMight,
            int maxTotalMight,
            int remainingMight,
            CharacterCombatChart characterCombatChart
    ) {
    }
}
