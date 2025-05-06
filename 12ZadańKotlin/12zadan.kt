import kotlin.math.PI
fun main() {
    /**
     * Exercise1: Complete the code to make the program print "Mary is 20 years old" to standard output:
     * fun main() {
     * val name = "Mary"
     * val age = 20
     * // Write your code here
     * }
    */

    fun zad1() {
    val name = "Mary"
    val age = 20
    println("$name is $age years old")
    }

    /**
     * Exercise2: Explicitly declare the correct type for each variable:
     *
     * ```
     * fun main() {
     *     val a: Int = 1000
     *     val b = "log message"
     *     val c = 3.14
     *     val d = 100_000_000_000_000
     *     val e = false
     *     val f = '\n'
     * }
     * ```
     */
    fun zad2() {
        val a: Int = 1000
        val b: String = "log message"
        val c: Double = 3.14
        val d: Long = 100_000_000_000_000
        val e: Boolean = false
        val f: Char = '\n'
    }

    /**
     * Exercise3: You have a list of “green” numbers and a list of “red” numbers.
     * Complete the code to print how many numbers there are in total.
     *
     * ```
     * fun main() {
     *     val greenNumbers = listOf(1, 4, 23)
     *     val redNumbers = listOf(17, 2)
     *     // Write your code here
     * }
     * ```
     */
    fun zad3() {
        val greenNumbers = listOf(1, 4, 23)
        val redNumbers = listOf(17, 2)
        val totalCount = greenNumbers.count() + redNumbers.count()
        println(totalCount)
    }

    /**
     * Exercise4: You have a set of protocols supported by your server.
     * A user requests to use a particular protocol. Complete the program to check whether the requested protocol
     * is supported or not (isSupported must be a Boolean value).
     *
     * ```
     * fun main() {
     *     val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
     *     val requested = "smtp"
     *     val isSupported = // Write your code here
     *     println("Support for $requested: $isSupported")
     * }
     * ```
     */
    fun zad4() {
        val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
        val requested = "smtp"
        val isSupported = requested.uppercase() in SUPPORTED
        println("Support for $requested: $isSupported")
    }

    /**
     * Exercise5: Define a map that relates integer numbers from 1 to 3 to their corresponding spelling.
     * Use this map to spell the given number.
     *
     * ```
     * fun main() {
     *     val number2word = // Write your code here
     *     val n = 2
     *     println("$n is spelt as '${<Write your code here>}'")
     * }
     * ```
     */
    fun zad5() {
        val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
        val n = 2
        println("$n is spelt as '${number2word[n]}'")
    }

    /**
     * Exercise6: Using a when expression, update the following program so that it prints the corresponding actions when you input the names of game console buttons.
     *
     * Button  | Action
     * ------- | --------
     * A       | Yes
     * B       | No
     * X       | Menu
     * Y       | Nothing
     * Other   | There is no such button
     *
     * ```
     * fun main() {
     *     val button = "A"
     *     println(
     *         // Write your code here
     *     )
     * }
     * ```
     */
    fun zad6() {
        val button = "A"
        println(
            when (button) {
                "A" -> "Yes"
                "B" -> "No"
                "X" -> "Menu"
                "Y" -> "Nothing"
                else -> "There is no such button"
            }
        )
    }

    /**
     * Exercise7: You have a program that counts pizza slices until there’s a whole pizza with 8 slices.
     * Refactor this program in two ways:
     * 1. Use a while loop.
     * 2. Use a do-while loop.
     *
     * ```
     * fun main() {
     *     var pizzaSlices = 0
     *     // Start refactoring here
     *     pizzaSlices++
     *     println("There's only $pizzaSlices slice/s of pizza :(")
     *     pizzaSlices++
     *     println("There's only $pizzaSlices slice/s of pizza :(")
     *     pizzaSlices++
     *     println("There's only $pizzaSlices slice/s of pizza :(")
     *     pizzaSlices++
     *     println("There's only $pizzaSlices slice/s of pizza :(")
     *     pizzaSlices++
     *     println("There's only $pizzaSlices slice/s of pizza :(")
     *     pizzaSlices++
     *     println("There's only $pizzaSlices slice/s of pizza :(")
     *     pizzaSlices++
     *     println("There's only $pizzaSlices slice/s of pizza :(")
     *     pizzaSlices++
     *     // End refactoring here
     *     println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
     * }
     * ```
     */
    fun zad7() {
        var pizzaSlices = 0
        while ( pizzaSlices < 7 ) {
            pizzaSlices++
            println("There's only $pizzaSlices slice/s of pizza :(")
        }
        pizzaSlices++
        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    }


    fun zad7a() {
        var pizzaSlices = 0
        pizzaSlices++
        do {
            println("There's only $pizzaSlices slice/s of pizza :(")
            pizzaSlices++
        } while ( pizzaSlices < 8 )
        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    }

    /**
     * Exercise8: Write a program that simulates the FizzBuzz game.
     *
     * Print numbers from 1 to 100 incrementally:
     * - Replace any number divisible by 3 with the word "fizz".
     * - Replace any number divisible by 5 with the word "buzz".
     * - Replace any number divisible by both 3 and 5 with the word "fizzbuzz".
     *
     * Hints:
     * - Use a for loop to iterate over the numbers.
     * - Use a when expression to choose what to print.
     * - Use the modulo operator (%) to check divisibility.
     */
    fun zad8() {
        for (number in 1..100) {
            println(
                when {
                    number % 15 == 0 -> "fizzbuzz"
                    number % 3 == 0 -> "fizz"
                    number % 5 == 0 -> "buzz"
                    else -> "$number"
                }
            )
        }
    }

    /**
     * Exercise9: You have a list of words. Use a `for` loop and an `if` statement
     * to print only the words that start with the letter 'l'.
     *
     * Hint:
     * - Use the `.startsWith()` function for `String` to check the first letter.
     */
    fun zad9() {
        val words = listOf("dinosaur", "limousine", "magazine", "language")
        for (w in words) {
            if (w.startsWith("l")) {
                println(w)
            }
        }
    }
    /**
     * Exercise10: Write a function called `circleArea` that takes the radius of a circle (as an `Int`)
     * and returns the area of that circle as a `Double`.
     *
     * - Use the `PI` constant from `kotlin.math`.
     * - The area of a circle is calculated as π * radius².
     * - Example: `circleArea(2)` should return approximately 12.566.
     *
     * Note:
     * - If you use curly braces `{}` to define the function body, you must explicitly declare the return type.
     */
    fun circleArea(radius: Int): Double {
        return PI * radius * radius
    }

    fun zad10() {
        println(circleArea(2)) // 12.566370614359172
    }
    /**
     * Exercise11: Rewrite the `circleArea` function as a single-expression function.
     *
     * - Use the `PI` constant from `kotlin.math`.
     * - A single-expression function can omit curly braces and the `return` keyword.
     * - The return type still needs to be specified.
     *
     * Example:
     * ```kotlin
     * fun circleArea(radius: Int): Double = PI * radius * radius
     * ```
     */

    fun zad11() {
        println(circleArea(2)) // 12.566370614359172
    }

    /**
     * Exercise12: You have a function that translates a time interval given in hours, minutes, and seconds into seconds.
     *
     * - Use default parameter values so that callers can provide only the arguments they need.
     * - Use named arguments to improve readability at the call site.
     *
     * Formula:
     * (hours * 60 + minutes) * 60 + seconds
     *
     * Example usage:
     * - `intervalInSeconds(1, 20, 15)` → 4815
     * - `intervalInSeconds(minutes = 1, seconds = 25)` → 85
     * - `intervalInSeconds(hours = 2)` → 7200
     */
    fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0): Int =
        ((hours * 60) + minutes) * 60 + seconds

    fun zad12() {
        println(intervalInSeconds(1, 20, 15))                // 4815
        println(intervalInSeconds(minutes = 1, seconds = 25)) // 85
        println(intervalInSeconds(hours = 2))                 // 7200
        println(intervalInSeconds(minutes = 10))              // 600
        println(intervalInSeconds(hours = 1, seconds = 1))    // 3601
    }


    zad1()
    zad3()
    zad4()
    zad5()
    zad6()
    zad7()
    zad7a()
    zad8()
    zad9()
    zad10()
    zad11()
    zad12()

}
