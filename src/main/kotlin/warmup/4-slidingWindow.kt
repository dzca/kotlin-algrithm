package warmup

import java.util.*
import kotlin.collections.ArrayDeque

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

/**
 * Trap water problem
 *
 * given an array represent building heights and each building width is one.
 * compute how much water the array can hold
 *
 * example:
 * a = {0,1,0,2,1,0,1,2,1,2,1} => 6
 *
 * water at i: f(i) = min(lm, rm) - a[i]
 */

fun trapWater1(a: IntArray): Int{
    val n = a.size

    var w = 0
    for(i in 0..n-1){
        var lm = 0
        for(j in i downTo 0){
            lm = max(a[j], lm)
        }

        var rm = 0
        for(j in i .. n-1){
            rm = max(a[j], rm)
        }

        var k = min(rm, lm) - a[i]

        println("current water a[$i] = $k")
        w += k
    }

    return w
}

/**
 * create boundary in array before compute
 */
fun trapWater2(a: IntArray): Int {
    val n = a.size

    var lma = IntArray(n)
    var rma = IntArray(n)

    lma[0] = a[0]
    for(i in 1..n-1){
        lma[i] = max(lma[i-1], a[i])
    }

    rma[n-1] = a[n-1]
    for(i in n-2 downTo 0){
        rma[i] = max(rma[i+1], a[i])
    }

    var w = 0
    for(i in 0..n-1){
        w = w + min(lma[i], rma[i]) - a[i]
    }

    return w
}

/**
 * By stack
 */
fun trapWater3(a: IntArray): Int {
    val n = a.size
    var i = 0
    var w = 0
    var m: Int
    val s = ArrayDeque<Int>()
    while(i < n){
        while(s.isNotEmpty() && a[i] > a[s.last()]){
            m = s.removeLast()
            println("pop($m)")
            if(s.isEmpty()) break

            var l = i - s.last() - 1
            var h = min(a[i], a[s.last()])-a[m]

            println("i=$i, dw =$l * $h, last=${s.last()}")
            w += l * h
        }
        s.addLast(i)
        i++
        println("s = ${s.toString()}")
    }
    return w
}

/**
 * two pointer approach
 */
fun trapWater4(a: IntArray): Int {

    return 1
}

/**
 * find the longest substring without repeat
 *
 * s= "abcbbcab" -> 3
 * s= "bbbbb" -> 1
 */

fun longestSubstring1(s: String, n: Int) :Int{
    var r = 0
    var i = 0

    while (i < s.length){
        var a = BooleanArray(n){ false }
        var j = i

        while(j < s.length && !a[s[j].code]){
            // why not r++? because we cannot reset r in outer while loop
            a[s[j].code] = true
            j+=1
            r = max(r, j-i)
        }
        println("s[$i]=${s[i]}, s[$j-1]=${s[j-1]}, r=$r")
        // found repeat
        a[s[i].code] = false
        i+=1
    }

    return r
}

/**
 * n - size of the lookup table
 */
fun longestSubstring2(s: String, n: Int) :Int{
    var x = 0 // substring size
    var l = 0 // left index
    var r = 0 // right index

    var a = BooleanArray(n){false}

    if(s.length == 0) return 0

    while(l < s.length && r < s.length){
        if(a[s[r].code] == false){
            a[s[r].code] = true
            r+=1
            x=max(x, r-l)
        } else {
            a[s[l].code] = false
            l+=1
        }
    }

    return x
}

/**
 * Q6: Distinct elements in window
 *
 * given an array a[] of size n and window size k, count distinct elements in
 * every k sized window.
 *
 * a = {1,1,1,3,4,2,3} k=4 => [2,3,4,3]
 *
 * 1.[1,1,1,3] distinct = 2
 * 2.[1,1,3,4] distinct = 3
 * 3.[1,3,4,2] distinct = 4
 * 4.[3,4,2,3] distinct = 2
 */

fun windowK1(a: IntArray, k:Int): IntArray{
    val n = a.size
    val r = IntArray(n-k+1)
    for(i in 0..n-k){
        var t = 0

        for(j in i.. (i+k-1)){
            t+=1
            // check if a[j] repeated
            for(x in j-1 downTo i){
                if(a[j] == a[x]) {
                    t -= 1
                    // one repeat only
                    break
                }
            }
        }
        r[i] = t
    }

    return r
}

/**
 * use hash set
 *
 * f(time) = k * O(n)
 * f(space) = k
 */
fun windowK2(a: IntArray, k:Int): IntArray{
    val n = a.size
    val r = IntArray(n-k+1)

    for(i in 0..n-k){
        val m = HashSet<Int>()
        var d = 0
        for(j in i..(i+k-1)){
            if(!m.contains(a[j])){
                m.add(a[j])
                d+=1
            }
        }
        r[i] = d
    }
    return r
}

