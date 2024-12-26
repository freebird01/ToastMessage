package com.example.toastmessage

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toastmessage.ui.theme.ToastMessageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToastMessageTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ToastMessageExample(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ToastMessageExample(name: String, modifier: Modifier = Modifier) {
    val myContext = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                Toast.makeText(myContext, "This is a Toast", Toast.LENGTH_LONG).show()
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF7955BA)),
            modifier = Modifier.padding(10.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Show Toast Message")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToastMessageTheme {
        ToastMessageExample("Android")
    }
}