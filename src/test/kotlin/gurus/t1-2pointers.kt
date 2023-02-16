package gurus

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class Test2Pointers {

    @Test
    fun `find sum`(){
        val a1 = intArrayOf(1,2,3,4,6)
        val a2 = intArrayOf(2,5,9,11)

        val r1 = intArrayOf(1,3)
        val r2 = intArrayOf(0, 2)
        assertContentEquals(r1, findSum(a1, 6))
        assertContentEquals(r2, findSum(a2, 11))
    }

    @Test
    fun `remove duplicate`(){
        val a1 = intArrayOf(2, 3, 3, 3, 6, 9, 9)
        val a2 = intArrayOf(2, 2, 2, 11)

        val r1 = intArrayOf(2, 3, 6, 9)
        val r2 = intArrayOf(2,11)

        val n1 = rmDuplicate(a1)
        val n2 = rmDuplicate(a2)

        assertEquals(4, n1)
        assertContentEquals(r1, a1.copyOfRange(0, n1))

        assertEquals(2, n2)
        assertContentEquals(r2, a2.copyOfRange(0, n2))
    }

    @Test
    fun `remove key`(){
        val a1 = intArrayOf(3, 2, 3, 6, 3, 10, 9, 3)
        val a2 = intArrayOf(2, 11, 2, 2, 1)

        val r1 = intArrayOf(2, 6, 10, 9)
        val r2 = intArrayOf(11,1)

        val n1 = rmKey(a1, 3)
        val n2 = rmKey(a2, 2)

        assertEquals(4, n1)
        assertContentEquals(r1, a1.copyOfRange(0, n1))
        assertEquals(2, n2)
        assertContentEquals(r2, a2.copyOfRange(0, n2))
    }

    @Test
    fun `sort array square`(){
        val a1 = intArrayOf(-2, -1, 0, 2, 3)
        val a2 = intArrayOf(-3, -1, 0, 1, 2)

        val r1 = intArrayOf(0, 1, 4, 4, 9)
        val r2 = intArrayOf(0, 1, 1, 4, 9)

        assertContentEquals(r1, sortArraySquare(a1))
        assertContentEquals(r2, sortArraySquare(a2))
    }
}
