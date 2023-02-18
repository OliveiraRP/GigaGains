package com.oliveirarp.gigagains.exercise.data.local

import android.content.Context
import com.oliveirarp.gigagains.database.GigaGainsDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(GigaGainsDatabase.Schema, context, "gigagains.db")
    }
}