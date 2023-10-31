package vokorpgback.feature.commons.domain.model.dice;

public class OfficialDiceFactory implements DiceFactory {
    @Override
    public Dice createDice(int numberOfFaces) {
        return new OfficialDice(numberOfFaces);
    }
}
