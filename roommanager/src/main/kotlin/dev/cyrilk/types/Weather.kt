package dev.cyrilk.types

data class WeatherApiData(
    val latitude: Double,
    val longitude: Double,
    val generationtime_ms: Double,
    val utc_offset_seconds: Int,
    val timezone: String,
    val timezone_abbreviation: String,
    val elevation: Double,
    val daily_units: DailyUnits,
    val daily: Daily
)

data class DailyUnits(
    val time: String,
    val temperature_2m_max: String,
    val sunrise: String,
    val sunset: String,
    val wind_speed_10m_max: String
)

data class Daily(
    val time: List<String>,
    val temperature_2m_max: List<Double>,
    val sunrise: List<String>,
    val sunset: List<String>,
    val wind_speed_10m_max: List<Double>
)
