package vokorpgback.feature.character.exposition.dto;

public class CharacterCreationResponse {
    private final String name;
    private final int age;
    private final AbilitiesDto abilities;
    private final int totalPower;
    private final GearDto gear;

    public CharacterCreationResponse(String name, int age, AbilitiesDto abilities, int totalPower, GearDto gear) {
        this.name = name;
        this.age = age;
        this.abilities = abilities;
        this.totalPower = totalPower;
        this.gear = gear;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public AbilitiesDto getAbilities() {
        return abilities;
    }

    public int getTotalPower() {
        return totalPower;
    }

    public GearDto getGear() {
        return gear;
    }
}
