package com.kalm004.gameoflife

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GameOfLifeTests {
    @Test
    fun emptyWorldTest() {
        val world = World(3, 3)
        world.stepForward()
        assertTrue(world.isDead())
    }

    @Test
    fun onlyOneCellAlive() {
        val world = World(3, 3)
        world.spawnCell(0, 1)
        world.stepForward()
        assertTrue(world.isDead())
    }

    @Test
    fun worldSpawnWorks() {
        val world = World(3, 3)
        world.spawnCell(0, 1)
        world.spawnCell(0, 2)
        world.spawnCell(1, 1)
        assertFalse(world.isDead())
    }

    @Test
    fun worldGeneratesLive() {
        val world = World(3, 3)
        world.spawnCell(0, 1)
        world.spawnCell(0, 2)
        world.spawnCell(1, 1)
        world.stepForward()
        assertTrue(world.isCellAlive(1, 2), "Check 1, 2")
        assertTrue(world.isCellAlive(0, 0), "Check 0, 0")
        assertTrue(world.isCellAlive(1, 0), "Check 1, 0")
        world.stepForward()
        assertTrue(world.isCellAlive(1, 0), "Check 1, 0")
        assertTrue(world.isCellAlive(2, 1), "Check 2, 1")
        assertTrue(world.isCellAlive(1, 2), "Check 1, 2")
    }

    @Test
    fun biggerWorldGeneratesLive() {
        val world = World(4, 4)
        world.spawnCell(0, 1)
        world.spawnCell(0, 2)
        world.spawnCell(1, 1)
        world.stepForward()
        assertTrue(world.isCellAlive(1, 2), "Check 1, 2")
        assertTrue(world.isCellAlive(0, 0), "Check 0, 0")
        assertTrue(world.isCellAlive(1, 0), "Check 1, 0")
        world.stepForward()
        assertTrue(world.isCellAlive(1, 0), "Check 1, 0")
        assertTrue(world.isCellAlive(2, 1), "Check 2, 1")
        assertTrue(world.isCellAlive(1, 2), "Check 1, 2")
        assertTrue(world.isCellAlive(0, 3), "Check 0, 3")
    }
}