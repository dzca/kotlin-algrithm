package warmup

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * questions from https://www.enjoyalgorithms.com/data-structures-and-algorithms-course/
 * Module 8
 */
class M8{
    @Test
    fun `intersect1`(){
        val a1 = intArrayOf(3,4,6,2,8,5,9)
        val b1 = intArrayOf(6,3,2,7,5,1)
        val r1 = intArrayOf(3,6,2,5)

        val a2 = intArrayOf(3,4,6,7,10,12,5)
        val b2 = intArrayOf(7,11,18,15,12)
        val r2 = intArrayOf(7,12)

        val a3 = intArrayOf(3,4,6,10,5)
        val b3 = intArrayOf(7,11,18,15,12)
        val r3 = intArrayOf()

        assertContentEquals(r1, intersect1(a1, b1))
        assertContentEquals(r2, intersect1(a2, b2))
        assertContentEquals(r3, intersect1(a3, b3))
    }

    @Test
    fun `intersect2`(){
        val a1 = intArrayOf(3,4,6,2,8,5,9)
        val b1 = intArrayOf(6,3,2,7,5,1)
        val r1 = intArrayOf(3,6,2,5)

        val a2 = intArrayOf(3,4,6,7,10,12,5)
        val b2 = intArrayOf(7,11,18,15,12)
        val r2 = intArrayOf(7,12)

        val a3 = intArrayOf(3,4,6,10,5)
        val b3 = intArrayOf(7,11,18,15,12)
        val r3 = intArrayOf()

        assertTrue { r1.toHashSet() == intersect2(a1, b1).toHashSet() }
        assertTrue { r2.toHashSet() == intersect2(a2, b2).toHashSet() }
        assertTrue { r3.toHashSet() == intersect2(a3, b3).toHashSet() }
    }

    @Test
    fun `isSubArray1`(){
        val a1 = intArrayOf(2,8,12,6,10,11)
        val b1 = intArrayOf(8,2,6,11)

        val a2 = intArrayOf(6,4,8,3,2)
        val b2 = intArrayOf(4,7,3,9)

        assertTrue { warmup.isSubArray1(a1, b1) }
        assertTrue { !warmup.isSubArray1(a2, b2) }
    }

    @Test
    fun `isSubArray2`(){
        val a1 = intArrayOf(2,8,12,6,10,11)
        val b1 = intArrayOf(8,2,6,11)

        val a2 = intArrayOf(6,4,8,3,2)
        val b2 = intArrayOf(4,7,3,9)

        assertTrue { warmup.isSubArray2(a1, b1) }
        assertTrue { !warmup.isSubArray2(a2, b2) }
    }
}