/**
 * use hash table to store frequency
 * use 2 pointer to control window.
 */
fun windowK3(a: IntArray, k:Int): IntArray{
    val n = a.size
    val r = IntArray(n-k+1)

    // k = number, v = frequency
    val t = Hashtable<Int, Int>()
    var d = 0 // number of distinct
    // count hash table for 1st window
    for(i in 0..k-1){
        // println("i=$i, a[$i]=${a[i]}")
        if(!t.containsKey(a[i])) {
            d += 1
        }
        t[a[i]] = t[a[i]]?.plus(1)?: 1
    }
    r[0] = d

    println("r=${r.contentToString()}, t=$t")
    for(i in 1..n-k){
        var j = i + k -1
        // remove 1st one to shift window
        if(t[a[i-1]] == 1){
            t.remove(a[i-1])
            d-=1
        }else {
            t[a[i-1]] = t[a[i-1]]?.minus(1)
        }

        println("i=$i, t=$t, a[$j]=${a[j]}")
        if(!t.containsKey(a[j])){
            d+=1
        }
        t[a[j]] = t[a[j]]?.plus(1)?:1

        r[i] = d

        println("r=${r.contentToString()}, t=$t, d=$d")
    }
    println("done")
    return r
}

/**
 * Q7 max continuous of 1s
 *
 * find max number of consecutive 1's, if you can flip at most k 0's
 *
 * a = {1,0,0,1,1,0,1,0,1,1,1} k=2, r=8
 * a = {110101001} k=1, r=4
 */
fun maxContinuousOnesFlip1(a: IntArray, k: Int): Int{
    val n = a.size
    var m = 0 // max number

    for(i in 0..n-1){
        var j = i
        var z = k // zero counter

        while(j<n){
            if(a[j]==0){
                if(z>0){
                    z-=1
                } else {
                    break
                }
            }
            j++
        }
        m = max(m, j-i)
    }
    return m
}

fun maxContinuousOnesFlip2(a: IntArray, k: Int): Int {
    val n = a.size
    var m = 0 // max number

    var z = 0 // zero count
    var l = 0
    for(r in 0..n-1){
        if(a[r]==0){
            z++
        }

        if(z > k){
            if(a[l]==0){
                z--
            }
            l++
        }
        m = max(m, r-l+1)
        println("z=$z l=$l, r=$r, m=$m")
    }
    return m
}
/**
 * Q8 max consecutive ones
 *
 * a = {110111001} => 3
 * a = {011110011} => 4
 * a = {1111} => 4
 * a = {00101} => 1
 */
fun maxContinuousOnes1(a: IntArray): Int{
    val n = a.size
    var m = 0
    for(i in 0 until n){
        var t = 0
        if(a[i]==1){
            for(j in i until n){
                if(a[j]==1){
                    t++
                } else {
                    break
                }
            }
            m = max(m, t)
        }
    }
    return m
}

/**
 * user counter
 */
fun maxContinuousOnes2(a: IntArray): Int{
    val n = a.size
    var m = 0

    var t = 0 // 1 counter
    for(r in 0 until n){
        if(a[r]==0) {
            t = 0
        } else {
            t++
        }
        m = max(m, t)
    }
    return m
}

/**
 * use l and r pointer
 */
fun maxContinuousOnes3(a: IntArray): Int {
    val n = a.size
    var m = 0

    var l = 0

    while(l < n){
        println("l=$l")
        if(a[l]==0){
            l+=1
        } else {
            var r = l
            while(r < n-1 && a[r+1]==1){
                r+=1
            }
            println("m=$m, r=$r")
            m = max(m, r-l+1)
            l = r +1
        }
    }
    return m
}

/**
 * Q9 N repeated elements
 *
 * given an array of size 2n(n>1), there are n+1 unique elements.
 * and exactly one item x is repeated n times. find item x
 *
 * example:
 * a = {1,2,2,3} r=2
 * a = {2,1,2,5,3,2,2,4} r=2
 * a = {5,1,5,2,5,3,5,4,6,5} r=5
 */

/**
 * hash table
 * f(time)=O(n) f(space)=O(n)
 */
fun repeatedN1(a: IntArray): Int{
    val m = 0
    val n = a.size
    var i = 0

    val t = WeakHashMap<Int, Int>()
    while(i < n){
        t[a[i]] = t[a[i]]?.plus(1)?:1
        t[a[i]]?.let{
            if(it > 1){
                return a[i]
            }
        }
        i+=1
    }
    return -1
}

/**
 * pigeon hole
 * f(time)=O(n) f(space)=O(n)
 */
fun repeatedN2(a: IntArray): Int{
    val m = 0

    return m
}