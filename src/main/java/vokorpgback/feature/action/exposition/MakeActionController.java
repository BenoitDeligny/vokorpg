//package vokorpgback.feature.action.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//import vokorpgback.feature.action.application.MakeActionUseCase;
//import vokorpgback.feature.action.controller.dto.MakeActionRequest;
//import vokorpgback.feature.action.controller.dto.MakeActionResponse;
//import vokorpgback.feature.action.domain.CharacterActionScore;
//import vokorpgback.feature.commons.domain.model.dice.OfficialDiceFactory;
//import vokorpgback.feature.commons.domain.model.knowledge.Knowledge;
//
//import java.util.Optional;
//
//@RestController
//public class MakeActionController {
//
//    private final MakeActionUseCase useCase;
//    private final OfficialDiceFactory diceFactory;
//
//    public MakeActionController(MakeActionUseCase useCase, OfficialDiceFactory diceFactory) {
//        this.useCase = useCase;
//        this.diceFactory = diceFactory;
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<MakeActionResponse> makeAction(@RequestBody MakeActionRequest request) {
//        int difficultyThreshold = request.difficultyThreshold();
//        CharacterActionScore characterActionScore = toDomain(request);
//
//        MakeActionResponse makeActionResponse = new MakeActionResponse(useCase.handle(difficultyThreshold, characterActionScore));
//
//        return ResponseEntity.of(Optional.of(makeActionResponse));
//    }
//
//    private CharacterActionScore toDomain(MakeActionRequest request) {
//        return new CharacterActionScore(
//                diceFactory.createDice(6).roll(),
//                diceFactory.createDice(6).roll(),
//                abilityScoreToUse(request),
//                knowledgeScoreToUse(request)
//        );
//    }
//
//    private int abilityScoreToUse(MakeActionRequest request) {
//        return switch (request.abilityToUse()) {
//            case STRENGTH -> request.legendaryCharacter().strength();
//            case AGILITY -> request.legendaryCharacter().agility();
//            case PERCEPTION -> request.legendaryCharacter().perception();
//        };
//    }
//
//    private int knowledgeScoreToUse(MakeActionRequest request) {
//        return request.legendaryCharacter()
//                .knowledge()
//                .stream()
//                .filter(knowledge -> knowledge.getType().name().equals(request.knowledgeToUse().name()))
//                .mapToInt(Knowledge::getMasteryLevel).sum();
//    }
//}
