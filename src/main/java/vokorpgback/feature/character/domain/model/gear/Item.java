package vokorpgback.feature.character.domain.model.gear;

import java.util.List;

public abstract class Item {
  protected final String name;
  protected final ItemCategory itemCategory;
  protected final List<Trait> traits;
  protected final String description;

  protected Item(String name, ItemCategory itemCategory, List<Trait> traits, String description) {
    this.name = name;
    this.itemCategory = itemCategory;
    this.traits = traits;
    this.description = description;
  }

  abstract boolean isHelmet();

  abstract boolean isMask();

  abstract boolean isNecklace();

  abstract boolean isCloak();

  abstract boolean isCostume();

  abstract boolean isArmor();

  abstract boolean isShield();

  abstract boolean isWeapon();

  abstract boolean isWristband();

  abstract boolean isGloves();

  abstract boolean isRing();

  abstract boolean isBelt();

  abstract boolean isBoots();

  public String getName() {
    return name;
  }

  public ItemCategory getCategory() {
    return itemCategory;
  }

  public List<Trait> getTraits() {
    return traits;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((itemCategory == null) ? 0 : itemCategory.hashCode());
    result = prime * result + ((traits == null) ? 0 : traits.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Item other = (Item) obj;
    if (name == null) {
      if (other.name != null) return false;
    } else if (!name.equals(other.name)) return false;
    if (itemCategory != other.itemCategory) return false;
    if (traits == null) {
      if (other.traits != null) return false;
    } else if (!traits.equals(other.traits)) return false;
    if (description == null) {
      if (other.description != null) return false;
    } else if (!description.equals(other.description)) return false;
    return true;
  }
}
