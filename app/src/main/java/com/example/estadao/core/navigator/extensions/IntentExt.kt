package com.example.estadao.core.navigator.extensions

import android.content.Context
import android.content.Intent

fun Intent.start(context: Context) {
    context.startActivity(this)
}