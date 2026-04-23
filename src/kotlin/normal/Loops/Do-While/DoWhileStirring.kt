/**
 * Recipe: Do-While Loop
 * 
 * What you'll learn:
 * - do-while runs AT LEAST once
 * - Difference between while and do-while
 * 
 * Kitchen analogy:
 * "Taste first, then decide!" 👨‍🍳
 */

fun main() {
    println("🍳 Do-While Loop Kitchen")
    println("========================")
    
    // ===== EXAMPLE 1: BASIC DO-WHILE =====
    println("\n🥣 Example: Tasting Soup")
    
    var tasteCount = 0
    
    do {
        tasteCount++
        println("   Taste #$tasteCount")
        
        if (tasteCount >= 3) {
            println("   ✅ Perfect!")
        } else {
            println("   🧂 Needs more salt...")
        }
    } while (tasteCount < 3)
    
    // ===== EXAMPLE 2: WHILE VS DO-WHILE =====
    println("\n📊 While vs Do-While")
    
    var x = 5
    println("   Do-while (runs once):")
    do {
        println("      x = $x")
        x++
    } while (x < 3)  // Condition false, but runs once!
    
    var y = 5
    println("   While (never runs):")
    while (y < 3) {
        println("      This never prints")
    }
    
    // ===== SUMMARY =====
    println("\n📚 Summary:")
    println("   do { } while (condition)")
    println("   ✓ Runs AT LEAST once")
    println("   ✓ Condition checked AFTER")
}

// ===== CHALLENGE =====
// Roll dice until you get a 6!
// fun main() {
//     var roll = 0
//     do {
//         roll = (1..6).random()
//         println("🎲 Rolled: $roll")
//     } while (roll != 6)
// }
