/**
 * Recipe: Set - Unique Elements Collection
 * 
 * Learn: Store unique elements, no duplicates allowed
 * 
 * @author Kotlin CookBook
 */

fun main() {
    println("=" .repeat(50))
    println("🃏 KOTLIN SET RECIPE")
    println("=" .repeat(50))
    
    // ========== 1. CREATE SETS ==========
    println("\n1️⃣ CREATE SETS")
    
    // Immutable set (read-only)
    val unique = setOf(1, 2, 3, 2, 1, 4, 2, 5)
    println("Set (duplicates removed): $unique")  // [1, 2, 3, 4, 5]
    
    // Mutable set
    val tags = mutableSetOf("kotlin", "java", "python")
    println("Mutable: $tags")
    
    // ========== 2. CHECK EXISTENCE ==========
    println("\n2️⃣ CHECK EXISTENCE")
    
    println("Has 'kotlin'? ${"kotlin" in tags}")     // true
    println("Has 'ruby'? ${tags.contains("ruby")}")  // false
    println("Size: ${tags.size}")  // 3
    
    // ========== 3. ADD ELEMENTS ==========
    println("\n3️⃣ ADD ELEMENTS")
    
    tags.add("javascript")      // Add new
    tags.add("kotlin")          // Ignored (already exists)
    tags.addAll(setOf("go", "rust"))
    println("After adds: $tags")  // [kotlin, java, python, javascript, go, rust]
    
    // ========== 4. REMOVE ELEMENTS ==========
    println("\n4️⃣ REMOVE ELEMENTS")
    
    tags.remove("java")
    tags.removeIf { it.startsWith("p") }  // Removes "python"
    println("After removes: $tags")  // [kotlin, javascript, go, rust]
    
    // ========== 5. SET OPERATIONS (MATH) ==========
    println("\n5️⃣ SET OPERATIONS")
    
    val setA = setOf(1, 2, 3, 4, 5)
    val setB = setOf(4, 5, 6, 7, 8)
    
    println("Union (A ∪ B): ${setA.union(setB)}")           // [1,2,3,4,5,6,7,8]
    println("Intersection (A ∩ B): ${setA.intersect(setB)}") // [4,5]
    println("Difference (A - B): ${setA.subtract(setB)}")    // [1,2,3]
    
    // Shortcut operators
    println("Union: ${setA + setB}")     // Same as union
    println("Diff: ${setA - setB}")      // Same as subtract
    
    // ========== 6. LOOP THROUGH ==========
    println("\n6️⃣ LOOP THROUGH")
    
    val colors = setOf("Red", "Green", "Blue")
    
    // Simple for loop
    for (color in colors) {
        println("→ $color")
    }
    
    // forEach
    colors.forEach { println("Color: $it") }
    
    // ========== 7. REMOVE DUPLICATES FROM LIST ==========
    println("\n7️⃣ REMOVE DUPLICATES")
    
    val withDuplicates = listOf(1, 2, 2, 3, 3, 3, 4, 1, 5)
    val withoutDuplicates = withDuplicates.toSet()
    println("Original: $withDuplicates")
    println("Unique: $withoutDuplicates")  // [1, 2, 3, 4, 5]
    
    // ========== 8. CONVERT BETWEEN TYPES ==========
    println("\n8️⃣ CONVERT")
    
    // Set → List (to get index access)
    val setToList = unique.toList()
    println("Set to list: $setToList")
    println("First element: ${setToList[0]}")  // Can access by index now!
    
    // List → Set (removes duplicates)
    val listToSet = listOf("a", "b", "a", "c").toSet()
    println("List to set: $listToSet")  // [a, b, c]
    
    // Mutable → Immutable
    val immutable = tags.toSet()
    // immutable.add("swift")  // ❌ Error! Can't modify
    
    // ========== 9. REAL EXAMPLE ==========
    println("\n9️⃣ REAL EXAMPLE: User Tags")
    
    val user1Tags = setOf("kotlin", "android", "programming")
    val user2Tags = setOf("python", "android", "data")
    val user3Tags = setOf("kotlin", "web", "javascript")
    
    // All unique tags across all users
    val allTags = user1Tags.union(user2Tags).union(user3Tags)
    println("All tags: $allTags")
    
    // Tags common to all (intersection of all three)
    val commonTags = user1Tags.intersect(user2Tags).intersect(user3Tags)
    println("Common tags: $commonTags")  // []
    
    // Tags only user1 has
    val user1Only = user1Tags.subtract(user2Tags).subtract(user3Tags)
    println("User1 only: $user1Only")  // [programming]
    
    // ========== 10. PRACTICAL: INVITE LIST ==========
    println("\n🔟 PRACTICAL: No Duplicate Invites")
    
    val invites = mutableSetOf<String>()
    
    fun sendInvite(email: String) {
        if (invites.add(email)) {
            println("✅ Invite sent to $email")
        } else {
            println("⚠️ Already invited: $email")
        }
    }
    
    sendInvite("alice@email.com")
    sendInvite("bob@email.com")
    sendInvite("alice@email.com")  // Duplicate!
    sendInvite("charlie@email.com")
    
    println("\nFinal invite list: $invites")
    println("Total unique guests: ${invites.size}")
}

/* 🍳 TRY IT YOURSELF:
1. Create a set of your favorite movies. Try to add a duplicate.
2. Take a list with duplicates, convert to set to remove them.
3. Find common friends between two people using set intersection.
4. Create a set of banned words and check if a sentence contains any.
*/
