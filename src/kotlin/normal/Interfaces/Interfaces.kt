/**
 * Recipe: Interfaces 📋
 * 
 * What you'll learn:
 * - What are Interfaces (contracts that classes can implement)
 * - Default implementations (methods with bodies)
 * - Properties in interfaces
 * - Multiple interface inheritance
 * 
 * Kitchen analogy:
 * An interface is like a JOB DESCRIPTION!
 * - "Can Cook" means you must have a cook() method
 * - A chef can implement multiple interfaces (Cookable, Cleanable, Bakeable)
 * 
 * @author Your realmg51-cpu
 * @since May 2026
 */

// ============================================================
// INTERFACES (MUST be at TOP LEVEL, not inside main)
// ============================================================

// Basic interface
interface Cookable {
    fun cook()  // No body - must implement
}

// Interface with default implementation
interface Cleanable {
    fun clean() {
        println("🧹 Cleaning up...")
    }
}

// Interface with properties
interface Nameable {
    val name: String
    val description: String
        get() = "Item: $name"
}

// Multiple interfaces
interface Heatable {
    fun heat(temp: Int)
}

interface Measureable {
    fun measure(): Double
}

// Kitchen interfaces
interface CanCook {
    fun prepareDish(dish: String)
    fun getSpecialty(): String
}

interface CanBake {
    fun bake(item: String, temp: Int)
    fun getBakingSkills(): String = "Basic baking"
}

interface CanGrill {
    fun grill(food: String, minutes: Int)
}

// Appliance interfaces
interface Appliance {
    fun turnOn()
    fun turnOff()
}

interface SmartAppliance : Appliance {
    fun connectToWifi()
    fun getStatus(): String
}

// Animal interfaces
interface Flyable {
    fun fly()
}

// Database interface
interface RecipeDatabase {
    fun saveRecipe(name: String, ingredients: List<String>)
    fun saveRecipes(recipes: Map<String, List<String>>) {
        println("Saving ${recipes.size} recipes...")
        recipes.forEach { (name, ingredients) -> saveRecipe(name, ingredients) }
    }
    fun getRecipeCount(): Int = 0
}

// Order interfaces
interface Orderable {
    val price: Double
    fun getDescription(): String
    fun isAvailable(): Boolean = true
}

interface Discountable {
    fun applyDiscount(percent: Int): Double
    fun hasLoyaltyDiscount(): Boolean = false
}

// ============================================================
// CLASSES IMPLEMENTING INTERFACES
// ============================================================

class Chef : Cookable {
    override fun cook() {
        println("👨‍🍳 Chef is cooking!")
    }
}

class Assistant : Cleanable  // Uses default clean()

class KitchenTool(override val name: String) : Nameable

class Microwave : Heatable, Measureable {
    override fun heat(temp: Int) = println("🔥 Heating to ${temp}°C")
    override fun measure(): Double = 1.5
}

class PastryChef : CanCook, CanBake {
    override fun prepareDish(dish: String) = println("🍰 Preparing $dish")
    override fun getSpecialty(): String = "Desserts"
    override fun bake(item: String, temp: Int) = println("🎂 Baking $item at ${temp}°C")
    override fun getBakingSkills(): String = "Expert pastry chef"
}

class GrillMaster : CanCook, CanGrill {
    override fun prepareDish(dish: String) = println("🥩 Preparing $dish")
    override fun getSpecialty(): String = "BBQ"
    override fun grill(food: String, minutes: Int) = println("🔥 Grilling $food for $minutes min")
}

class SmartOven : SmartAppliance {
    override fun turnOn() = println("🔥 Oven on")
    override fun turnOff() = println("❄️ Oven off")
    override fun connectToWifi() = println("📶 Connected to WiFi")
    override fun getStatus(): String = "Oven ready"
}

class Bird(name: String) : Flyable {
    override fun fly() = println("$name is flying!")
}

class SimpleDatabase : RecipeDatabase {
    private val recipes = mutableListOf<String>()
    override fun saveRecipe(name: String, ingredients: List<String>) {
        recipes.add(name)
        println("  📝 Saved: $name")
    }
    override fun getRecipeCount(): Int = recipes.size
}

class MenuItem(
    override val price: Double,
    private val name: String,
    private val available: Boolean = true
) : Orderable, Discountable {
    override fun getDescription(): String = "$name - $${price}"
    override fun isAvailable(): Boolean = available
    override fun applyDiscount(percent: Int): Double = price - (price * percent / 100)
    override fun hasLoyaltyDiscount(): Boolean = true
}

// ============================================================
// MAIN FUNCTION
// ============================================================

