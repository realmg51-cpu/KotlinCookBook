/**
 * Recipe: Interfaces 📋
 * 
 * What you'll learn:
 * - What are Interfaces (contracts that classes can implement)
 * - Default implementations (methods with bodies)
 * - Properties in interfaces
 * - Multiple interface inheritance
 * - Real-world examples (Cookable, Payable, Printable)
 * 
 * Kitchen analogy:
 * An interface is like a JOB DESCRIPTION or CONTRACT!
 * - "Can Cook" means you must have a cook() method
 * - "Can Clean" means you must have a clean() method
 * 
 * A chef can implement multiple interfaces:
 * - Chef implements Cookable (must know how to cook)
 * - Chef implements Cleanable (must know how to clean)
 * - Chef implements Trainable (must be able to learn)
 * 
 * The interface just says WHAT to do, not HOW to do it!
 * 
 * @author Your Name
 * @since May 2026
 */

// ============================================================
// INTERFACES (at TOP LEVEL)
// ============================================================

// Basic interface
interface Cookable {
    fun cook()  // No body - must be implemented
}

// Interface with default implementation
interface Cleanable {
    fun clean() {
        println("🧹 Cleaning up the kitchen...")  // Default implementation
    }
}

// Interface with properties
interface Nameable {
    val name: String  // Must be overridden
    val description: String  // Can be computed
        get() = "Item: $name"
}

// Multiple interfaces example
interface Heatable {
    fun heat(temperature: Int)
}

interface Measureable {
    fun measure(): Double
    fun getUnit(): String = "grams"  // Default implementation
}

// Real-world kitchen interface
interface RecipeItem {
    val calories: Int
    fun getNutritionInfo(): String
}

