package vokorpgback.feature.action.exposition.dto

class PerformActionRequest(
        val actionType: String,
        val actionDifficulty: Int,
        val character: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PerformActionRequest

        if (actionType != other.actionType) return false
        if (actionDifficulty != other.actionDifficulty) return false
        return character == other.character
    }

    override fun hashCode(): Int {
        var result = actionType.hashCode()
        result = 31 * result + actionDifficulty
        result = 31 * result + character.hashCode()
        return result
    }

    override fun toString(): String {
        return "PerformActionRequest(actionType='$actionType', actionDifficulty=$actionDifficulty, character='$character')"
    }

}