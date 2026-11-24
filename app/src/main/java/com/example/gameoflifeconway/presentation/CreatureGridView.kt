package com.example.gameoflifeconway.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.OffsetEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CreatureGridView(
    creatures: Array<IntArray>,
    gridSize: Int,
    color: Color
) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val cellSize = size.width / gridSize
        for (row in 0..<gridSize) {
            for (column in 0..<gridSize) {
                // Is there a creature
                if (creatures[row][column] == 1) {
                    drawRect(
                        color = color,
                        topLeft = Offset(column * cellSize, row * cellSize),
                        size = Size(cellSize, cellSize)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CreateGridPreview() {
    val size = 50
    val creatures = remember {
        Array(size) {
            IntArray(size) {
                (0..1).random()
            }
        }
    }

    Box(modifier = Modifier
        .padding(16.dp)
        .background(Color.White)
    ) {
        CreatureGridView(
            creatures = creatures,
            gridSize = size,
            color = Color.Red
        )
    }
}