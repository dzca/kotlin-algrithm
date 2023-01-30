package monster

/**
 * utility
 */
class ArrayConverter<T,V> {
    /**
     * covert each item T in source into array Type V
     */
    fun map(a: Array<T>, fn: (T) -> V): List<V>{
        return a.map(fn)
    }
}

fun intsToBools(a: Array<Int>): Array<Boolean>{
    val c = ArrayConverter<Int, Boolean>()
    val b = c.map(a) { x -> x != 0 }
    return b.toTypedArray()
}

/**
 * find the index of first true in an ordered boolean array
 *
 * example:
 * [false, false, true, true, true] => 2
 */
fun firstTrue(a: Array<Boolean>): Int{
    val n = a.size
    var l = 0
    var r = n-1
    var p = -1
    while(l <= r){
        var m = l + (r-l)/2

        if(a[m]) {
            p = m
            r = m -1
        } else {
            l = m + 1
        }
    }

    return p
}

/**
 * Given an array of integers sorted in increasing order and a target,
 * find the index of the first element in the array that is larger
 * than or equal to the target. Assume that it is guaranteed to find
 * a satisfying number.
 * fn( a[m] >= k )
 */
fun firstNoLessThan(a: Array<Int>, k: Int): Int{
    val n = a.size
    var l = 0
    var r = n - 1
    var p = -1
    while(l <= r){
        val m = l + (r-l)/2

        if(a[m] >= k) {
            p = m
            r = m - 1
        } else {
            l = m + 1
        }
    }

    return p
}

/**
 * Given a sorted array of integers and a target integer, find the
 * first occurrence of the target and return its index.
 * Return -1 if the target is not in the array.
 * example:
 * arr = [1, 3, 3, 3, 3, 6, 10, 10, 10, 100], target = 3, Output: 1
 */
fun firstMatch(a: Array<Int>, k: Int): Int{
    val n = a.size
    var l = 0
    var r = n - 1
    var p = -1
    while(l <= r){
        val m = l + (r-l)/2

        if(a[m] == k){
            p=m
            r = m - 1
        } else if(a[m] > k){
            r = m - 1
        } else {
            l = m + 1
        }
    }

    return p
}

/**
 * Given an integer, find its square root without
 * using the built-in square root function. Only
 * return the integer part (truncate the decimals).
 */
fun squareRoot(n: Int): Int{
    var l = 1
    var r = n
    var p = 0
    while(l <= r ){
        val m = l + (r-l)/2
        val t = m*m
        if(t == n) return m
        if(t > n){
            r = m - 1
        } else {
            p = m
            l = m + 1
        }
    }

    return p
}