package com.example.gameoflifeconway.data

enum class DesignType(val offsetDesign: List<Pair<Int, Int>>) {
    // Still life
    BLOCK(listOf(
        0 to -1, 1 to -1,
        0 to 0, 1 to 0
    )),
    BEEHIVE(listOf(
        -1 to -1, 0 to -1,
        -2 to 0, 1 to 0,
        -1 to 1, 0 to 1
    )),
    LOAF(listOf(
        -1 to -1, 0 to -1,
        -2 to 0, 1 to 0,
        -1 to 1, 1 to 1,
        0 to 2
    )),
    BOAT(listOf(
        -1 to -1, 0 to -1,
        -1 to 0, 1 to 0,
        0 to 1
    )),
    TUB(listOf(
        0 to -1,
        -1 to 0, 1 to 0,
        0 to 1
    )),

    // Oscillators
    BLINKER(listOf(
        0 to -1, 0 to 0, 0 to 1
    )),
    TOAD(listOf(
        1 to -2, -1 to -1, 2 to -1,
        -1 to 0, 2 to 0, 0 to 1
    )),
    BEACON(listOf(
        -2 to -2, -1 to -2, -2 to -1, -1 to -1,
        0 to 0, 1 to 0, 0 to 1, 1 to 1
    )),
    PULSAR(listOf(
        -4 to -6, -3 to -6, -2 to -6, 2 to -6, 3 to -6, 4 to -6,
        -6 to -4, -1 to -4, 1 to -4, 6 to -4,
        -6 to -3, -1 to -3, 1 to -3, 6 to -3,
        -6 to -2, -1 to -2, 1 to -2, 6 to -2,
        -4 to -1, -3 to -1, -2 to -1, 2 to -1, 3 to -1, 4 to -1,
        -4 to 1, -3 to 1, -2 to 1, 2 to 1, 3 to 1, 4 to 1,
        -6 to 2, -1 to 2, 1 to 2, 6 to 2,
        -6 to 3, -1 to 3, 1 to 3, 6 to 3,
        -6 to 4, -1 to 4, 1 to 4, 6 to 4,
        -4 to 6, -3 to 6, -2 to 6, 2 to 6, 3 to 6, 4 to 6
    )),
    PENTA_DECATHLON(listOf(
        -1 to -4, 0 to -4, 1 to -4,
        -1 to -3, 1 to -3,
        -1 to -2, 0 to -2, 1 to -2,
        -1 to -1, 0 to -1, 1 to -1,
        -1 to 0, 0 to 0, 1 to 0,
        -1 to 1, 0 to 1, 1 to 1,
        -1 to 2, 1 to 2,
        -1 to 3, 0 to 3, 1 to 3
    )),

    // Spaceships
    GLIDER(listOf(
        0 to -1, 1 to 0,
        -1 to 1, 0 to 1, 1 to 1
    )),
    LWSS(listOf(
        0 to -1, 1 to -1,
        -2 to 0, -1 to 0, 1 to 0, 2 to 0,
        -2 to 1, -1 to 1, 0 to 1, 1 to 1,
        -1 to 2, 0 to 2
    )),
    MWSS(listOf(
        -2 to -2, -1 to -2, 0 to -2, 1 to -2, 2 to -2,
        -3 to -1, 2 to -1, 2 to 0,
        -3 to 1, 1 to 1, -1 to 2
    )),
    HWSS(listOf(
        -3 to -2, -2 to -2, -1 to -2, 0 to -2, 1 to -2, 2 to -2,
        -4 to -1, 2 to -1, 2 to 0,
        -4 to 1, 1 to 1, -2 to 2, -1 to 2
    ));

    companion object {
        val stillLifeDesigns = listOf(BLOCK, BEEHIVE, LOAF, BOAT, TUB)
        val oscillatorsDesigns = listOf(BLINKER, TOAD, BEACON, PULSAR, PENTA_DECATHLON)
        val spaceShipsDesigns = listOf(GLIDER, LWSS, MWSS, HWSS)
    }
}