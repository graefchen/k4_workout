package com.example.workout.Classes

import kotlin.math.floor

// Using a Singleton
// What is a Singleton?
// This here: https://en.wikipedia.org/wiki/Singleton_pattern
//
// A global Object like Singleton is very helpful for us as it makes
// "transferring" data in the App way more easy and as they are potentially
// all in one place, we also do not need to copy all the data.
object WorkoutSingleton {
    val workouts = mutableListOf<Workout>()
    // even mutable lists start at 0
    // they are not like Lua, Matlab or APL
    var currentWorkout = 0

    fun addWorkout(workout: Workout) {
        workouts.add(workout)
    }

    fun removeWorkoutAt(index: Int) {
        workouts.removeAt(index)
    }

    // Returning the Current Active Workout
    fun getCurrentWorkout(): Workout {
        return workouts[currentWorkout]
    }

    fun getList(): MutableList<Workout> {
        return workouts
    }

    // Increasing the Number of currentWorkout by 1
    fun incCurrentWorkout() {
        currentWorkout++
    }

    // Checking if we are at the last workout
    //
    // NOTE TO THYSELF:
    // Could this also be abstracted to an
    // simple Iteration and Iteration Interface?
    fun isLastWorkout(): Boolean {
        // Mainly here because when no Workout was set
        // so that the App does not do some funny stuff.
        if (workouts.isEmpty()) return true
        return (currentWorkout + 1 == workouts.size)
    }

    fun isEmpty(): Boolean {
        return workouts.isEmpty()
    }

    // get the percentage between
    fun percDone(): Int {
        if (workouts.isEmpty()) return 100
        return floor((currentWorkout / (workouts.size - 1) * 100).toDouble()).toInt()
    }

    // BE CAREFUL WHEN USING THUS FUNCTION
    // This function clears
    fun clearWorkouts() {
        workouts.clear()
    }
}