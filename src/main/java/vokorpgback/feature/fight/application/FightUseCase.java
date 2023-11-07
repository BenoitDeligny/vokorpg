package vokorpgback.feature.fight.application;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.fight.domain.model.Encounter;

public class FightUseCase {

    public boolean handle(LegendaryCharacter legendaryCharacter, Encounter encounter) {

        // TODO: add fleeing option

        // character's turn
        int characterDamages = legendaryCharacter.rollDamages();
        encounter.assignDamages(characterDamages, legendaryCharacter.characterCombatDice());

        // opponents' turn
        int opponentDamages = encounter.computeOpponentsTotalDamages();
        legendaryCharacter.takeDamages(opponentDamages);

        // finish or loop
        if (legendaryCharacter.isDead()) {
            return false;
        } else if (encounter.livingOpponents().isEmpty()) {
            return true;
        } else {
            return handle(legendaryCharacter, encounter);
        }
    }
}
