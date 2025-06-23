package com.example.workout.Activity

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.workout.Activity.Workout.WorkoutActive
import com.example.workout.Activity.Workout.WorkoutFinished
import com.example.workout.Activity.Workout.WorkoutPause
import com.example.workout.Activity.Workout.WorkoutPreparation
import com.example.workout.Classes.WorkoutSingleton

// When in the workout we are either still in active workout
// or taking a pause
// We are constantly switching between those as long as we are
// in the current Workout
enum class WORKOUT {
    PAUSE,
    ACTIVE,
    PREPARATION
}

// Currently in the Workout Activity
@Composable
fun ActivityIn(onWorkoutFinished: () -> Unit) {
    var workout = WorkoutSingleton
    var currentWorkoutState by remember { mutableStateOf(WORKOUT.PREPARATION) }

    var currentWorkout by remember { mutableStateOf(workout.getCurrentWorkout()) }

    // checking if we are still are in a Workout, else we return to another screen
    if (!workout.isLastWorkout()) {
        when (currentWorkoutState) {
            WORKOUT.PREPARATION -> WorkoutPreparation(currentWorkout)
            WORKOUT.ACTIVE -> WorkoutActive(currentWorkout)
            WORKOUT.PAUSE -> WorkoutPause(currentWorkout)
        }
    } else {
        // calling the callback function
        WorkoutFinished(onFinished = {-> onWorkoutFinished()})
    }
}