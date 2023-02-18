package com.oliveirarp.gigagains.exercise.data.program_plan

import com.oliveirarp.gigagains.core.domain.util.CommonFlow
import com.oliveirarp.gigagains.core.domain.util.toCommonFlow
import com.oliveirarp.gigagains.database.GigaGainsDatabase
import com.oliveirarp.gigagains.program_plan.data.ProgramPlanDataSource
import com.oliveirarp.gigagains.program_plan.data.ProgramPlanItem
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlProgramPlanDataSource(
    db: GigaGainsDatabase
) : ProgramPlanDataSource {

    private val queries = db.programPlanQueries

    override fun getProgramPlan(): CommonFlow<List<ProgramPlanItem>> {
        return queries
            .getProgramPlan()
            .asFlow()
            .mapToList()
            .map { programPlan ->
                programPlan.map { it.toProgramPlanItem() }
            }
            .toCommonFlow()
    }

    override suspend fun insertProgramPlanItem(item: ProgramPlanItem) {
        queries.insertExercise(
            exerciseId = item.exerciseId,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}