package com.example.workout.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.workout.data.Workout
import com.example.workout.data.WorkoutList
import com.example.workout.data.WorkoutSingleton

// Currently Choosing the Activity
@Composable
fun ActivityChoose(onWorkoutChosen: () -> Unit) {
    // because remember has some weird interaction with a mutable list
    // we needed to have the following two lines and casting the mutable list
    // into a list ...
    var list = WorkoutSingleton.getList().toList()
    var workoutList by remember { mutableStateOf(list) }

    var somethingSelected by remember { mutableStateOf(false) }

    // all the available Workouts
    var availableWorkouts = WorkoutList().list

    // making that ****ing thing scrollable
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
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
            var index = 0
            workoutList.forEach { workout ->
                AddedWorkout(workout, index, onRemove = { i ->
                    WorkoutSingleton.removeWorkoutAt(i)
                    workoutList = WorkoutSingleton.getList().toList()
                    if (WorkoutSingleton.isEmpty()) somethingSelected = false
                })
                index = index + 1
            }
        }
        HorizontalDivider(color = Color.Blue, thickness = 1.dp)
        Column {
            availableWorkouts.forEach { workout ->
                AddWorkout(workout, onAdded = {
                    WorkoutSingleton.addWorkout(workout)
                    workoutList = WorkoutSingleton.getList().toList()
                    if (!somethingSelected) somethingSelected = true
                })
            }
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Button(
                onClick = {
                    if (!WorkoutSingleton.isEmpty()) onWorkoutChosen()
                }) {
                Text(text = "Start Workout")
            }
        }
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
        IconButton(onClick = {
            onAdded()
        }) { Icon(Icons.Outlined.Add, "Small floating action button.") }
    }
}