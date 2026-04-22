/**
 * Recipe: Input & Null Safety
 * 
 * What you'll learn:
 * - Get user input with readln()
 * - Handle null values safely
 * - Use ?. (safe call), ?: (Elvis), and !! (risky)
 * 
 * Kitchen analogy:
 * - `?.` = Check if ingredient exists before using it
 * - `?:` = "If empty, use this backup ingredient"
 * - `!!` = "I'm 100% sure this ingredient is here!" (dangerous!)
 */

fun main() {
    println("🍳 Welcome to the Null Safety Kitchen!")
    println("======================================")
    
    // ===== PART 1: GETTING USER INPUT =====
    println("\n📝 What's your favorite dish?")
    // val dish = readln()  
	val dish = "fish"
	// Safe - readln() never returns 
	// because Input doesn't work CI enviroment so I'll comment it.
    
    println("How many years have you been cooking?")
	val years = 3
    // val input = readln()
    //val years = input.toIntOrNull()  // Returns null if not a number
    
    // ===== PART 2: HANDLING NULL WITH ELVIS =====
    val experience = years ?: 0  // Elvis operator: if years is null, use 0
    
    println("\n👨‍🍳 So you love $dish and have been cooking for $experience years!")
    
    // ===== PART 3: SAFE CALL OPERATOR =====
    var secretIngredient: String? = null  // Nullable type
    
    // Safe call - won't crash
    println("\n🔍 Secret ingredient length: ${secretIngredient?.length ?: "unknown"}")
    
    // Let's add a secret ingredient
    println("\n🥫 Want to add a secret ingredient? (yes/no)")
    val answer = readln().lowercase()
    
    if (answer == "yes") {
        println("What's your secret ingredient?")
        secretIngredient = readln()
        println("✨ Added: ${secretIngredient ?: "nothing"} to the recipe!")
    }
    
    // ===== PART 4: let() SCOPE FUNCTION =====
    println("\n🎯 Let's use your secret ingredient!")
    
    secretIngredient?.let {
        // This block only runs if secretIngredient is NOT null
        println("   Cooking with $it... 🍳")
        println("   The $it makes it special!")
    } ?: run {
        println("   No secret ingredient today. Still delicious!")
    }
    
    // ===== PART 5: THE DANGEROUS !! OPERATOR =====
    println("\n⚠️  DANGER ZONE: The !! operator")
    println("   (Only use when you're 100% sure!)")
    
    var guaranteedIngredient: String? = "Salt"
    // val length = guaranteedIngredient!!.length  // Would crash if null
    
    if (guaranteedIngredient != null) {
        println("   ✅ Guaranteed ingredient exists: $guaranteedIngredient")
    }
    
    // ===== PART 6: PRACTICAL EXAMPLE =====
    println("\n🍝 Let's make Spaghetti!")
    println("   What would you like to add?")
    
    val topping = readlnOrNull()  // Can return null (e.g., Ctrl+D)
    
    val finalTopping = topping?.let {
        when (it.lowercase()) {
            "cheese" -> "🧀 Parmesan"
            "basil" -> "🌿 Fresh Basil"
            "mushroom" -> "🍄 Sauteed Mushrooms"
            else -> it
        }
    } ?: "🍅 Just tomato sauce"
    
    println("\n🍽️ Your Spaghetti with $finalTopping is ready!")
    
    // ===== SUMMARY =====
    println("\n" + "=".repeat(50))
    println("📚 Null Safety Summary:")
    println("   • `?.` - Safe call: returns null if left side is null")
    println("   • `?:` - Elvis: provides default value for null")
    println("   • `?.let { }` - Run code only if not null")
    println("   • `!!` - Force unwrap (avoid if possible!)")
    println("=".repeat(50))
    
    // Challenge for the reader
    println("\n📝 YOUR TURN:")
    println("   Write code that asks for user's age and prints:")
    println("   - 'Adult' if age >= 18")
    println("   - 'Minor' if age < 18")
    println("   - 'Invalid' if input is not a number")
    println("\n   Hint: Use readln() and toIntOrNull()!")
}

// ===== CHALLENGE SOLUTION =====
// fun main() {
//     println("Enter your age:")
//     val input = readln()
//     val age = input.toIntOrNull()
//     
//     when {
//         age == null -> println("Invalid - not a number!")
//         age >= 18 -> println("Adult")
//         else -> println("Minor")
//     }
// }