fun main() {
    println("📋 INTERFACES - Job Descriptions for Your Code\n")
    
    // Part 1: Basic interface
    println("📚 PART 1: Basic Interface")
    println("-".repeat(50))
    val chef = Chef()
    chef.cook()
    
    // Part 2: Default implementation
    println("\n📚 PART 2: Default Implementation")
    println("-".repeat(50))
    val assistant = Assistant()
    assistant.clean()
    
    // Part 3: Properties in interfaces
    println("\n📚 PART 3: Properties")
    println("-".repeat(50))
    val knife = KitchenTool("Chef's Knife")
    println("Name: ${knife.name}")
    println("Description: ${knife.description}")
    
    // Part 4: Multiple interfaces
    println("\n📚 PART 4: Multiple Interfaces")
    println("-".repeat(50))
    val microwave = Microwave()
    microwave.heat(180)
    println("Measure: ${microwave.measure()} min")
    
    // Part 5: Kitchen example
    println("\n📚 PART 5: Kitchen Example")
    println("-".repeat(50))
    val pastryChef = PastryChef()
    pastryChef.prepareDish("Tiramisu")
    pastryChef.bake("Croissant", 180)
    println("Specialty: ${pastryChef.getSpecialty()}")
    println("Skills: ${pastryChef.getBakingSkills()}")
    
    val grillMaster = GrillMaster()
    grillMaster.prepareDish("Steak")
    grillMaster.grill("Ribeye", 8)
    println("Specialty: ${grillMaster.getSpecialty()}")
    
    // Part 6: Interface inheritance
    println("\n📚 PART 6: Interface Inheritance")
    println("-".repeat(50))
    val oven = SmartOven()
    oven.turnOn()
    oven.connectToWifi()
    println(oven.getStatus())
    oven.turnOff()
    
    // Part 7: Database example
    println("\n📚 PART 7: Database with Default Methods")
    println("-".repeat(50))
    val db = SimpleDatabase()
    val recipes = mapOf(
        "Pizza" to listOf("Dough", "Cheese", "Tomato"),
        "Pasta" to listOf("Pasta", "Sauce", "Parmesan")
    )
    db.saveRecipes(recipes)
    println("Total: ${db.getRecipeCount()} recipes")
    
    // Part 8: Order system
    println("\n📚 PART 8: Order System")
    println("-".repeat(50))
    val pizza = MenuItem(15.99, "Margherita Pizza")
    println(pizza.getDescription())
    println("Available: ${pizza.isAvailable()}")
    println("After 20% discount: $${pizza.applyDiscount(20)}")
    println("Loyalty discount? ${pizza.hasLoyaltyDiscount()}")
    
    // Part 9: Interface vs Abstract Class
    println("\n📚 PART 9: Interface vs Abstract Class")
    println("-".repeat(50))
    abstract class Animal(val name: String) {
        abstract fun makeSound()
        fun breathe() = println("$name is breathing")
    }
    class Sparrow(name: String) : Animal(name), Flyable {
        override fun makeSound() = println("$name says: Chirp!")
        override fun fly() = println("$name is flying!")
    }
    val sparrow = Sparrow("Sparrow")
    sparrow.breathe()
    sparrow.makeSound()
    sparrow.fly()
    
    // Part 10: Real example - Payment
    println("\n📚 PART 10: Payment Example")
    println("-".repeat(50))
    interface Payable {
        fun pay(amount: Double)
        fun getMethod(): String
    }
    class CreditCard(val number: String) : Payable {
        override fun pay(amount: Double) = println("Paid $$amount with card $number")
        override fun getMethod(): String = "Credit Card"
    }
    class PayPal(val email: String) : Payable {
        override fun pay(amount: Double) = println("Paid $$amount with PayPal ($email)")
        override fun getMethod(): String = "PayPal"
    }
    
    val card = CreditCard("****1234")
    val paypal = PayPal("chef@kitchen.com")
    card.pay(49.99)
    paypal.pay(29.99)
    
    /* 🍳 TRY IT YOURSELF:
     * 
     * 1. Create interface `Playable` with play(), pause(), stop()
     *    Create class `MusicPlayer` that implements it
     * 
     * 2. Create interface `Scalable` with scale(factor: Double)
     *    And `Resizable` with resize(width: Int, height: Int)
     *    Create class `Image` that implements both
     * 
     * 3. Create interface `Thermometer` with property `temperature: Double`
     *    And method `getReading()` with default implementation
     */
    
    println("\n" + "=".repeat(60))
    println("🎉 Interfaces Mastered!")
    println("=".repeat(60))
    
    println("""
        
        💡 QUICK SUMMARY:
        • Interface = CONTRACT (what to do, not how)
        • Class can implement MULTIPLE interfaces
        • Can have default method implementations
        • Can have properties (no backing fields)
        • Use when you need multiple inheritance
        
    """.trimIndent())
}
