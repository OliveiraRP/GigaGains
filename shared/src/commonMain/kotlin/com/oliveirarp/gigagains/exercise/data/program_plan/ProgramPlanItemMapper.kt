package com.oliveirarp.gigagains.exercise.data.program_plan

import com.oliveirarp.gigagains.program_plan.data.ProgramPlanItem
import database.ProgramPlan

fun ProgramPlan.toProgramPlanItem(): ProgramPlanItem {
    return ProgramPlanItem(
        exerciseId = exerciseId
    )
}