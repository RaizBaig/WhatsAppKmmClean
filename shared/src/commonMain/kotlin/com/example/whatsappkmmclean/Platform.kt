package com.example.whatsappkmmclean

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform