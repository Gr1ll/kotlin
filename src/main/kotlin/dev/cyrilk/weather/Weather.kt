package dev.cyrilk.weather

import com.google.gson.Gson
import dev.cyrilk.types.WeatherApiData
import io.github.cdimascio.dotenv.dotenv
import java.net.URI
import java.text.SimpleDateFormat
import java.util.Calendar

class Weather {

    private fun getWeatherData(): WeatherApiData {
        val dotenv = dotenv()
        val weatherApiUrl: URI = URI.create(dotenv["WEATHER_API_URL"])
        return Gson().fromJson(weatherApiUrl.toURL().readText(), WeatherApiData::class.java)
    }

    fun getMsUntilSunrise(): Long {
        val weatherData = getWeatherData();
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
        val sunriseMs = simpleDateFormat.parse(weatherData.daily.sunrise[0]).toInstant().toEpochMilli()
        val nowMs = Calendar.getInstance().timeInMillis

        return (sunriseMs - nowMs)
    }

    fun getMsUntilSunset(): Long {
        val weatherData = getWeatherData();
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
        val sunsetMs = simpleDateFormat.parse(weatherData.daily.sunset[0]).toInstant().toEpochMilli()
        val nowMs = Calendar.getInstance().timeInMillis

        return (sunsetMs - nowMs)
    }
}