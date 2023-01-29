package practice

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestP1{

    @Test
    fun `binarySearch`(){
        val a = arrayOf(-4,2,4,5,9,12)

        assertEquals(3, binarySearch(a, 5, 0, 5))
        assertEquals(-1, binarySearch(a, 6, 0, 5))

    }

    @Test
    fun `mergeSort`(){
        val a = listOf(24,2,14,5,9,12)
        val r = listOf(2,5,9,12,14,24)

        assertEquals(r, mergeSort(a))
    }

    @Test
    fun `quickSort`(){
        val a = listOf(24,2,14,5,9,12)
        val r = listOf(2,5,9,12,14,24)
        assertEquals(r, quickSort(a))
    }
}