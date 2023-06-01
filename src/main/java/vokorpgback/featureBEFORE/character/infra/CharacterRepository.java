package vokorpgback.featureBEFORE.character.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import vokorpgback.featureBEFORE.character.infra.entity.CharacterEntity;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {
}
