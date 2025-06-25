package com.example.workout.activity.workout

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.workout.data.Workout

// Workout Pause
@Composable
fun WorkoutPause(currentWORKOUT: Workout, onPauseFinished: () -> Unit) {
    Text(text = "IN A PAUSE")
    onPauseFinished()
}