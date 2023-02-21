package gurus

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestIslandsProblems {

    @Test
    fun `count islands`(){
        val a1 = arrayOf(
            arrayOf(0, 1, 1, 1, 0),
            arrayOf(0, 0, 0, 1, 1),
            arrayOf(0, 1, 1, 1, 0),
            arrayOf(0, 1, 1, 0, 0),
            arrayOf(0, 0, 0, 0, 0)
        )

        val a2 = arrayOf(
            arrayOf(1, 1, 1, 0, 0),
            arrayOf(0, 1, 0, 0, 1),
            arrayOf(0, 0, 1, 1, 0),
            arrayOf(0, 0, 1, 0, 0 ),
            arrayOf(0, 0, 1, 0, 0)
        )

        assertEquals(1, countIslands(a1))
        assertEquals(3, countIslands(a2))
    }
}