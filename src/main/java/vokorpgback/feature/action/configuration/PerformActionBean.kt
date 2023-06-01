package vokorpgback.feature.action.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import vokorpgback.feature.action.application.PerformActionUseCase

@Configuration
open class PerformActionBean {
    @Bean
    open fun performActionUseCase(): PerformActionUseCase {
        return PerformActionUseCase()
    }
}
