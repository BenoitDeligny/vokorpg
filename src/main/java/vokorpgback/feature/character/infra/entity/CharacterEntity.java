package vokorpgback.feature.character.infra.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "legendary_character")
public class CharacterEntity {
    @EmbeddedId
    private CharacterIdentity characterIdentity;

    @Column(name = "strength", nullable = false)
    private int strength;

    @Column(name = "agility", nullable = false)
    private int agility;

    @Column(name = "perception", nullable = false)
    private int perception;

    @Column(name = "natural_might", nullable = false)
    private int naturalMight;

    @Column(name = "total_might", nullable = false)
    private int totalMight;

    @Column(name = "remaining_might", nullable = false)
    private int remainingMight;

    // TODO add gear, backPack, powers, knowledge


    public CharacterEntity() {
    }

    public CharacterEntity(CharacterIdentity characterIdentity, int strength, int agility, int perception, int naturalMight, int totalMight, int remainingMight) {
        this.characterIdentity = characterIdentity;
        this.strength = strength;
        this.agility = agility;
        this.perception = perception;
        this.naturalMight = naturalMight;
        this.totalMight = totalMight;
        this.remainingMight = remainingMight;
    }

    @Embeddable
    public static class CharacterIdentity implements Serializable {

        @Column(name = "uuid", nullable = false)
        private UUID uuid;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "age", nullable = false)
        private int age;

        public CharacterIdentity() {
        }

        public CharacterIdentity(UUID uuid, String name, int age) {
            this.uuid = uuid;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "CharacterIdentity{" +
                    "uuid=" + uuid +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CharacterIdentity that = (CharacterIdentity) o;
            return age == that.age && Objects.equals(uuid, that.uuid) && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(uuid, name, age);
        }
    }

    @Override
    public String toString() {
        return "CharacterEntity{" +
                "characterIdentity=" + characterIdentity +
                ", strength=" + strength +
                ", agility=" + agility +
                ", perception=" + perception +
                ", naturalMight=" + naturalMight +
                ", totalMight=" + totalMight +
                ", remainingMight=" + remainingMight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterEntity character = (CharacterEntity) o;
        return strength == character.strength && agility == character.agility && perception == character.perception && naturalMight == character.naturalMight && totalMight == character.totalMight && remainingMight == character.remainingMight && Objects.equals(characterIdentity, character.characterIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterIdentity, strength, agility, perception, naturalMight, totalMight, remainingMight);
    }
}
