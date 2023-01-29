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