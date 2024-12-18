package dev.cyrilk.types

data class Shutter(
    val state: String,
    val power: Double,
    val current_pos: Int
)