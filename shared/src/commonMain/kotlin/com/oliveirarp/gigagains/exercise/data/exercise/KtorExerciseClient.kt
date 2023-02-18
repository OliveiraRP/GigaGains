package com.oliveirarp.gigagains.exercise.data.exercise

import com.oliveirarp.gigagains.NetworkConstants
import com.oliveirarp.gigagains.core.domain.exercise.Exercise
import com.oliveirarp.gigagains.core.domain.muscle_group.MuscleGroup
import com.oliveirarp.gigagains.exercise.domain.exercise.ExerciseClient
import com.oliveirarp.gigagains.exercise.domain.exercise.ExerciseError
import com.oliveirarp.gigagains.exercise.domain.exercise.ExerciseException
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.utils.io.errors.*

class KtorExerciseClient(
    private val httpClient: HttpClient
): ExerciseClient {

    override suspend fun listByMuscleGroup(muscleGroup: MuscleGroup): List<Exercise> {
        val result = try {
            httpClient.get {
                url(NetworkConstants.BASE_URL + "/exercises/target/" + muscleGroup.muscleGroupValue)
                headers {
                    append("X-RapidAPI-Key", NetworkConstants.API_KEY)
                }
            }
        } catch (e: IOException) {
            throw ExerciseException(ExerciseError.SERVICE_UNAVAILABLE)
        }

        when (result.status.value) {
            in 200..299 -> Unit
            500 -> throw ExerciseException(ExerciseError.SERVER_ERROR)
            in 400..499 -> throw ExerciseException(ExerciseError.CLIENT_ERROR)
            else -> throw ExerciseException(ExerciseError.UNKNOWN_ERROR)
        }

        return try {
            result.body<List<ExerciseResponseDto>>().map {
                Exercise(
                    id = it.id.toInt(),
                    name = it.name,
                    muscleGroup = MuscleGroup.byValue(it.target),
                    gif = it.gifUrl
                )
            }
        } catch (e: Exception) {
            throw ExerciseException(ExerciseError.SERVER_ERROR)
        }
    }
}