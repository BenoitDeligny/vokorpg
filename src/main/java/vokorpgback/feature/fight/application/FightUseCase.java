package vokorpgback.feature.fight.application;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.fight.domain.model.CombatResult;
import vokorpgback.feature.fight.domain.model.Encounter;

public class FightUseCase {

    public CombatResult handle(LegendaryCharacter legendaryCharacter, Encounter encounter, boolean isFleeing) {

        // TODO: add fleeing option
            // check if character want to flee
            // check if 2 rolls + agility > remaining might of opponents
                // only the opponent that the character is actually fighting or all the opponent in the encounter ?

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
            return handle(legendaryCharacter, encounter, false);
        }
    }
}
