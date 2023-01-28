package practice

/**
 * split the array into 2 parts and match the k
 *
 * k will be find in m
 */
fun binarySearch(a: Array<Int>, k: Int, l: Int, r: Int): Int{
     if(l > r) return -1

     var m = l + (r-l)/2
     println("l=$l, r=$r, m=$m")
     if(a[m] == k) return m
     return if(a[m] > k){
         binarySearch(a, k, l, m -1)
     } else {
         binarySearch(a, k, m+1, r)
     }
}
