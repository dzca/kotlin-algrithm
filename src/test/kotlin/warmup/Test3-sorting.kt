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

    @Test
    fun `countSort`(){
        val a1 = arrayOf(24,2,14,5,9,12)
        val a2 = arrayOf(1,4,1,2,7,5,2,7)
        val a3 = arrayOf(2,5,3,0,2,3,0,3)


        val r1 = arrayOf(2,5,9,12,14,24)
        val r2 = arrayOf(1,1,2,2,4,5,7,7)
        val r3 = arrayOf(0, 0, 2, 2, 3, 3, 3, 5)

        assertContentEquals(r1, countSort(a1, 25))
        assertContentEquals(r2, countSort(a2, 8))
        assertContentEquals(r3, countSort(a3, 6   ))
    }

    @Test
    fun `sort_0_1_2`(){
        val a1 = arrayOf(0,2,1,0,1,2,1,0)
        val a2 = arrayOf(0,1,1,0,1,2,1,2,0,0)
        val a3 = arrayOf(2,0,1)


        val r1 = arrayOf(0,0,0,1,1,1,2,2)
        val r2 = arrayOf(0,0,0,0,1,1,1,1,2,2)
        val r3 = arrayOf(0,1,2)

        assertContentEquals(r1, sort_0_1_2(a1))
        assertContentEquals(r2, sort_0_1_2(a2))
        assertContentEquals(r3, sort_0_1_2(a3))
    }
}