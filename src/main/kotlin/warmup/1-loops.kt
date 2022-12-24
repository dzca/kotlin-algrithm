package warmup

/**
 * 1. given hight of buildings in array, count the number of buildings facing the sunset.
 *
 * e.g.
 *
 * height[] = [7,4,8,2,9] out=3. 7,8,9 can see sunset
 *
 * - find size of array: size_t n = sizeof(a)/sizeof(a[0])
 * - time = O(n), space = O(1)
 */

/**
 * - for(i in 1..a.size)
 * - a: Array<Int>
 * - val a1 = arrayOf(7,4,8,2,9)
 * - println("i=$i v=${a[i]}")
 */
fun faceSun(a : Array<Int>): Int {
    var r = 1
    var p = a[0] // point to highest building
    for(i in 1..a.size -1){
        if(a[i] > p ){
            p = a[i]
            r++
        }
    }
    return r
}

/**
 * 2. an element is a leader if it is strictly greater than all element
 * to its right side
 *
 * given an integer array a[] of size n, find the leader.
 *
 * [2, 7, 8, 3, 5 6, 1, 4, 5] => [8, 6, 5]
 * [16, 17, 4, 3, 5, 2] => [17, 5, 2]
 * [6,5,4,3,2,2,1] => [6, 5, 4, 3, 2, 1]
 * [1,2,3,4,5,6] => [6]
 */

/**
 * - for downwards: for(i in a.size - 2 downTo 0)
 * - Arrays.toString(a1)
 */
fun leaders(a: Array<Int>): Array<Int>{
    var r = arrayOf<Int>()

    var v = a[a.size -1]
    r+=v
    for(i in a.size - 2 downTo 0){
        if(a[i] > v){
            // println("a[$i] = ${a[i]}, v = $v")
            v = a[i]
            r+=v
        }
    }
    return r.reversedArray()
}

/**
 * 3. array is a valid mountain when it is first strictly increasing and then strictly decrease.
 *
 * e.g.
 *
 * [5, 2, 1, 4] => false
 * [5, 8, 8] => false
 * [1, 2, 6, 5, 3] => true
 */

fun isMountain(a: Array<Int>): Boolean {
    var n = a.size

    var i = 0
    // check upwards
    while (i < n - 1 && a[i] < a[i + 1]) {
        i++
    }
    // check items for downwards
    if (i == 0 || i == n - 1) return false

    // check downward
    while (i < n - 1 && a[i] > a[i + 1]) {
        i++
    }

    return i == n - 1
}

/**
 * 4. Roman value convert
 *
 * I=1
 * V=5
 * X=10
 * L=50
 * C=100
 * D=500
 * M=1000
 *
 * - input contains only I,V,X,L,C,D,M
 * - input in range [1,3999]
 * - avoid 4 chars being repeated, IV=4=5-1, IX=9, when smaller
 *      number is before large number,value is substracted.
 * - a number are characters written in descending order e.g. XII=12 XX+V+II=27
 *
 * example:
 *
 * XL => 40 (50-10)
 * MCMIV => 1904 (1000+ 900 + 4)
 * LVIII => 58 (50 + 8)
 * MCMXCIV => 1994 (M=1000 CM=900, XC=90, IV=4)
 *
 * - time=O(n), space = O(1)
 */

fun r2int(c: Char): Int{
    return when(c){
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> -1
    }
}

fun int2r(i: Int): String{
    return when(i){
        1000 -> "M"
        else -> "N"
    }
    return ""
}

/**
 * - while
 * - - when(){ x -> else -> }
 */
fun roman2int(s: String): Int{
    val n = s.length
    var r = 0

    // if n+1 exist,compare and compute, else accumulate
    var i = 0
    while(i <= n-1){
        var v1 = r2int(s[i])
        if(i < n-1){
            var v2 = r2int(s[i+1])
            if(v1<v2){
                r += (v2-v1)
                i++
            }else {
                r += v1
            }
        } else {
            r+=v1
        }
        i++
    }

    return r
}

