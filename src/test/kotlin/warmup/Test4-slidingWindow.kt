package warmup

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

/**
 * questions from https://www.enjoyalgorithms.com/data-structures-and-algorithms-course/
 * Module 6
 */
class M6{
    @Test
    fun `moveZerosEnd`(){
        val a1 = arrayOf(4,8,6,0,2,0,1,15,12,0)
        val a2 = arrayOf(0,3,5,9,0,0,23,2)

        val r1 = arrayOf(4,8,6,2,1,15,12,0,0,0)
        val r2 = arrayOf(3,5,9,23,2,0,0,0)

        assertContentEquals(r1, moveZerosEnd(a1))
        assertContentEquals(r2, moveZerosEnd(a2))
    }

    @Test
    fun `removeDuplicates`(){
        val a1 = arrayOf(1,2,2,2,3,3,3)
        val a2 = arrayOf(1,1,2,2,3,3,4,4,5,5)

        val r1 = arrayOf(1,2,3)
        val r2 = arrayOf(1,2,3,4,5)

        assertContentEquals(r1, removeDuplicates(a1))
        assertContentEquals(r2, removeDuplicates(a2))
    }

    @Test
    fun `maxArea`(){
        val a1 = intArrayOf(1,8,6,2,5,4,8,3,7)
        val a2 = intArrayOf(1,1)

        assertEquals(49, maxArea(a1))
        assertEquals(1, maxArea(a2))
    }

    @Test
    fun `trapWater`(){
        val a1 = intArrayOf(0,1,0,2,1,0,3,2,1,2,1)
        val a2 = intArrayOf(0,1,0,2,1,0,1,2,1,2,1)
        assertEquals(5, trapWater1(a1))
        assertEquals(6, trapWater1(a2))

        assertEquals(5, trapWater2(a1))
        assertEquals(6, trapWater2(a2))

        assertEquals(5, trapWater2(a1))
        assertEquals(6, trapWater3(a2))
    }

    @Test
    fun `longestSubstring`(){
        val s1 = "abcbbcab"
        val s2= "bbbbb"
        val s3 = "c"

        assertEquals(3, longestSubstring1(s1, 256))
        assertEquals(1, longestSubstring1(s2, 256))
        assertEquals(1, longestSubstring1(s3, 256))

        assertEquals(3, longestSubstring2(s1, 256))
        assertEquals(1, longestSubstring2(s2, 256))
        assertEquals(1, longestSubstring2(s3, 256))
    }

    @Test
    fun `windowK`(){
        val a1 = intArrayOf(1,1,1,3,4,2,3)
        val a2 = intArrayOf(1,2,4,4,2)

        val r1 = intArrayOf(2,3,4,3)
        val r2 = intArrayOf(3,2,2)
        assertContentEquals(r1, windowK1(a1, 4))
        assertContentEquals(r2, windowK1(a2, 3))

        assertContentEquals(r1, windowK2(a1, 4))
        assertContentEquals(r2, windowK2(a2, 3))

        assertContentEquals(r1, windowK3(a1, 4))
        assertContentEquals(r2, windowK3(a2, 3))
    }

    @Test
    fun `maxContinuousOnesFlip1`(){
        val a1 = intArrayOf(1,0,0,1,1,0,1,0,1,1,1)
        val a2 = intArrayOf(1,1,0,1,0,1,0,0,1)

        assertEquals(8, maxContinuousOnesFlip1(a1, 2))
        assertEquals(4, maxContinuousOnesFlip1(a2, 1))
    }

    @Test
    fun `maxContinuousOnesFlip2`(){
        val a1 = intArrayOf(1,0,0,1,1,0,1,0,1,1,1)
        val a2 = intArrayOf(1,1,0,1,0,1,0,0,1)

        assertEquals(8, maxContinuousOnesFlip2(a1, 2))
        assertEquals(4, maxContinuousOnesFlip2(a2, 1))
    }

    @Test
    fun `maxContinuousOnes1`(){
        val a1 = intArrayOf(1,1,0,1,1,1,0,0,1)
        val a2 = intArrayOf(0,1,1,1,1,0,0,1,1)
        val a3 = intArrayOf(1,1,1,1)
        val a4 = intArrayOf(0,0,1,0,1)

        assertEquals(3, maxContinuousOnes1(a1))
        assertEquals(4, maxContinuousOnes1(a2))
        assertEquals(4, maxContinuousOnes1(a3))
        assertEquals(1, maxContinuousOnes1(a4))
    }

    @Test
    fun `maxContinuousOnes2`(){
        val a1 = intArrayOf(1,1,0,1,1,1,0,0,1)
        val a2 = intArrayOf(0,1,1,1,1,0,0,1,1)
        val a3 = intArrayOf(1,1,1,1)
        val a4 = intArrayOf(0,0,1,0,1)

        assertEquals(3, maxContinuousOnes2(a1))
        assertEquals(4, maxContinuousOnes2(a2))
        assertEquals(4, maxContinuousOnes2(a3))
        assertEquals(1, maxContinuousOnes2(a4))
    }

    @Test
    fun `maxContinuousOnes3`(){
        val a1 = intArrayOf(1,1,0,1,1,1,0,0,1)
        val a2 = intArrayOf(0,1,1,1,1,0,0,1,1)
        val a3 = intArrayOf(1,1,1,1)
        val a4 = intArrayOf(0,0,1,0,1)

        assertEquals(3, maxContinuousOnes3(a1))
        assertEquals(4, maxContinuousOnes3(a2))
        assertEquals(4, maxContinuousOnes3(a3))
        assertEquals(1, maxContinuousOnes3(a4))
    }

    @Test
    fun `repeatedN1`(){
        val a1 = intArrayOf(1,2,2,3)
        val a2 = intArrayOf(2,1,2,5,3,2,2,4)
        val a3 = intArrayOf(5,1,5,2,5,3,5,4,6,5)

        assertEquals(2, repeatedN1(a1))
        assertEquals(2, repeatedN1(a2))
        assertEquals(5, repeatedN1(a3))
    }
}