package vokorpgback.feature.action.exposition

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import vokorpgback.feature.action.application.PerformActionUseCase

@WebMvcTest(ActionController::class)
class ActionControllerTest(@Autowired mockMvc: MockMvc) {

    @MockBean
    lateinit var performActionUseCase: PerformActionUseCase
}