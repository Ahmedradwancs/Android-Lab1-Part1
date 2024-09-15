package com.example.lab1_part1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1_part1.ui.theme.Lab1Part1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Part1Theme {
                RandomInfoApp()
            }
        }
    }
}

@Composable
fun RandomInfoApp() {
    // List of sentences about you
    val sentences = listOf(
        "I love coding in Kotlin!",
        "I enjoy watching movies on weekends.",
        "My favorite food is pizza and pasta.",
        "I play Tennis and Football.",
        "I’m learning Android development.",
        "I love playing video games.",
        "My favorite movie is Interstellar.",
        "I enjoy photography as a hobby.",
        "I’m fluent in three languages.",
        "I love watching action movies."
    )

    // State to hold the current sentence
    var currentSentence by remember { mutableStateOf(sentences[0]) }

    // Composable layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display Image
        Image(
            painter = painterResource(id = R.drawable.img_me), // Add your image to the drawable folder
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        // Display the random sentence
        Text(
            text = currentSentence,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to randomize the sentence
        Button(onClick = {
            currentSentence = sentences.random()
        }) {
            Text(text = "Show Random Info")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab1Part1Theme {
        RandomInfoApp()
    }
}