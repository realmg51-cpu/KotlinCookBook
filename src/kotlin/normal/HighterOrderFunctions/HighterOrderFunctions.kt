/**
 * Recipe: Higher-Order Functions 🎯
 * 
 * Learn: Functions that take other functions as parameters OR return functions
 * 
 * Kitchen analogy: Master Chef who accepts ANY cooking method and applies it
 * 
 * @author @realmg51-cpu
 * @since April 2026
 */

fun main() {
    println("🍳 HIGHER-ORDER FUNCTIONS\n")
    
    // PART 1: Function as parameter
    fun cook(dish: String, method: (String) -> String) {
        println("Cooking $dish... ${method(dish)}")
    }
    
    val fry = { food: String -> "Fried $food 🔥" }
    val steam = { food: String -> "Steamed $food 💨" }
    
    cook("Rice", fry)
    cook("Fish", steam)
    
    // PART 2: Function returning function
    fun getChef(style: String): (String) -> String {
        return when (style) {
            "italian" -> { food -> "Italian $food 🍝" }
            "japanese" -> { food -> "Japanese $food 🍱" }
            else -> { food -> "$food 🍳" }
        }
    }
    
    val italianChef = getChef("italian")
    println(italianChef("Pizza"))
    
    // PART 3: Real-world HOFs
    val numbers = listOf(1, 2, 3, 4, 5)
    
    // map, filter, fold
    val squared = numbers.map { it * it }
    val even = numbers.filter { it % 2 == 0 }
    val sum = numbers.fold(0) { acc, n -> acc + n }
    
    println("Squared: $squared")
    println("Even: $even")
    println("Sum: $sum")
    
    // PART 4: Multiple HOF parameters (callbacks)
    fun processOrder(
        item: String,
        onPrepare: (String) -> String,
        onComplete: (String) -> Unit
    ) {
        val prepared = onPrepare(item)
        onComplete(prepared)
    }
    
    processOrder(
        item = "Burger",
        onPrepare = { it -> "Grilled $it" },
        onComplete = { result -> println("✅ $result is ready!") }
    )
    
    // PART 5: Extension with HOF
    fun <T> List<T>.customProcess(action: (T) -> String): String {
        return this.joinToString(", ") { action(it) }
    }
    
    val fruits = listOf("Apple", "Banana", "Orange")
    val result = fruits.customProcess { fruit -> "🍎 $fruit" }
    println("Processed: $result")
    
    /* 🍳 TRY IT YOURSELF:
     * 1. Create measureTime() that measures execution time of a lambda
     * 2. Write retry() that retries failed operation up to 3 times
     * 3. Use map + filter to get squares of even numbers from 1..10
     */
    
    println("\n🎉 Done! Higher-Order Functions mastered!")
}
