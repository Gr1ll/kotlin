package dev.cyrilk.room

import dev.cyrilk.types.WeatherApiData
import dev.cyrilk.weather.Weather
import java.util.*

class Shutters(val weatherData: WeatherApiData? = null) {

    fun setShutter(percentage: Int){
        println("${percentage}%")
    }

    fun getShutterPercentage():Int{
        return 0
    }

    fun openOnSunrise(){
        val msUntilSunrise: Long = Weather().getMsUntilSunrise()
        if (checkEmergencies()) return;
        if (msUntilSunrise < 0) return;
        Timer().schedule(object : TimerTask() {
            override fun run() {
                setShutter(100)
            }
        }, msUntilSunrise)
    }

    fun closeOnSunset(){
        val msUntilSunset: Long = Weather().getMsUntilSunset()
        if (checkEmergencies()) return;
        if (msUntilSunset < 0) return;
        Timer().schedule(object : TimerTask() {
            override fun run() {
                setShutter(0)
            }
        }, msUntilSunset)
    }

    private fun checkEmergencies(): Boolean {
        if (weatherData == null) return false

        if (weatherData.daily.wind_speed_10m_max[0] > 50){
            windEmergency();
            return true
        } else if (weatherData.daily.temperature_2m_max[0] > 30){
            hotWeatherEmergency();
            return true
        }

        return false;
    }

    private fun hotWeatherEmergency(){
        println("Hot day!")
        setShutter(0)
    }

    private fun windEmergency(){
        println("Windy day!")
        setShutter(100);
    }

}