package vokorpgback.feature.fight.application;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.commons.domain.model.dice.OfficialDiceFactory;
import vokorpgback.feature.commons.domain.model.opponent.Opponent;
import vokorpgback.feature.commons.domain.port.DiceFactory;
import vokorpgback.feature.fight.domain.model.Encounter;

public class FightUseCase {

    public void handle(LegendaryCharacter legendaryCharacter, Encounter encounter) {
        // TODO: rules
        // damages = number of combat dice + bonus (weapon, power, skills, ...)
        // apply damages to remaining might of monsters (theoretically, max monster per attack is number of dice)
        // if monsters survived do the same for them

        // TODO: should we make "turn" split ?

        Opponent badGuy = encounter.opponent();
        int characterDamages = legendaryCharacter.rollDamages();
        badGuy.takeDamages(characterDamages);
        // if opponent alive then fightback
        int opponentDamages = encounter.opponent().rollDamages();
        legendaryCharacter.takeDamages(opponentDamages);
    }
}
