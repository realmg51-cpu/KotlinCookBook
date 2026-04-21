/**
 * Recipe: ContinueExample
 * What you'll learn: Skip bad items and keep going
 */

fun main() {
    val eggs = listOf("🥚 Good", "🥚 Good", "💩 Bad", "🥚 Good", "🥚 Good")
    
    for (egg in eggs.withIndex()) {
        if (egg.value == "💩 Bad") {
            println("🚫 Egg #${egg.index + 1} is bad! Throwing away...")
            continue  // Skip this egg, move to next
        }
        
        println("✅ Adding ${egg.value} egg #${egg.index + 1} to bowl")
    }
    
    println("Finished checking all eggs!")
}
