package com.oliveirarp.gigagains.core.domain.muscle_group

enum class MuscleGroup(
    val muscleGroupName: String,
    val muscleGroupValue: String
) {
    ABS("Abs", "abs"),
    BACK("Back", "upper back"),
    BICEPS("Biceps", "biceps"),
    CALVES("Calves", "calves"),
    CHEST("Chest", "pectorals"),
    DELTS("Delts", "delts"),
    GLUTES("Glutes", "glutes"),
    HAMSTRINGS("Hamstrings", "hamstrings"),
    LATS("Lats", "lats"),
    QUADS("Quads", "quads"),
    TRAPS("Traps", "traps"),
    TRICEPS("Triceps", "triceps");

    companion object {
        fun byValue(value: String): MuscleGroup {
            return values().find { it.muscleGroupValue == value }
                ?: throw IllegalArgumentException("Invalid muscle group value")
        }
    }
}
