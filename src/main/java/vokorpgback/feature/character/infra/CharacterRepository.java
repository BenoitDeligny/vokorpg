package vokorpgback.feature.character.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import vokorpgback.feature.character.infra.entity.CharacterEntity;
import vokorpgback.feature.character.infra.entity.CharacterEntity.CharacterIdentity;

public interface CharacterRepository extends JpaRepository<CharacterEntity, CharacterIdentity> {
}
