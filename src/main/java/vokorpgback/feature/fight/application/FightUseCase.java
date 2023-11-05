package vokorpgback.feature.fight.application;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.fight.domain.model.Encounter;

public class FightUseCase {

    public void handle(LegendaryCharacter legendaryCharacter, Encounter encounter) {
        // TODO: make a loop to finish the fight

        // character's turn
        int characterDamages = legendaryCharacter.rollDamages();
        encounter.assignDamages(characterDamages, legendaryCharacter.characterCombatDice());

        // opponents' turn
        int opponentDamages = encounter.computeOpponentsTotalDamages();
        legendaryCharacter.takeDamages(opponentDamages);

        // finish or loop
        if (encounter.livingOpponents().isEmpty() || legendaryCharacter.isDead()) {
            return;
        } else {
            handle(legendaryCharacter, encounter);
        }
    }
}
