package com.example.nutrisport

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform