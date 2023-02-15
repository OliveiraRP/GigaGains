package com.oliveirarp.gigagains.exercise.data.exercise

@kotlinx.serialization.Serializable
data class ExerciseResponseDto(
    val bodyPart: String,
    val equipment: String,
    val gifUrl: String,
    val id: String,
    val name: String,
    val target: String,
)
