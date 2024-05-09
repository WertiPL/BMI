package com.s23141.kotlinexercises
import kotlin.math.PI
import kotlin.random.Random


//https://kotlinlang.org/docs/kotlin-doc.html#block-tags
//https://kotlinlang.org/docs/kotlin-reference.pdf


fun main() {

    println("Start Task 1")
    println(circleArea(2)) // ex1
    ex2()
    println("Start Task 3 \n")
    ex3()
    println("Start Task 4\n")
    ex4()
    println("Start Task 5\n")
    ex5()
    println("Start Task 6\n")
    ex6()
    println("Start Task 7\n")
    ex7()
    println("Start Task 8\n")
    ex8()
    println("Start Task 9\n")
    ex9()
    println("Start Task 10\n")
    ex10()
}

/**
 * Function practise
 * Exercise 1
 * Write a function called circleArea that takes the radius of a circle in integer format as a parameter and outputs the area of that circle.
 * import a package
 * @author s23141
 */
fun circleArea(radius: Int): Double {
    /**
     * @return the new size of the circleArea.
     */
    return PI * radius * radius
}

/**
 * Exercise 2
 *You have a function that translates a time interval given in hours, minutes, and seconds into seconds. In most cases, you need to pass only one or two function
 * parameters while the rest are equal to 0. Improve the function and the code that calls it by using default parameter values and named arguments so that the code is
 * easier to read.
 * @author s23141
 *
 * @return sum of second from hour and minutes and seconds
 */

fun ex2(){
    println("Start Task 2\n")
    println(intervalInSeconds(1, 20, 15))
    println(intervalInSeconds(0, 1, 25))
    println(intervalInSeconds(2, 0, 0))
    println(intervalInSeconds(0, 10, 0))
    println(intervalInSeconds(1, 0, 1))
    println(intervalInSeconds(1,  1))
    println(intervalInSeconds(1))
    println(intervalInSeconds(minutes = 1, seconds = 15))
    println(intervalInSeconds(hours = 1, seconds = 15))
}
fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) =
    ((hours * 60) + minutes) * 60 + seconds


/**
 * Exercise 3
 * Write a function that takes an Int value and an action (a function with type () -> Unit)
 * which then repeats the action the given number of times. Then use this function
 * to print “Hello” 5 times.
 * @param [n] numer of repeat of print
 * @return repated text
 * @author s23141
 *
 */
fun ex3(){
    repeatN(5) { println("Hello\n") }
}
fun repeatN(n: Int, action: () -> Unit) {
    for (i in 1..n) { action() }}


/** Exercise 4
 * You have the employeeById function that gives you access to a database of employees of a company.
 * Unfortunately, this function returns a value of the Employee?
 * type, so the result can be null. Your goal is to write a function that returns the
 * salary of an employee when their id is provided, or 0 if the employee is missing from
 * the database.
 * @param id indication numer of employee ub data funtion
 * @author s23141
 */

fun ex4(){
    println((1..5).sumOf { id -> salaryById(id) })
}

data class Employee (val name: String, var salary: Int)
fun employeeById(id: Int) = when(id) {
    1 -> Employee("Mary", 20)
    2 -> null
    3 -> Employee("John", 21)
    4 -> Employee("Ann", 23)
    else -> null
}

/**
 * function returns salary using
 * @param id
 * @return salary
 */

fun salaryById(id: Int) = employeeById(id)?.salary ?: 0


/** Exercise 5
 * To test your code, you need a generator that can create random employees.
 * Define a class with a fixed list of potential names (inside the class body), and that is
 * configured by a minimum and maximum salary (inside the class header).
 * Once again, the main function demonstrates how you can use this class.
 *
 *
 * @constructor EmployeeEx5 @param name: String, @param salary: Int
 * @receiver generateEmployee @param minSalary @param maxSalary
 * @return Random Employye with random Salary from range
 *
 * @author s23141
 */

data class EmployeeEx5(val name: String, var salary: Int)
class RandomEmployeeGenerator(var minSalary: Int, var maxSalary: Int) {
    val names = listOf("Krzychu", "Ela", "Marta", "Marta", "Stefan", "Marek")
    fun generateEmployee() = Employee(
        names.random(), Random.nextInt(from = minSalary, until = maxSalary)
    )
}

fun ex5() {
    val empGen = RandomEmployeeGenerator(10, 30)
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    empGen.minSalary = 50
    empGen.maxSalary = 100
    println(empGen.generateEmployee())
}

/** Exercise 6
 * Define a data class Employee with two properties: one for a name, and another for a salary.
 * Make sure that the property for salary is mutable, otherwise you won’t
 * get a salary boost at the Start of the year!
 * The main function demonstrates how you can use this data class.
 *
 *
 * Class EmployeeEx6
 *  @param name
 *  @param salary
 *
 *
 * @author s23141
 *
 */
data class EmployeeEx6(val name: String, var salary: Int)
fun ex6(){
    val emp = Employee("Mary", 20)
    println(emp)
    emp.salary += 10
    println(emp)
}


/** Exercise 7
 * You have a program that counts pizza slices until there’s a whole pizza with 8 slices. Refactor this program in two ways:
 * Use a while loop.
 * Use a do-while loop
 *
 * @example
 * fun main() {
 * var pizzaSlices = 0
 * // Start refactoring here
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * // End refactoring here
 * println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
 * }
 *
 *
 * @author s23141
*/


fun ex7(){
    var pizzaSlices = 0
    while ( pizzaSlices < 7 )
    {
        pizzaSlices++
        println("There's only $pizzaSlices slice/s of pizza :(")
    }
    pizzaSlices++
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")


    pizzaSlices = 0 
    pizzaSlices++ 
    do { 
        println("There's only $pizzaSlices slice/s of pizza :(") 
        pizzaSlices++ 
    } while 
            ( pizzaSlices < 8) 
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}


/** Exercise 8
 * You have a list of words. Use for and if to print only the words that start with the letter l.
 * Hint
 * Use the .startsWith() function for String type.
 *
 * @return words with start letter "l"
 *
 * @author s23141
 */

fun ex8(){
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    for (w in words) { if (w.startsWith("l")) println(w) }
}


/** Exercise 9
 * Write a program that simulates the Fizz buzz game. Your task is to print numbers from 1 to 100 incrementally, replacing any number divisible by three with the word
 * "fizz", and any number divisible by five with the word "buzz". Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz".
 * Hint
 * Use a for loop to count numbers and a when expression to decide what to print at each step
 * @return fizzbuzz or fuzz or byzz or number
 *
 * @author s23141
 */

fun ex9(){
    for (number in 1..100) {
        println(
            when { number % 15 == 0 -> "fizzbuzz"
                number % 3 == 0 -> "fizz"
                number % 5 == 0 -> "buzz"
            else -> number.toString()
            }
        )
    }
}

/** Exercise 10
 * using
 * a when expression, update the following program so that when you input the names of
 * GameBoy buttons, the actions are printed to output.
 *
 * Button Action
 *
 * A Yes
 * B No
 * X Menu
 * Y Nothing
 * Other There is no such button
 *
 * @return Print status of @param button
 *
 * @author s23141
 */


fun ex10(){
    val button = "A"
    println(
        when (button) {
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            "Y" -> "Nothing"
            else
            -> "There is no such button"
        }
    )
}