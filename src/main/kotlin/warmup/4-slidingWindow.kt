package warmup

import java.util.*

/**
 * Module 6 is  2 pointers and sliding window problems
 */

/**
 * Move zero to end in an array
 *
 * Example:
 * {4,8,6,0,2,0,1,15,12,0} => {4,8,6,2,1,15,12,0,0,0}
 *
 * {0,3,5,9,0,0,23,2} => {3,5,9,23,2,0,0,0}
 *
 * - maintain relative order
 * - solve the problem in place
 *
 * attempt 1:
 * - 1st loop pick up the none zero and put in new array
 * - 2nd loop fill the zeros on the end
 *
 * attempt 2:
 * - use 2 pointer for start and end of zero
 */

fun moveZerosEnd(a: Array<Int>): Array<Int>{
    var i = 0

    for(j in 0..a.size -1){
        if(a[i]== 0){
            if(a[j]!=0){
                swap(a, i, j)

                println("swap $i,$j, => ${a.contentToString()}")
                i++
            }
        } else {
            i++
        }
    }
    return a
}

/**
 * remove duplicates from sorted array
 *
 * example:
 *
 * a = {1,2,2,2,3,3,3} => {1,2,3}
 * a = {1,1,2,2,3,3,4,4,5,5} => {1,2,3,4,5}
 */
fun removeDuplicates(a: Array<Int>): Array<Int> {
    val n = a.size
    if(n <= 1) return a

    var i = 0

    for(j in 1.. n-1){
        if(a[i] != a[j]){
            i++
            a[i] = a[j]
        }
    }

    return a.copyOfRange(0, i+1)
}
