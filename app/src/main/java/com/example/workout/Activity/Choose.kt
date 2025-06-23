package com.example.workout.Activity

import androidx.compose.runtime.Composable
// Currently Choosing the Activity
@Composable
fun ActivityChoose(onWorkoutChosen: () -> Unit) {
    onWorkoutChosen()
}