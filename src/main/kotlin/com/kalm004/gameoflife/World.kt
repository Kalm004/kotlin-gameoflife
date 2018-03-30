package com.kalm004.gameoflife

class World(private val width : Int, private val height : Int) {
    private val worldPositions = List(height, { List(width, { WorldPosition(false) })})

    fun stepForward() {
        //Calculate nextState for all positions
        worldPositions.forEachIndexed { x, list ->
            list.forEachIndexed { y, position -> if (position.isAlive) addCellToNeighbours(x, y) } }

        worldPositions.forEach { it.forEach { it.stepForward() } }
    }

    private fun addCellToNeighbours(cellPosX: Int, cellPosY: Int) {
        for (neighbourPosX in cellPosX - 1..cellPosX + 1) {
            for (neighbourPosY in cellPosY - 1..cellPosY + 1) {
                //Checking is the neighbour position is inside the table and is not the current cell
                if (positionInsideLimits(neighbourPosX, neighbourPosY)
                        && (neighbourPosX != cellPosX || neighbourPosY != cellPosY)) {
                    worldPositions[neighbourPosX][neighbourPosY].addAliveNeighbour()
                }
            }
        }
    }

    private fun positionInsideLimits(x: Int, y: Int) = x in 0..(height - 1) && y in 0..(width - 1)

    fun isDead() = worldPositions.all { it.all { !it.isAlive }}

    fun spawnCell(x : Int, y : Int) {
        worldPositions[x][y].isAlive = true
    }

    fun isCellAlive(x : Int, y : Int) = worldPositions[x][y].isAlive
}