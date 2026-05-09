/**
 * Recipe: Coroutines 🚀
 * 
 * What you'll learn:
 * - What are Coroutines (lightweight threads)
 * - How to launch coroutines
 * - suspend functions
 * - delay() vs Thread.sleep()
 * - Basic coroutine builders: launch, async, runBlocking
 * 
 * Kitchen analogy:
 * Coroutines are like having MULTIPLE CHEFS in a kitchen!
 * - Without coroutines: One chef does ONE thing at a time (blocking)
 * - With coroutines: One chef can START boiling water, THEN chop veggies
 *   while waiting for water to boil (non-blocking)
 * 
 * Regular thread = A chef who stands and watches water boil 😴
 * Coroutine = A chef who starts boiling water, does other tasks, 
 *             then comes back when water is ready! 🏃‍♂️
 * 
 * @author realmg51-cpu
 * @since May 2026
 */

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println("🚀 COROUTINES - Efficient Kitchen Management\n")
    
    // ============================================================
    // PART 1: BASIC COROUTINE
    // ============================================================
    println("📚 PART 1: Launching Coroutines")
    println("-".repeat(50))
    
    println("Starting tasks...")
    
    // launch: Fire and forget (like telling chef to start a task)
    launch {
        delay(1000)  // Non-blocking wait (like waiting for water to boil)
        println("   👨‍🍳 Task 1: Water is boiling!")
    }
    
    launch {
        delay(500)
        println("   👩‍🍳 Task 2: Chopping vegetables!")
    }
    
    launch {
        delay(1500)
        println("   🍳 Task 3: Sauce is ready!")
    }
    
    println("✅ All tasks launched! (Main thread continues...)\n")
    delay(2000)  // Wait for all coroutines to finish
    
    // ============================================================
    // PART 2: suspend FUNCTIONS
    // ============================================================
    println("\n📚 PART 2: Suspend Functions")
    println("-".repeat(50))
    
    // suspend function can be paused and resumed
    suspend fun boilWater(minutes: Int) {
        println("   🔥 Starting to boil water...")
        delay(minutes * 1000L)  // Simulate boiling time
        println("   💧 Water is boiled after $minutes minutes!")
    }
    
    suspend fun chopVegetables() {
        println("   🔪 Chopping vegetables...")
        delay(1000)
        println("   🥕 Vegetables chopped!")
    }
    
    suspend fun cookPasta() {
        println("   🍝 Cooking pasta...")
        delay(2000)
        println("   🍝 Pasta is ready!")
    }
    
    launch {
        boilWater(2)
    }
    
    launch {
        chopVegetables()
    }
    
    launch {
        cookPasta()
    }
    
    delay(3000)
    
    // ============================================================
    // PART 3: runBlocking (Bridge between normal and coroutine world)
    // ============================================================
    println("\n\n📚 PART 3: runBlocking - The Main Kitchen Manager")
    println("-".repeat(50))
    
    runBlocking {
        println("👨‍🍳 Kitchen manager coordinating the team...")
        
        launch {
            repeat(3) { i ->
                println("   🍳 Cooking dish ${i + 1}/3")
                delay(500)
            }
        }
        
        launch {
            repeat(2) { i ->
                println("   🧼 Cleaning station ${i + 1}/2")
                delay(700)
            }
        }
        
        delay(2000)
        println("✅ All tasks completed!")
    }
    
    println("Back to normal code...\n")
    
    // ============================================================
    // PART 4: async (Get RETURN values)
    // ============================================================
    println("\n📚 PART 4: async - Getting Results")
    println("-".repeat(50))
    
    suspend fun cookRice(): String {
        delay(1000)
        return "🍚 Steamed rice"
    }
    
    suspend fun cookCurry(): String {
        delay(1500)
        return "🍛 Chicken curry"
    }
    
    suspend fun makeSalad(): String {
        delay(800)
        return "🥗 Fresh salad"
    }
    
    val time = measureTimeMillis {
        val riceDeferred = async { cookRice() }
        val curryDeferred = async { cookCurry() }
        val saladDeferred = async { makeSalad() }
        
        val rice = riceDeferred.await()
        val curry = curryDeferred.await()
        val salad = saladDeferred.await()
        
        println("   📦 All dishes ready:")
        println("   $rice")
        println("   $curry")
        println("   $salad")
    }
    
    println("   ⏱️ Total cooking time: ${time}ms (all cooked concurrently!)\n")
    
    // ============================================================
    // PART 5: COROUTINE VS THREAD (Comparison)
    // ============================================================
    println("\n📚 PART 5: Coroutine vs Thread")
    println("-".repeat(50))
    
    // Thread way (heavy, blocking)
    println("🐌 THREADS (Old way):")
    val threadStart = System.currentTimeMillis()
    
    thread {
        Thread.sleep(1000)
        println("   Thread 1 done")
    }
    thread {
        Thread.sleep(500)
        println("   Thread 2 done")
    }
    
    Thread.sleep(1500)
    val threadTime = System.currentTimeMillis() - threadStart
    
    // Coroutine way (light, non-blocking)
    println("\n🚀 COROUTINES (New way):")
    val coroutineStart = System.currentTimeMillis()
    
    runBlocking {
        launch {
            delay(1000)
            println("   Coroutine 1 done")
        }
        launch {
            delay(500)
            println("   Coroutine 2 done")
        }
    }
    
    val coroutineTime = System.currentTimeMillis() - coroutineStart
    println("\n   ⏱️ Thread time: ${threadTime}ms")
    println("   ⏱️ Coroutine time: ${coroutineTime}ms")
    println("   💡 Both take similar time, but coroutines use FEWER resources!\n")
    
    // ============================================================
    // PART 6: KITCHEN ORDER SYSTEM (Real example)
    // ============================================================
    println("\n📚 PART 6: Restaurant Order System")
    println("-".repeat(50))
    
    data class Order(val id: Int, val dish: String)
    
    suspend fun processOrder(order: Order) {
        println("   📝 Order #${order.id}: Processing ${order.dish}")
        
        // Simulate different cooking times
        val cookTime = when {
            order.dish.contains("Pizza") -> 2000L
            order.dish.contains("Pasta") -> 1500L
            else -> 1000L
        }
        
        delay(cookTime)
        println("   ✅ Order #${order.id}: ${order.dish} is ready! (${cookTime}ms)")
    }
    
    runBlocking {
        println("👨‍🍳 Restaurant kitchen opening...\n")
        
        val orders = listOf(
            Order(101, "Margherita Pizza"),
            Order(102, "Spaghetti Pasta"),
            Order(103, "Caesar Salad"),
            Order(104, "Pepperoni Pizza")
        )
        
        val startTime = System.currentTimeMillis()
        
        // Process all orders concurrently
        val jobs = orders.map { order ->
            launch { processOrder(order) }
        }
        
        jobs.forEach { it.join() }  // Wait for all
        
        val totalTime = System.currentTimeMillis() - startTime
        println("\n   🎉 All orders completed in ${totalTime}ms!")
        println("   💡 If done sequentially, would take ~6500ms")
    }
    
    // ============================================================
    // PART 7: CANCELLATION
    // ============================================================
    println("\n📚 PART 7: Cancelling Coroutines")
    println("-".repeat(50))
    
    runBlocking {
        val cookingJob = launch {
            repeat(10) { i ->
                println("   🍳 Cooking step ${i + 1}/10...")
                delay(500)
            }
            println("   ✅ Meal completed!")
        }
        
        delay(1500)  // Let it cook for 1.5 seconds
        println("   🛑 Customer cancelled the order!")
        cookingJob.cancel()
        
        if (cookingJob.isCancelled) {
            println("   ❌ Cooking cancelled mid-way!")
        }
    }
    
    // ============================================================
    // PART 8: withTimeout (Auto-cancel after time limit)
    // ============================================================
    println("\n📚 PART 8: Timeout")
    println("-".repeat(50))
    
    runBlocking {
        suspend fun slowCooking() {
            println("   🔥 Starting slow-cooked meal...")
            delay(3000)
            println("   🍲 Meal ready!")
        }
        
        try {
            withTimeout(2000) {
                slowCooking()
            }
        } catch (e: TimeoutCancellationException) {
            println("   ⏰ Timeout! Meal took too long, cancelled!")
        }
    }
    
    // ============================================================
    // PART 9: Multiple coroutines on different contexts
    // ============================================================
    println("\n📚 PART 9: Different Dispatchers")
    println("-".repeat(50))
    
    runBlocking {
        println("🔄 Coroutines on different threads:")
        
        launch(Dispatchers.Default) {
            println("   🔹 Default dispatcher (CPU work): ${Thread.currentThread().name}")
            delay(500)
        }
        
        launch(Dispatchers.IO) {
            println("   🔸 IO dispatcher (File/Network): ${Thread.currentThread().name}")
            delay(500)
        }
        
        launch(Dispatchers.Unconfined) {
            println("   🔹 Unconfined dispatcher: ${Thread.currentThread().name}")
            delay(500)
        }
        
        delay(1000)
    }
    
    /* 🍳 TRY IT YOURSELF:
     * 
     * 1. Create a suspend function `fetchMenu()` that loads menu after 1 second
     *    Use launch to fetch the menu in background
     * 
     * 2. Use async to fetch 3 different recipes simultaneously
     *    Each recipe takes different time (1s, 2s, 3s)
     *    Display all recipes when all are ready
     * 
     * 3. Create a coroutine that shows a countdown timer (5,4,3,2,1)
     *    Cancel it if user presses "stop" (simulate with delay)
     * 
     * 4. Challenge: Create a kitchen automation system where:
     *    - 3 chefs working concurrently
     *    - Each chef prepares 2 dishes
     *    - Use coroutines to manage the workflow
     *    - Track total time vs sequential time
     */
    
    println("\n" + "=".repeat(60))
    println("🎉 Coroutines Mastered! Your kitchen is now EFFICIENT!")
    println("=".repeat(60))
    
    println("""
        
        💡 QUICK SUMMARY:
        
        • launch    = Fire and forget (no return value)
        • async     = Returns a result (use .await())
        • delay()   = Non-blocking wait (coroutine friendly)
        • runBlocking = Bridge between normal and coroutine code
        
        ✅ COROUTINES ARE:
        • Lightweight (1,000+ coroutines vs 1,000 threads)
        • Non-blocking (doesn't waste CPU)
        • Easy to cancel
        • Sequential-looking code, concurrent execution
        
        🚀 Dispatchers:
        • Dispatchers.Default - CPU intensive work
        • Dispatchers.IO - Network, file operations
        • Dispatchers.Main - UI thread (Android)
        • Dispatchers.Unconfined - Not recommended for production
        
    """.trimIndent())
}
