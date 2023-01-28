package warmup

import java.util.*
import kotlin.collections.HashSet

/**
 * Q1: FizzBuzz
 */

/**
 * Q2: Row with max ones
 */

/**
 * Q3: pair sum in array
 */

/**
 * Q4: Triplets with zero sum
 */

/**
 * Q5: intersection of two arrays
 *
 * both arrays are distinct
 * intersection is a list of common element
 *
 * example:
 * a={3,4,6,2,8,5,9} b={6,3,2,7,5,1} => r={3,6,2,5}
 *
 * a={3,4,6,7,10,12,5}, b={7,11,18,15,12}, r={7,12}
 * a={3,4,6,10,5}, b={7,11,18,15,12}, r={}
 */
fun intersect1(a: IntArray, b: IntArray): IntArray{
    var r = mutableListOf<Int>()
    for(x in a){
        for(element in b){
            if(x == element) {
                r.add(x)
                break
            }
        }
    }
    return r.toIntArray()
}

/**
 * hash table
 */
fun intersect2(a: IntArray, b: IntArray): IntArray{
    var r = mutableListOf<Int>()

    val t = a.toHashSet()
    for(j in b.indices){
        if(t.contains(b[j]))
            r.add(b[j])
    }
    return r.toIntArray()
}

/**
 * Q6: check if array b is sub array of a
 *
 * Example:
 * a=(2,8,12,6,10,11) b=(8,2,6,11) true
 * a=(6,4,8,3,2) b=(4,7,3,9) false
 */

/**
 * Hash table
 */
fun isSubArray1(a: IntArray, b: IntArray): Boolean{
    val t = HashSet<Int>()

    for(i in a){
        t.add(i)
    }

    for(x in b){
        if(!t.contains(x))
            return false
    }

    return true
}

/**
 * sorting and 2 pointer
 */
fun isSubArray2(a: IntArray, b: IntArray): Boolean{

    return true
}