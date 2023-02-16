package monster

import java.util.stream.Collectors


/**
 * Hearts, Spades, Clubs, Diamonds
 */
enum class Suit{ HEARTS,SPADES, CLUBS, DIAMONDS}



class CardGame{

    // k = name (e.g. A,2,J,K), v = rank
    private val ranks = HashMap<String, Int>()

    // k = rank, v = name (e.g. A,2,J,K)
    private val values = HashMap<Int, String>()

    private val cards = ArrayList<Card>()

    data class Card(val suit: String, val rank: Int) : Comparable<Card>{
        override fun compareTo(other: Card): Int {
            return this.rank.compareTo(other.rank)
        }
    }

    init {
        initRankTable()
        initValueTable()
    }

    private fun initRankTable(){
        var i = 0

        for(i in 2..10){
            ranks.put(i.toString(), i)
        }

        for(c in "JQKA"){
            i += 1
            ranks.put(c.toString(), i)
        }
    }

    private fun initValueTable(){
        ranks.forEach{ (k, v)->
            values.put(v, k)
        }
    }

    fun addCard(suit:String, name: String){
        val rank = ranks[name]
        cards.add(Card(suit, rank!!))
    }

    /**
     * e.g. 3 of Spades
     */
    fun cardString(id: Int): String{
        val card = cards[id]
        val name = values[card.rank]
        return "$name of ${card.suit}"
    }

    /**
     * dose card a beats b
     */
    fun cardBeats(a: Int, b: Int): Boolean{
        return cards[a] > cards[b]
    }
}

// enum class Size { SMALL, MEDIUM, LARGE}

enum class Size(val size: Int) {
    SMALL(1),
    MEDIUM(2),
    LARGE(3)
}

// val s = Size.SMALL.size

class Parking(val n: Int, val ins: Array<Array<String>>){
    data class Car(
        val size: String,
        val color: String,
        val brand: String){

        override fun toString(): String {
            return "$size $color $brand"
        }
    }

    val slots = arrayOfNulls<Car>(n)
    var freeSpots = n

    init{
        parseIns()
    }

    private fun parseIns(){
        for(c in ins){
            when(c[0]){
                "park" -> park(c[1].toInt(), Car(c[2], c[3],c[4]))
                "print" -> print(c[1].toInt())
                "freeSpots" -> printFreeSpots()
            }
        }
    }
    /**
     * If the given spot is unavailable, the car will try to park
     * at the next spot in order until it finds an available slot,
     * or there are no more slots left
     */
    fun park(spot: Int, car: Car){
       // println("parking $car")
        for(i in spot until n) {
            if (slots[i] == null) {
                slots[i] = car
               // println("parked $car")
                freeSpots -= 1
                break
            }
        }
    }

    fun remove(spot: Int){
        slots[spot]?.let{
            slots[spot] = null
            freeSpots += 1
        }
    }

    fun print(spot: Int){
        if(slots[spot] == null){
            println("Empty")
        } else {
            println(slots[spot])
        }
    }

    fun printFreeSpots(){
        println("$freeSpots")
    }
}
