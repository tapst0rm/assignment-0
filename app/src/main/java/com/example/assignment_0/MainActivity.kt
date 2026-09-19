package com.example.assignment_0

import android.R.attr.left
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment_0.ui.theme.Assignment0Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment0Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Nyi Nyi Zaw Zaw",
                        student_id = "1878468",
                        modifier = Modifier.padding(innerPadding)
                    )
                    Probability_Click()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String,student_id: String,modifier: Modifier = Modifier) {
    Column(modifier=modifier){
        Text(text = "Name: $name")
        Text(text = "Student ID: $student_id",)
    }
}

@Composable
fun Probability_Click(modifier:Modifier = Modifier){
    var count by remember{ mutableStateOf(0) }
    var result by remember{ mutableStateOf("")}
    Box(modifier = modifier.fillMaxSize(),contentAlignment = Alignment.Center){
        Text(if(result=="") "Should we go?" else result,modifier.padding(bottom = 190.dp), fontSize = 25.sp)
        Text("Clicks: $count", fontSize = 20.sp)
    }
    Row(modifier = modifier.fillMaxSize().padding(bottom = 100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){
        Button(
            onClick = {
                count++
                result = if (Random.nextDouble()<0.50) "Yes" else "No"
            }
        ) {
            Text("Ok")
        }
        Button(
            onClick = {
                count++
                result = if (Random.nextDouble()<0.25) "Yes" else "No"
            }
        ) {
            Text("Meh")
        }
        Button(
            onClick = {
                count++
                result = if (Random.nextDouble()<0.10) "Yes" else "No"
            }
        ) {
            Text("No")
        }
    }
}

