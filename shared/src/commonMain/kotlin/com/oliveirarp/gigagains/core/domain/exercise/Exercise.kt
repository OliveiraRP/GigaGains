package com.oliveirarp.gigagains.core.domain.exercise

import com.oliveirarp.gigagains.core.domain.muscle_group.MuscleGroup

class Exercise (
    val id: Int,
    val name: String,
    val muscleGroup: MuscleGroup,
    val gif: String,
)