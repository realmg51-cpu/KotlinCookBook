/**
 * Recipe: Null Safety Basics
 * 
 * What you'll learn:
 * - Nullable types (String?)
 * - Safe call operator (?.)
 * - Elvis operator (?:)
 * 
 * Kitchen analogy:
 * - `?.` = "Check if ingredient exists before using"
 * - `?:` = "If empty, use backup ingredient"
 */

fun main() {
    println("🍳 Null Safety Kitchen")
    println("=====================")
    
    // ===== 1. NULLABLE VARIABLE =====
    var secret: String? = null
    println("1. Secret ingredient: $secret")
    
    // ===== 2. SAFE CALL (?.) =====
    println("2. Length (safe call): ${secret?.length}")
    
    // ===== 3. ELVIS OPERATOR (?:) =====
    val display = secret ?: "No secret"
    println("3. Display (Elvis): $display")
    
    // ===== 4. ASSIGN VALUE =====
    secret = "Love"
    println("4. After assigning: $secret")
    println("5. Length now: ${secret?.length}")
    
    // ===== 5. LET SCOPE =====
    secret?.let {
        println("6. Cooking with: $it 🍳")
    }
    
    // ===== SUMMARY =====
    println("\n📚 Rules:")
    println("   • ?. = safe call (returns null if null)")
    println("   • ?: = Elvis (provides default)")
    println("   • let = run code if not null")
}

/* ===== INTERACTIVE VERSION (run locally, NOT in CI) =====
fun main() {
    print("Enter your secret ingredient: ")
    val input = readln()
    val secret: String? = if (input.isEmpty()) null else input
    
    println("Secret: ${secret ?: "none"}")
    secret?.let { println("Cooking with $it!") }
}
*/
