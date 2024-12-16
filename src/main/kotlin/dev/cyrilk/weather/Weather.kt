package dev.cyrilk.weather

import com.google.gson.Gson
import dev.cyrilk.types.WeatherApiData
import java.net.URI
import java.text.SimpleDateFormat
import java.util.Calendar

class Weather {

    private fun getWeatherData(): WeatherApiData {
        val weatherApiUrl: URI = URI.create("https://api.open-meteo.com/v1/forecast?latitude=47.097226&longitude=8.27263&daily=temperature_2m_max,sunrise,sunset,wind_speed_10m_max&timezone=Europe%2FBerlin&forecast_days=1")
        return Gson().fromJson(weatherApiUrl.toURL().readText(), WeatherApiData::class.java)
    }

    fun getMsUntilSunrise(): Long {
        val weatherData = getWeatherData();
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
        println(weatherData)
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