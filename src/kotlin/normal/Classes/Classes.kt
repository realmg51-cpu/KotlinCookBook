/**
 * Recipe: Classes 👨‍🍳
 * 
 * What you'll learn:
 * - Creating classes and objects
 * - Properties (variables inside classes)
 * - Constructors (primary and secondary)
 * - Methods (functions inside classes)
 * - Data classes (auto-generated equals, hashCode, toString)
 * 
 * Kitchen analogy:
 * A class is like a RECIPE TEMPLATE - it describes how to make a dish.
 * An object is the ACTUAL DISH you cook using that recipe.
 * You can use the same recipe (class) to make many dishes (objects)!
 * 
 * @author Your Name
 * @since May 2026
 */

fun main() {
    println("👨‍🍳 KOTLIN CLASSES - Recipe Templates for Your Code\n")
    
    // ============================================================
    // PART 1: BASIC CLASS
    // ============================================================
    println("📚 PART 1: Basic Class")
    println("-".repeat(50))
    
    class Chef {
        var name: String = "Unknown"
        var experience: Int = 0
        
        fun cook() {
            println("👨‍🍳 $name is cooking with $experience years of experience!")
        }
        
        fun introduce() {
            println("Hi! I'm Chef $name")
        }
    }
    
    val chef1 = Chef()
    chef1.name = "Gordon"
    chef1.experience = 25
    chef1.cook()
    chef1.introduce()
    
    // ============================================================
    // PART 2: PRIMARY CONSTRUCTOR
    // ============================================================
    println("\n\n📚 PART 2: Primary Constructor")
    println("-".repeat(50))
    
    class Dish(val name: String, val price: Double, val ingredients: List<String>) {
        
        fun display() {
            println("🍽️ $name - $$price")
            println("   Ingredients: ${ingredients.joinToString(", ")}")
        }
        
        fun isExpensive(): Boolean = price > 20.0
    }
    
    val pizza = Dish("Margherita Pizza", 14.99, listOf("Dough", "Tomato", "Mozzarella", "Basil"))
    pizza.display()
    println("Expensive? ${pizza.isExpensive()}")
    
    // ============================================================
    // PART 3: CONSTRUCTOR WITH INIT BLOCK
    // ============================================================
    println("\n\n📚 PART 3: Constructor with init Block")
    println("-".repeat(50))
    
    class RecipeBook(val title: String) {
        private val recipes = mutableListOf<String>()
        
        init {
            println("📖 Creating recipe book: '$title'")
        }
        
        fun addRecipe(recipe: String) {
            recipes.add(recipe)
            println("  ✅ Added: $recipe")
        }
        
        fun getRecipeCount(): Int = recipes.size
    }
    
    val myBook = RecipeBook("My Favorite Dishes")
    myBook.addRecipe("Spaghetti Carbonara")
    myBook.addRecipe("Chicken Tikka Masala")
    println("Total recipes: ${myBook.getRecipeCount()}")
    
    // ============================================================
    // PART 4: SECONDARY CONSTRUCTOR
    // ============================================================
    println("\n\n📚 PART 4: Secondary Constructor")
    println("-".repeat(50))
    
    class Kitchen(val name: String) {
        var size: String = "Medium"
        var hasOven: Boolean = false
        
        // Secondary constructor
        constructor(name: String, size: String) : this(name) {
            this.size = size
            println("  🏠 Kitchen: $name ($size size)")
        }
        
        constructor(name: String, hasOven: Boolean) : this(name) {
            this.hasOven = hasOven
            val ovenStatus = if (hasOven) "with oven" else "without oven"
            println("  🏠 Kitchen: $name ($ovenStatus)")
        }
        
        fun describe() {
            println("Kitchen '$name' - Size: $size, Has oven: $hasOven")
        }
    }
    
    val kitchen1 = Kitchen("Home Kitchen", "Large")
    kitchen1.describe()
    
    val kitchen2 = Kitchen("Pizza Shop", true)
    kitchen2.describe()
    
    // ============================================================
    // PART 5: DATA CLASS (Auto-generated methods)
    // ============================================================
    println("\n\n📚 PART 5: Data Class - The Magic Recipe")
    println("-".repeat(50))
    
    data class Ingredient(
        val name: String,
        val quantity: Double,
        val unit: String
    )
    
    val egg = Ingredient("Egg", 2.0, "pieces")
    val flour = Ingredient("Flour", 250.0, "grams")
    val egg2 = Ingredient("Egg", 2.0, "pieces")
    
    println("Ingredient: $egg")  // Auto toString()
    println("Is egg == egg2? ${egg == egg2}")  // Auto equals()
    
    // Copy with changes
    val moreFlour = flour.copy(quantity = 500.0)
    println("Original: $flour")
    println("Copied: $moreFlour")
    
    // Destructuring
    val (name, qty, unit) = egg
    println("Destructured: $name, $qty $unit")
    
    // ============================================================
    // PART 6: CLASS WITH METHODS
    // ============================================================
    println("\n\n📚 PART 6: Class with Multiple Methods")
    println("-".repeat(50))
    
    class Oven {
        private var temperature: Int = 0
        private var isOn: Boolean = false
        
        fun turnOn() {
            isOn = true
            println("🔥 Oven turned on")
        }
        
        fun turnOff() {
            isOn = false
            temperature = 0
            println("❄️ Oven turned off")
        }
        
        fun preheat(temp: Int) {
            if (!isOn) turnOn()
            temperature = temp
            println("🌡️ Preheating to $temp°C...")
        }
        
        fun bake(dish: String, minutes: Int) {
            if (!isOn || temperature == 0) {
                println("⚠️ Please preheat the oven first!")
                return
            }
            println("🍪 Baking $dish at $temperature°C for $minutes minutes...")
            println("✅ $dish is ready! 🎉")
        }
        
        fun getStatus(): String {
            return if (isOn) "On at $temperature°C" else "Off"
        }
    }
    
    val oven = Oven()
    oven.preheat(180)
    oven.bake("Chocolate Cake", 30)
    println("Status: ${oven.getStatus()}")
    oven.turnOff()
    
    // ============================================================
    // PART 7: CLASS WITH PROPERTIES (Getters/Setters)
    // ============================================================
    println("\n\n📚 PART 7: Custom Getters/Setters")
    println("-".repeat(50))
    
    class Thermostat {
        var celsius: Double = 20.0
            set(value) {
                println("  🌡️ Changing temperature from $field°C to $value°C")
                field = value
            }
        
        // Custom getter for Fahrenheit
        val fahrenheit: Double
            get() = (celsius * 9/5) + 32
        
        fun display() {
            println("Temperature: $celsius°C / ${"%.1f".format(fahrenheit)}°F")
        }
    }
    
    val thermo = Thermostat()
    thermo.display()
    thermo.celsius = 25.0
    thermo.display()
    
    // ============================================================
    // PART 8: INNER CLASS
    // ============================================================
    println("\n\n📚 PART 8: Inner Class (Class inside Class)")
    println("-".repeat(50))
    
    class Restaurant(val name: String) {
        private val customers = mutableListOf<String>()
        
        inner class Table(val tableNumber: Int) {
            fun reserve(customerName: String) {
                customers.add(customerName)
                println("📝 Reserved table $tableNumber for $customerName at $name")
            }
        }
        
        fun showCustomers() {
            println("👥 Customers at $name: ${customers.joinToString()}")
        }
    }
    
    val restaurant = Restaurant("Golden Palace")
    val table5 = restaurant.Table(5)
    table5.reserve("John")
    table5.reserve("Sarah")
    restaurant.showCustomers()
    
    // ============================================================
    // PART 9: KITCHEN ORDER SYSTEM (Practical Example)
    // ============================================================
    println("\n\n📚 PART 9: Real Example - Order System")
    println("-".repeat(50))
    
    data class MenuItem(val name: String, val price: Double)
    
    class Order(val orderId: Int) {
        private val items = mutableListOf<MenuItem>()
        
        fun addItem(item: MenuItem) {
            items.add(item)
            println("  🍽️ Added ${item.name} (\$${item.price})")
        }
        
        fun getTotal(): Double = items.sumOf { it.price }
        
        fun display() {
            println("Order #$orderId:")
            items.forEach { println("  - ${it.name}: \$${it.price}") }
            println("  Total: \$${getTotal()}")
        }
    }
    
    val pizzaItem = MenuItem("Pizza", 15.99)
    val saladItem = MenuItem("Salad", 8.99)
    
    val order = Order(1001)
    order.addItem(pizzaItem)
    order.addItem(saladItem)
    order.display()
    
    /* 🍳 TRY IT YOURSELF:
     * 
     * 1. Create a class `Recipe` with name, prepTime, cookTime, and ingredients
     *    Add method `getTotalTime()` that sums prepTime + cookTime
     * 
     * 2. Create a data class `Customer` with name, email, and loyaltyPoints
     *    Use copy() to add 10 loyalty points
     * 
     * 3. Create a class `Pantry` that can store ingredients (use MutableList)
     *    Add methods: addIngredient(), removeIngredient(), listIngredients()
     * 
     * 4. Challenge: Create a `ShoppingCart` class with:
     *    - Items list (MenuItem objects)
     *    - addItem(), removeItem(), getTotal()
     *    - applyDiscount(percent) method
     * 
     * 5. Advanced: Create a `Cookbook` class that contains multiple Recipe objects
     *    Add ability to search recipes by ingredient
     */
    
    println("\n" + "=".repeat(60))
    println("🎉 Congratulations! You've mastered Kotlin Classes!")
    println("=".repeat(60))
    
    println("""
        
        💡 QUICK REFERENCE:
        • class ClassName { }           - Basic class
        • class Class(val prop: Type)   - Primary constructor
        • init { }                       - Initialization block
        • constructor() : this() { }    - Secondary constructor
        • data class Data(...)          - Auto toString, equals, copy
        • inner class Inner             - Class inside class
        • get() / set()                 - Custom property accessors
        
    """.trimIndent())
}
