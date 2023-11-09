package vokorpgback.feature.fight.application;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.fight.domain.model.CombatResult;
import vokorpgback.feature.fight.domain.model.Encounter;

public class TurnBasedFightUseCase {

    public void handle(LegendaryCharacter legendaryCharacter, Encounter encounter) {

        // TODO: think about adding fleeing option -> change the looping way and implements turn by turn
        // TODO: fleeing rules
            // check if character want to flee
            // check if 2 rolls + agility > remaining might of opponents
                // only the opponent that the character is actually fighting or all the opponent in the encounter ?

        // character's turn
        int characterDamages = legendaryCharacter.rollDamages();
        encounter.assignDamages(characterDamages, legendaryCharacter.characterCombatDice());

        // opponents' turn
        int opponentDamages = encounter.computeOpponentsTotalDamages();
        legendaryCharacter.takeDamages(opponentDamages);

        // TODO: return a temporary result ?
    }
}
