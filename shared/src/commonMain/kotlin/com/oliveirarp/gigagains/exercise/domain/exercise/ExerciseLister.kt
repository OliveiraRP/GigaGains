package com.oliveirarp.gigagains.exercise.domain.exercise

import com.oliveirarp.gigagains.core.domain.exercise.Exercise
import com.oliveirarp.gigagains.core.domain.muscle_group.MuscleGroup
import com.oliveirarp.gigagains.core.domain.util.Resource

class ExerciseLister(
    private val client: ExerciseClient
) {

    suspend fun listByMuscleGroup(
        muscleGroup: MuscleGroup
    ): Resource<List<Exercise>> {
        return try {
            val exerciseList = client.listByMuscleGroup(
                muscleGroup
            )

            Resource.Success(exerciseList)
        } catch (e: ExerciseException) {
            e.printStackTrace()
            Resource.Error(e)
        }
    }
}