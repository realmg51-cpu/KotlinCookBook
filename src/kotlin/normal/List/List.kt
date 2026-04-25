/*
* In this recipe, we are learning how to use list (listOf)
* list is a very useful thing you need to know
*/
fun main() {
    val numbers = listOf(1, 2, 3)
    
    // 1. Print the entire list
    println(numbers)  // [1, 2, 3]
    
    // 2. Access individual elements
    println("First element: ${numbers[0]}")    // 1
    println("Second element: ${numbers[1]}")   // 2
    println("Third element: ${numbers[2]}")    // 3
    
    // 3. Basic properties
    println("Size: ${numbers.size}")           // 3
    println("Is empty: ${numbers.isEmpty()}")  // false
    println("Contains 2: ${numbers.contains(2)}") // true
    
    // 4. Loop through the list using for
    println("Using for loop:")
    for (num in numbers) {
        println(num)
    }
    
    // 5. Loop using forEach
    println("Using forEach:")
    numbers.forEach { println(it) }
    
    // 6. Get first and last
    println("First: ${numbers.first()}")  // 1
    println("Last: ${numbers.last()}")    // 3
}
