/**
 * Recipe: Basic Functions
 * 
 * What you'll learn:
 * - Create and call functions
 * - Parameters and return types
 * - Default parameters
 * - Named arguments
 * - Single-expression functions
 * 
 * Kitchen analogy:
 * "A function is like a recipe - write it once, use it many times!"
 */

fun main() {
    println("🍳 Basic Functions - Your Kitchen Recipes")
    println("==========================================")
    
    // ===== 1. SIMPLE FUNCTION =====
    println("\n📝 1. Simple Function")
    greetChef()
    
    // ===== 2. WITH PARAMETERS =====
    println("\n📝 2. Function with Parameters")
    cookDish("Pasta", 30)
    cookDish("Soup", 20)
    
    // ===== 3. WITH RETURN VALUE =====
    println("\n📝 3. Return Value")
    val total = add(5, 3)
    println("   5 + 3 = $total")
    
    val price = calculatePrice(2)
    println("   Total: $$price")
    
    // ===== 4. DEFAULT PARAMETERS =====
    println("\n📝 4. Default Parameters")
    makeCoffee("Espresso")
    makeCoffee("Latte", 2)
    makeCoffee()  // Uses defaults
    
    // ===== 5. NAMED ARGUMENTS =====
    println("\n📝 5. Named Arguments")
    bakeCake(flour = 500, sugar = 200, eggs = 3)
    bakeCake(eggs = 4, flour = 600, sugar = 250)
    
    // ===== 6. SINGLE-EXPRESSION =====
    println("\n📝 6. Single-Expression Functions")
    println("   Double of 10: ${double(10)}")
    println("   Square of 5: ${square(5)}")
    
    // ===== SUMMARY =====
    println("\n" + "=".repeat(50))
    println("📚 Summary:")
    println("   fun name() { }")
    println("   fun name(p: Type): Return { }")
    println("   fun name(p: Type = default)")
    println("   fun name() = expression")
}

// Simple function
fun greetChef() {
    println("   Hello, Chef! 🍳")
}

// With parameters
fun cookDish(dishName: String, minutes: Int) {
    println("   🔪 Cooking $dishName for $minutes minutes...")
    println("   ✅ $dishName is ready!")
}

// With return value
fun add(a: Int, b: Int): Int = a + b

fun calculatePrice(pizzas: Int): Double {
    val pricePerPizza = 12.99
    return pizzas * pricePerPizza
}

// Default parameters
fun makeCoffee(type: String = "Americano", sugar: Int = 1) {
    println("   ☕ $type with $sugar sugar")
}

// Named arguments
fun bakeCake(flour: Int, sugar: Int, eggs: Int) {
    println("   🎂 Flour: ${flour}g, Sugar: ${sugar}g, Eggs: $eggs")
}

// Single-expression
fun double(x: Int) = x * 2
fun square(x: Int) = x * x

// ===== CHALLENGE =====
// Write a function that converts Celsius to Fahrenheit
// fun celsiusToFahrenheit(c: Double) = c * 9.0 / 5.0 + 32
