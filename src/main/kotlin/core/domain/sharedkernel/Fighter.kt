package core.domain.sharedkernel

interface Fighter {
    fun initiative(): Int
    fun attacks(): Int
    infix fun damagedBy(damages: Int): Fighter
    infix fun healedBy(heal: Int): Fighter
    fun dead(): Boolean
}