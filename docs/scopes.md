In Kotlin, scope functions are used to execute a block 
of code within the scope of an object. Generally, you 
can use scope functions to wrap a variable or a set of 
logic and return an object literal as your result. 
Therefore, we can access these objects without their 
names. 

## let function
The let function has numerous applications, but it is 
generally used to prevent a NullPointerException from 
occurring. The let function returns the lambda result 
and the context object is the [it] identifier. 

fun main (){
    val name: String? = "I love Kotlin!!"
    
    val lengthOfString = name?.let{
        println(it.reversed)
        println(it.length)
    }
    println(lengthOfString)
}

## with function
The with function has a return type as the lambda result, 
and the context object is the [this] keyword, which refers 
to the object itself.

## run function
The run function returns the lambda result, 
and we refer to the context object by using 
the [this] keyword. The run function is a 
combination of the with and let functions.

## apply function
apply is a higher order function. The apply function 
returns a context object, and the context object returns this.

## also function
The also function is similar to the previous functions in 
that it is used to perform an operation on a particular 
object after it has been initialized. The also function 
returns the context object, and the context object can 
be referred to using the [it] identifier.