package vokorpgback.feature.character.infra.entity;

public class CharacterEntity {
    private String name;
    private int age;
    private int strength;
    private int agility;
    private int perception;
    // TODO
    // add power, knowledge, relic, gear, ...

    public CharacterEntity(String name, int age, int strength, int agility, int perception) {
        this.name = name;
        this.age = age;
        this.strength = strength;
        this.agility = agility;
        this.perception = perception;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getPerception() {
        return perception;
    }

    // TODO
    // remove setters if not needed
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

}
