package com.example.workout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workout.Activity.ActivityChoose
import com.example.workout.Activity.ActivityIn
import com.example.workout.ui.theme.WorkoutTheme

// Main Activity
// Either in an Workout of choosing an workout
enum class ACTIVITY {
    WORKOUT_IN,
    WORKOUT_CHOOSE
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorkoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Container(innerPadding)
                }
            }
        }
    }
}

@Composable
fun Container(innerPadding: PaddingValues) {
    // Note: For some reasons this Box can not hande the
    // "fillMaxSize" function of the Modifier...
    // that is why we need to add "fillMaxSize" on **all**
    // other Composable Objects further down in the Tree...
    Box(
        modifier = Modifier
            .padding(innerPadding)
            .padding(5.dp)
    ) {
        CurrentScreen()
    }
}

@Composable
fun CurrentScreen() {
    var currentActivity by remember { mutableStateOf(ACTIVITY.WORKOUT_CHOOSE) }

    // Note: it seems like that this is not working ... for whatever reason ...
    // not understando
    when (currentActivity) {
        ACTIVITY.WORKOUT_CHOOSE -> {
            ActivityChoose(onWorkoutChosen = { currentActivity = ACTIVITY.WORKOUT_IN })
        }

        ACTIVITY.WORKOUT_IN -> {
            ActivityIn(onWorkoutFinished = {
                currentActivity = ACTIVITY.WORKOUT_CHOOSE
            })
        }
    }
}