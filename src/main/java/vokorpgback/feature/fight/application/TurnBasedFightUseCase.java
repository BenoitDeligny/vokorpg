package vokorpgback.feature.fight.application;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.fight.domain.model.Fight;
import vokorpgback.feature.fight.domain.model.FightState;
import vokorpgback.feature.fight.domain.model.FightResult;
import vokorpgback.feature.fight.domain.model.Encounter;

public class TurnBasedFightUseCase {

    public FightState handle(LegendaryCharacter legendaryCharacter, Encounter encounter, boolean attemptToFlee) {
        Fight fight = new Fight(legendaryCharacter, encounter, attemptToFlee);

        return fight.makeTurn();
    }
}
