package com.oliveirarp.gigagains.exercise.data.local

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun create(): SqlDriver
}