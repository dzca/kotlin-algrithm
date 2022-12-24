package warmup

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertTrue

/**
 * questions from https://www.enjoyalgorithms.com/data-structures-and-algorithms-course/
 * Module 4
 */
class TestM4 {

    @Test
    fun `binarySearch`(){
        val a = arrayOf(-4,2,4,5,9,12)

        assertTrue { binarySearch(a, 5, 0, 5) == 3 }
        assertTrue { binarySearch(a, 6, 0, 5) == -1 }
    }

    @Test
    fun `binarySearchLoop`(){
        val a = arrayOf(-4,2,4,5,9,12)

        assertTrue { binarySearchLoop(a, 5, 0, 5) == 3 }
        assertTrue { binarySearchLoop(a, 6, 0, 5) == -1 }
    }

    @Test
    fun `findMax`(){
        val a1 = arrayOf(18,110,210,452,810,500,101,13)
        val a2 = arrayOf(1,2,3,4,5)
        assertTrue { findMax(a1, 0, 7) == 810 }
        assertTrue { findMax(a2, 0, 4) == 5 }
    }

    @Test
    fun `findFirstLast`(){
        val a1 = arrayOf(-1,1,2,2,2,5,6,12,12)
        val a2 = arrayOf(21,32,51,70,71)

        val r1 = arrayOf(2,4)
        val r2 = arrayOf(3,3)
        val r3 = arrayOf(-1,-1)
        assertContentEquals(r1, findFirstLast(a1, 2))
        assertContentEquals(r2, findFirstLast(a2, 70))
        assertContentEquals(r3, findFirstLast(a2, 55))
    }

    @Test
    fun `minInRotatedArray`(){

        val a1 = arrayOf(5,6,7,8,9,1,2,3,4)
        val a2 = arrayOf(8,9,3,4,5,6,7)
        val a3 = arrayOf(5,6,7,8,9)
        val a4 = arrayOf(8,7)

        assertTrue { minInRotatedArray(a1) == 1 }
        assertTrue { minInRotatedArray(a2) == 3 }
        assertTrue { minInRotatedArray(a3) == 5 }
        assertTrue { minInRotatedArray(a4) == 7 }
    }
}