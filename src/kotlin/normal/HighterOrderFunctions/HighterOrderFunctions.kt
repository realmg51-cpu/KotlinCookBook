/**
 * Recipe: Higher-Order Functions 🎯
 * 
 * What you'll learn:
 * - What are Higher-Order Functions (HOF)
 * - Functions that take OTHER functions as parameters
 * - Functions that RETURN functions
 * - Real-world examples with cooking analogies
 * - Combining HOF with lambda expressions
 * 
 * Kitchen analogy:
 * A regular function is like a simple kitchen tool (a knife - does ONE thing).
 * A Higher-Order Function is like a Master Chef who says:
 * "Give me your COOKING METHOD, and I'll apply it to ANY ingredient!"
 * 
 * Or think of a "Cooking Show Template":
 * - The show has a FIXED structure (introduce, cook, taste, rate)
 * - But the actual COOKING METHOD changes each episode
 * - That's a Higher-Order Function - fixed structure, flexible behavior!
 * 
 * Difference from LambdaFunctions.kt:
 * - LambdaFunctions.kt shows HOW to CREATE anonymous functions
 * - This recipe shows HOW to USE functions as PARAMETERS and RETURN VALUES
 * 
 * @author RealMG (realmg)
 * @since April 2026
 */

fun main() {
    println("=".repeat(60))
    println("🍳 HIGHER-ORDER FUNCTIONS - The Master Chef's Toolkit 🎯")
    println("=".repeat(60))
    
    // ============================================================
    // PART 1: FUNCTIONS THAT ACCEPT OTHER FUNCTIONS
    // ============================================================
    println("\n📚 PART 1: Functions as Parameters")
    println("-".repeat(50))
    
    // Example 1: Cooking show template
    fun cookingShowTemplate(
        dishName: String, 
        cookMethod: (String) -> String  // Higher-Order: accepts a function!
    ) {
        println("\n🎬 Welcome to Cooking Show!")
        println("📝 Today's dish: $dishName")
        println("👨‍🍳 Let's cook...")
        
        val result = cookMethod(dishName)  // Execute the passed function
        
        println("🍽️ Final result: $result")
        println("⭐ Rating: 5 stars! ⭐")
    }
    
    // Different cooking methods (lambdas)
    val italianStyle = { dish: String -> "🍝 Italian $dish with basil and parmesan" }
    val japaneseStyle = { dish: String -> "🍱 Japanese $dish with miso and wasabi" }
    val mexicanStyle = { dish: String -> "🌮 Mexican $dish with salsa and avocado" }
    
    cookingShowTemplate("Pasta", italianStyle)
    cookingShowTemplate("Rice", japaneseStyle)
    cookingShowTemplate("Taco", mexicanStyle)
    
    // ============================================================
    // PART 2: REAL-WORLD HOF - String Operations
    // ============================================================
    println("\n\n📚 PART 2: Real-World String Transformer")
    println("-".repeat(50))
    
    fun transformString(
        input: String,
        transformer: (String) -> String  // HOF parameter
    ): String {
        println("🔧 Original: '$input'")
        val transformed = transformer(input)
        println("✨ Transformed: '$transformed'")
        return transformed
    }
    
    // Try different transformations
    transformString("hello world") { it.uppercase() }
    transformString("Kotlin is fun") { it.reversed() }
    transformString("cookbook") { it.substring(0, 4) }
    transformString("   messy   ") { it.trim() }
    
    // ============================================================
    // PART 3: FUNCTIONS WITH MULTIPLE HOF PARAMETERS
    // ============================================================
    println("\n\n📚 PART 3: Multiple Function Parameters")
    println("-".repeat(50))
    
    fun processNumber(
        number: Int,
        onSuccess: (Int) -> String,
        onError: (Int) -> String
    ): String {
        return if (number > 0) {
            onSuccess(number)
        } else {
            onError(number)
        }
    }
    
    val successHandler = { num: Int -> "✅ Success! $num is positive. Square: ${num * num}" }
    val errorHandler = { num: Int -> "❌ Error! $num is not positive. Using absolute: ${Math.abs(num)}" }
    
    println(processNumber(5, successHandler, errorHandler))
    println(processNumber(-3, successHandler, errorHandler))
    
    // ============================================================
    // PART 4: FUNCTIONS THAT RETURN FUNCTIONS
    // ============================================================
    println("\n\n📚 PART 4: Functions Returning Functions")
    println("-".repeat(50))
    
    // A "recipe factory" - returns different cooking methods
    fun getCookingMethod(style: String): (String) -> String {
        println("\n🔧 Creating cooking method for style: $style")
        
        return when (style.lowercase()) {
            "fried" -> { food -> "🔥 Fried $food until golden brown" }
            "steamed" -> { food -> "💨 Steamed $food to perfection" }
            "raw" -> { food -> "🥗 Fresh raw $food, no cooking needed" }
            "grilled" -> { food -> "🌋 Grilled $food with smoky flavor" }
            else -> { food -> "🍳 Cooked $food with basic method" }
        }
    }
    
    val friedMethod = getCookingMethod("fried")
    val steamedMethod = getCookingMethod("steamed")
    val grilledMethod = getCookingMethod("grilled")
    
    println("\nResults:")
    println(friedMethod("Chicken"))
    println(steamedMethod("Vegetables"))
    println(grilledMethod("Salmon"))
    
    // ============================================================
    // PART 5: PRACTICAL COLLECTION HOF (Kotlin built-in)
    // ============================================================
    println("\n\n📚 PART 5: Built-in Higher-Order Functions")
    println("-".repeat(50))
    
    val menuItems = listOf("Pizza", "Burger", "Pasta", "Salad", "Sushi")
    val prices = listOf(12.99, 8.99, 14.99, 7.99, 16.99)
    
    println("Original menu: $menuItems")
    println("Prices: $prices")
    
    // .map() - transform each element
    val expensiveMenu = menuItems.map { item -> "⭐ $item (special) ⭐" }
    println("\nAfter .map(): $expensiveMenu")
    
    // .filter() - keep elements that match condition
    val shortNames = menuItems.filter { it.length <= 5 }
    println("Short names (filtered): $shortNames")
    
    // .fold() - accumulate/reduce
    val totalPrice = prices.fold(0.0) { sum, price -> sum + price }
    println("Total price (folded): $$totalPrice")
    
    // Chaining HOFs together!
    val result = menuItems
        .filter { it.length > 4 }           // Keep longer names
        .map { it.uppercase() }              // Convert to uppercase
        .sorted()                            // Sort alphabetically
        .joinToString(" ★ ")                 // Join with stars
    
    println("\nChained HOF result: $result")
    
    // ============================================================
    // PART 6: PRACTICAL KITCHEN TIMER WITH CALLBACKS
    // ============================================================
    println("\n\n📚 PART 6: Kitchen Timer with Callbacks ⏲️")
    println("-".repeat(50))
    
    fun kitchenTimer(
        durationSeconds: Int,
        onStart: () -> Unit,
        onTick: (Int) -> Unit,
        onComplete: (String) -> Unit
    ) {
        onStart()
        
        for (second in durationSeconds downTo 1) {
            onTick(second)
            Thread.sleep(500) // Simulate time passing
        }
        
        onComplete("Dish is ready! 🎉")
    }
    
    kitchenTimer(
        durationSeconds = 3,
        onStart = { println("👩‍🍳 Starting cooking timer...") },
        onTick = { remaining -> println("⏰ $remaining seconds remaining...") },
        onComplete = { message -> println("✅ $message") }
    )
    
    // ============================================================
    // PART 7: EXTENSION FUNCTIONS WITH HOF (Advanced)
    // ============================================================
    println("\n\n📚 PART 7: Extension Higher-Order Functions")
    println("-".repeat(50))
    
    // Create an extension function for List
    fun <T> List<T>.customProcess(
        action: (T) -> String,
        separator: String = ", "
    ): String {
        return this.map { action(it) }.joinToString(separator)
    }
    
    val fruits = listOf("Apple", "Banana", "Orange", "Mango")
    
    val result1 = fruits.customProcess { fruit -> "🍎 $fruit" }
    val result2 = fruits.customProcess({ fruit -> "Fresh $fruit" }, separator = " | ")
    
    println("With emoji: $result1")
    println("With custom separator: $result2")
    
    // ============================================================
    // PART 8: TYPE ALIAS FOR CLEANER CODE
    // ============================================================
    println("\n\n📚 PART 8: Type Aliases for Cleaner HOFs")
    println("-".repeat(50))
    
    // Define type aliases for complex function types
    typealias CookingMethod = (String) -> String
    typealias RecipeValidator = (String, List<String>) -> Boolean
    
    fun executeCooking(dish: String, method: CookingMethod): String {
        return method(dish)
    }
    
    fun validateRecipe(recipeName: String, ingredients: List<String>, validator: RecipeValidator): Boolean {
        return validator(recipeName, ingredients)
    }
    
    val simpleCook: CookingMethod = { dish -> "Cooked $dish simply 🍳" }
    println(executeCooking("Egg", simpleCook))
    
    val hasCheese: RecipeValidator = { recipe, ingredients ->
        ingredients.any { it.lowercase().contains("cheese") }
    }
    
    val pizzaIngredients = listOf("Dough", "Tomato sauce", "Cheese", "Pepperoni")
    val saladIngredients = listOf("Lettuce", "Tomato", "Cucumber", "Olive oil")
    
    println("Pizza has cheese? ${validateRecipe("Pizza", pizzaIngredients, hasCheese)}")
    println("Salad has cheese? ${validateRecipe("Salad", saladIngredients, hasCheese)}")
    
    /* 🍳 TRY IT YOURSELF:
     * 
     * 1. Create a higher-order function `measureTime` that takes a lambda and
     *    measures how long it takes to execute. Print the execution time.
     *    Hint: Use System.currentTimeMillis()
     * 
     * 2. Write a function `applyDiscount` that takes a price (Double) and
     *    a discount calculator: (Double) -> Double. Apply multiple discounts.
     * 
     * 3. Create a function `retry` that takes an operation (() -> T) and retries
     *    it up to 3 times if it fails (throws exception).
     * 
     * 4. Write a function `compose` that takes two functions f and g and returns
     *    a new function that does f(g(x)). (Function composition)
     * 
     * 5. Challenge: Create a simple "pipeline" system:
     *    - Function `createPipeline` returns a list of processing steps
     *    - Each step is a (String) -> String function
     *    - Apply all steps in sequence to an input string
     *    Example: trim -> lowercase -> capitalize first letter -> add "✨"
     * 
     * 6. Advanced: Build a simple "strategy pattern" for cooking:
     *    - Define different CookingStrategy interfaces (as function types)
     *    - Create a Chef class that can switch strategies at runtime
     *    - Implement strategies: FryStrategy, BakeStrategy, SteamStrategy
     */
    
    // ============================================================
    // BONUS: Performance Comparison
    // ============================================================
    println("\n\n🌟 BONUS: Inline Functions (Performance)")
    println("-".repeat(50))
    
    // Regular HOF (creates object)
    fun regularHOF(operation: () -> Unit) {
        operation()
    }
    
    // Inline HOF (no object created - better performance)
    inline fun inlineHOF(operation: () -> Unit) {
        operation()
    }
    
    println("Use 'inline' keyword for small, frequently-called HOFs!")
    println("Kotlin standard library uses inline extensively (e.g., repeat, map, filter)")
    
    // Example of repeat (built-in inline HOF)
    println("\nUsing repeat() - built-in inline HOF:")
    repeat(3) { iteration ->
        println("  Stirring pot... iteration ${iteration + 1}")
    }
    
    println("\n" + "=".repeat(60))
    println("🎉 CONGRATULATIONS! You've mastered Higher-Order Functions!")
    println("Now you can write flexible, reusable, and powerful Kotlin code!")
    println("=".repeat(60))
    
    println("\n💡 Quick Reference:")
    println("  • HOF = function that takes functions OR returns functions")
    println("  • Lambda = anonymous function (often passed to HOF)")
    println("  • (String) -> Int = function type syntax")
    println("  • Use 'inline' for performance with small lambdas")
    println("  • Type aliases make complex HOFs readable")
}
