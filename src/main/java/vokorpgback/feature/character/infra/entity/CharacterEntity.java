package vokorpgback.feature.character.infra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "legendary_character")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int age;
    private int strength;
    private int agility;
    private int perception;
    private int totalPower;
    // TODO
    // add power, knowledge, relic, gear, ...

    public CharacterEntity() {
    }

    public CharacterEntity(String name, int age, int strength, int agility, int perception, int totalPower) {
        this.name = name;
        this.age = age;
        this.strength = strength;
        this.agility = agility;
        this.perception = perception;
        this.totalPower = totalPower;
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

    public int getTotalPower() {
        return totalPower;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        result = prime * result + strength;
        result = prime * result + agility;
        result = prime * result + perception;
        result = prime * result + totalPower;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CharacterEntity other = (CharacterEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        if (strength != other.strength)
            return false;
        if (agility != other.agility)
            return false;
        if (perception != other.perception)
            return false;
        if (totalPower != other.totalPower)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CharacterEntity [id=" + id + ", name=" + name + ", age=" + age + ", strength=" + strength + ", agility="
                + agility + ", perception=" + perception + ", totalPower=" + totalPower + "]";
    }

}
