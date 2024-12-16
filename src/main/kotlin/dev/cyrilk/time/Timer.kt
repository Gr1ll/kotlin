package dev.cyrilk.time

import dev.cyrilk.room.Shutters
import java.util.Calendar
import java.util.Timer
import java.util.TimerTask


fun startTimer() {
    executeTasks().run();
    Timer().schedule(executeTasks(), getTimeInMsUntilMidnight(), 86400000)
}

fun executeTasks() = object: TimerTask() {
    override fun run() {
        val shutters = Shutters()
        println("executing tasks")
        shutters.openOnSunrise();
        shutters.closeOnSunset();
    }
}

fun getTimeInMsUntilMidnight(): Long {
    val now = Calendar.getInstance()
    val midnight = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
        if (before(now)) {
            add(Calendar.DAY_OF_MONTH, 1)
        }
    }
    return midnight.timeInMillis - now.timeInMillis
}