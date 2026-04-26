
# ✏️ Recipe: Working with Mutable Lists (`mutableListOf`)

> *"A whiteboard that you can erase, rewrite, and reorganize – perfect for dynamic menus!"*

---

## 📋 Table of Contents

1. [What You'll Learn](#-what-youll-learn)
2. [The Kitchen Analogy](#-the-kitchen-analogy)
3. [What is `mutableListOf`?](#-what-is-mutablelistof)
4. [Creating Mutable Lists](#-creating-mutable-lists)
5. [Adding Items](#-adding-items)
6. [Removing Items](#-removing-items)
7. [Updating Items](#-updating-items)
8. [Other Modifications](#-other-modifications)
9. [Looping Through Mutable Lists](#-looping-through-mutable-lists)
10. [`mutableListOf` vs `listOf`](#-mutablelistof-vs-listof)
11. [Converting Between Types](#-converting-between-types)
12. [Common Operations in Practice](#-common-operations-in-practice)
13. [Try It Yourself – Exercises](#-try-it-yourself--exercises)
14. [Common Pitfalls](#-common-pitfalls)
15. [Real-World Examples](#-real-world-examples)
16. [What's Next?](#-whats-next)
17. [Recipe Summary](#-recipe-summary)

---

## 🎯 What You'll Learn

By the end of this recipe, you will be able to:

- ✅ Create **mutable** lists using `mutableListOf`
- ✅ **Add** items to a list (`add`, `addAll`, `addAt`)
- ✅ **Remove** items from a list (`remove`, `removeAt`, `removeAll`, `clear`)
- ✅ **Update** items at specific positions
- ✅ **Sort** and **shuffle** lists in-place
- ✅ Convert between **immutable** and **mutable** lists
- ✅ Understand when to use `mutableListOf` vs `listOf`
- ✅ Avoid common **concurrent modification** errors

---

## 🍽️ The Kitchen Analogy

### From Fixed Board to Dynamic Whiteboard

Remember the **fixed wooden board** from the `listOf` recipe? That was perfect for a **set menu** that never changes.

But sometimes, you need a **dynamic whiteboard** – especially when you're running a busy kitchen where **orders keep coming in**!

```
┌─────────────────────────────────────────┐
│           TODAY'S LIVE MENU             │
├─────────────────────────────────────────┤
│  1. Beef Wellington        [SOLD OUT]   │ ← Can remove
│  2. Lobster Bisque         [ADDED]      │ ← Can add
│  3. Chocolate Fondant      [UPDATED]    │ ← Can change
│  4. Mushroom Risotto       [NEW!]       │ ← Can insert
│  5. Tiramisu               [CHEF'S PICK]│
└─────────────────────────────────────────┘
          ✏️ CAN ERASE • ADD • REWRITE ✏️
```

**On a whiteboard, you can:**

| Action | Example |
|--------|---------|
| ➕ **Add** a new dish | "Add Mushroom Risotto at the end" |
| 📍 **Insert** at a specific position | "Put Salad as the second item" |
| ✖️ **Remove** a dish | "Beef Wellington is sold out – erase it" |
| ✏️ **Update** a dish | "Change price of Lobster Bisque" |
| 🔀 **Reorder** | "Move Tiramisu to the top" |
| 🧹 **Clear** the board | "New day, new menu – erase everything" |
| 🔄 **Sort** | "Alphabetize all dishes" |

This **dynamic whiteboard** is exactly how `mutableListOf` works in Kotlin!

> 💡 **Chef's Tip:** Use `listOf` for permanent data (like a printed recipe book). Use `mutableListOf` for data that changes (like today's orders, shopping cart, or live scores).

---

## 🔍 What is `mutableListOf`?

`mutableListOf` is a function in Kotlin that creates a **mutable** (changeable) list. Unlike `listOf`, you can add, remove, replace, and reorder items.

**Syntax:**
```kotlin
val listName = mutableListOf(item1, item2, item3, ...)
```

**Key characteristics:**

| Property | Description |
|----------|-------------|
| **Ordered** | Items stay in insertion order (unless you change them) |
| **Indexed** | Each item has a position (0, 1, 2, ...) |
| **Mutable** | ✅ Can add, remove, update, reorder |
| **Type-safe** | Kotlin infers the type automatically |
| **Can contain duplicates** | Yes, `[1, 2, 2, 3]` is allowed |
| **Can be empty** | Yes, `mutableListOf()` |
| **Can hold null values** | Yes, if you specify nullable type |

---

## 🥣 Creating Mutable Lists

### Basic Creation

```kotlin
// Empty mutable list (must specify type)
val empty = mutableListOf<String>()
val emptyInts: MutableList<Int> = mutableListOf()

// With initial items
val numbers = mutableListOf(10, 20, 30, 40, 50)
val fruits = mutableListOf("Apple", "Banana", "Orange", "Mango")
val mixed = mutableListOf(42, "Hello", true, 3.14)

// With explicit type
val doubles: MutableList<Double> = mutableListOf(1.0, 2.5, 3.7)

// With nullable items
val withNulls: MutableList<String?> = mutableListOf("Apple", null, "Orange")
```

### Using `MutableList` Constructor

```kotlin
// Create list with size and initializer
val squares = MutableList(5) { index -> index * index }
println(squares)  // [0, 1, 4, 9, 16]

// Create list with all zeros
val zeros = MutableList(10) { 0 }
println(zeros)  // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
```

### From Other Collections

```kotlin
// From array
val array = arrayOf("a", "b", "c")
val fromArray = array.toMutableList()
println(fromArray)  // [a, b, c]

// From range
val fromRange = (1..5).toMutableList()
println(fromRange)  // [1, 2, 3, 4, 5]

// From immutable list
val immutable = listOf(1, 2, 3)
val mutable = immutable.toMutableList()
println(mutable)  // [1, 2, 3]
```

---

## ➕ Adding Items

### `add(item)` – Add to the end

```kotlin
val fruits = mutableListOf("Apple", "Banana")
fruits.add("Orange")
fruits.add("Mango")
println(fruits)  // [Apple, Banana, Orange, Mango]
```

### `add(index, item)` – Insert at specific position

```kotlin
val colors = mutableListOf("Red", "Blue", "Green")
colors.add(1, "Yellow")        // Insert at index 1
println(colors)                // [Red, Yellow, Blue, Green]
```

> ⚠️ Shifts the element currently at that position (and any subsequent elements) to the right.

### `addAll(collection)` – Add multiple items

```kotlin
val numbers = mutableListOf(1, 2, 3)
numbers.addAll(listOf(4, 5, 6))
println(numbers)  // [1, 2, 3, 4, 5, 6]

// Add at specific index
numbers.addAll(3, listOf(10, 11))
println(numbers)  // [1, 2, 3, 10, 11, 4, 5, 6]
```

### Adding Null Values

```kotlin
val list = mutableListOf<String?>("A", "B")
list.add(null)      // Allowed
list.add(null)
println(list)       // [A, B, null, null]
```

---

## ✖️ Removing Items

### `remove(element)` – Remove first occurrence

```kotlin
val fruits = mutableListOf("Apple", "Banana", "Orange", "Banana")
fruits.remove("Banana")  // Removes only the FIRST Banana
println(fruits)          // [Apple, Orange, Banana]
```

Returns `true` if element was found and removed, `false` otherwise.

### `removeAt(index)` – Remove by position

```kotlin
val colors = mutableListOf("Red", "Green", "Blue", "Yellow")
val removed = colors.removeAt(1)  // Removes "Green"
println(colors)    // [Red, Blue, Yellow]
println(removed)   // Green
```

### `removeAll(collection)` – Remove multiple items

```kotlin
val numbers = mutableListOf(1, 2, 3, 4, 5, 2, 3)
numbers.removeAll(listOf(2, 3))  // Removes ALL occurrences of 2 and 3
println(numbers)  // [1, 4, 5]
```

### `retainAll(collection)` – Keep only specified items

```kotlin
val numbers = mutableListOf(1, 2, 3, 4, 5, 6)
numbers.retainAll(listOf(2, 4, 6))  // Keep only 2, 4, 6
println(numbers)  // [2, 4, 6]
```

### `removeIf(predicate)` – Remove based on condition

```kotlin
val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
numbers.removeIf { it % 2 == 0 }  // Remove all even numbers
println(numbers)  // [1, 3, 5, 7, 9]
```

### `clear()` – Remove all items

```kotlin
val list = mutableListOf(1, 2, 3)
list.clear()
println(list)  // []
println(list.isEmpty())  // true
```

---

## ✏️ Updating Items

### Set value at index

```kotlin
val fruits = mutableListOf("Apple", "Banana", "Orange")
fruits[1] = "Blueberry"      // Replace index 1
println(fruits)              // [Apple, Blueberry, Orange]

// Or using .set()
fruits.set(2, "Cherry")
println(fruits)              // [Apple, Blueberry, Cherry]
```

### Fill entire list

```kotlin
val numbers = mutableListOf(1, 2, 3, 4, 5)
numbers.fill(0)  // Replace all with 0
println(numbers)  // [0, 0, 0, 0, 0]
```

### Replace with conditions

```kotlin
val scores = mutableListOf(45, 72, 68, 91, 55)

// Replace all scores below 60 with 60
for (i in scores.indices) {
    if (scores[i] < 60) {
        scores[i] = 60
    }
}
println(scores)  // [60, 72, 68, 91, 60]
```

---

## 🔄 Other Modifications

### `sort()` – Sort in ascending order

```kotlin
val numbers = mutableListOf(5, 2, 8, 1, 9)
numbers.sort()
println(numbers)  // [1, 2, 5, 8, 9]

val words = mutableListOf("banana", "apple", "cherry")
words.sort()
println(words)  // [apple, banana, cherry]
```

### `sortDescending()` – Sort in descending order

```kotlin
val numbers = mutableListOf(5, 2, 8, 1, 9)
numbers.sortDescending()
println(numbers)  // [9, 8, 5, 2, 1]
```

### `sortBy()` – Sort by a property

```kotlin
data class Person(val name: String, val age: Int)

val people = mutableListOf(
    Person("Alice", 25),
    Person("Bob", 18),
    Person("Charlie", 32)
)

people.sortBy { it.age }
println(people.map { it.name })  // [Bob, Alice, Charlie]

people.sortByDescending { it.age }
println(people.map { it.name })  // [Charlie, Alice, Bob]
```

### `shuffle()` – Randomize order

```kotlin
val numbers = mutableListOf(1, 2, 3, 4, 5)
numbers.shuffle()
println(numbers)  // Random order, e.g., [3, 5, 1, 4, 2]
```

### `reverse()` – Reverse order

```kotlin
val letters = mutableListOf("A", "B", "C", "D")
letters.reverse()
println(letters)  // [D, C, B, A]
```

### `swap()` – Swap two elements (custom function)

```kotlin
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

val fruits = mutableListOf("Apple", "Banana", "Orange")
fruits.swap(0, 2)
println(fruits)  // [Orange, Banana, Apple]
```

---

## 🔄 Looping Through Mutable Lists

All the same looping techniques work, but you can modify the list *carefully*:

```kotlin
val numbers = mutableListOf(1, 2, 3, 4, 5)

// Regular for loop
for (num in numbers) {
    println(num)
}

// For loop with index
for (i in numbers.indices) {
    numbers[i] = numbers[i] * 2  // Modify in-place
}
println(numbers)  // [2, 4, 6, 8, 10]

// forEach
numbers.forEach { println(it) }

// forEachIndexed
numbers.forEachIndexed { index, value ->
    println("Index $index: $value")
}
```

> ⚠️ **WARNING:** Do NOT modify a list while iterating over it with `for (item in list)`! Use `removeIf()` or iterate backwards.

---

## ⚖️ `mutableListOf` vs `listOf`

This comparison is critical for choosing the right tool:

| Feature | `listOf` (Immutable) | `mutableListOf` |
|---------|---------------------|-----------------|
| **Creation** | `val list = listOf(1,2,3)` | `val list = mutableListOf(1,2,3)` |
| **Add item** | ❌ `list.add(4)` error | ✅ `list.add(4)` |
| **Insert at index** | ❌ `list.add(1, 4)` error | ✅ `list.add(1, 4)` |
| **Add multiple** | ❌ `list.addAll(...)` error | ✅ `list.addAll(...)` |
| **Remove item** | ❌ `list.remove(1)` error | ✅ `list.remove(1)` |
| **Remove by index** | ❌ `list.removeAt(0)` error | ✅ `list.removeAt(0)` |
| **Remove with condition** | ❌ `list.removeIf {...}` error | ✅ `list.removeIf {...}` |
| **Modify item** | ❌ `list[0]=10` error | ✅ `list[0]=10` |
| **Sort in-place** | ❌ `list.sort()` error | ✅ `list.sort()` |
| **Shuffle** | ❌ `list.shuffle()` error | ✅ `list.shuffle()` |
| **Reverse** | ❌ `list.reverse()` error | ✅ `list.reverse()` |
| **Clear** | ❌ `list.clear()` error | ✅ `list.clear()` |
| **Thread-safe?** | ✅ Yes (if items are immutable) | ❌ No (needs manual sync) |
| **Performance** | 🚀 Slightly better | 🐢 Slightly slower |

### When to Use Which?

| Scenario | Use |
|----------|-----|
| Fixed data (constants, config) | `listOf` |
| Parameters that shouldn't change | `listOf` |
| API return values (read-only) | `listOf` |
| Shopping cart (items come and go) | `mutableListOf` |
| Task list (add/remove tasks) | `mutableListOf` |
| Live scores (updates frequently) | `mutableListOf` |
| Building a list dynamically | `mutableListOf` |

> 🧑‍🍳 **Golden Rule:** Default to `listOf`. If you find yourself fighting to modify it, switch to `mutableListOf`. Don't use mutable lists "just in case" – that's like using a chainsaw to cut a tomato!

---

## 🔄 Converting Between Types

### Immutable → Mutable

```kotlin
val readOnly = listOf(1, 2, 3, 4, 5)
val mutable = readOnly.toMutableList()
mutable.add(6)
println(mutable)  // [1, 2, 3, 4, 5, 6]
```

### Mutable → Immutable

```kotlin
val mutable = mutableListOf(1, 2, 3)
val readOnly = mutable.toList()
// readOnly.add(4)  // ❌ Compile error!

// Changes to mutable DO NOT affect the copy
mutable.add(4)
println(mutable)   // [1, 2, 3, 4]
println(readOnly)  // [1, 2, 3] (unchanged!)
```

### Creating a Defensive Copy

```kotlin
class ShoppingCart(private val items: MutableList<String>) {
    // Return a defensive copy to prevent external modification
    fun getItems(): List<String> {
        return items.toList()  // Immutable snapshot
    }
    
    fun addItem(item: String) {
        items.add(item)
    }
}
```

---

## 🛠️ Common Operations in Practice

### Combining Add and Remove

```kotlin
val cart = mutableListOf("Apple", "Banana", "Orange")

// Replace Banana with Blueberry
cart.remove("Banana")
cart.add("Blueberry")
println(cart)  // [Apple, Orange, Blueberry]

// Better: replace at index
val index = cart.indexOf("Orange")
if (index != -1) {
    cart[index] = "Mango"
}
println(cart)  // [Apple, Mango, Blueberry]
```

### Batch Operations

```kotlin
val tasks = mutableListOf(
    "Buy milk",
    "Call doctor",
    "Write code",
    "Exercise",
    "Read book"
)

// Remove multiple tasks
tasks.removeAll(listOf("Buy milk", "Read book"))
println(tasks)  // [Call doctor, Write code, Exercise]

// Keep only specific tasks
tasks.retainAll(listOf("Write code", "Exercise"))
println(tasks)  // [Write code, Exercise]
```

### Conditional Removal

```kotlin
val scores = mutableListOf(85, 45, 92, 38, 76, 55, 88)

// Remove all failing scores (below 50)
scores.removeIf { it < 50 }
println(scores)  // [85, 92, 76, 55, 88]
```

### In-Place Transformation

```kotlin
val prices = mutableListOf(10.0, 20.0, 30.0, 40.0)

// Apply 10% discount to all items
for (i in prices.indices) {
    prices[i] = prices[i] * 0.9
}
println(prices)  // [9.0, 18.0, 27.0, 36.0]

// Using replaceAll (Kotlin 1.6+)
prices.replaceAll { it * 0.9 }
println(prices)  // [8.1, 16.2, 24.3, 32.4]
```

---

## 🧪 Try It Yourself – Exercises

### 🍜 Beginner Exercises

**Exercise 1: Shopping List**
```kotlin
// Create a mutable list of 3 grocery items
// Add two more items
// Remove the second item
// Print the final list
```

**Solution:**
```kotlin
val groceries = mutableListOf("Milk", "Eggs", "Bread")
groceries.add("Butter")
groceries.add("Cheese")
groceries.removeAt(1)  // Removes "Eggs"
println(groceries)  // [Milk, Bread, Butter, Cheese]
```

---

**Exercise 2: Update Scores**
```kotlin
val scores = mutableListOf(75, 82, 90, 68, 95)
// Add 5 bonus points to each score
// Print the updated scores
```

**Solution:**
```kotlin
for (i in scores.indices) {
    scores[i] = scores[i] + 5
}
println(scores)  // [80, 87, 95, 73, 100]
```

---

### 🥘 Intermediate Exercises

**Exercise 3: Todo List Manager**
```kotlin
val todos = mutableListOf(
    "Finish report",
    "Buy groceries",
    "Call mom",
    "Clean room"
)

// 1. Mark "Call mom" as done (remove it)
// 2. Add "Learn Kotlin" to the beginning
// 3. Sort the list alphabetically
// 4. Print the list
```

**Solution:**
```kotlin
todos.remove("Call mom")
todos.add(0, "Learn Kotlin")
todos.sort()
println(todos)  // [Buy groceries, Clean room, Finish report, Learn Kotlin]
```

---

**Exercise 4: Remove Duplicates**
```kotlin
val numbers = mutableListOf(1, 2, 2, 3, 4, 4, 4, 5, 1, 2)
// Remove all duplicates (keep only first occurrence)
// Hint: You can use toSet() or build a new list
```

**Solution:**
```kotlin
val unique = numbers.toSet().toMutableList()
println(unique)  // [1, 2, 3, 4, 5]

// OR manually (to understand the logic)
val seen = mutableSetOf<Int>()
val iterator = numbers.iterator()
while (iterator.hasNext()) {
    val value = iterator.next()
    if (value in seen) {
        iterator.remove()
    } else {
        seen.add(value)
    }
}
println(numbers)  // [1, 2, 3, 4, 5]
```

---

### 🔥 Advanced Exercises

**Exercise 5: Playlist Manager**
```kotlin
data class Song(val title: String, val artist: String, val durationSeconds: Int)

val playlist = mutableListOf(
    Song("Bohemian Rhapsody", "Queen", 354),
    Song("Imagine", "John Lennon", 183),
    Song("Hotel California", "Eagles", 391),
    Song("Shape of You", "Ed Sheeran", 233)
)

// 1. Add a new song at the end
// 2. Remove songs longer than 300 seconds (5 minutes)
// 3. Move "Imagine" to the first position
// 4. Sort remaining songs by duration
// 5. Print the final playlist
```

**Solution:**
```kotlin
// 1. Add
playlist.add(Song("Blinding Lights", "The Weeknd", 200))

// 2. Remove long songs
playlist.removeIf { it.durationSeconds > 300 }
// Removed: Bohemian Rhapsody, Hotel California

// 3. Move "Imagine" to first
val imagine = playlist.find { it.title == "Imagine" }
if (imagine != null) {
    playlist.remove(imagine)
    playlist.add(0, imagine)
}

// 4. Sort by duration
playlist.sortBy { it.durationSeconds }

// 5. Print
playlist.forEach { println("${it.title} - ${it.durationSeconds}s") }
// Output:
// Imagine - 183s
// Blinding Lights - 200s
// Shape of You - 233s
```

---

**Exercise 6: Filtering with Modification**
```kotlin
val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// Replace all odd numbers with their square
// Example: 1→1, 3→9, 5→25, etc.
// Keep even numbers unchanged
```

**Solution:**
```kotlin
for (i in numbers.indices) {
    if (numbers[i] % 2 != 0) {
        numbers[i] = numbers[i] * numbers[i]
    }
}
println(numbers)  // [1, 2, 9, 4, 25, 6, 49, 8, 81, 10]
```

---

## ⚠️ Common Pitfalls

### Pitfall 1: Concurrent Modification

```kotlin
val numbers = mutableListOf(1, 2, 3, 4, 5)

// ❌ BAD - ConcurrentModificationException!
// for (num in numbers) {
//     if (num % 2 == 0) {
//         numbers.remove(num)  // CRASH!
//     }
// }

// ✅ GOOD - Use removeIf
numbers.removeIf { it % 2 == 0 }
println(numbers)  // [1, 3, 5]

// ✅ GOOD - Iterate backwards
for (i in numbers.size - 1 downTo 0) {
    if (numbers[i] % 2 == 0) {
        numbers.removeAt(i)
    }
}
```

### Pitfall 2: IndexOutOfBoundsException

```kotlin
val list = mutableListOf(1, 2, 3)

// ❌ BAD - Index 3 doesn't exist
// list[3] = 10  // IndexOutOfBoundsException!
// list.add(5, 20)  // IndexOutOfBoundsException!

// ✅ GOOD - Check bounds
if (3 < list.size) {
    list[3] = 10
} else {
    list.add(10)  // Add to end
}
```

### Pitfall 3: Confusing `remove` with `removeAt`

```kotlin
val list = mutableListOf(10, 20, 30, 20)

list.remove(20)     // Removes the VALUE 20 (first occurrence)
println(list)       // [10, 30, 20]

val another = mutableListOf(10, 20, 30)
another.removeAt(1) // Removes element at INDEX 1 (value 20)
println(another)    // [10, 30]
```

### Pitfall 4: Modifying After Creating Read-Only View

```kotlin
val mutable = mutableListOf(1, 2, 3)
val readOnly = mutable.toList()

mutable.add(4)
println(mutable)   // [1, 2, 3, 4]
println(readOnly)  // [1, 2, 3] - NOT updated!

// The readOnly is a SNAPSHOT, not a live view
```

### Pitfall 5: Using `val` But Mutating Contents

Remember: `val` prevents reassigning the variable, but DOES NOT prevent modifying the list's contents!

```kotlin
val list = mutableListOf(1, 2, 3)
list.add(4)     // ✅ Allowed! (mutating content)
list = mutableListOf(4, 5, 6)  // ❌ ERROR! Cannot reassign

val immutable = listOf(1, 2, 3)
immutable.add(4)  // ❌ ERROR! Cannot mutate content
```

---

## 🌍 Real-World Examples

### Example 1: Shopping Cart System

```kotlin
data class CartItem(val name: String, val price: Double, var quantity: Int)

class ShoppingCart {
    private val items = mutableListOf<CartItem>()
    
    fun addItem(name: String, price: Double, quantity: Int = 1) {
        val existing = items.find { it.name == name }
        if (existing != null) {
            existing.quantity += quantity
        } else {
            items.add(CartItem(name, price, quantity))
        }
    }
    
    fun removeItem(name: String) {
        items.removeIf { it.name == name }
    }
    
    fun updateQuantity(name: String, newQuantity: Int) {
        if (newQuantity <= 0) {
            removeItem(name)
        } else {
            items.find { it.name == name }?.quantity = newQuantity
        }
    }
    
    fun getTotal(): Double {
        return items.sumOf { it.price * it.quantity }
    }
    
    fun getItems(): List<CartItem> = items.toList()  // Defensive copy
    
    fun clear() = items.clear()
}

fun main() {
    val cart = ShoppingCart()
    cart.addItem("Laptop", 999.99)
    cart.addItem("Mouse", 25.99, 2)
    cart.addItem("Laptop", 999.99)  // Adds another laptop? No, increases quantity
    
    println("Total: \$${cart.getTotal()}")  // Laptop x2 + Mouse x2
    
    cart.updateQuantity("Mouse", 1)
    println("After update: \$${cart.getTotal()}")
    
    cart.removeItem("Laptop")
    println("After removal: \$${cart.getTotal()}")
}
```

### Example 2: Task Manager with Priorities

```kotlin
data class Task(val id: Int, var description: String, var isComplete: Boolean = false)

class TaskManager {
    private val tasks = mutableListOf<Task>()
    private var nextId = 1
    
    fun addTask(description: String) {
        tasks.add(Task(nextId++, description))
    }
    
    fun completeTask(id: Int) {
        tasks.find { it.id == id }?.isComplete = true
    }
    
    fun deleteTask(id: Int) {
        tasks.removeIf { it.id == id }
    }
    
    fun moveToTop(id: Int) {
        val task = tasks.find { it.id == id }
        if (task != null) {
            tasks.remove(task)
            tasks.add(0, task)
        }
    }
    
    fun sortByCompletion() {
        tasks.sortBy { it.isComplete }
    }
    
    fun getPendingTasks(): List<Task> = tasks.filter { !it.isComplete }
    
    fun getCompletedTasks(): List<Task> = tasks.filter { it.isComplete }
    
    fun printAll() {
        tasks.forEachIndexed { index, task ->
            val status = if (task.isComplete) "✓" else "□"
            println("${index + 1}. [$status] ${task.description} (ID: ${task.id})")
        }
    }
}

fun main() {
    val manager = TaskManager()
    manager.addTask("Buy groceries")
    manager.addTask("Write report")
    manager.addTask("Call dentist")
    
    manager.completeTask(2)
    manager.moveToTop(3)
    manager.addTask("Learn Kotlin")
    
    println("All tasks:")
    manager.printAll()
    
    println("\nPending: ${manager.getPendingTasks().size}")
    println("Completed: ${manager.getCompletedTasks().size}")
}
```

### Example 3: Live Scoreboard

```kotlin
data class Team(val name: String, var score: Int = 0)

class Scoreboard {
    private val teams = mutableListOf<Team>()
    
    fun addTeam(name: String) {
        teams.add(Team(name))
    }
    
    fun addPoints(teamName: String, points: Int) {
        teams.find { it.name == teamName }?.score?.let {
            teams.find { it.name == teamName }!!.score += points
        }
    }
    
    fun removeTeam(teamName: String) {
        teams.removeIf { it.name == teamName }
    }
    
    fun sortByScore() {
        teams.sortByDescending { it.score }
    }
    
    fun getTopScorers(n: Int): List<Team> {
        return teams.sortedByDescending { it.score }.take(n)
    }
    
    fun printStandings() {
        println("\n=== SCOREBOARD ===")
        teams.sortedByDescending { it.score }.forEachIndexed { index, team ->
            println("${index + 1}. ${team.name}: ${team.score}")
        }
    }
}

fun main() {
    val scoreboard = Scoreboard()
    scoreboard.addTeam("Dragons")
    scoreboard.addTeam("Phoenix")
    scoreboard.addTeam("Wolves")
    
    scoreboard.addPoints("Dragons", 25)
    scoreboard.addPoints("Phoenix", 42)
    scoreboard.addPoints("Wolves", 18)
    scoreboard.addPoints("Dragons", 10)
    
    scoreboard.printStandings()
    // Output:
    // 1. Phoenix: 42
    // 2. Dragons: 35
    // 3. Wolves: 18
    
    println("\nTop 2: ${scoreboard.getTopScorers(2).map { it.name }}")
    // Top 2: [Phoenix, Dragons]
}
```

---

## 🗺️ What's Next?

Now that you've mastered `mutableListOf`, you're ready for:

| Recipe | What You'll Learn |
|--------|-------------------|
| **`setOf` / `mutableSetOf`** | Unique elements (no duplicates) |
| **`mapOf` / `mutableMapOf`** | Key-value pairs (dictionaries) |
| **LambdaFunctions** | Transform and filter collections |
| **Scope Functions** | `let`, `run`, `apply`, `also`, `with` |
| **Coroutines** | Async operations with collections |

---

## 📝 Recipe Summary

### Quick Reference Card

```kotlin
// CREATE
val list = mutableListOf(1, 2, 3)

// ADD
list.add(4)                    // [1, 2, 3, 4]
list.add(1, 99)                // [1, 99, 2, 3, 4]
list.addAll(listOf(5, 6))      // [1, 99, 2, 3, 4, 5, 6]

// REMOVE
list.remove(3)                 // [1, 99, 2, 4, 5, 6]
list.removeAt(1)               // [1, 2, 4, 5, 6]
list.removeIf { it > 4 }       // [1, 2, 4]
list.clear()                   // []

// UPDATE
list[0] = 10                   // [10, 2, 4]
list.fill(0)                   // [0, 0, 0]

// SORT & REORDER
list.sort()                    // Ascending
list.sortDescending()          // Descending
list.shuffle()                 // Random order
list.reverse()                 // Reverse order

// CONVERT
val immutable = list.toList()  // To read-only
val mutable = list.toMutableList()  // From read-only
```

### Key Takeaways

1. ✅ `mutableListOf` creates **changeable** lists
2. ✅ Use **add**, **remove**, **set** to modify contents
3. ✅ `val` prevents reassignment but NOT mutation
4. ✅ Never modify a list while iterating over it (use `removeIf`)
5. ✅ Convert to `listOf` when you need a read-only snapshot
6. ✅ Default to `listOf` – only use mutable when you need changes
7. ✅ Always create **defensive copies** when exposing mutable lists to external code

---

## 🎉 Congratulations, Chef!

You've successfully mastered the **Mutable List** recipe! 🧑‍🍳

You can now:
- Create and manage dynamic collections
- Add, remove, and update items with confidence
- Sort, shuffle, and reorganize lists
- Choose between mutable and immutable wisely
- Build real-world applications like shopping carts and task managers

**Remember:** 
> *"With great mutability comes great responsibility."* 🕷️

Use mutable lists when you need them, but always prefer immutable lists for safety. Your future self (and your teammates) will thank you!

---

*"A mutable list is like a whiteboard – powerful, but erase carefully!"*

— Kotlin Kitchen Wisdom 📚

---

## 🔗 Related Resources

- 📖 [Official Kotlin Collections Documentation](https://kotlinlang.org/docs/collections-overview.html)
- 📖 [MutableList API Reference](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/)
- 🍳 [Previous Recipe: listOf →](../List.kt)
- 🍳 [Next Recipe: Set →](../../Set/Set.kt)

---

**Happy coding, Chef!** 🚀👨‍🍳
