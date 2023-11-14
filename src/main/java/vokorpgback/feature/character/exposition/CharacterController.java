//package vokorpgback.feature.character.exposition;
//
//import jakarta.validation.Valid;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//import vokorpgback.feature.character.application.CreateCharacterUseCase;
//import vokorpgback.feature.character.exposition.dto.CharacterCreationRequest;
//import vokorpgback.feature.character.exposition.dto.CharacterCreationResponse;
//import vokorpgback.feature.character.exposition.dto.ItemResponseDto;
//import vokorpgback.feature.character.exposition.dto.KnowledgeResponseDto;
//import vokorpgback.feature.character.exposition.dto.PowerResponseDto;
//import vokorpgback.feature.character.exposition.dto.TraitResponseDto;
//import vokorpgback.feature.commons.domain.model.GameMode;
//import vokorpgback.feature.commons.domain.model.Power;
//import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
//import vokorpgback.feature.commons.domain.model.character.LegendaryCharacterFactory;
//import vokorpgback.feature.commons.domain.model.dice.OfficialDiceFactory;
//import vokorpgback.feature.commons.domain.model.gear.Item;
//import vokorpgback.feature.commons.domain.model.gear.Trait;
//import vokorpgback.feature.commons.domain.model.knowledge.Knowledge;
//
//@RestController
//public class CharacterController {
//
//    private final CreateCharacterUseCase createCharacterUseCase;
//
//    public CharacterController(CreateCharacterUseCase createCharacterUseCase) {
//        this.createCharacterUseCase = createCharacterUseCase;
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<CharacterCreationResponse> createCharacter(
//            @Valid @RequestBody CharacterCreationRequest request
//    ) {
//
//        LegendaryCharacter legendaryCharacter = createCharacterUseCase.handle(
//                LegendaryCharacterFactory.generateLegendaryCharacter(
//                        toGameModeDomain(request.getGameMode()),
//                        new OfficialDiceFactory(),
//                        request.getName()
//                )
//        );
//
//        return ResponseEntity.ofNullable(toResponse(legendaryCharacter));
//    }
//
//    private GameMode toGameModeDomain(String gameModeDto) {
//        return GameMode.valueOf(gameModeDto);
//    }
//
//    private CharacterCreationResponse toResponse(LegendaryCharacter legendaryCharacter) {
//        return new CharacterCreationResponse(
//                legendaryCharacter.name(),
//                legendaryCharacter.age(),
//                legendaryCharacter.strength(),
//                legendaryCharacter.agility(),
//                legendaryCharacter.perception(),
//                legendaryCharacter.maxTotalMight(),
//                legendaryCharacter.characterCombatDice(),
//                legendaryCharacter.gear().getGearItems().stream().map(this::toItemDto).toList(),
//                legendaryCharacter.powers().stream().map(this::toPowerDto).toList(),
//                legendaryCharacter.knowledge().stream().map(this::toKnowledgeDto).toList()
//        );
//    }
//
//    private ItemResponseDto toItemDto(Item item) {
//        return new ItemResponseDto(
//                item.getName(),
//                item.getType().name(),
//                toTraitDto(item.getTrait()),
//                item.getDescription()
//        );
//    }
//
//    private TraitResponseDto toTraitDto(Trait trait) {
//        return new TraitResponseDto(
//                trait.type().name(),
//                trait.modifier()
//        );
//    }
//
//    private PowerResponseDto toPowerDto(Power power) {
//        return new PowerResponseDto(
//                power.name()
//        );
//    }
//
//    private KnowledgeResponseDto toKnowledgeDto(Knowledge knowledge) {
//        return new KnowledgeResponseDto(
//                knowledge.getType().name(),
//                knowledge.getMasteryLevel()
//        );
//    }
//}
