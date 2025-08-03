package com.gazocar.climaapp.repository

import com.gazocar.climaapp.api.ClimaApiService
import com.gazocar.climaapp.api.RetrofitClient
import com.gazocar.climaapp.model.ClimaResponse
import com.gazocar.climaapp.model.PronosticoResponse

class ClimaRepository {
    private val api = RetrofitClient.instance.create(ClimaApiService::class.java)

    // PASO IMPORTANTE:
    // 1. Ve a https://openweathermap.org/api
    // 2. Crea una cuenta gratuita
    // 3. Obtén tu API key
    // 4. Reemplaza "TU_API_KEY_AQUI" con tu API key real
    private val apiKey = "c517284c93acca3669a1cb9471b8a06c"

    suspend fun obtenerClima(ciudad: String): ClimaResponse {
        return try {
            if (apiKey == "c517284c93acca3669a1cb9471b8a06c") {
                throw Exception("Por favor configura tu API key de OpenWeatherMap")
            }
            api.obtenerClimaActual(ciudad, apiKey)
        } catch (e: Exception) {
            throw Exception("Error al obtener el clima: ${e.message}")
        }
    }

    suspend fun obtenerPronostico(ciudad: String): PronosticoResponse {
        return try {
            if (apiKey == "c517284c93acca3669a1cb9471b8a06c") {
                throw Exception("Por favor configura tu API key de OpenWeatherMap")
            }
            api.obtenerPronostico(ciudad, apiKey)
        } catch (e: Exception) {
            throw Exception("Error al obtener el pronóstico: ${e.message}")
        }
    }
}