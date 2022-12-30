package warmup

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * questions from https://www.enjoyalgorithms.com/data-structures-and-algorithms-course/
 * Module 5
 */
class TestM5{
    @Test
    fun `bubble`(){
        val a = arrayOf(24,2,14,5,9,12)

        val r = arrayOf(2,5,9,12,14,24)

        assertContentEquals(r, bubble(a))
        // assertContentEquals(r, a)
    }

    @Test
    fun `selectionSort`(){
        val a = arrayOf(24,2,14,5,9,12)

        val r = arrayOf(2,5,9,12,14,24)

        assertContentEquals(r, selectionSort(a))
    }

    @Test
    fun `insertionSort`(){
        val a = arrayOf(24,2,14,5,9,12)
        val r = arrayOf(2,5,9,12,14,24)

        assertContentEquals(r, insertionSort(a))
    }

    @Test
    fun `mergeSort`(){
        val a = listOf(24,2,14,5,9,12)
        val r = listOf(2,5,9,12,14,24)

        assertEquals(r, mergeSort(a))
    }

    @Test
    fun `quickSortList`(){
        val a = listOf(24,2,14,5,9,12)
        val r = listOf(2,5,9,12,14,24)
        assertEquals(r, quickSortList(a))
    }

    @Test
    fun `quickSort array impl`(){
        val a = arrayOf(24,2,14,5,9,12)
        val r = arrayOf(2,5,9,12,14,24)

        quickSort(a, 0, 5)
        assertContentEquals(r, a)
    }
}