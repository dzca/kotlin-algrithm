package leet

/**
 * - hard
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that
 * every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 */
fun minWindow(a: String, b: String): String{

    return a
}

fun max(a: Int, b: Int): Int {
    return if(a>b) a else b
}

/**
 * - easy
 * hash map impl
 */
fun longestSubStr1(s: String): Int {
    val t = HashMap<Char, Int>()
    var m = 0
    var l = 0
    var r = 0
    var n = s.length

    if(n==0) return 0

    while(r < n && l <= r){

        if(t.contains(s[r])){
            t.remove(s[l])
            l +=1
        } else {
            t.put(s[r], r)
            m = max(m, r-l + 1)
            r +=1
        }
    }

    return m
}

fun contains(s: String, c: Char, l:Int, r:Int): Boolean{
    for(i in l..r){
        if(s[i] == c)
            return true
    }
    return false
}

/**
 * tow pointer impl
 */
fun longestSubStr2(s: String): Int {

    var m = 0
    var l = 0
    var r = 0
    var n = s.length
    if(n <=0) return n

    while(r in l until n){
        if(contains(s, s[r], l, r-1)){
            l +=1
        } else {
            m = max(m, r-l + 1)
            r +=1
        }
    }

    return m
}

/**
 * - medium
 * Given an array of positive integers nums and a positive integer
 * target, return the minimal length of a subarray whose sum is
 * greater than or equal to target. If there is no such subarray,
 * return 0 instead.
 *
 * Input: target = 7, nums = [2,3,1,2,4,3] Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Input: target = 4, nums = [1,4,4] => 1
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1] => 0
 */

fun min(a: Int, b: Int):Int{
    return if(a>b) b else a
}

/**
 * v1 - 2 pointer
 */
fun minSubArrayLen(k: Int, a: IntArray): Int {
    val n = a.size
    var m = 0

    if(n == 1) return if(a[0]>=k) 1 else 0

    var l = 0
    var r = 0
    var s = a[0]
    while(l < n){

        if(s >= k){
            if(m > 0){
                m = min(m, r-l+1)
            } else {
                m = r-l+1
            }
            s=s-a[l]
            l+=1
        } else {
            if(r == n-1 && s < k){
                return m
            } else {
                r+=1
                s+=a[r]
            }
        }
    }

    return m
}

/**
 * answer
 */
fun minLen(k:Int, a: IntArray):Int{
    var m = 0
    val n = a.size
    var l = 0
    var s = 0
    for(i in 0 until n){
        s += a[i]
        while(s >= k){
            if(m > 0){
                m = min(m, i-l+1)
            } else {
                m = i-l+1
            }

            s -= a[l]
            l+=1
        }
    }

    return m
}