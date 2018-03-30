package com.kalm004.gameoflife

class WorldPosition(var isAlive : Boolean) {
    private var aliveNeighbours : Int = 0

    fun addAliveNeighbour() {
        aliveNeighbours++
    }

    fun stepForward() {
        isAlive = when {
            aliveNeighbours < 2 -> false
            aliveNeighbours > 3 -> false
            else -> true
        }
        aliveNeighbours = 0
    }
}