package com.example.workout.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.workout.data.WorkoutSingleton
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// The Player that looks like a normal Music player
// with Image, Name, Description, Duration
@Composable
fun SportPlayer(
    id: Int,
    name: String,
    description: String,
    duration: Float,
    onFinished: () -> Unit
) {
    var image = painterResource(id)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(painter = image, contentDescription = null)
            Text(
                text = name,
                textAlign = TextAlign.Center,
                fontSize = 7.em,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = description, textAlign = TextAlign.Center)
            DurationBar(duration = duration, onFinished)
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DurationBar(duration: Float, onFinished: () -> Unit) {
    var currentProgress by remember { mutableFloatStateOf(0f) }
    val scope = rememberCoroutineScope()

    // Using an coroutine to not block the UI-Render thread
    scope.launch {
        loadProgress(duration, updateProgress = { progress ->
            currentProgress = progress
        })
        // it seems like a problem occurs here ...
        // we MUST check for it here or some other problem occurs here
        if (!WorkoutSingleton.isFinished()) onFinished()
    }

    LinearProgressIndicator(progress = { currentProgress }, modifier = Modifier.fillMaxWidth())
}

suspend fun loadProgress(maxDuration: Float, updateProgress: (Float) -> Unit) {
    var duration = (maxDuration * 10).toInt()

    for (i in 1..duration) {
        updateProgress(i.toFloat() / duration)
        delay(100)
    }
}