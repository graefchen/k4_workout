package com.example.workout.Activity.Workout

import androidx.compose.runtime.Composable

// Workout Preparation
@Composable
fun WorkoutFinished(onFinished: () -> Unit) {
    onFinished()
}