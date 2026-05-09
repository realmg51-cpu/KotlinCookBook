/**
 * Recipe: Coroutines 🚀
 * 
 * Learn: Lightweight concurrency
 * 
 * @author realmg51-cpu
 * @since May 2026
 */

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("🚀 COROUTINES - Efficient Kitchen Management\n")
    
    // Basic launch
    println("📚 PART 1: Basic Coroutines")
    println("-".repeat(50))
    
    launch {
        delay(1000)
        println("   👨‍🍳 Task 1: Water boiling!")
    }
    
    launch {
        delay(500)
        println("   👩‍🍳 Task 2: Chopping veggies!")
    }
    
    launch {
        delay(1500)
        println("   🍳 Task 3: Sauce ready!")
    }
    
    delay(2000)
    
    // Async with results
    println("\n📚 PART 2: Getting Results")
    println("-".repeat(50))
    
    val result1 = async {
        delay(1000)
        "🍚 Rice"
    }
    
    val result2 = async {
        delay(800)
        "🍛 Curry"
    }
    
    println("   Dishes: ${result1.await()}, ${result2.await()}")
    
    // Cooking simulation
    println("\n📚 PART 3: Restaurant Orders")
    println("-".repeat(50))
    
    suspend fun cook(dish: String, time: Long): String {
        delay(time)
        return "$dish ready (${time}ms)"
    }
    
    val pizza = async { cook("🍕 Pizza", 2000) }
    val pasta = async { cook("🍝 Pasta", 1500) }
    val salad = async { cook("🥗 Salad", 1000) }
    
    println("   ${pizza.await()}")
    println("   ${pasta.await()}")
    println("   ${salad.await()}")
    
    println("\n🎉 All coroutines completed!")
}