/**
 * power function for Int
 */
fun pow(base:Int, exponent:Int): Int {
    var r = 0
    var exp = exponent

    if (exp != 0) {
        while (exp > 0) {
            r *= base
            exp--
        }
    }
    return r
}

/**
 * fn(3949) => MMMCMXLIX
 *  3000/1000(M) => MMM
 *  900/100(C) => CM
 */
fun int2Roman(v: Int): String{
    // M = 1000
    val RN_M = arrayOf("", "M", "MM", "MMM")
    // C = 100, D = 500
    val RN_C = arrayOf("", "C", "CCC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    // X = 10, L = 50
    val RN_X = arrayOf("", "X", "XX", "XXX","XL","L","LX","LXX","LXXX","XC")
    // I = 1, V = 5
    val RN_I = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" )

    var r = ""
    r += RN_M[v / 1000]
    r += RN_C[v % 1000 / 100]
    r += RN_X[v % 100 / 10]
    r += RN_I[v % 10]

    return r
}

/**
 * the equilibrium index is an index such that sum of elements
 * at lower indexes is equal to sum of elements at higher index.
 *
 * sum(a[0]...a[i-1]) = sum(a[i+1]...a[n]), i=[0, n-1]
 *
 * - i = 0, sum(lower) = 0
 * - i = n-1, sum(higher) = 0
 *  example:
 *  a1 = {-7,1,5,2,-4,3,0} => 3
 *  a2 = {0,1,3 -2, -1} => 1
 *  a3 = {1,2,-2,-1} => -1 no equilibrium index
 */
fun equilibrium(a: Array<Int>): Int{
    var t = 0 // total sum
    var l = 0
    var x = -1
    for(v in a){
        t+=v
    }

    for(i in 0..a.size -1){
        var r = t - l - a[i]
        if(l == r)
            return i
        else
            l +=a[i]
    }
    return x
}

/**
 * given an array a of n (n>1), get array r where r[i] is product of all
 * elements of a except a[i].
 *
 * - solve problem without division operator
 *
 * example
 * a1 = {2,1,3,4} p1={12,24,8,6}
 * a2 = {5,2,8,4,5} p2={320,800,200,400,320}
 * a3 = {1,0,4,3,5} p3 ={0,60,0,0,0}
 * a4 = {1,1,1,1,1,1,1} p4 ={1,1,1,1,1,1,1}
 * a5 = {0,4,0,3} p5={0,0,0,0}
 *
 * 1) 2d loops O(n^2)
 * 2) prefix[] * suffix[] O(n)
 * 3) use p for both prefix[] and suffix[] in different stage
 */

fun prodArray(a: Array<Int>): Array<Int>{
    var p = arrayOf(1)

    for(i in 1 ..a.size - 1){
        // println("$i - ${a[i-1]} * ${p[i-1]}")
        p += (a[i-1] * p[i-1])
    }

    var s = 1
    for(i in a.size -1 downTo 0){
        p[i] = p[i] * s
        s *= a[i]
    }
    return p
}

/**
 * rotate matrix in counter clock wise
 *
 * ex1:
 * 1 2 3      3 6 9
 * 4 5 6  =>  2 5 8
 * 7 8 9      1 4 7
 *
 * ex2:
 *  1  2  3  4     4  8 12  6
 *  5  6  7  8     3  7 11 15
 *  9 10 11 12 =>  2  6 10 14
 * 13 14 15 16     1  5  9 13
 */
fun rotateMatrix(a: Array<Array<Int>>): Array<Array<Int>>{
    var r = arrayOf(arrayOf(1,2,3))

    return r
}

/**
 * Given a 2-d m x n matrix, print all the elements in spiral order.
 *
 *  1  2  3  4
 *  5  6  7  8
 *  9 10 11 12
 * 13 14 15 16
 *
 * => 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 */
fun spiralMatrix(a: Array<Array<Int>>): Array<Int>{
    var r = arrayOf(1,2,3)

    return r
}