/**
 * Recipe: Map - Key-Value Pairs
 * 
 * Learn: Store and lookup data by unique keys
 * 
 * @author Kotlin CookBook
 */

fun main() {
    println("=" .repeat(50))
    println("📖 KOTLIN MAP RECIPE")
    println("=" .repeat(50))
    
    // ========== 1. CREATE MAPS ==========
    println("\n1️⃣ CREATE MAPS")
    
    // Immutable map (read-only)
    val readOnly = mapOf(
        "Apple" to 1.99,
        "Banana" to 0.99,
        "Orange" to 2.49
    )
    println("Immutable: $readOnly")
    
    // Mutable map (can change)
    val prices = mutableMapOf(
        "Apple" to 1.99,
        "Banana" to 0.99
    )
    println("Mutable: $prices")
    
    // ========== 2. ACCESS VALUES ==========
    println("\n2️⃣ ACCESS VALUES")
    
    println("Apple price: ${prices["Apple"]}")           // 1.99
    println("Grape price: ${prices["Grape"]}")           // null
    println("Grape default: ${prices.getOrDefault("Grape", 0.0)}")  // 0.0
    
    // ========== 3. ADD & UPDATE ==========
    println("\n3️⃣ ADD & UPDATE")
    
    prices["Orange"] = 2.49      // Add new
    prices["Apple"] = 2.19       // Update existing
    prices.put("Grape", 3.99)    // Alternative way
    println("After adds: $prices")
    
    // ========== 4. REMOVE ==========
    println("\n4️⃣ REMOVE")
    
    prices.remove("Banana")
    println("After remove: $prices")
    
    // ========== 5. CHECK EXISTENCE ==========
    println("\n5️⃣ CHECK EXISTENCE")
    
    println("Has Apple? ${"Apple" in prices}")        // true
    println("Has Banana? ${prices.containsKey("Banana")}")  // false
    println("Has price 2.49? ${prices.containsValue(2.49)}")  // true
    
    // ========== 6. LOOP THROUGH MAP ==========
    println("\n6️⃣ LOOP THROUGH")
    
    // Method 1: Destructuring
    for ((item, price) in prices) {
        println("$item: $$price")
    }
    
    // Method 2: forEach
    prices.forEach { (item, price) ->
        println("→ $item costs $$price")
    }
    
    // Loop through keys only
    println("Keys: ${prices.keys}")
    
    // Loop through values only
    println("Values: ${prices.values}")
    
    // ========== 7. USEFUL OPERATIONS ==========
    println("\n7️⃣ USEFUL OPERATIONS")
    
    // Get size
    println("Size: ${prices.size}")
    
    // Check empty
    println("Is empty? ${prices.isEmpty()}")
    
    // Get all entries
    println("Entries: ${prices.entries}")
    
    // ========== 8. CONVERT BETWEEN TYPES ==========
    println("\n8️⃣ CONVERT")
    
    // Mutable → Immutable
    val snapshot = prices.toMap()
    // snapshot["Mango"] = 1.99  // ❌ Error! Immutable
    
    // List of pairs → Map
    val pairList = listOf("A" to 1, "B" to 2)
    val fromList = pairList.toMap()
    println("From list: $fromList")
    
    // Map → List
    val toList = prices.toList()
    println("To list: $toList")
    
    // ========== 9. DEFAULT VALUES ==========
    println("\n9️⃣ DEFAULT VALUES")
    
    val withDefault = mutableMapOf<String, Int>().withDefault { 0 }
    withDefault["Score"] = 100
    println(withDefault.getValue("Score"))    // 100
    println(withDefault.getValue("Missing"))  // 0 (default)
    
    // ========== 10. REAL EXAMPLE ==========
    println("\n🔟 REAL EXAMPLE: Student Grades")
    
    val grades = mutableMapOf<String, Int>()
    
    // Add grades
    grades["Alice"] = 85
    grades["Bob"] = 92
    grades["Charlie"] = 78
    
    // Update grade
    grades["Alice"] = 90
    
    // Calculate average
    val average = grades.values.average()
    println("Grades: $grades")
    println("Average: ${"%.1f".format(average)}")
    
    // Find top student
    val topStudent = grades.maxByOrNull { it.value }
    println("Top student: ${topStudent?.key} with ${topStudent?.value}")
    
    // Add bonus points
    for (student in grades.keys) {
        grades[student] = grades[student]!! + 5
    }
    println("After bonus: $grades")
}

/* 🍳 TRY IT YOURSELF:
1. Create a phone book (name → phone number). Add 3 contacts, update one, remove one.
2. Count word frequencies in a sentence: "apple banana apple orange banana apple"
3. Create a shopping cart with product names and quantities. Add items, update quantities.
*/
