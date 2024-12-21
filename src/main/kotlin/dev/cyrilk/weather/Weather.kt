package dev.cyrilk.weather

import com.google.gson.Gson
import dev.cyrilk.types.WeatherApiData
import io.github.cdimascio.dotenv.dotenv
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.text.SimpleDateFormat
import java.util.*

class Weather {

    private suspend fun getWeatherData(): WeatherApiData {
        val dotenv = dotenv()
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get(dotenv["WEATHER_API_URL"])
        client.close();
        return Gson().fromJson(response.bodyAsText(),WeatherApiData::class.java)
    }

    suspend fun getMsUntilSunrise(): Long {
        val weatherData = getWeatherData();
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
        val sunriseMs = simpleDateFormat.parse(weatherData.daily.sunrise[0]).toInstant().toEpochMilli()
        val nowMs = Calendar.getInstance().timeInMillis

        return (sunriseMs - nowMs)
    }

    suspend fun getMsUntilSunset(): Long {
        val weatherData = getWeatherData();
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
        val sunsetMs = simpleDateFormat.parse(weatherData.daily.sunset[0]).toInstant().toEpochMilli()
        val nowMs = Calendar.getInstance().timeInMillis

        return (sunsetMs - nowMs)
    }
}