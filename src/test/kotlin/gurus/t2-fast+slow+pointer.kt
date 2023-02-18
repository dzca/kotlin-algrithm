package gurus

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
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

    @Test
    fun `test count size of a cycle linked list`(){
        val a1 = arrayOf(1,2,3,4,5,6)
        val l2 = LinkedList<Int>(a1)
        var h2 = l2.getHead()

        val s = l2.move(h2, 2)
        val p = l2.move(h2, 5)
        p?.next = s

        assertEquals(4, l2.findCycleSize())
    }

    @Test
    fun `test find the middle of a linked list`(){
        val a1 = arrayOf(1,2,3,4,5,6)
        val l1 = LinkedList<Int>(a1)

        assertEquals(4, l1.findMiddle()?.v)
    }

    @Test
    fun `find the start of a cyclic linked list`(){
        // build linked list
        val a1 = arrayOf(1,2,3,4,5,6)
        val l2 = LinkedList<Int>(a1)
        var h2 = l2.getHead()

        // build cycle 3,4,5,6
        val s = l2.move(h2, 2)
        val p = l2.move(h2, 5)
        p?.next = s

        assertEquals(3, l2.findCycleStart()?.v)
    }
}
