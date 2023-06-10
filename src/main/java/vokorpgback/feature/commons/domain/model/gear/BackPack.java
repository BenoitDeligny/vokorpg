package vokorpgback.feature.commons.domain.model.gear;

import java.util.List;

public record BackPack(List<Consumable> consumables) {

    public void addToBackPack(Consumable consumable) {
        consumables.add(consumable);
    }

//    private void toRemoveFromBackPack(Consumable consumable) {
//        if (consumable.getQuantity() == 0) {
//            consumables.remove(consumable);
//        }
//    }
}
