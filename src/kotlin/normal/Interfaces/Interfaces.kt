/**
 * Recipe: Interfaces 📋
 * 
 * What you'll learn:
 * - What are Interfaces (contracts that classes must follow)
 * - How to define and implement interfaces
 * - Default implementations
 * 
 * Kitchen analogy:
 * An interface is like a JOB DESCRIPTION for kitchen staff.
 * "CanCook" means you MUST have a cook() method.
 * 
 * @author realmg51-cpu
 * @since May 2026
 */

// Interface: The contract
interface CanCook {
    fun cook()                    // Must implement
    fun clean() {                 // Default implementation (optional)
        println("🧹 Cleaning the kitchen...")
    }
}

// Class implementing the interface
class Chef : CanCook {
    override fun cook() {
        println("👨‍🍳 Chef is cooking a delicious meal!")
    }
    // clean() is optional - can use default or override
}

class BeginnerChef : CanCook {
    override fun cook() {
        println("🍳 Beginner is learning to cook...")
    }
    
    override fun clean() {
        println("🧼 Beginner does extra thorough cleaning!")
    }
}

fun main() {
    println("📋 INTERFACES - Job Description for Cooks\n")
    
    val chef = Chef()
    chef.cook()
    chef.clean()  // Uses default implementation
    
    println()
    
    val beginner = BeginnerChef()
    beginner.cook()
    beginner.clean()  // Uses overridden version
    
    /* 🍳 TRY IT YOURSELF:
     * 
     * 1. Create interface `CanBake` with bake() method
     * 2. Create class `Baker` that implements it
     * 3. Add default method `preheat()` to the interface
     */
    
    println("\n💡 Key Points:")
    println("• Interface = Contract (WHAT to do, not HOW)")
    println("• Class implements interface using ':' ")
    println("• Must override abstract methods")
    println("• Can have default implementations")
    println("• A class can implement MULTIPLE interfaces")
}
