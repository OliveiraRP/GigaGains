package com.oliveirarp.gigagains.exercise.domain.exercise

import com.oliveirarp.gigagains.core.domain.exercise.Exercise
import com.oliveirarp.gigagains.core.domain.muscle_group.MuscleGroup

interface ExerciseClient {
    suspend fun listByMuscleGroup(
        muscleGroup: MuscleGroup
    ): List<Exercise>
}