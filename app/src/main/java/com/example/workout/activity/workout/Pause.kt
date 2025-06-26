package com.example.workout.activity.workout

import androidx.compose.runtime.Composable
import com.example.workout.components.SportPlayer
import com.example.workout.data.Workout
import com.example.workout.data.WorkoutSingleton

// Workout Pause
@Composable
fun WorkoutPause(currentWORKOUT: Workout, onPauseFinished: () -> Unit) {
    SportPlayer(
        currentWORKOUT.id,
        "Pause\n\nNext: ${currentWORKOUT.name}",
        currentWORKOUT.description,
        "Finished ${WorkoutSingleton.currentWorkout} of ${WorkoutSingleton.workouts.size}",
        5f,
        onPauseFinished
    )
}