package com.example.workout.activity.workout

import androidx.compose.runtime.Composable
import com.example.workout.data.Workout
import com.example.workout.components.SportPlayer
import com.example.workout.data.WorkoutSingleton

// Workout Active
@Composable
fun WorkoutActive(currentWorkout: Workout, onFinished: () -> Unit) {
    SportPlayer(
        currentWorkout.id,
        currentWorkout.name,
        currentWorkout.description,
        "Finished ${WorkoutSingleton.currentWorkout} of ${WorkoutSingleton.workouts.size}",
        currentWorkout.duration.toFloat(),
        onFinished = onFinished
    )
}