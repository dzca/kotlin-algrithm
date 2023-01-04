package warmup

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

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
}