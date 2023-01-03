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

 bubble, selection, insertion =O(n^2)
 merge, quick, heap =O(nlogn)
 */

/**
 * bubble sort: move lager item bye swap
 * time O(n^2) space O(1)
 */
fun bubble(a: Array<Int>) : Array<Int>{
    val n = a.size - 1

    var t:Int
    for(i in 0..n-1){
        for(j in i..n-1){
            if(a[j] > a[j+1]){
                t = a[j]
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
    var t: Int
    for(i in 0 .. n){
        s = i
        // find minimal v
        for(j in i..n-1){
            if(a[s] > a[j+1]){
                s = j + 1
            }
        }
        // swap
        t = a[i]
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
        val v = a[i]
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

    val r = mutableListOf<Int>()

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

fun quickSortList(a: List<Int>): List<Int> {

    if(a.size < 2) return a
    //val m = a.size shr 1
    val m = a.size - 1
     println("quickSortList in: a[m]=${a[m]}, a = ${a}")

    val l = a.filter { it -> it < a[m] }
    val r = a.filter { it -> it > a[m]}
    val e = a.filter { it -> it == a[m] }

    val x = quickSortList(l) + e + quickSortList(r)

    //println("quickSortList out: x= ${x}")
    return x
}

fun swap(a: Array<Int>, i: Int, j:Int){
    val t = a[i]
    a[i] = a[j]
    a[j] = t
}

/**
 * return the index of the pivot value, after the balance
 *
 * c(time) = O(n) c(space) = O(1)
 */
fun partition(a: Array<Int>, l: Int, r:Int): Int{
    val p = a[r]
    // println("pivot: p=${p}")
    var j = l - 1 // point to last swap-ed value

    for(i in l until r){
        // if iterator < pivot, swap a[j] with item next to last swapped
        if(a[i] < p){
            j++
            swap(a, i, j)
        }
    }
    // println("before last swap: j=$j, a=${a.contentToString()}")
    // swap pivot and first item bigger than pivot
    swap(a, ++j, r)

    // println("balanced: a=${a.contentToString()}")
    return j
}

/**
 * time = divide + conquer + combine
 *
 * conquer:
 * left = T(i) range:[0..i]
 * right = T(n-i-1) range: [i+1..n-1]
 *
 * if n=1, T(n) = c
 * if n>1, T(n) = T(i) + T(n-i-1) + cn
 *
 * Total time method 2:
 * if array size is n, and we swap in every pivot
 * t = cn + c(n-1)...+ 2c + c = c(n*(n+1)/2) = O(n^2)
 */
fun quickSort(a: Array<Int>, l: Int, r:Int){
    if(l < r){
        val p = partition(a, l, r)
        quickSort(a, l, p-1)
        quickSort(a, p+1, r)
    }
}

/**
 * k is the (number of hash keys) = max + 1
 */
fun countSort(a: Array<Int>, k: Int): Array<Int>{
    // [1, 4, 1, 2, 7, 5, 2, 7]
    val c = IntArray(k) { _ -> 0 }

    for(i in a){
        c[i] += 1
    }

    // c=[0, 2, 2, 0, 1, 1, 0, 2], k = 8
    println("step1: array c=${Arrays.toString(c)}")

    for(j in 1..k -1){
        c[j] += c[j-1]
    }
    // c = [0,2,4,4,5,6,6,8]
    println("step2: array c=${Arrays.toString(c)}")

    val b = IntArray(a.size){ _ -> 0 }
    var v :Int
    // place items from a into b, backwards
    for(i in a.size - 1 downTo 0){
        v = a[i]
        b[c[v] - 1] = v
        c[v] -= 1
    }

    println("step3: c=${Arrays.toString(c)}")
    println("step3: b=${Arrays.toString(b)}")
    return b.toTypedArray()
}

/**
 * sort an array with 0s,1s,2s.
 *
 * Example:
 * a = {0,2,1,0,1,2,1,0} => {0,0,0,1,1,1,2,2}
 * a = {0,1,1,0,1,2,1,2,0,0} => {0,0,0,0,1,1,1,1,2,2}
 * a = {2,0,1} -> {0,1,2}
 *
 * 1 - count and write, T(time)=O(n), T(space) = O(1)
 * 2 - three way partition
 */

fun sort_0_1_2(a: Array<Int>): Array<Int>{
    var l = 0
    var m = 0
    var h = a.size - 1

    while( m <= h){
        if(a[m] == 0){
            swap(a, m, l)
            m++
            l++
        } else if(a[m] == 1){
            m++
        } else {
            swap(a, m, h)
            h--
        }
    }

    return a
}