package com.ac10.runtracker.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "running_table")
data class Run(
    var img: Bitmap? = null,
    var timeStamp: Long = 0L,
    var avgSpeedInKMH: Float = 0f,
    var distanceInMeters: Int,
    var timeInMillis: Long,
    val caloriesBurned: Int,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
