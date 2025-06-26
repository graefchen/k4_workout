package com.example.workout.data

import com.example.workout.R

class WorkoutList {
    var list = listOf<Workout>(
        Workout("Push ups", "", 30, R.drawable.man_doing_push_up_vector_illustration),
        Workout("Sit ups", "", 30, R.drawable.woman_doing_sit_up),
    )
}