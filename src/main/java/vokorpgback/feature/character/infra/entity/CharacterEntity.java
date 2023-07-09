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
    private CharacterIdentity characterIdentity;

    public CharacterIdentity getCharacterIdentity() {
        return characterIdentity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterEntity that)) return false;
        return Objects.equals(characterIdentity, that.characterIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterIdentity);
    }

    @Embeddable
    public static class CharacterIdentity implements Serializable {

        @NotNull
        @Column(name = "name", nullable = false)
        private String name;

        @NotNull
        @Column(name = "age", nullable = false)
        private String age;

        public CharacterIdentity() {
        }

        public CharacterIdentity(@NotNull String name, @NotNull String age) {
            this.name = name;
            this.age = age;
        }
    }
}