fun main() {
    println("📋 INTERFACES - Job Descriptions for Your Code\n")
    
    // ============================================================
    // PART 1: BASIC INTERFACE (Simple chef)
    // ============================================================
    println("📚 PART 1: Basic Interface")
    println("-".repeat(50))
    
    class Chef : Cookable {
        override fun cook() {
            println("👨‍🍳 Chef is cooking a delicious meal!")
        }
    }
    
    val chef = Chef()
    chef.cook()
    
    // ============================================================
    // PART 2: INTERFACE WITH DEFAULT IMPLEMENTATION
    // ============================================================
    println("\n\n📚 PART 2: Interface with Default Implementation")
    println("-".repeat(50))
    
    class Assistant : Cleanable {
        // No need to override clean() - uses default
    }
    
    class SuperChef : Cookable, Cleanable {
        override fun cook() {
            println("👨‍🍳 SuperChef is cooking gourmet food!")
        }
        
        // Optionally override default method
        override fun clean() {
            println("🧼 SuperChef does extra thorough cleaning!")
        }
    }
    
    val assistant = Assistant()
    assistant.clean()
    
    val superChef = SuperChef()
    superChef.cook()
    superChef.clean()
    
    // ============================================================
    // PART 3: INTERFACE WITH PROPERTIES
    // ============================================================
    println("\n\n📚 PART 3: Interface with Properties")
    println("-".repeat(50))
    
    class KitchenTool(override val name: String) : Nameable {
        override val description: String
            get() = "Kitchen tool: $name"
    }
    
    val knife = KitchenTool("Chef's Knife")
    println("Name: ${knife.name}")
    println("Description: ${knife.description}")
    
    // ============================================================
    // PART 4: MULTIPLE INTERFACES (A class can implement many)
    // ============================================================
    println("\n\n📚 PART 4: Multiple Interfaces")
    println("-".repeat(50))
    
    class Microwave : Heatable, Measureable {
        override fun heat(temperature: Int) {
            println("🔥 Microwave heating to $temperature°C")
        }
        
        override fun measure(): Double {
            return 1.5  // minutes
        }
        
        override fun getUnit(): String {
            return "minutes"  // Override default
        }
    }
    
    val microwave = Microwave()
    microwave.heat(180)
    println("Measured: ${microwave.measure()} ${microwave.getUnit()}")
    
    // ============================================================
    // PART 5: INTERFACE INHERITANCE (Interfaces can extend)
    // ============================================================
    println("\n\n📚 PART 5: Interface Inheritance")
    println("-".repeat(50))
    
    interface Appliance {
        fun turnOn()
        fun turnOff()
    }
    
    interface SmartAppliance : Appliance {
        fun connectToWifi()
        fun getStatus(): String
    }
    
    class SmartOven : SmartAppliance {
        override fun turnOn() {
            println("🔥 Smart oven turned on")
        }
        
        override fun turnOff() {
            println("❄️ Smart oven turned off")
        }
        
        override fun connectToWifi() {
            println("📶 Connecting oven to WiFi...")
        }
        
        override fun getStatus(): String {
            return "Oven is ready and connected!"
        }
    }
    
    val oven = SmartOven()
    oven.turnOn()
    oven.connectToWifi()
    println(oven.getStatus())
    oven.turnOff()
    
    // ============================================================
    // PART 6: REAL KITCHEN EXAMPLE - Cooking appliances
    // ============================================================
    println("\n\n📚 PART 6: Real Kitchen Example")
    println("-".repeat(50))
    
    interface CanCook {
        fun prepareDish(dish: String)
        fun getSpecialty(): String
    }
    
    interface CanBake {
        fun bake(item: String, temperature: Int)
        fun getBakingSkills(): String = "Basic baking"
    }
    
    interface CanGrill {
        fun grill(food: String, minutes: Int)
    }
    
    class PastryChef : CanCook, CanBake {
        override fun prepareDish(dish: String) {
            println("🍰 Preparing fancy dessert: $dish")
        }
        
        override fun getSpecialty(): String {
            return "Desserts and pastries"
        }
        
        override fun bake(item: String, temperature: Int) {
            println("🎂 Baking $item at ${temperature}°C with precision")
        }
        
        override fun getBakingSkills(): String {
            return "Expert pastry chef"
        }
    }
    
    class GrillMaster : CanCook, CanGrill {
        override fun prepareDish(dish: String) {
            println("🥩 Preparing grilled dish: $dish")
        }
        
        override fun getSpecialty(): String {
            return "BBQ and grilling"
        }
        
        override fun grill(food: String, minutes: Int) {
            println("🔥 Grilling $food for $minutes minutes on open flame")
        }
    }
    
    val pastryChef = PastryChef()
    pastryChef.prepareDish("Tiramisu")
    pastryChef.bake("Croissant", 180)
    println("Specialty: ${pastryChef.getSpecialty()}")
    println("Skills: ${pastryChef.getBakingSkills()}")
    
    println()
    
    val grillMaster = GrillMaster()
    grillMaster.prepareDish("Steak")
    grillMaster.grill("Ribeye", 8)
    println("Specialty: ${grillMaster.getSpecialty()}")
    
    // ============================================================
    // PART 7: INTERFACE VS ABSTRACT CLASS
    // ============================================================
    println("\n\n📚 PART 7: Interface vs Abstract Class")
    println("-".repeat(50))
    
    // Interface: contract, no state
    interface Flyable {
        fun fly()
    }
    
    // Abstract class: can have state
    abstract class Animal(val name: String) {
        abstract fun makeSound()
        
        fun breathe() {
            println("$name is breathing")
        }
    }
    
    class Bird(name: String) : Animal(name), Flyable {
        override fun makeSound() {
            println("$name says: Chirp chirp!")
        }
        
        override fun fly() {
            println("$name is flying!")
        }
    }
    
    val bird = Bird("Sparrow")
    bird.breathe()
    bird.makeSound()
    bird.fly()
    
    // ============================================================
    // PART 8: INTERFACE WITH COMPLEX DEFAULTS
    // ============================================================
    println("\n\n📚 PART 8: Complex Default Methods")
    println("-".repeat(50))
    
    interface RecipeDatabase {
        fun saveRecipe(name: String, ingredients: List<String>)
        
        // Default implementation with helper logic
        fun saveRecipes(recipes: Map<String, List<String>>) {
            println("💾 Saving ${recipes.size} recipes to database...")
            recipes.forEach { (name, ingredients) ->
                saveRecipe(name, ingredients)
            }
            println("✅ All recipes saved!")
        }
        
        // Extension-like functionality
        fun getRecipeCount(): Int = 0  // Default, can override
    }
    
    class SimpleDatabase : RecipeDatabase {
        private val recipes = mutableListOf<String>()
        
        override fun saveRecipe(name: String, ingredients: List<String>) {
            recipes.add(name)
            println("  📝 Saved recipe: $name (${ingredients.size} ingredients)")
        }
        
        override fun getRecipeCount(): Int = recipes.size
    }
    
    val db = SimpleDatabase()
    val myRecipes = mapOf(
        "Pizza" to listOf("Dough", "Cheese", "Tomato"),
        "Pasta" to listOf("Pasta", "Sauce", "Parmesan"),
        "Salad" to listOf("Lettuce", "Tomato", "Cucumber")
    )
    db.saveRecipes(myRecipes)
    println("Total recipes: ${db.getRecipeCount()}")
    
    // ============================================================
    // PART 9: INTERFACE CONFLICT RESOLUTION (Same method name)
    // ============================================================
    println("\n\n📚 PART 9: Resolving Method Conflicts")
    println("-".repeat(50))
    
    interface Chef1 {
        fun cook() {
            println("Chef1: Cooking with spices")
        }
    }
    
    interface Chef2 {
        fun cook() {
            println("Chef2: Cooking with herbs")
        }
    }
    
    class MasterChef : Chef1, Chef2 {
        // Must resolve conflict
        override fun cook() {
            super<Chef1>.cook()  // Call Chef1's version
            super<Chef2>.cook()  // Call Chef2's version
            println("MasterChef: Combining both styles!")
        }
        
        // Or provide completely new implementation
        fun cookMyWay() {
            println("MasterChef: Using my secret recipe!")
        }
    }
    
    val master = MasterChef()
    master.cook()
    master.cookMyWay()
    
    // ============================================================
    // PART 10: PRACTICAL ORDER SYSTEM
    // ============================================================
    println("\n\n📚 PART 10: Practical Example - Order System")
    println("-".repeat(50))
    
    interface Orderable {
        val price: Double
        fun getDescription(): String
        fun isAvailable(): Boolean = true  // Default: available
    }
    
    interface Discountable {
        fun applyDiscount(percent: Int): Double
        fun hasLoyaltyDiscount(): Boolean = false
    }
    
    class MenuItem(
        override val price: Double,
        private val name: String,
        private val available: Boolean = true
    ) : Orderable, Discountable {
        
        override fun getDescription(): String {
            return "$name - $${price}"
        }
        
        override fun isAvailable(): Boolean = available
        
        override fun applyDiscount(percent: Int): Double {
            val discount = price * percent / 100
            return price - discount
        }
        
        override fun hasLoyaltyDiscount(): Boolean = true
    }
    
    val pizzaItem = MenuItem(15.99, "Margherita Pizza")
    val soldOutItem = MenuItem(9.99, "Daily Soup", false)
    
    println("Item: ${pizzaItem.getDescription()}")
    println("Available: ${pizzaItem.isAvailable()}")
    println("After 20% discount: $${pizzaItem.applyDiscount(20)}")
    println("Has loyalty? ${pizzaItem.hasLoyaltyDiscount()}")
    
    println("\nSold out: ${soldOutItem.getDescription()}")
    println("Available: ${soldOutItem.isAvailable()}")
    
    /* 🍳 TRY IT YOURSELF:
     * 
     * 1. Create interface `Playable` with play(), pause(), stop() methods
     *    Create class `MusicPlayer` that implements it
     * 
     * 2. Create interface `Scalable` with scale(factor: Double)
     *    And `Resizable` with resize(width: Int, height: Int)
     *    Create class `Image` that implements both
     * 
     * 3. Create interface `Thermometer` with property `temperature: Double`
     *    And method `getReading()` with default implementation
     * 
     * 4. Challenge: Create kitchen interfaces:
     *    - `Blendable` with blend(speed: Int)
     *    - `Fryable` with fry(oilAmount: Double)
     *    - `Boilable` with boil(time: Int)
     *    Then class `Multicooker` that implements all three
     */
    
    println("\n" + "=".repeat(60))
    println("🎉 Interfaces Mastered! You now understand contracts!")
    println("=".repeat(60))
    
    println("""
        
        💡 INTERFACE QUICK SUMMARY:
        
        ✅ Use Interface when:
        • Defining a CONTRACT (what to do, not how)
        • Multiple unrelated classes share behavior
        • You need multiple inheritance (class can implement many)
        
        ❌ Use Abstract Class when:
        • You need to store STATE (properties with backing fields)
        • You have a common BASE implementation
        • Classes are closely related (hierarchy)
        
        📋 Interface Features:
        • Can have properties (but no backing fields)
        • Can have default implementations
        • Can inherit from other interfaces
        • No constructors
        
        🆚 Comparison:
        | Feature              | Interface | Abstract Class |
        |---------------------|-----------|----------------|
        | Multiple inheritance| ✅ Yes    | ❌ No         |
        | State (fields)       | ❌ No     | ✅ Yes        |
        | Constructors        | ❌ No     | ✅ Yes        |
        | Default methods     | ✅ Yes    | ✅ Yes        |
        
    """.trimIndent())
}
