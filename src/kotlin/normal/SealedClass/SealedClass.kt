/**
 * Recipe: Sealed Classes 📦
 * 
 * What you'll learn:
 * - What are Sealed Classes (restricted class hierarchies)
 * - Using 'when' expressions safely
 * - Real-world examples (UI states, payment results, cooking status)
 * 
 * Kitchen analogy:
 * A sealed class is like a FIXED MENU at a restaurant!
 * You know EXACTLY what dishes can be ordered (no surprises).
 * 
 * @author realmg51-cpu
 * @since May 2026
 */

// ============================================================
// SEALED CLASSES (at TOP LEVEL - cannot be inside main)
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
    object SoupOfTheDay : Dish()
}

// Example 3: Recipe difficulty
sealed class Recipe {
    data class Easy(val prepTime: Int) : Recipe()
    data class Medium(val prepTime: Int, val tools: List<String>) : Recipe()
    data class Hard(val prepTime: Int, val tools: List<String>, val experience: String) : Recipe()
}

// Example 4: Kitchen order system
sealed class KitchenOrder {
    object AwaitingPayment : KitchenOrder()
    object Paid : KitchenOrder()
    data class Cooking(val dish: String, val remainingTime: Int) : KitchenOrder()
    data class Ready(val dish: String, val pickupNumber: Int) : KitchenOrder()
    data class Completed(val dish: String, val rating: Int?) : KitchenOrder()
}

// Example 5: UI States
sealed class UiState {
    object Loading : UiState()
    data class Success(val data: String) : UiState()
    data class Error(val message: String) : UiState()
}

// Enum can also be top level
enum class CookingLevel {
    EASY, MEDIUM, HARD
}

fun main() {
    println("📦 SEALED CLASSES - Fixed Menu Restaurant\n")
    
    // ============================================================
    // PART 1: COOKING STATUS
    // ============================================================
    println("📚 PART 1: Cooking Status")
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
    // PART 2: DISH TYPES
    // ============================================================
    println("\n\n📚 PART 2: Different Dish Types")
    println("-".repeat(50))
    
    fun describeDish(dish: Dish): String {
        return when (dish) {
            is Dish.Pizza -> "🍕 Pizza: ${dish.size} with ${dish.toppings.joinToString(", ")}"
            is Dish.Pasta -> "🍝 Pasta: ${dish.sauce} sauce${if (dish.hasCheese) " + cheese" else ""}"
            is Dish.Salad -> "🥗 Salad: ${dish.dressing} dressing${if (dish.isVegan) " (vegan)" else ""}"
            is Dish.SoupOfTheDay -> "🥣 Today's special soup!"
        }
    }
    
    val pizza = Dish.Pizza("Large", listOf("Pepperoni", "Mushrooms"))
    val pasta = Dish.Pasta("Carbonara", true)
    val salad = Dish.Salad("Caesar", false)
    
    println(describeDish(pizza))
    println(describeDish(pasta))
    println(describeDish(salad))
    println(describeDish(Dish.SoupOfTheDay))
    
    // ============================================================
    // PART 3: ENUM VS SEALED (Simple comparison)
    // ============================================================
    println("\n\n📚 PART 3: Enum vs Sealed Class")
    println("-".repeat(50))
    
    // Enum: simple, no extra data
    println("Enum example: ${CookingLevel.EASY}")
    
    // Sealed: each type can have different data
    fun describeRecipe(recipe: Recipe): String {
        return when (recipe) {
            is Recipe.Easy -> "📘 Easy (${recipe.prepTime} min)"
            is Recipe.Medium -> "📙 Medium (${recipe.prepTime} min, tools: ${recipe.tools.joinToString()})"
            is Recipe.Hard -> "📕 Hard (${recipe.prepTime} min, needs ${recipe.experience})"
        }
    }
    
    println(describeRecipe(Recipe.Easy(10)))
    println(describeRecipe(Recipe.Medium(30, listOf("Oven", "Mixer"))))
    println(describeRecipe(Recipe.Hard(60, listOf("Stand mixer"), "2+ years")))
    
    // ============================================================
    // PART 4: KITCHEN ORDER SYSTEM
    // ============================================================
    println("\n\n📚 PART 4: Kitchen Order Tracking")
    println("-".repeat(50))
    
    fun processOrder(order: KitchenOrder): String {
        return when (order) {
            is KitchenOrder.AwaitingPayment -> "💳 Please complete payment"
            is KitchenOrder.Paid -> "✅ Payment received, preparing order"
            is KitchenOrder.Cooking -> "👨‍🍳 Cooking ${order.dish}... ${order.remainingTime} min left"
            is KitchenOrder.Ready -> "🔔 ${order.dish} ready! Pickup #${order.pickupNumber}"
            is KitchenOrder.Completed -> {
                val rating = order.rating?.let { " ($it stars)" } ?: " (no rating)"
                "🏁 Completed$rating. Thank you!"
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
    // PART 5: UI STATE (Practical example)
    // ============================================================
    println("\n\n📚 PART 5: UI State Management")
    println("-".repeat(50))
    
    fun renderScreen(state: UiState): String {
        return when (state) {
            is UiState.Loading -> "⏳ Loading..."
            is UiState.Success -> "✅ Data: ${state.data}"
            is UiState.Error -> "❌ Error: ${state.message}"
        }
    }
    
    println(renderScreen(UiState.Loading))
    println(renderScreen(UiState.Success("Welcome back!")))
    println(renderScreen(UiState.Error("Network failed")))
    
    // ============================================================
    // PART 6: SMART CASTS (No manual casting needed)
    // ============================================================
    println("\n\n📚 PART 6: Smart Casts")
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
    println("Pasta price: $${getPrice(pasta)}")
    println("Salad price: $${getPrice(salad)}")
    
    // ============================================================
    // PART 7: COMPILER SAFETY (No 'else' needed)
    // ============================================================
    println("\n\n📚 PART 7: Compiler-Enforced Safety")
    println("-".repeat(50))
    
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
    println("Pasta emoji: ${getEmoji(pasta)}")
    
    /* 🍳 TRY IT YOURSELF:
     * 
     * 1. Create a sealed class `Operation` with:
     *    - Add(x: Int, y: Int)
     *    - Subtract(x: Int, y: Int)
     *    - Multiply(x: Int, y: Int)
     *    Write a function that evaluates each
     * 
     * 2. Create a sealed class `NetworkResult` with:
     *    - Loading
     *    - Success(data: String)
     *    - Error(code: Int, message: String)
     * 
     * 3. Create `CoffeeOrder` sealed class with:
     *    - Espresso(hasSugar: Boolean)
     *    - Latte(milkType: String)
     *    - Americano(waterAmount: Int)
     */
    
    println("\n" + "=".repeat(60))
    println("🎉 Sealed Classes Mastered!")
    println("=".repeat(60))
    
    println("""
        
        💡 QUICK TIPS:
        • Sealed classes must be TOP LEVEL (not inside functions)
        • Use 'object' for no-data variants
        • Use 'data class' for variants with data
        • No 'else' needed in 'when' - compiler checks everything!
        • Better than enum when each case needs different data
        
    """.trimIndent())
}
