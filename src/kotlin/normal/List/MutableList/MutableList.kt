/**
 * Recipe: MutableList - Dynamic Lists
 * 
 * Learn: Add, remove, update elements in a list
 * 
 * @author Kotlin CookBook
 */

fun main() {
    // 1. CREATE mutable list
    val list = mutableListOf(1, 2, 3)
    println("Initial: $list")  // [1, 2, 3]
    
    // 2. ADD elements
    list.add(4)                // Add to end
    list.add(1, 99)            // Add at index 1
    list.addAll(listOf(5, 6))  // Add multiple
    println("After adding: $list")  // [1, 99, 2, 3, 4, 5, 6]
    
    // 3. REMOVE elements
    list.remove(3)             // Remove value 3
    list.removeAt(1)           // Remove at index 1
    list.removeIf { it > 5 }   // Remove by condition
    println("After removing: $list")  // [1, 2, 4]
    
    // 4. UPDATE elements
    list[0] = 100              // Assign new value
    println("After update: $list")  // [100, 2, 4]
    
    // 5. SORT
    val numbers = mutableListOf(5, 2, 8, 1, 9)
    numbers.sort()             // Ascending
    println("Sorted ascending: $numbers")  // [1, 2, 5, 8, 9]
    
    numbers.sortDescending()   // Descending
    println("Sorted descending: $numbers")  // [9, 8, 5, 2, 1]
    
    // 6. REVERSE
    val letters = mutableListOf("A", "B", "C")
    letters.reverse()
    println("Reversed: $letters")  // [C, B, A]
    
    // 7. CLEAR ALL
    val temp = mutableListOf(1, 2, 3)
    temp.clear()
    println("After clear: $temp")  // []
    
    // 8. Convert to immutable (read-only)
    val mutable = mutableListOf(1, 2, 3)
    val immutable = mutable.toList()
    // immutable.add(4)  // ❌ Error! Cannot modify
    
    // 9. Loop and modify (be careful!)
    val scores = mutableListOf(10, 20, 30, 40)
    for (i in scores.indices) {
        scores[i] = scores[i] * 2
    }
    println("Doubled: $scores")  // [20, 40, 60, 80]
    
    // 10. Quick checks
    println("Size: ${scores.size}")
    println("Contains 40? ${scores.contains(40)}")
    println("Is empty? ${scores.isEmpty()}")
}

/* 🍳 TRY IT YOURSELF:
1. Create a todo list, add 3 tasks, remove the 2nd task
2. Create a list of scores, remove scores below 5
3. Create a list of numbers, double each element
*/
