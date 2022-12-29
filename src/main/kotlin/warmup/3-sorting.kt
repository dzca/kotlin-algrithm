package warmup

import java.util.*

/**
 * Module 5 is sorting
Insertion Sort — Stable
Selection Sort — Unstable
Bubble Sort — Stable
Merge Sort — Stable
Shell Sort — Unstable
Timsort — Stable
 */

/**
 * bubble sort: move lager item bye swap
 * time O(n^2) space O(1)
 */
fun bubble(a: Array<Int>) : Array<Int>{
    val n = a.size - 1

    for(i in 0..n-1){
        for(j in i..n-1){
            if(a[j] > a[j+1]){
                var t = a[j]
                a[j] = a[j+1]
                a[j+1] = t
            }
        }
    }

    return a
}

/**
 * Selection sort: select minimal value and put it on the head.
 * time O(n^2) space O(1)
 */
fun selectionSort(a: Array<Int>) : Array<Int>{
    val n = a.size - 1

    var s: Int  // index of min value
    for(i in 0 .. n){
        s = i
        // find minimal v
        for(j in i..n-1){
            if(a[s] > a[j+1]){
                s = j + 1
            }
        }
        // swap
        var t = a[i]
        a[i] = a[s]
        a[s] = t
    }
    return a
}

/**
 * insertion sort: left side is a sorted array, pick up one on right and
 * insert it into correct position in the sorted array.
 * time O(n^2) space O(1)
 */
fun insertionSort(a: Array<Int>) : Array<Int>{
    val n = a.size - 1

    for(i in 1 .. n){
        var v = a[i]
        var j = i

        println("set v=a[$i]=${a[i]}, array = ${Arrays.toString(a)}")
        // find the index of min in the range [0..j]
        while(j > 0 && a[j-1] > v){
            a[j] = a[j-1]
            println("move a[$j]=${a[j]} into a[${j+1}]")
            j--
        }
        // left half sorted, move v into a[j]
        println("move v=$v into a[${j}]")
        a[j] = v
    }

    return a
}

/**
 * merge two sorted lists into one list
 */
fun merge(la: List<Int>, ra: List<Int>): List<Int> {
    var i = 0
    var j = 0

    var r = mutableListOf<Int>()

    while(i<la.count() && j<ra.count()){
        if(la[i] < ra[j]){
            r.add(la[i])
            i++
        } else {
            r.add(ra[j])
            j++
        }
    }

    while(i<la.count()){
        r.add(la[i])
        i++
    }

    while(j<ra.count()){
        r.add(ra[j])
        j++
    }

    return r
}

fun mergeSort(a: List<Int>): List<Int> {

    // println("mergeSort: a = ${a}")
    if(a.size < 2) return a
    // l =[0..m-1], r = [m..n-1]
    val m = a.size shr 1

    val al = mergeSort(a.subList(0, m))
    val ar = mergeSort(a.subList(m, a.size))
    return merge(al, ar)
}