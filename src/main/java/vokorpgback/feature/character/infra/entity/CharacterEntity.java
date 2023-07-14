package vokorpgback.feature.character.infra.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "legendary_character")
public class CharacterEntity {
    // TODO find a better primary key
    @EmbeddedId
    private final CharacterIdentity characterIdentity;

    @Column(name = "strength", nullable = false)
    private final int strength;

    @Column(name = "agility", nullable = false)
    private final int agility;

    @Column(name = "perception", nullable = false)
    private final int perception;

    @Column(name = "natural_might", nullable = false)
    private final int naturalMight;

    @Column(name = "total_might", nullable = false)
    private final int totalMight;

    @Column(name = "remaining_might", nullable = false)
    private final int remainingMight;

    // TODO add gear, backPack, powers, knowledge

    public CharacterEntity(CharacterIdentity characterIdentity, int strength, int agility, int perception, int naturalMight, int totalMight, int remainingMight) {
        this.characterIdentity = characterIdentity;
        this.strength = strength;
        this.agility = agility;
        this.perception = perception;
        this.naturalMight = naturalMight;
        this.totalMight = totalMight;
        this.remainingMight = remainingMight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterEntity that = (CharacterEntity) o;
        return strength == that.strength && agility == that.agility && perception == that.perception && naturalMight == that.naturalMight && totalMight == that.totalMight && remainingMight == that.remainingMight && Objects.equals(characterIdentity, that.characterIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterIdentity, strength, agility, perception, naturalMight, totalMight, remainingMight);
    }

    @Embeddable
    public static class CharacterIdentity implements Serializable {

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "age", nullable = false)
        private int age;

        public CharacterIdentity() {
        }

        public CharacterIdentity(@NotNull String name, @NotNull int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CharacterIdentity that = (CharacterIdentity) o;
            return Objects.equals(name, that.name) && Objects.equals(age, that.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
