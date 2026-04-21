/**
 * Recipe: WhileLoopBasics
 * What you'll learn: Repeat actions while condition is true
 */

fun main() {
    // Like stirring soup: keep stirring while it's NOT ready
    var soupReady = false
    var stirCount = 0
    
    while (!soupReady) {
        stirCount++
        println("Stirring soup... (stir #$stirCount)")
        
        if (stirCount >= 5) {
            soupReady = true
            println("✅ Soup is ready!")
        }
    }
}
