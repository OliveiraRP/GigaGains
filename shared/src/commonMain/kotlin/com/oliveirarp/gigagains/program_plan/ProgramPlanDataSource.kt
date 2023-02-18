package com.oliveirarp.gigagains.program_plan

import com.oliveirarp.gigagains.core.domain.util.CommonFlow

interface ProgramPlanDataSource {
    fun getProgramPlan(): CommonFlow<List<ProgramPlanItem>>
    suspend fun insertProgramPlanItem(item: ProgramPlanItem)
}