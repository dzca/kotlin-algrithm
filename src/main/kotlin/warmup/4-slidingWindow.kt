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

/**
 * container with most water
 *
 * given array a[n] where a[i] is height of a bar. find sub array
 * that holds most water
 *
 * - n >= 2
 * - f(n) = max[(j-i) * min(a[i]...a[j])]
 *
 * example:
 *
 * a={1,5,6,3,4,2} => 12
 *
 * line [5,6,3,4] d=4, min height = 3
 */

fun max(a:Int, b: Int): Int{
    return if(a >= b) a else b
}
fun min(a:Int, b: Int): Int{
    return if(a <= b) a else b
}
/**
 * set i=0, j = n-1
 *
 * if h(i) < h(j), height = h(i) =>  a(i, j) > a(i, j-1), so i++
 * if h(i) > h(j), height = h(j) => a(i, j) > a(i+1, j), so j--
 *
 * T(time) = O(n), T(space) = O(1)
 */
fun maxArea(a: IntArray): Int {

    var n = a.size
    var i = 0
    var j = n-1

    var m = 0
    while(i<j){
        var area = (j-i) * min(a[i], a[j])
        println("area =($j -$i) * min(${a[i]}, ${a[j]}) = $area")
        m = max(area, m)
        if(a[i] < a[j]){
            i++
        } else {
            j--
        }
    }
    return m
}