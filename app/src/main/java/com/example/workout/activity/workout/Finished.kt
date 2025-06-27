package com.example.workout.activity.workout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workout.data.WorkoutSingleton

// Workout Preparation
@Composable
fun WorkoutFinished(onFinished: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Finished the Workout!")
        WorkoutSingleton.getList().forEach { workout ->
            Text(text = workout.name)
        }
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    onFinished()
                }) {
                Text(text = "Return")
            }
        }
    }
}