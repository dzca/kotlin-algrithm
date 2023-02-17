package gurus

import warmup.min
import java.lang.Math.*
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

/**
 * Given an array of unsorted numbers, find all unique triplets in it that
 * add up to zero.
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]
 *
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 */

fun tripletSum(a: IntArray): ArrayList<IntArray>{
    val n = a.size - 1
    // -3,-2,-1,0,1,1,2
    val r = ArrayList<IntArray>()

    a.sort()
    for(i in 0 until n){
        if(i>0 && a[i-1] == a[i])
            continue
        else {
            findPair(a, i, -a[i], r)
        }
    }

    return r
}

/**
 * find 2 elements x,y in array a (i..n), that sum(x,y)==v
 *  and put it into the result array r
 */
fun findPair(a: IntArray, i: Int, d: Int, list: ArrayList<IntArray>){
    var l = i + 1
    var r = a.size - 1
    // -3,-2,-1,0,1,1,2
    while(l< r){
        val v = a[l] + a[r]
        if(v == d){
            list.add(intArrayOf(a[i], a[l], a[r]))
            l+=1
            r-=1
            // the next one could be a duplicate
            while(l < r && a[l] == a[l -1])
                l+=1
            while(l<r && a[r] == a[r + 1])
                r-=1
        } else if( v > d){
            r-=1
        } else {
            l+=1
        }
    }
}

/**
 * Given an array of unsorted numbers and a target number, find a triplet
 * in the array whose sum is as close to the target number as possible,
 * return the sum of the triplet. If there are more than one such triplet,
 * return the sum of the triplet with the smallest sum.
 *
 * Input: [-2, 0, 1, 2], target=2 Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 *
 * Input: [1, 0, 1, 1], target=100 Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 *
 * Input: [0, 0, 1, 1, 2, 6], target=5 Output: 4
 */

fun tripletSumMin(a: IntArray, t: Int): Int{
    val n = a.size - 1
    a.sort()
    var s = Int.MAX_VALUE
    for(i in 0 until n){
        // findtripletSumMin
        var l = i + 1
        var r = n
        var d = t - a[i] - a[l] - a[r]

        while( l < r){
            if(d == 0) return t

            // handle the smallest sum when we have more than one solution
            s = min(s, kotlin.math.abs(d))

            if(d > 0) {
                l+=1 // dec d
            } else {
                r-=1 // inc d
            }
        }
    }
    return t - s
}

