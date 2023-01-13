
data class Person(var firstName: String="Dustin", var age: Int = 10)

fun main(args: Array<String>) {

    val person = Person()

    /////////////////////////
    // let return value
    val name: String? = "I love Kotlin!!"

    val lengthOfString = name?.let{
        println(it.reversed())
        println(it.length)
        "OK"
    }
    println(lengthOfString)

    val p = person?.let{
        it.age +=5
        it
    }
    println("p.age=${p.toString()}")
    // with return value

    val personInfo = with (person){
        println(this.firstName)
        println(this.age)
        age += 10
        this
        //"I love the game of football"
    }
    println(personInfo)
   // println(personInfo +",age->"+ person.age)

    /////////////////////////
    // run return value
    val person1: Person? = Person()
    val bio = person1?.run {
        println(name)
        println(age)
        "LogRocket rocks!!!"
    }
    println("bio=$bio")

    /////////////////////////
    // apply
    val p2 = Person()
    val li = p2.apply {
        firstName = "Li"
        age = 32
    }
    println("li=$li")

    /////////////////////////
    // also
    val numbers = mutableListOf("one", "two", "three")
    val x = numbers
        .also {
            println("The list elements before adding new one: $it")
            numbers.add("four")
            it.add("five")
        }

    println("x=$x")
}