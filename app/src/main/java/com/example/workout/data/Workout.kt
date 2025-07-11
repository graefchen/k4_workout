package com.example.workout.data

// The Workout Data Class to store:
// - the Name of the Workout
// - the Description of the Workout
// - the Duration of the Workout
data class Workout(
    val name: String,
    val description: String,
    val duration: Int,
    val id: Int
)
