package vokorpgback.feature.fight.application;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.fight.domain.model.Fight;
import vokorpgback.feature.fight.domain.model.FightState;
import vokorpgback.feature.fight.domain.model.FightResult;
import vokorpgback.feature.fight.domain.model.Encounter;

public class QuickFightUseCase {

    public FightState handle(LegendaryCharacter legendaryCharacter, Encounter encounter) {

        Fight fight = new Fight(legendaryCharacter, encounter);

        FightState fightState = fight.makeTurn();

        if (fightState.fightResult().equals(FightResult.IN_PROGRESS)) {
            return fight.makeTurn();
        } else {
            return fightState;
        }
    }
}
