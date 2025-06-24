package com.example.workout.Activity.Workout

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.workout.Classes.Workout

// Workout Preparation
@Composable
fun WorkoutPreparation(currentWORKOUT: Workout, onWorkoutPreparationFinished: () -> Unit) {
    Column {
        Text(text = "Start workout")
        Button(onClick = {onWorkoutPreparationFinished()}) {
            Text(text = "Preparation Finished!")
        }
    }
}