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
}