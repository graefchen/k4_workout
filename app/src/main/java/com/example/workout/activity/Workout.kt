package com.example.workout.activity

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.workout.activity.workout.WorkoutActive
import com.example.workout.activity.workout.WorkoutFinished
import com.example.workout.activity.workout.WorkoutPause
import com.example.workout.activity.workout.WorkoutPreparation
import com.example.workout.data.WorkoutSingleton

// When in the workout we are either still in active workout
// or taking a pause
// We are constantly switching between those as long as we are
// in the current Workout
enum class WORKOUT {
    PREPARATION,
    ACTIVE,
    PAUSE,
    FINISHED
}

// Currently in the Workout Activity
@Composable
fun ActivityIn(onWorkoutFinished: () -> Unit) {
    var workout = WorkoutSingleton
    var currentWorkoutState by remember { mutableStateOf(WORKOUT.PREPARATION) }

    // Dummy Workout to not get null error
    var currentWorkout by remember { mutableStateOf(workout.getCurrentWorkout()) }

    when (currentWorkoutState) {
        WORKOUT.PREPARATION -> WorkoutPreparation(
            currentWorkout,
            onWorkoutPreparationFinished = {
                currentWorkoutState = WORKOUT.ACTIVE
            }
        )

        WORKOUT.ACTIVE -> WorkoutActive(currentWorkout, onFinished = {
            // increasing the number of the current workout ...
            workout.incCurrentWorkout()
            if (workout.isFinished()) {
                currentWorkoutState = WORKOUT.FINISHED
            } else {
                currentWorkoutState = WORKOUT.PAUSE
                currentWorkout = workout.getCurrentWorkout()
            }
        })

        WORKOUT.PAUSE -> WorkoutPause(currentWorkout, onPauseFinished = {
            currentWorkoutState = WORKOUT.ACTIVE
        })

        WORKOUT.FINISHED -> WorkoutFinished(onFinished = {
            workout.clearWorkouts()
            onWorkoutFinished()
        })
    }
}