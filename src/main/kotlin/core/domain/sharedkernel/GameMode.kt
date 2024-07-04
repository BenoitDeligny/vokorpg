package core.domain.sharedkernel

// TODO: naming -> difficulty ?
enum class GameMode(val abilityModifier: Int) {
    NORMAL(1),
    EASY(4);
}