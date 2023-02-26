package gurus

/**
 * questions to find islands
 */

fun countIslandsDFS(a: Array<Array<Int>>): Int {
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

fun countIslandsBFS(a: Array<Array<Int>>): Int{
    val c = a.size -1
    val r = a[0].size -1

    var x = 0
    for(i in 0..c){
        for(j in 0..r){
            if(a[i][j] == 1){
                x++
                println("add bfs $i, $j")
                findIslandBFS(a, i, j)
            }
        }
    }
    return x
}

fun findIslandBFS(a: Array<Array<Int>>, x:Int, y:Int){
    println("bfs push $x, $y")
    val q = ArrayDeque<Array<Int>>()
    q.addLast(arrayOf(x, y))


    while(q.size > 0){
        println("q size= ${q.size}")
        val x = q.removeFirst()
        val i = x[0]
        val j = x[1]
        println("bfs pop $i, $j, ${a[0].size}")

        if(i< 0 || i >= a.size || j <0 || j>=a[0].size){
            continue
        }

        if(a[i][j] == 1){
            println("bfs found $i, $j, q.size=${q.size}")
            a[i][j] = 0
        } else {
            continue
        }
        q.addLast(arrayOf(i-1,j))
        q.addLast(arrayOf(i+1,j))
        q.addLast(arrayOf(i,j-1))
        q.addLast(arrayOf(i,j+1))
    }
    println("exit while")
}