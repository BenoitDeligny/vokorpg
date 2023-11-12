package vokorpgback.feature.fight.application;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.fight.domain.model.CombatResult;
import vokorpgback.feature.fight.domain.model.CombatState;
import vokorpgback.feature.fight.domain.model.Encounter;

public class TurnBasedFightUseCase {

    public CombatResult handle(LegendaryCharacter legendaryCharacter, Encounter encounter, boolean attemptToFlee) {

        // fleeing attempt
        if (isLegendaryCharacterFleeing(legendaryCharacter, encounter, attemptToFlee)) {
            return new CombatResult(CombatState.FLED, legendaryCharacter, encounter);
        }

        // character's turn
        int characterDamages = legendaryCharacter.rollDamages();
        encounter.assignDamages(characterDamages, legendaryCharacter.characterCombatDice());

        // opponents' turn
        int opponentDamages = encounter.computeOpponentsTotalDamages();
        legendaryCharacter.takeDamages(opponentDamages);

        return getCombatResult(legendaryCharacter, encounter);
    }

    private static boolean isLegendaryCharacterFleeing(LegendaryCharacter legendaryCharacter, Encounter encounter, boolean attemptToFlee) {
        return attemptToFlee && isLegendaryCharacterFleeingScoreEnough(legendaryCharacter, encounter);
    }

    private static boolean isLegendaryCharacterFleeingScoreEnough(LegendaryCharacter legendaryCharacter, Encounter encounter) {
        return legendaryCharacter.fleeingScore() >= encounter.livingOpponents().get(0).fightingMight().remainingMight();
    }

    // TODO: think about refactoring this as we maybe can melt this with the QuickFightUseCase return
    // tell don't ask in the CombatResult ?
    private CombatResult getCombatResult(LegendaryCharacter legendaryCharacter, Encounter encounter) {
        if (legendaryCharacter.isDead()) {
            return new CombatResult(CombatState.LOST, legendaryCharacter, encounter);
        } else if(encounter.livingOpponents().isEmpty()) {
            return new CombatResult(CombatState.WON, legendaryCharacter, encounter);
        } else {
            return new CombatResult(CombatState.IN_PROGRESS, legendaryCharacter, encounter);
        }
    }
}
