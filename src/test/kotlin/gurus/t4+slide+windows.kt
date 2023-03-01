package gurus

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestSlideWindowProblems {

    @Test
    fun `maxSumByK`(){
        val a1 = intArrayOf(2, 1, 5, 1, 3, 2)
        val a2 = intArrayOf(2, 3, 4, 1, 5)

        assertEquals(9, maxSumByK(a1, 3))
        assertEquals(7, maxSumByK(a2, 2))
    }
}