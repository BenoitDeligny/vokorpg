package vokorpgback.feature.commons.domain.model.dice;

public class LoadedDiceFactory implements DiceFactory {
    @Override
    public Dice createDice(int loadedValue) {
        return new LoadedDice(loadedValue);
    }
}
