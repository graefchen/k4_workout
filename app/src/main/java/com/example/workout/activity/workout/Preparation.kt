package com.example.workout.activity.workout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workout.data.Workout
import com.example.workout.data.WorkoutSingleton

// Workout Preparation
@Composable
fun WorkoutPreparation(currentWORKOUT: Workout, onWorkoutPreparationFinished: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Your Workout consists of:", textAlign = TextAlign.Center, fontSize = 20.sp)
        WorkoutSingleton.getList().toList().forEach { workout ->
            Text(text = workout.name)
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { onWorkoutPreparationFinished() }) {
                Text(text = "Cancel")
            }
            Button(
                onClick = { onWorkoutPreparationFinished() }) {
                Text(text = "Start")
            }
        }
    }
}
