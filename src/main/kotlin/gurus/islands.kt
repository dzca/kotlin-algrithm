package gurus

/**
 * questions to find islands
 */

fun countIslands(a: Array<Array<Int>>): Int {
    val c = a.size -1
    val r = a[0].size -1
    var x = 0 // count of islands
    for(i in 0..c){
        for(j in 0 .. r){
            // println("$i, $j, v = ${a[i][j]}")
            if(a[i][j] ==1){
                x++
                findIslandDFS(a, i, j)
            }
        }
    }
    return x
}

fun findIslandDFS(a:Array<Array<Int>>,i: Int, j:Int){
    if(i< 0 || i >= a.size || j <0 || j>=a[0].size){
        return
    }
    if(a[i][j] == 1){
        a[i][j] = 0
    } else {
        return
    }
    findIslandDFS(a, i-1, j)
    findIslandDFS(a, i+1, j)
    findIslandDFS(a, i, j+1)
    findIslandDFS(a, i, j-1)
}