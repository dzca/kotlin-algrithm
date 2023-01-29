package practice

/**
 * split the array into 2 parts and match the k
 *
 * k will be find in m
 */
fun binarySearch(a: Array<Int>, k: Int, l1: Int, r1: Int): Int{
    var l = l1
    var r = r1
    while(l <= r){
        var m = l + (r-l)/2

        if(a[m] == k) return m
        if(a[m] < k){
            l = m + 1
        } else {
            r = m - 1
        }
    }
    return -1
}
