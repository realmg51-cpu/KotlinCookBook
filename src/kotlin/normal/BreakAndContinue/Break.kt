/**
 * Recipe: BreakExample
 * What you'll learn: Stop loop when condition is met
 */

fun main() {
    var spoonful = 1
    
    while (spoonful <= 10) {
        println("🥄 Tasting spoonful #$spoonful")
        
        if (spoonful == 5) {
            println("✅ Perfect! No more tasting needed!")
            break  // Exit loop immediately
        }
        
        spoonful++
    }
    
    println("Loop stopped at spoonful #$spoonful")
}
