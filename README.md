# Kotlin Algorithm

Project to prepare algorithm interview for android developer

## Getting started
- main folder is the practice code
- test folder is the test driver

### Stage 1: Warm up
- review the basic algorithm under package [warmup]
- use package [practice] to practice sorting and searching
- algorithm tutorial(https://www.enjoyalgorithms.com)

### Stage 2: algo monster
- follow course @ algorithm monster (https://algo.monster/)
- do coding in package[monster]

## Kotlin language gramma

### logics
- Elvis operator: m[c] = m[c]?.plus(1)?: 1
- null or default value: val x = t[a[i]] ?:0
  t[a[i]] = x.plus(1)
- Regex("[^\\w]")
- when(t){ x -> else -> }
- println(number shr 1) // divide by 2
- val m = Int.MAX_VALUE
- val m = Int.MIN_VALUE

### collections
- Length() tends to refer to contiguous elements - a string has a length for example.
- Count() tends to refer to the number of elements in a looser collection.
- size is the size of the container

### hashmap
- hashmap iterator for(k in m.keys){}
- val m = HashMap<Char, Int>()
- m.put(key, v), m.get(key), m.remove(key)
- v = m[key]
- m.clear()
- m.replace("Cap" , 999)
- m.containsKey(k)
- array to set: val t = a.toHashSet()


## hashset
- HashSet()
- add(e): Boolean, remove(e): Boolean, contains(e), clear()

### array 

init
=======
    val a: Array<String>
    val array = arrayOfNulls<String>(5)
    val b = Array<String>(10) {i -> ""}
- for (i in 0 until j)
- for (i in 0..j)
- for (i in K downTo 0)
- for(i in 1..a.size)
- for(j in b.indices){
- a: Array<Int>
- val a1 = arrayOf(7,4,8,2,9)
- Arrays.toString(a1), r.contentToString()
- a.reversedArray()
- a += item
- val b = intArrayOf(42,2,21) init by value
- val b = IntArray(size), Array<Int>: b.toTypedArray()
- a.copyOfRange(0, i+1) copy sub array exclusive [0, n] 
- IntArray is int[], Array<Int> is Integer[]
- val c = IntArray(k) { _ -> 0 }

### ArrayList
- val a: ArrayList<String> = ArrayList<String>()
- get,remove,size,

### stack and queue

- val stack = ArrayDeque(listOf(1, 2, 3)) // stack: [1, 2, 3]
- stack.addLast(0)                        // stack: [1, 2, 3, 0]         (push)
- val value = stack.removeLast()          // value: 0, stack: [1, 2, 3]  (pop)
- s.last()
- s. removeFirst()

### list 
- list.size
- list.subList(0,mid) [0, mid) new list
- list.slice(1..2) [1, 2] a view of original list
- list: List<Int>
- var newList : MutableList<Int> = mutableListOf()
- list.add(item)
- val numbers = mutableListOf(38,27,43,3,9,82,10)
- val a = listOf('1', '2', '3')

### string
- s.foreach {x -> }
