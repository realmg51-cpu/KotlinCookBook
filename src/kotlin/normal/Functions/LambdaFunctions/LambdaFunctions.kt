/**
 * Recipe: Lambda Functions
 * 
 * What you'll learn:
 * - What are lambdas (function literals)
 * - Lambda syntax: { parameters -> body }
 * - Using 'it' for single parameter
 * - Higher-order functions
 * - Common operations: map, filter, forEach
 * 
 * Kitchen analogy:
 * "A lambda is like a quick note - a small recipe you write on the spot!"
 */

fun main() {
    println("🍳 Lambda Functions - Quick Kitchen Notes")
    println("==========================================")
    
    // ===== 1. BASIC LAMBDA =====
    println("\n📝 1. Basic Lambda")
    
    // Lambda stored in variable
    val greet = { println("   Hello, Chef!") }
    greet()
    
    // Lambda with parameters
    val cook = { dish: String -> println("   Cooking $dish...") }
    cook("Pasta")
    
    // Lambda with return value
    val double = { x: Int -> x * 2 }
    println("   Double of 5: ${double(5)}")
    
    // ===== 2. USING 'it' =====
    println("\n📝 2. Using 'it' (single parameter shortcut)")
    
    val square: (Int) -> Int = { it * it }
    println("   Square of 7: ${square(7)}")
    
    val isEven = { it: Int -> it % 2 == 0 }
    println("   Is 4 even? ${isEven(4)}")
    println("   Is 5 even? ${isEven(5)}")
    
    // ===== 3. LAMBDA AS PARAMETER =====
    println("\n📝 3. Lambda as Parameter (Higher-Order Functions)")
    
    // repeat() takes a lambda
    println("   Repeating 3 times:")
    repeat(3) {
        println("      🍳 Cooking...")
    }
    
    // Custom higher-order function
    fun timer(seconds: Int, action: () -> Unit) {
        println("   Starting timer...")
        repeat(seconds) { action() }
        println("   Time's up!")
    }
    
    timer(2) {
        println("      ⏰ Tick...")
    }
    
    // ===== 4. COLLECTION OPERATIONS =====
    println("\n📝 4. Lambda with Collections")
    
    val numbers = listOf(1, 2, 3, 4, 5)
    
    // forEach - do something with each
    print("   forEach: ")
    numbers.forEach { print("$it ") }
    println()
    
    // map - transform each element
    val doubled = numbers.map { it * 2 }
    println("   map (double): $doubled")
    
    // filter - keep matching elements
    val evens = numbers.filter { it % 2 == 0 }
    println("   filter (even): $evens")
    
    // reduce - combine all
    val sum = numbers.reduce { acc, n -> acc + n }
    println("   reduce (sum): $sum")
    
    // ===== 5. MULTI-LINE LAMBDA =====
    println("\n📝 5. Multi-line Lambda")
    
    val processOrder = { items: List<String> ->
        println("   📋 Order received:")
        items.forEach { println("      - $it") }
        "   Total: ${items.size} items"
    }
    
    val result = processOrder(listOf("Pizza", "Salad", "Soda"))
    println(result)
    
    // ===== 6. FUNCTION RETURNING LAMBDA =====
    println("\n📝 6. Function Returning Lambda")
    
    fun getMultiplier(factor: Int): (Int) -> Int {
        return { x -> x * factor }
    }
    
    val double2 = getMultiplier(2)
    val triple = getMultiplier(3)
    
    println("   double2 of 5: ${double2(5)}")
    println("   triple of 5: ${triple(5)}")
    
    // ===== SUMMARY =====
    println("\n" + "=".repeat(50))
    println("📚 Lambda Summary:")
    println("   • Syntax: { params -> body }")
    println("   • Single param: { it * 2 }")
    println("   • Higher-order: function that takes lambda")
    println("   • Common: map, filter, forEach, reduce")
    println("=".repeat(50))
}

// ===== CHALLENGES =====
// 1. Write a lambda that checks if a number is odd
// val isOdd = { it: Int -> it % 2 != 0 }

// 2. Use filter to get numbers greater than 3
// listOf(1,2,3,4,5).filter { it > 3 }

// 3. Use map to convert list to strings
// listOf(1,2,3).map { "Number $it" }
