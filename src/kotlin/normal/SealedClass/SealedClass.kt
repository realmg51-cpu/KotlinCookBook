/**
 * Recipe: Sealed Classes 📦
 * 
 * What you'll learn:
 * - What are Sealed Classes (restricted class hierarchies)
 * - Why they're better than enum for complex cases
 * - Using 'when' expressions safely
 * - Real-world examples (UI states, payment results, cooking status)
 * 
 * Kitchen analogy:
 * A sealed class is like a FIXED MENU at a restaurant!
 * You know EXACTLY what dishes can be ordered (no surprises).
 * 
 * Enum = Simple menu with just dish names
 * Sealed Class = Full menu with different dish types (each with unique details)
 *   - Pizza has size and toppings 🍕
 *   - Pasta has sauce type 🍝
 *   - Salad has dressing 🥗
 * 
 * The chef knows ALL possible dishes in advance - no custom orders!
 * 
 * @author realmg51-cpu
 * @since May 2026
 */

// ============================================================
// SEALED CLASS DEFINITIONS (must be at top level)
// ============================================================

// Example 1: Simple cooking status
sealed class CookingStatus {
    object NotStarted : CookingStatus()
    object InProgress : CookingStatus()
    object Ready : CookingStatus()
    data class Failed(val reason: String) : CookingStatus()
}

// Example 2: Different types of dishes
sealed class Dish {
    data class Pizza(val size: String, val toppings: List<String>) : Dish()
    data class Pasta(val sauce: String, val hasCheese: Boolean) : Dish()
    data class Salad(val dressing: String, val isVegan: Boolean) : Dish()
    object SoupOfTheDay : Dish()  // No extra data
}

// Example 3: UI States (common Android use case)
sealed class UiState {
    object Loading : UiState()
    data class Success(val data: String) : UiState()
    data class Error(val message: String) : UiState()
}

