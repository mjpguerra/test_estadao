package com.example.estadao.core.extensions

fun String.toCardDateStringFormat(): String {
    return "${substring(0, 4)}-${substring(4, 6)}-${substring(6)}"
}