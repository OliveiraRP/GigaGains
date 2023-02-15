package com.oliveirarp.gigagains.exercise.domain.exercise

import com.oliveirarp.gigagains.core.domain.muscle_group.MuscleGroup
import com.oliveirarp.gigagains.exercise.data.exercise.ExerciseResponseDto

interface ExerciseClient {
    suspend fun listByMuscleGroup(
        muscleGroup: MuscleGroup
    ): List<ExerciseResponseDto>
}