package gurus

import java.lang.Math.pow
import java.lang.Math.sqrt
import kotlin.math.pow

/**
 * Given an array of sorted numbers and a target sum, find
 * a pair in the array whose sum is equal to the given target.
 */
fun findSum(a: IntArray, n:Int): IntArray{
    var l = 0
    var r = a.size - 1

    while(l <= r){
        var s = a[l] + a[r]
        if(s == n)
            return intArrayOf(l, r)

        if(s > n){
            r-=1
        } else {
            l+=1
        }
    }
    return intArrayOf()
}

/**
 * condition: keep the result in same array, and in order
 * 
 * Given an array of sorted numbers, remove all duplicate number
 * instances from it in-place, such that each element appears
 * only once. The relative order of the elements should be kept
 * the same, and you should not use any extra space so that
 * the solution have a space complexity of O(1).
 */
fun rmDuplicate(a: IntArray): Int{
    var p = 1 // point to next duplicated item
    val n = a.size-1
    var s = 1

    for(i in 0..n){
        if(a[p-1] != a[i]){
            a[p] = a[i]
            p += 1
        }
    }
    return p
}

/**
 * Given an unsorted array of numbers and a target ‘key’,
 * remove all instances of ‘key’ in-place and return the new length of the array.
 *
 * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3 Output: 4
 * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
 *
 * Input: [2, 11, 2, 2, 1], Key=2 Output: 2
 * Explanation: The first two elements after removing every 'Key' will be [11, 1].
 */
fun rmKey(a: IntArray, k: Int): Int{
    var p = 0 // pointer to next of ^key
    val n = a.size-1

    for(i in 0..n){
        if(a[i] != k){
            a[p] = a[i]
            p+=1
        }
    }
    return p
}

/**
 * Given a sorted array, create a new array containing squares of all
 * the numbers of the input array in the sorted order.
 *
 * Input: [-2, -1, 0, 2, 3] Output: [0, 1, 4, 4, 9]
 * Input: [-3, -1, 0, 1, 2] Output: [0, 1, 1, 4, 9]
 */

fun sqrt(x:Int): Int{
    return x.toDouble().pow(2.0).toInt()
}
fun sortArraySquare(a: IntArray): IntArray{
    var l = 0
    var r = a.size - 1
    var i = a.size - 1 // highest value index in result array x
    var x = IntArray(a.size)

    while(l <= r){
        val vl = sqrt(a[l])
        val vr = sqrt(a[r])

        if(vl > vr){
            x[i] = vl
            l += 1
        } else {
            x[i] = vr
            r -=1
        }
        i-=1
    }
    return x
}