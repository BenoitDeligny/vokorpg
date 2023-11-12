package vokorpgback.feature.fight.domain.model;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;

public class Fight {
    private final LegendaryCharacter legendaryCharacter;
    private final Encounter encounter;
    private boolean attemptToFlee;

    public Fight(LegendaryCharacter legendaryCharacter, Encounter encounter) {
        this.legendaryCharacter = legendaryCharacter;
        this.encounter = encounter;
    }

    public Fight(LegendaryCharacter legendaryCharacter, Encounter encounter, boolean attemptToFlee) {
        this.legendaryCharacter = legendaryCharacter;
        this.encounter = encounter;
        this.attemptToFlee = attemptToFlee;
    }

    public FightState makeTurn() {
        // fleeing attempt
        if (isLegendaryCharacterFleeing(legendaryCharacter, encounter, attemptToFlee)) {
            return new FightState(FightResult.FLED, legendaryCharacter, encounter);
        }

        // character's turn
        characterTurn();

        // opponents' turn
        opponentTurn();

        if (legendaryCharacter.isDead()) {
            return new FightState(FightResult.LOST, legendaryCharacter, encounter);
        } else if(encounter.livingOpponents().isEmpty()) {
            return new FightState(FightResult.WON, legendaryCharacter, encounter);
        } else {
            return new FightState(FightResult.IN_PROGRESS, legendaryCharacter, encounter);
        }
    }

    private boolean isLegendaryCharacterFleeing(LegendaryCharacter legendaryCharacter, Encounter encounter, boolean attemptToFlee) {
        return attemptToFlee && isLegendaryCharacterFleeingScoreEnough(legendaryCharacter, encounter);
    }

    private boolean isLegendaryCharacterFleeingScoreEnough(LegendaryCharacter legendaryCharacter, Encounter encounter) {
        return legendaryCharacter.fleeingScore() >= encounter.livingOpponents().get(0).fightingMight().remainingMight();
    }

    private void characterTurn() {
        int characterDamages = legendaryCharacter.rollDamages();
        encounter.assignDamages(characterDamages, legendaryCharacter.characterCombatDice());
    }

    private void opponentTurn() {
        int opponentDamages = encounter.computeOpponentsTotalDamages();
        legendaryCharacter.takeDamages(opponentDamages);
    }
}
