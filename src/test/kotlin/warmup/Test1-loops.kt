package warmup

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * questions from https://www.enjoyalgorithms.com/data-structures-and-algorithms-course/
 * Module 3
 */
class TestM3 {

    @Test
    fun `faceSun`(){
        val a1 = arrayOf(7,4,8,2,9)
        assertEquals(3, faceSun(a1))
    }

    @Test
    fun `leader`(){
        val a1 = arrayOf(16, 17, 4, 3, 5, 2)
        val a2 = arrayOf(6,5,4,3,2,1)
        val a3 = arrayOf(1,2,3,4,5,6)

        // Arrays.toString(a1)
        val r1 = arrayOf(17, 5, 2)
        val r2 = arrayOf(6, 5, 4, 3, 2, 1)
        val r3 = arrayOf(6)
        assertContentEquals(r1, leaders(a1))
        assertContentEquals(r2, leaders(a2))
        assertContentEquals(r3, leaders(a3))
    }

    @Test
    fun `isMountain`(){
        val a1 = arrayOf(5, 2, 1, 4)
        val a2 = arrayOf(5, 8 ,8)
        val a3 = arrayOf(1, 2, 6, 5, 3)

        assertFalse(isMountain(a1))
        assertFalse(isMountain(a2))
        assertTrue(isMountain(a3))
    }

    @Test
    fun `roman2int`() {
        val s1 = "MCMIV"
        val s2 = "LVIII"
        val s3 = "MCMXCIV"

        assertEquals(1904, roman2int(s1))
        assertEquals(58, roman2int(s2))
        assertEquals(1994, roman2int(s3))
    }

    @Test
    fun `int2Roman`() {
        val s1 = "MCMIV"
        val s2 = "LVIII"
        val s3 = "MCMXCIV"
        val s4 = "MMMCMXLIX"

        assertEquals(s1, int2Roman(1904))
        assertEquals(s2, int2Roman(58))
        assertEquals(s3, int2Roman(1994))
        assertEquals(s4, int2Roman(3949))
    }

    @Test
    fun `equilibrium`(){
        val a1 = arrayOf(-7,1,5,2,-4,3,0)
        val a2 = arrayOf(0, 1, 3, -2, -1)
        val a3 = arrayOf(1,2,-2,-1)
        assertEquals(3, equilibrium(a1))
        assertEquals(1, equilibrium(a2))
        assertEquals(-1, equilibrium(a3))
    }

    @Test
    fun `prodArray`(){
        val a1 = arrayOf(2,1,3,4)
        val a2 = arrayOf(5,2,8,4,5)
        val a3 = arrayOf(1,0,4,3,5)
        val a4 = arrayOf(1,1,1,1,1,1,1)
        val a5 = arrayOf(0,4,0,3)

        val r1 = arrayOf(12,24,8,6)
        val r2 = arrayOf(320,800,200,400,320)
        val r3 = arrayOf(0,60,0,0,0)
        val r4 = arrayOf(1,1,1,1,1,1,1)
        val r5 = arrayOf(0,0,0,0)

        //println(Arrays.toString(warmup.prodArray(a1)))
        assertContentEquals(r1, prodArray(a1))
        assertContentEquals(r2, prodArray(a2))
        assertContentEquals(r3, prodArray(a3))
        assertContentEquals(r4, prodArray(a4))
        assertContentEquals(r5, prodArray(a5))
    }

//    @Test
//    fun `rotateMatrix`(){
//
//    }
//
//    @Test
//    fun `spiralMatrix`(){
//        val a1 = arrayOf(1,2,3,4)
//        val a2 = arrayOf(5,6,7,8)
//        val a3 = arrayOf(9,10,11,12)
//        val a4 = arrayOf(13,14,15,16)
//        val m1 = arrayOf(a1,a2,a3,a4)
//
//        val r1 = arrayOf(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10)
//
//        assertContentEquals(warmup.spiralMatrix(m1), r1)
//    }
}