fun main() {
    println("📦 SEALED CLASSES - Fixed Menu Restaurant\n")
    
    // ============================================================
    // PART 1: SIMPLE SEALED CLASS (Cooking Status)
    // ============================================================
    println("📚 PART 1: Cooking Status Example")
    println("-".repeat(50))
    
    fun getOrderStatus(status: CookingStatus): String {
        return when (status) {
            is CookingStatus.NotStarted -> "🔘 Order received"
            is CookingStatus.InProgress -> "👨‍🍳 Cooking in progress..."
            is CookingStatus.Ready -> "✅ Order ready!"
            is CookingStatus.Failed -> "❌ Failed: ${status.reason}"
        }
    }
    
    println(getOrderStatus(CookingStatus.NotStarted))
    println(getOrderStatus(CookingStatus.InProgress))
    println(getOrderStatus(CookingStatus.Ready))
    println(getOrderStatus(CookingStatus.Failed("Out of ingredients")))
    
    // ============================================================
    // PART 2: DISH TYPES (Different data for each)
    // ============================================================
    println("\n\n📚 PART 2: Different Dish Types")
    println("-".repeat(50))
    
    fun describeDish(dish: Dish): String {
        return when (dish) {
            is Dish.Pizza -> "🍕 Pizza: ${dish.size} size with ${dish.toppings.joinToString(", ")}"
            is Dish.Pasta -> "🍝 Pasta: ${dish.sauce} sauce${if (dish.hasCheese) " + cheese" else ""}"
            is Dish.Salad -> "🥗 Salad: ${dish.dressing} dressing${if (dish.isVegan) " (vegan)" else ""}"
            is Dish.SoupOfTheDay -> "🥣 Today's special soup!"
        }
    }
    
    val pizza = Dish.Pizza("Large", listOf("Pepperoni", "Mushrooms", "Olives"))
    val pasta = Dish.Pasta("Carbonara", true)
    val salad = Dish.Salad("Caesar", false)
    val soup = Dish.SoupOfTheDay
    
    println(describeDish(pizza))
    println(describeDish(pasta))
    println(describeDish(salad))
    println(describeDish(soup))
    
    // ============================================================
    // PART 3: UI STATE (Real-world example)
    // ============================================================
    println("\n\n📚 PART 3: UI State Management")
    println("-".repeat(50))
    
    fun renderScreen(state: UiState) {
        when (state) {
            is UiState.Loading -> println("⏳ Loading... Please wait")
            is UiState.Success -> println("✅ Data loaded: ${state.data}")
            is UiState.Error -> println("❌ Error: ${state.message}")
        }
    }
    
    renderScreen(UiState.Loading)
    renderScreen(UiState.Success("Welcome back, Chef!"))
    renderScreen(UiState.Error("Network connection failed"))
    
    // ============================================================
    // PART 4: SEALED VS ENUM
    // ============================================================
    println("\n\n📚 PART 4: Sealed Class vs Enum")
    println("-".repeat(50))
    
    // Enum: Good for simple values
    enum class CookingLevel {
        EASY, MEDIUM, HARD
    }
    
    // Sealed: Good when each type has different data
    sealed class Recipe {
        data class Easy(val prepTime: Int) : Recipe()      // 5-10 minutes
        data class Medium(val prepTime: Int, val tools: List<String>) : Recipe()
        data class Hard(val prepTime: Int, val tools: List<String>, val experience: String) : Recipe()
    }
    
    fun describeRecipe(recipe: Recipe): String {
        return when (recipe) {
            is Recipe.Easy -> "📘 Easy recipe (${recipe.prepTime} min)"
            is Recipe.Medium -> "📙 Medium recipe (${recipe.prepTime} min, tools: ${recipe.tools.joinToString()})"
            is Recipe.Hard -> "📕 Hard recipe (${recipe.prepTime} min, needs ${recipe.experience})"
        }
    }
    
    println(describeRecipe(Recipe.Easy(10)))
    println(describeRecipe(Recipe.Medium(30, listOf("Oven", "Mixer"))))
    println(describeRecipe(Recipe.Hard(60, listOf("Stand mixer", "Thermometer"), "2+ years experience")))
    
    // ============================================================
    // PART 5: PRACTICAL KITCHEN EXAMPLE
    // ============================================================
    println("\n\n📚 PART 5: Kitchen Order System")
    println("-".repeat(50))
    
    sealed class KitchenOrder {
        object AwaitingPayment : KitchenOrder()
        object Paid : KitchenOrder()
        data class Cooking(val dish: String, val remainingTime: Int) : KitchenOrder()
        data class Ready(val dish: String, val pickupNumber: Int) : KitchenOrder()
        data class Completed(val dish: String, val rating: Int?) : KitchenOrder()
    }
    
    fun processOrder(order: KitchenOrder): String {
        return when (order) {
            is KitchenOrder.AwaitingPayment -> "💳 Please complete payment first"
            is KitchenOrder.Paid -> "✅ Payment received, preparing your order"
            is KitchenOrder.Cooking -> "👨‍🍳 Cooking ${order.dish}... ${order.remainingTime} min remaining"
            is KitchenOrder.Ready -> "🔔 ${order.dish} ready! Pickup at counter #${order.pickupNumber}"
            is KitchenOrder.Completed -> {
                val rating = order.rating?.let { " ($it stars)" } ?: " (no rating)"
                "🏁 Order completed$rating. Thank you!"
            }
        }
    }
    
    var order: KitchenOrder = KitchenOrder.AwaitingPayment
    println(processOrder(order))
    
    order = KitchenOrder.Paid
    println(processOrder(order))
    
    order = KitchenOrder.Cooking("Margherita Pizza", 15)
    println(processOrder(order))
    
    order = KitchenOrder.Ready("Margherita Pizza", 42)
    println(processOrder(order))
    
    order = KitchenOrder.Completed("Margherita Pizza", 5)
    println(processOrder(order))
    
    // ============================================================
    // PART 6: SMART CASTS WITH SEALED CLASSES
    // ============================================================
    println("\n\n📚 PART 6: Smart Casts (No explicit casting needed!)")
    println("-".repeat(50))
    
    fun getPrice(dish: Dish): Double {
        return when (dish) {
            is Dish.Pizza -> when (dish.size) {
                "Small" -> 10.99
                "Medium" -> 14.99
                "Large" -> 18.99
                else -> 12.99
            }
            is Dish.Pasta -> if (dish.hasCheese) 16.99 else 13.99
            is Dish.Salad -> if (dish.isVegan) 9.99 else 11.99
            is Dish.SoupOfTheDay -> 7.99
        }
    }
    
    println("Pizza price: $${getPrice(pizza)}")
    println("Salad price: $${getPrice(salad)}")
    println("Soup price: $${getPrice(Dish.SoupOfTheDay)}")
    
    // ============================================================
    // PART 7: CHECKING ALL TYPES (Compiler safety)
    // ============================================================
    println("\n\n📚 PART 7: Compiler-Enforced Exhaustive when")
    println("-".repeat(50))
    
    // Kotlin compiler checks if ALL types are handled
    fun getEmoji(dish: Dish): String {
        return when (dish) {
            is Dish.Pizza -> "🍕"
            is Dish.Pasta -> "🍝"
            is Dish.Salad -> "🥗"
            is Dish.SoupOfTheDay -> "🥣"
        }
        // No 'else' needed! Compiler knows all cases are covered
    }
    
    println("Pizza emoji: ${getEmoji(pizza)}")
    println("Soup emoji: ${getEmoji(Dish.SoupOfTheDay)}")
    
    /* 🍳 TRY IT YOURSELF:
     * 
     * 1. Create a sealed class `Operation` with:
     *    - Add(x: Int, y: Int)
     *    - Subtract(x: Int, y: Int) 
     *    - Multiply(x: Int, y: Int)
     *    - Divide(x: Int, y: Int)
     *    Write a function that evaluates each operation
     * 
     * 2. Create a sealed class `NetworkResult` with:
     *    - Loading
     *    - Success(data: String)
     *    - Error(code: Int, message: String)
     *    Simulate an API call that returns different states
     * 
     * 3. Create a sealed hierarchy for `CoffeeOrder`:
     *    - Espresso (size: String, hasSugar: Boolean)
     *    - Latte (milkType: String, shots: Int)
     *    - Americano (waterAmount: Int)
     *    Write a function that returns the price
     * 
     * 4. Challenge: Create a small ordering system where:
     *    - Customer can order different dish types
     *    - Kitchen processes orders in stages
     *    - Use sealed classes to represent each stage
     */
    
    println("\n" + "=".repeat(60))
    println("🎉 Sealed Classes Mastered! Your menu is now FIXED!")
    println("=".repeat(60))
    
    println("""
        
        💡 WHEN TO USE SEALED CLASSES:
        
        ✅ Use Sealed Class when:
        • You have a FIXED set of subtypes
        • Each subtype needs DIFFERENT data
        • You want COMPILER safety (no missing cases)
        • You're modeling state (success/error/loading)
        
        ❌ Use Enum when:
        • All options are SIMPLE constants
        • No extra data needed
        • You just need to list possibilities
        
        🎯 Real-world uses:
        • UI states (Loading, Success, Error)
        • API results
        • Payment processing
        • Order status tracking
        • User actions
        • Navigation events
        
    """.trimIndent())
}
