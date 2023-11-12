package vokorpgback.feature.fight.application;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.fight.domain.model.CombatResult;
import vokorpgback.feature.fight.domain.model.CombatState;
import vokorpgback.feature.fight.domain.model.Encounter;

public class QuickFightUseCase {

    public CombatResult handle(LegendaryCharacter legendaryCharacter, Encounter encounter) {

        // character's turn
        int characterDamages = legendaryCharacter.rollDamages();
        encounter.assignDamages(characterDamages, legendaryCharacter.characterCombatDice());

        // opponents' turn
        int opponentDamages = encounter.computeOpponentsTotalDamages();
        legendaryCharacter.takeDamages(opponentDamages);

        // finish or loop
        // TODO: think about refactoring this as we maybe can melt this with the TurnBasedFightUseCase return
        // tell don't ask in the CombatResult ?
        if (legendaryCharacter.isDead()) {
            return new CombatResult(CombatState.LOST, legendaryCharacter, encounter);
        } else if (encounter.livingOpponents().isEmpty()) {
            return new CombatResult(CombatState.WON, legendaryCharacter, encounter);
        } else {
            return handle(legendaryCharacter, encounter);
        }
    }
}
