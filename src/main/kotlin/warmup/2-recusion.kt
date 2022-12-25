package warmup

/**
 * Module 4 is mainly about recursion
 */

/**
 * binary search
 *
 * find key from sorted array
 *
 * example:
 * a = arrayOf(-4,2,4,5,9,12)
 * key = 5, r = 3
 * key = 6, r = -1
 *
 * learn:
 * - Math.round() rounds up to the nearest Integer
 * which can be above or below or even equal to the actual value.
 * - Math.floor rounds up to the nearest Integer which
 * can be equal to or below the actual value.
 * - Math.ceil rounds up to the nearest Integer which can
 * be equal to or above the actual value.
 */

fun binarySearch(a: Array<Int>, k: Int, l: Int, r: Int): Int{

    println("$l, $r")

    return if(l > r){
        -1
    } else {
        val m = l + (r-l) / 2
        if(a[m] == k ) {
            println("found at $m")
            m
        } else if(a[m] > k){
            binarySearch(a, k, l, m - 1)
        } else {
            binarySearch(a,k, m + 1, r)
        }
    }
}

/**
 * loop implement
 */
fun binarySearchLoop(a: Array<Int>, k: Int, l1: Int, r1: Int): Int{
    var l = l1
    var r = r1
    while(l <= r){
        val m = l + (r-l) / 2
        if(a[m] == k ) {
            println("found at $m")
            return m
        } else if(a[m] > k){
            r = m - 1
        } else {
            l = m + 1
        }
    }
    return -1
}

/**
 * Find maximum in first increasing and then decreasing array
 *
 * example:
 * (18,110,210,452,810,500,101,13) => 810
 * (1,2,3,4,5) => 5
 */

fun findMax(a: Array<Int>, l: Int, r: Int): Int{
    val m = l + (r-l + 1)/2
    val x = a[m]
    // println("[$l, $r] => a[$m]=$x")
    // terminal condition
    return if((m == r && x > a[m-1])|| (x > a[m+1] && x > a[m-1])) {
        x
    } else if( x < a[m+1]){
        findMax(a, m+1, r)
    } else {
        findMax(a, l, m -1)
    }
}

/**
 * find the first and last position of a given value form a sorted
 * ascending order.
 *
 * return [-1,-1] if not found
 * time complexity is O(log n)
 *
 * (-1,1,2,2,2,5,6,12,12), 2 => [2,4]
 * (21,32,51,70,71), 70 => [3,3]
 */

/**
 * find the index of first match
 *
 * criteria of found:
 * 1)v == a[m]
 *  - m == 0 -> m
 *  - a[m-1] < v -> m
 * 2)a[m] >= v -> find(l,m-1)
 * 3)a[m] < v -> find(m+1, r)
 * return -1
 *
 */
fun findFirst(a:Array<Int>, v: Int, l:Int, r:Int): Int{
    if(l > r) return -1
    val m = l + (r - l)/2
    println("[$l, $r] => a[$m]=${a[m]}")

    return if((m==0 || a[m-1] < v) && a[m]==v)
        m
    else if(a[m] >= v) {
        findFirst(a, v, l, m-1)
    } else {
        findFirst(a, v, m+1, r)
    }
}

/**
 * find the index of last match
 *
 * criteria of found:
 * 1)v == a[m]
 *  - m == r -> m
 *  - a[m+1] > v -> m
 * 2)a[m] <= v -> find(m+1, r)
 * 3)a[m] > v -> find(l,m-1)
 * return -1
 *
 */
fun findLast(a:Array<Int>, v: Int, l:Int, r:Int): Int {

    if(l > r) return -1
    val m = l + (r-l)/2

    println("[$l, $r] => a[$m]=${a[m]}")

    return if((m==r || a[m+1] > v) && a[m]==v){
         m
    } else if(a[m] <= v) {
        findLast(a, v, m+1, r)
    } else {
        findLast(a, v, l, m-1)
    }
}

fun findFirstLast(a:Array<Int>, v: Int): Array<Int>{
    // find left
    val l = findFirst(a,v, 0, a.size -1)
    println("found l: $l")
    // find right
    val r = findLast(a,v, l, a.size -1)
    println("found r: $r")
    println("done")
    return arrayOf<Int>(l,r)
}


/**
 * Find min value in a rotated array
 * Array is rotated by k
 * - [n-k, n-1] items increase
 * - [0, n-k-1] values increase
 * - x[n-k-1]>x[0]>x[n-1]>x[n-k]
 *
 * example:
 * {5,6,7,8,9,1,2,3,4} => 1
 * {8,9,3,4,5,6,7} => 3
 * {5,6,7,8,9} => 5
 * {8,7}=> 7
 */

/**
 * a[l] is always greater than a[r] if array is rotated
 *
 * l < r
 * 1) a[l] < a[r] ->a[l]
 * 2) a[m] > a[r] -> find(m+1, r)
 * 3) a[m] < a[r] -> find(l,m)
 *
 * space O(1), time O(log n)
 */
fun minInRotatedArray(a: Array<Int>, l1: Int, r1: Int): Int{
    var l = l1
    var r = r1
    while(l < r){
        if(a[l]< a[r]) return a[l]
        val m = l + (r -l)/2

        if(a[m] > a[r]) l=m+1 else r=m
    }
    return a[l]
}

/**
 * Search a key in a sorted 2D [m x n] matrix
 *
 * examples:
 * 1) find 6 => true
 *   1, 2, 6, 7
 *  12,13,16,21
 *  23,35,36,48
 *
 * 2) find 7 => false
 *
 *  1, 2, 6
 * 12,13,16
 * 23,35,36
 *
 */

fun findInRow(a: Array<Array<Int>>, y:Int, r1:Int, k: Int): Boolean{
    var l = 0
    var r = r1

    while(l < r){
        val m = l + (r -l)/2
        println("col $m")
        if(a[y][m] == k) {
            println("found")
            return true
        } else if(a[y][m] > k) {
            r = m - 1
            println("move col r=> $r")
        } else {
            l = m
            println("move col l=> $l")
        }
    }

    return false
}

/**
 * find k in which row, then search that row with b search.
 * m = l + (r-l)/2
 * 1) a[l][0] < k && a[l][n-1] > k => findInRow()
 *
 *
 * 2) a[l][0]
 */
fun findInMatrix(a: Array<Array<Int>>,y:Int, x:Int, k: Int): Boolean {
    var l = 0
    var r = y - 1

    while(l <= r) {
        val m = l + (r-l)/2
        println("row $m")
        if(a[m][0] < k && a[m][x-1] >= k){
            return findInRow(a, m,  x, k)
        } else if(a[m][0] > k ){
            r = m - 1
            println("move row r=> $r")
        } else {
            l = m + 1
            println("move row l=> $l")
        }
    }

    return false
}

