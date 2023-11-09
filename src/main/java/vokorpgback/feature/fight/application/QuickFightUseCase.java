package vokorpgback.feature.fight.application;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.fight.domain.model.CombatResult;
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
        if (legendaryCharacter.isDead()) {
            return CombatResult.LOSE;
        } else if (encounter.livingOpponents().isEmpty()) {
            return CombatResult.WIN;
        } else {
            return handle(legendaryCharacter, encounter);
        }
    }
}
