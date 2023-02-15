package com.oliveirarp.gigagains.exercise.domain.exercise

enum class ExerciseError {
    SERVICE_UNAVAILABLE,
    CLIENT_ERROR,
    SERVER_ERROR,
    UNKNOWN_ERROR
}

class ExerciseException(val error: ExerciseError): Exception(
    "An error occurred: $error"
)