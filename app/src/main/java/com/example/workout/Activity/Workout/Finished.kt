package com.example.workout.Activity.Workout

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// Workout Preparation
@Composable
fun WorkoutFinished(onFinished: () -> Unit) {
    Column {
        Text(text="Finished the Workout!")
        Button(onClick = { onFinished() }) {
            Text(text="Finish!")
        }
    }
}