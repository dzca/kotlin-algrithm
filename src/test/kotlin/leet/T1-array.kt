package leet

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class T1{

    @Test
    fun `minWindow`(){
        val a1 = "ADOBECODEBANC"
        val b1 = "ABC"

        assertEquals("BANC", minWindow(a1, b1))
    }

    @Test
    fun `longestSubStr1`(){
        val a1 = "abcabcbb"
        val a2 = "bbbbb"
        val a3 =  "pwwkew"
        val a4 =  "abba"
        val a5 =  " "

        assertEquals(3, longestSubStr1(a1))
        assertEquals(1, longestSubStr1(a2))
        assertEquals(3, longestSubStr1(a3))
        assertEquals(2, longestSubStr1(a4))
        assertEquals(1, longestSubStr1(a5))
    }

    @Test
    fun `longestSubStr2`(){
        val a1 = "abcabcbb"
        val a2 = "bbbbb"
        val a3 =  "pwwkew"
        val a4 =  "abba"
        val a5 =  " "
        val a6 =  ""

        assertEquals(3, longestSubStr2(a1))
        assertEquals(1, longestSubStr1(a2))
        assertEquals(3, longestSubStr1(a3))
        assertEquals(2, longestSubStr2(a4))
        assertEquals(1, longestSubStr2(a5))
        assertEquals(0, longestSubStr2(a6))
    }
}