package monster

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestP1 {

    fun Boolean.toInt(b: Boolean) = if (b) 1 else 0
    fun Int.toBoolean(x: Int) = x != 0

    @Test
    fun `convert`(){
        val a = arrayOf(0,0,1,1,1)
        val b = a.map{ it!=0 }.toTypedArray()
        println(b.contentToString())

        println(intsToBools(a).contentToString())
    }

    @Test
    fun `firstTrue`() {
        val a1 = arrayOf(0,0,1,1,1)
        val a2 = arrayOf(1)
        val a3 = arrayOf(0,0,0)
        val a4 = arrayOf(1,1,1,1,1)
        val a5 = arrayOf(0,1)
        val a6 = arrayOf(0,0,0,0,0,0,0,1)

        assertEquals(2, firstTrue(intsToBools(a1)))
        assertEquals(0, firstTrue(intsToBools(a2)))
        assertEquals(-1, firstTrue(intsToBools(a3)))

        assertEquals(0, firstTrue(intsToBools(a4)))
        assertEquals(1, firstTrue(intsToBools(a5)))
        assertEquals(7, firstTrue(intsToBools(a6)))

    }

    @Test
    fun `firstNoLessThan`(){
        val a1 = arrayOf(1,3,3,5,5,8)
        val a2 = arrayOf(1,3)
        val a3 = arrayOf(3)
        assertEquals(1, firstNoLessThan(a1, 3))

        assertEquals(1, firstNoLessThan(a1, 2))
        assertEquals(1, firstNoLessThan(a2, 3))
        assertEquals(0, firstNoLessThan(a3, 3))
    }
    @Test
    fun `first Match`(){
        val a1 = arrayOf(1,3,3,5,5,8)
        val a2 = arrayOf(1,3)
        val a3 = arrayOf(3)
        assertEquals(1, firstMatch(a1, 3))

        assertEquals(-1, firstMatch(a1, 2))
        assertEquals(1, firstMatch(a2, 3))
        assertEquals(0, firstMatch(a3, 3))
    }

    @Test
    fun `square root`(){
        assertEquals(4, squareRoot(16))
        assertEquals(2, squareRoot(8))
        assertEquals(1, squareRoot(1))
        assertEquals(1, squareRoot(2))
        assertEquals(1, squareRoot(3))
    }

    @Test
    fun `findMinRotated`(){
        val a1 = arrayOf(30, 40, 50, 10, 20)
        val a2 = arrayOf(3, 5, 7, 11, 13, 17, 19, 2)
        val a3 = arrayOf(3, 5, 2)
        val a4 = arrayOf(3, 5)

        assertEquals(3, findMinRotated(a1))
        assertEquals(7, findMinRotated(a2))
        assertEquals(2, findMinRotated(a3))
        assertEquals(0, findMinRotated(a4))
    }

    @Test
    fun `peakOfMountain`() {
        val a1 = arrayOf(0, 1, 2, 3, 2, 1, 0)
        val a2 = arrayOf(0, 1, 2, 3, 4, 2, 1)
        val a3 = arrayOf(0, 2, 1)
        val a4 = arrayOf(0, 2, 8, 5, 4, 3, 2, 1)

        assertEquals(3, peakOfMountain(a1))
        assertEquals(4, peakOfMountain(a2))
        assertEquals(1, peakOfMountain(a3))
        assertEquals(2, peakOfMountain(a4))
    }
}