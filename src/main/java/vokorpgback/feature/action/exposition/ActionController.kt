package vokorpgback.feature.action.exposition

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vokorpgback.feature.action.application.PerformActionUseCase
import vokorpgback.feature.action.exposition.dto.PerformActionRequest
import java.util.*

@RestController
@RequestMapping("")
class ActionController(
        val performActionUseCase: PerformActionUseCase
) {

    //TODO
    // find equivalent of consumes and produces for java
    @PostMapping("/action")
    fun performAction(@RequestBody performActionRequest: PerformActionRequest): ResponseEntity<PerformActionResponse> {
        // action type -> miroring of knowledge ?
        // difficulty
        // character.ability concerned
        // character.bonuses (knowledge, item, power)
        print(performActionRequest);
        val newResponse = PerformActionResponse(true);
        return ResponseEntity.of(Optional.of(newResponse));
    }
}