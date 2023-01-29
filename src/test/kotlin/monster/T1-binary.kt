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

}