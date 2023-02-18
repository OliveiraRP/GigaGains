package com.oliveirarp.gigagains.exercise.data.local

import com.oliveirarp.gigagains.database.GigaGainsDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(GigaGainsDatabase.Schema, "gigagains.db")
    }
}