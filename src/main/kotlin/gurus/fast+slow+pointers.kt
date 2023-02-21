package gurus

data class ListNode<T>(
    var v: T,
    var next: ListNode<T>? = null){

    override fun toString(): String {
        return if(next!= null) "$v -> ${next.toString()}" else "$v"
    }
}

class LinkedList<T>(a: Array<T>){

    private var head: ListNode<T>? = null

    private var size = 0

    init{
        for(x in a){
            addLast(x)
        }
    }

    fun addFirst(v: T){
        head = ListNode(v = v, next = head)
        size++
    }

    fun isEmpty() = size == 0
    fun addLast(v: T){
        if(isEmpty()){
            head = ListNode(v = v)
            size++
            return
        }
        var p = head
        while(p?.next != null){
            p = p.next
        }
        p?.let {
            it.next = ListNode(v = v)
            size++
        }
    }

    fun getHead(): ListNode<T>?{
        return head
    }

    fun hasCycle(): Boolean {
        var fast = head
        var slow = head

        while(fast?.next != null){
            fast = fast?.next?.next
            slow = slow?.next

            if (slow == fast)
                return true
        }
        return false
    }

    fun findCycleSize(): Int{
        var fast = head
        var slow = head

        while(fast?.next != null){
            fast = fast?.next?.next
            slow = slow?.next

            if (slow == fast)
                return countCycleSize(slow)
        }
        return 0
    }

    private fun countCycleSize(start: ListNode<T>?): Int{
        var c = 0
        var p = start
        do {
            p = p?.next!!
            c++
        } while (p != start)
        return c
    }
    /**
     * Given the head of a Singly LinkedList, write a method to
     * return the middle node of the LinkedList.
     * If the total number of nodes in the LinkedList is even,
     * return the second middle node.
     */
    fun findMiddle(): ListNode<T>?{
        var fast = head
        var slow = head
        while(fast?.next != null){
            fast = fast?.next?.next
            slow = slow?.next
        }
        return slow
    }

    /**
     * Given the head of a Singly LinkedList that contains a cycle,
     * write a function to find the starting node of the cycle.
     */
    fun findCycleStart(): ListNode<T>?{

        val k = findCycleSize()
        var p1 = head
        var p2 = move(head, k)

        while(p1 != p2){
            p1 = p1?.next
            p2 = p2?.next
        }

        return p1
    }

    /**
     * find next k nodes from node p
     */
    fun move(s: ListNode<T>?, k: Int): ListNode<T>?{
        var p = s
        for(i in 1..k){
            p = p!!.next
        }
        return p
    }
}

/**
 * happy number
 */
fun happyNumber(v: Int) : Boolean {
    // p1 - slow pointer, p2 - faster pointer
    var p1 = v
    var p2 = v

    do {
        p1 = squareSum(p1)
        p2 = squareSum(squareSum(p2))
    } while(p1!=p2)

    return p1 == 1
}

fun squareSum(v: Int): Int{
    var s = 0
    var n = v
    while(n > 0){
        val x = n % 10
        s += (x * x)
        n /= 10
    }
    return s
}