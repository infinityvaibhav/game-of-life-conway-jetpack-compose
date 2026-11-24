package com.example.gameoflifeconway.data

import androidx.compose.runtime.FloatState
import kotlin.random.Random

class BoardModel(private val gridSize: Int) {
    var creatures: Array<IntArray> = Array(gridSize) { IntArray (gridSize) { Random.nextInt(0,2) } }

    fun randomBoard() {
        creatures = Array(gridSize) { IntArray (gridSize) { Random.nextInt(0,2) } }
    }

    fun clearBoard() {
        creatures = Array(gridSize) { IntArray (gridSize) }
    }

    fun countLiveNeighbours(row: Int, column: Int): Int {
        val directions = listOf(
            -1 to -1, 0 to -1, 1 to -1,
            -1 to 0,           1 to 0,
            -1 to 1, 0 to 1, 1 to 1,
        )

        return directions.sumOf { (dx, dy) ->
            val newRow = (row + dx + gridSize) % gridSize
            val newColumn = (column + dy + gridSize) % gridSize
            creatures[newRow][newColumn] // 1 if alive 0 and if not alive
        }
    }

    fun safelyAssignCreatureState(i: Int, j: Int, state: Int) {
        val newRow = (i + gridSize) % gridSize
        val newColumn = (j + gridSize) % gridSize
        creatures[newRow][newColumn] = state // 1 if alive 0 if not alive
    }

    fun nextGeneration(creatures: Array<IntArray>, gridSize: Int): Array<IntArray> {
        val newCreatures = creatures.map { it.copyOf() }.toTypedArray()

        for (row in 0..<gridSize) {
            for (column in 0..<gridSize) {
                val liveNeighbours = countLiveNeighbours(row, column)

                // Apply rules
                if (creatures[row][column] == 1) { // Cell is alive
                    // Die of loneliness or overcrowded
                    if (liveNeighbours !in 2..3) {
                        newCreatures[row][column] = 0 // Creature dies
                    }
                } else { // Cell is dead
                    if (liveNeighbours == 3) {
                        newCreatures[row][column] = 1 // Creature is born
                    }
                }
            }
        }


        return newCreatures
    }

    fun applyDesignPattern(
        row: Int,
        column: Int,
        designType: DesignType,
        swapXY:  Boolean
    ) {
        if (creatures[row][column] == 0) {
            for (offset in designType.offsetDesign) {
                val dx = if (swapXY) offset.first else offset.second
                val dy = if (swapXY) offset.second else offset.first

                safelyAssignCreatureState(
                    i = row + dx,
                    j = column + dy,
                    state = 1
                )
            }
        }
    }
}