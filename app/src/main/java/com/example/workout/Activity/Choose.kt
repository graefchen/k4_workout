package com.example.workout.Activity

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.workout.Classes.Workout
import com.example.workout.Classes.WorkoutList
import com.example.workout.Classes.WorkoutSingleton

// Currently Choosing the Activity
@Composable
fun ActivityChoose(onWorkoutChosen: () -> Unit) {
    // because remember has some weird interaction with a mutable list
    // we needed to have the following two lines and casting the mutable list
    // into a list ...
    var list = WorkoutSingleton.getList().toList()
    var workoutList by remember { mutableStateOf(list)}

    var somethingSelected by remember { mutableStateOf(false) }

    // all the available Workouts
    var availableWorkouts = WorkoutList().list

    Box(modifier = Modifier.fillMaxWidth()) {
        Column {
            Text(
                modifier = Modifier.fillMaxWidth(),
                fontSize = 5.em,
                textAlign = TextAlign.Center,
                text = "Current Workouts:"
            )
            HorizontalDivider(color = Color.Blue, thickness = 1.dp)
            if (!somethingSelected) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "No Workout selected"
                )
            } else {
                LazyColumn {
                    var index = 0
                    items(workoutList) { workout ->
                        AddedWorkout(workout, index, onRemove = { i ->
                            WorkoutSingleton.removeWorkoutAt(i)
                            workoutList = WorkoutSingleton.getList().toList()
                            if (WorkoutSingleton.isEmpty()) somethingSelected = false
                        })
                        index = index + 1
                    }
                }
            }
            HorizontalDivider(color = Color.Blue, thickness = 1.dp)
            LazyColumn {
                items(availableWorkouts) { workout ->
                    AddWorkout(workout, onAdded = {
                        workoutList = WorkoutSingleton.getList().toList()
                        if (!somethingSelected) somethingSelected = true
                    })
                }
            }
            Button(onClick = {
                if (!WorkoutSingleton.isEmpty()) onWorkoutChosen()
            }) {
                Text(text = "Start Workout")
            }
        }
        // This is a normal Floating Action Bar
        // Note: a Bottom App Bar might be better for a non MVP App
//        FloatingActionButton(
//            modifier = Modifier.align(Alignment.BottomCenter),
//            onClick = {
//                Log.i("App", "Clicked the Floating Action Button")
//                onWorkoutAdd()
//            },
//            shape = CircleShape
//        ) {
//            Icon(Icons.Filled.Add, "Floating action button.")
//        }
    }
}

@Composable
fun AddedWorkout(workout: Workout, index: Int, onRemove: (Int) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = workout.name)
        // Icon Button looks SOOOOOOO good (much better than other options)
        IconButton(onClick = {
            onRemove(index)
        }) { Icon(Icons.Outlined.Clear, "Small floating action button.") }
    }
}

@Composable
fun AddWorkout(workout: Workout, onAdded: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = workout.name)
        // Icon Button looks SOOOOOOO good (much better than other options)
        IconButton(onClick = {
            WorkoutSingleton.addWorkout(workout)
            Log.i("WorkoutApp", "Added workout: $workout")
            onAdded()
        }) { Icon(Icons.Outlined.Add, "Small floating action button.") }
    }
}