package com.example.gameoflifeconway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameoflifeconway.ui.theme.GameOfLifeConwayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameOfLifeConwayTheme {
                Text("Game of Life Conway")
            }
        }
    }
}

@Composable
fun GameOfLifeView(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Background()
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            TitleView()

            BoardView()

            ControlsView()
        }
    }
}

@Composable
fun TitleView() {
    Text(
        "Game of Life",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = Color.White,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(
                    colorResource(R.color.gradient_color1),
                    colorResource(R.color.gradient_color2),
                    colorResource(R.color.gradient_color3)
                )
            )
        )
    )
}

@Composable
fun BoardView() {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.Blue, shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Board",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ControlsView() {
    Text(
        text = "Controls",
        color = Color.White
    )
}

@Composable
fun Background(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(R.color.background_colo))) { }
}

@Preview
@Composable
private fun GameOfLifeViewPreview() {
    GameOfLifeView()
}