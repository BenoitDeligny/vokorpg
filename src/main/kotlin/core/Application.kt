package core

import core.domain.fight.Fight
import core.domain.hero.Hero
import core.domain.monster.Monster
import core.plugins.*
import io.ktor.server.application.*

suspend fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureRouting()
}
