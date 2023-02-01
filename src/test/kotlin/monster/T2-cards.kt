package monster

import org.junit.jupiter.api.Test

class TestP2{

    @Test
    fun `Test cards`(){

    }

    /**
     * n = 5
     * instructions = [
     *  ["park", "1", "Small", "Silver", "BMW"],
     *  ["park", "1", "Large", "Black", "Nissan"],
     *  ["print", "1"],
     *  ["print", "2"],
     *  ["print", "3"],
     * ]
     *
     * output ["Small Silver BMW","Large Black Nissan","Empty"]
     */
    @Test
    fun `test Parking`(){
        val ins = arrayOf(
            arrayOf("park", "1", "Small", "Silver", "BMW"),
            arrayOf("park", "1", "Large", "Black", "Nissan"),
            arrayOf("print", "1"),
            arrayOf("print", "2"),
            arrayOf("print", "3"),
            arrayOf("freeSpots")
            )
        val p = Parking(5, ins)
    }
}