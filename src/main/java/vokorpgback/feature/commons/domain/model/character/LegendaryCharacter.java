package vokorpgback.feature.commons.domain.model.character;

import vokorpgback.feature.commons.domain.model.ability.Ability;
import vokorpgback.feature.commons.domain.model.ability.Agility;
import vokorpgback.feature.commons.domain.model.ability.Perception;
import vokorpgback.feature.commons.domain.model.ability.Strength;
import vokorpgback.feature.commons.domain.model.Power;
import vokorpgback.feature.commons.domain.model.gear.BackPack;
import vokorpgback.feature.commons.domain.model.gear.Gear;
import vokorpgback.feature.commons.domain.model.knowledge.Knowledge;
import vokorpgback.feature.commons.domain.model.dice.Dice;

import java.util.List;
import java.util.UUID;

public class LegendaryCharacter {
    private final Identity identity;
    private final Strength strength;
    private final Agility agility;
    private final Perception perception;
    private final Gear gear;
    private final List<Power> powers;
    private final List<Knowledge> knowledge;
    private CharacterFightingMight fightingMight;
    private final BackPack backPack;
    private final Dice diceType;

    protected LegendaryCharacter(Identity identity, Strength strength, Agility agility, Perception perception, Gear gear, List<Power> powers, List<Knowledge> knowledge, BackPack backPack, Dice diceType) {
        this.identity = identity;
        this.strength = strength;
        this.agility = agility;
        this.perception = perception;
        this.gear = gear;
        this.powers = powers;
        this.knowledge = knowledge;
        this.diceType = diceType;
        this.fightingMight = computeFightingMight(strength, agility, perception, gear);
        this.backPack = backPack;
    }

    private static CharacterFightingMight computeFightingMight(Ability strength, Ability agility, Ability perception, Gear gear) {
        int maxNaturalPower = strength.value() + agility.value() + perception.value();
        int maxTotalPower = strength.value() + agility.value() + perception.value() + gear.computeMightBonusFromGear(); // TODO add knowledge, powers bonus

        return new CharacterFightingMight(
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

    public int rollDamages() {
        int damages = 0;

        for (int i = 0; i < characterCombatDice(); i++) {
            damages += diceType.roll();
        }

        return damages;
    }

    public void takeDamages(int opponentDamages) {
        this.fightingMight = new CharacterFightingMight(
                fightingMight.maxNaturalMight(),
                fightingMight.maxTotalMight(),
                fightingMight.remainingMight() - opponentDamages,
                fightingMight.characterCombatChart()
        );
    }

    public int fleeingScore() {
        return diceType.roll() + diceType.roll() + agility.value();
    }

    public boolean isDead() {
        return fightingMight.remainingMight() <= 0;
    }

    public UUID uuid() {
        return identity.uuid();
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
}
