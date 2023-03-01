package gurus

import leet.max

/**
 * slide window questions
 */

/**
 * Given an array of positive numbers and a positive number
 * k, find the maximum sum of any contiguous subarray of
 * size k.
 *
 * 1. [2, 1, 5, 1, 3, 2], k=3 => 9
 * Subarray with maximum sum is [5, 1, 3].
 *
 * 2. [2, 3, 4, 1, 5], k=2 => 7
 * Subarray with maximum sum is [3, 4].
 */
fun maxSumByK(a: IntArray, k: Int): Int{
    val n = a.size - 1

    var m = 0 // max sum
    var s = 0 // sum
    var l = 0
    for(i in 0..n){
        if(i + 1 > k){
            s -= a[l]
            l += 1
        }
        s += a[i]
        m = max(s, m)
    }
    return m
}