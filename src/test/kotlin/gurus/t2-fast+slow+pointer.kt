package gurus

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestFastSlowPointers {
    @Test
    fun `test linked list cycle`(){
        val a1 = arrayOf(1,2,3,4,5,6)
        val l1 = LinkedList<Int>(a1)
        val l2 = LinkedList<Int>(a1)
        var h2 = l2.getHead()
        h2?.next?.next?.next = h2

        println(l1.getHead().toString())

        assertFalse(l1.hasCycle())
        assertTrue(l2.hasCycle())
    }
}
