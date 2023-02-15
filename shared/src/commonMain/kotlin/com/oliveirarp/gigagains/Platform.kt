package com.oliveirarp.gigagains

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform