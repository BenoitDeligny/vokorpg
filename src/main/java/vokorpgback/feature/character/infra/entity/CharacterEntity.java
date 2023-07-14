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

    @Embeddable
    public static class CharacterIdentity implements Serializable {

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "age", nullable = false)
        private int age;

        public CharacterIdentity() {
        }

        public CharacterIdentity(@NotNull String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
