package dev.cyrilk.room;

import com.google.gson.Gson
import dev.cyrilk.types.Light
import io.github.cdimascio.dotenv.dotenv
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class Lights {
    private val dotenv = dotenv()

    suspend fun getLightStatus(): Boolean {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get(dotenv["LIGHTS_API_GET_URL"])
        client.close()
        val lightStatus = Gson().fromJson(response.bodyAsText(), Light::class.java).output
        return lightStatus
    }

    suspend fun setLightStatus(status: Boolean) {
        val client = HttpClient(CIO)
        client.get(dotenv["LIGHTS_API_SET_URL"] + status)
        client.close()
    }
}
