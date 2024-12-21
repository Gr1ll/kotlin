package dev.cyrilk.room

import com.google.gson.Gson
import dev.cyrilk.types.Shutter
import dev.cyrilk.types.WeatherApiData
import dev.cyrilk.weather.Weather
import io.github.cdimascio.dotenv.dotenv
import io.ktor.client.*
import java.util.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

class Shutters(val weatherData: WeatherApiData? = null) {
    private val dotenv = dotenv()

    suspend fun setShutter(percentage: Int) {
        val client = HttpClient(CIO)
        client.get(dotenv["ROLLER_API_URL"] + "?go=to_pos&roller_pos=" + percentage.toString())
        client.close();
    }

    suspend fun getShutterPercentage(): Int {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get(dotenv["ROLLER_API_URL"])
        client.close();
        val shutterPosition = Gson().fromJson(response.bodyAsText(), Shutter::class.java).current_pos
        return shutterPosition
    }

    fun openOnSunrise() {
        val msUntilSunrise: Long
        runBlocking {
            msUntilSunrise = Weather().getMsUntilSunrise()
        }
        if (checkEmergencies()) return;
        if (msUntilSunrise < 0) {
            runBlocking {
                setShutter(100)
            }
            return;
        };
        Timer().schedule(object : TimerTask() {
            override fun run() {
                runBlocking {
                    setShutter(100)
                }
            }
        }, msUntilSunrise)
    }

    fun closeOnSunset() {
        val msUntilSunset: Long;
        runBlocking {
            msUntilSunset = Weather().getMsUntilSunset()
        }
        if (checkEmergencies()) return;
        if (msUntilSunset < 0) {
            runBlocking {
                setShutter(0)
            }
            return
        };
        Timer().schedule(object : TimerTask() {
            override fun run() {
                runBlocking {
                    setShutter(0)
                }
            }
        }, msUntilSunset)
    }

    private fun checkEmergencies(): Boolean {
        if (weatherData == null) return false

        if (weatherData.daily.wind_speed_10m_max[0] > 50) {
            windEmergency();
            return true
        } else if (weatherData.daily.temperature_2m_max[0] > 30) {
            hotWeatherEmergency();
            return true
        }

        return false;
    }

    private fun hotWeatherEmergency() {
        println("Hot day!")
        runBlocking {
            setShutter(0)
        }
    }

    private fun windEmergency() {
        println("Windy day!")
        runBlocking {
            setShutter(100);
        }
    }
}