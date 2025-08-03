package com.gazocar.climaapp.model

data class Ciudad(
    val nombre: String,
    val fechaGuardado: Long = System.currentTimeMillis()
)
