
# 🧺 Recipe: Working with Lists (`listOf`)

> *"Organize your ingredients like a Michelin-star chef – keep everything in perfect, unchangeable order!"*

---

## 📋 Table of Contents

1. [What You'll Learn](#-what-youll-learn)
2. [The Kitchen Analogy](#-the-kitchen-analogy)
3. [What is `listOf`?](#-what-is-listoflistof)
4. [Creating Your First List](#-creating-your-first-list)
5. [Reading from a List](#-reading-from-a-list)
6. [Looping Through a List](#-looping-through-a-list)
7. [Common Operations](#-common-operations)
8. [`listOf` vs `mutableListOf`](#-listof-vs-mutablelistof)
9. [Transforming Lists (Without Changing Them)](#-transforming-lists-without-changing-them)
10. [Nullable Lists and Nullable Items](#-nullable-lists-and-nullable-items)
11. [Try It Yourself – Exercises](#-try-it-yourself--exercises)
12. [Common Pitfalls](#-common-pitfalls)
13. [What's Next?](#-whats-next)
14. [Recipe Summary](#-recipe-summary)

---

## 🎯 What You'll Learn

By the end of this recipe, you will be able to:

- ✅ Create **read-only lists** using `listOf`
- ✅ Access elements by **index**, `.first()`, `.last()`
- ✅ Loop through lists using `for`, `forEach`, and `forEachIndexed`
- ✅ Check if a list **contains** an item
- ✅ Find the **size** of a list
- ✅ Understand **immutability** and when to use `listOf` vs `mutableListOf`
- ✅ **Transform** lists using `map`, `filter`, `sorted` (without modifying original)
- ✅ Handle **nullable items** inside a list
- ✅ Avoid common **pitfalls**

---

## 🍽️ The Kitchen Analogy

Imagine you're the head chef at a fancy restaurant preparing for **guest chef night**.

### The Fixed Menu Board 🧾

You write today's **3 special dishes** on a beautiful wooden board:

```
┌─────────────────────────────┐
│      TODAY'S SPECIALS       │
├─────────────────────────────┤
│  1. Beef Wellington         │
│  2. Lobster Bisque          │
│  3. Chocolate Fondant       │
└─────────────────────────────┘
```

**Rules of this board:**

| Action | Allowed? | Why? |
|--------|----------|------|
| Look at dish #2 | ✅ Yes | It's written there |
| Read all dishes in order | ✅ Yes | Read from top to bottom |
| Count how many dishes | ✅ Yes | Just count the lines |
| Check if "Salad" is on the board | ✅ Yes | Look for the word |
| Add a 4th dish | ❌ No | The board is fixed |
| Remove Lobster Bisque | ❌ No | Cannot erase |
| Change Beef Wellington to Salmon | ❌ No | The board is permanent |

This **fixed wooden board** is exactly how `listOf` works in Kotlin!

### Wait, What About a Whiteboard? ✏️

A **whiteboard** would be a `mutableListOf` – you can erase, rewrite, add, and remove. But with great power comes great responsibility (and more bugs 🐛).

> 💡 **Chef's Tip:** Always start with a fixed board (`listOf`). Only switch to a whiteboard (`mutableListOf`) when you truly need to change the list later.

---

## 🔍 What is `listOf`?

`listOf` is a **function** in Kotlin that creates an **immutable** (read-only) list.

**Syntax:**
```kotlin
val listName = listOf(item1, item2, item3, ...)
```

**Key characteristics:**

| Property | Description |
|----------|-------------|
| **Ordered** | Items stay in the order you put them |
| **Indexed** | Each item has a position (0, 1, 2, ...) |
| **Immutable** | Cannot add, remove, or change items |
| **Type-safe** | Kotlin infers the type automatically |
| **Can contain duplicates** | Yes, `[1, 2, 2, 3]` is allowed |
| **Can be empty** | Yes, `listOf()` |
| **Can hold null values** | Yes, if you specify nullable type |

---

## 🥣 Creating Your First List

### Basic List Creation

```kotlin
// Simple list of integers
val numbers = listOf(10, 20, 30, 40, 50)

// List of strings
val fruits = listOf("Apple", "Banana", "Orange", "Mango")

// Mixed types (Kotlin infers List<Any>)
val mixed = listOf(42, "Hello", true, 3.14)

// Empty list (must specify type)
val empty = listOf<String>()
val emptyInts: List<Int> = listOf()

// List with explicit type
val doubles: List<Double> = listOf(1.0, 2.5, 3.7)
```

### List with Null Values

```kotlin
// List that can contain nulls (type is List<String?>)
val withNulls = listOf("Apple", null, "Orange", null)

println(withNulls) // [Apple, null, Orange, null]
println(withNulls.size) // 4
```

### List from Other Sources

```kotlin
// From a range
val rangeList = (1..10).toList() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

// From an array
val array = arrayOf("a", "b", "c")
val arrayToList = array.toList() // ["a", "b", "c"]

// Using List constructor with size and initializer
val squares = List(5) { index -> index * index }
// [0, 1, 4, 9, 16]
```

---

## 📖 Reading from a List

### Access by Index

```kotlin
val colors = listOf("Red", "Green", "Blue", "Yellow")

println(colors[0])     // Red
println(colors[1])     // Green
println(colors[2])     // Blue
println(colors[3])     // Yellow
// println(colors[4])  // ❌ IndexOutOfBoundsException!

// Using .get() method (same as [])
println(colors.get(0)) // Red
```

### Safe Access with `getOrElse` and `getOrNull`

```kotlin
val colors = listOf("Red", "Green", "Blue")

// Returns default value if index is out of bounds
println(colors.getOrElse(0) { "Unknown" })  // Red
println(colors.getOrElse(5) { "Unknown" })  // Unknown

// Returns null if index is out of bounds
println(colors.getOrNull(0))  // Red
println(colors.getOrNull(5))  // null
```

### First and Last Elements

```kotlin
val desserts = listOf("Ice Cream", "Cake", "Pie", "Brownie")

println(desserts.first())  // Ice Cream
println(desserts.last())   // Brownie

// Safe versions for empty lists
val emptyList = listOf<String>()
println(emptyList.firstOrNull())  // null
println(emptyList.lastOrNull())   // null
```

### Checking Existence

```kotlin
val fruits = listOf("Apple", "Banana", "Orange")

// Contains a single element
println(fruits.contains("Banana"))     // true
println(fruits.contains("Grape"))      // false

// Contains all elements from another collection
println(fruits.containsAll(listOf("Apple", "Orange")))  // true
println(fruits.containsAll(listOf("Apple", "Grape")))   // false

// Using 'in' operator (more readable)
println("Banana" in fruits)   // true
println("Grape" in fruits)    // false
```

### Getting Index of an Element

```kotlin
val numbers = listOf(10, 20, 30, 20, 40)

println(numbers.indexOf(20))   // 1 (first occurrence)
println(numbers.lastIndexOf(20)) // 3 (last occurrence)
println(numbers.indexOf(100))  // -1 (not found)
```

### List Properties

```kotlin
val items = listOf("One", "Two", "Three", "Four")

println(items.size)        // 4
println(items.isEmpty())   // false
println(items.isNotEmpty())// true

val empty = listOf<String>()
println(empty.isEmpty())   // true
println(empty.isNotEmpty())// false
```

---

## 🔄 Looping Through a List

### Traditional `for` Loop

```kotlin
val names = listOf("Alice", "Bob", "Charlie", "Diana")

for (name in names) {
    println("Hello, $name!")
}
// Output:
// Hello, Alice!
// Hello, Bob!
// Hello, Charlie!
// Hello, Diana!
```

### Loop with Index using `indices`

```kotlin
val names = listOf("Alice", "Bob", "Charlie")

for (i in names.indices) {
    println("Index $i: ${names[i]}")
}
// Output:
// Index 0: Alice
// Index 1: Bob
// Index 2: Charlie
```

### Loop with Index using `.withIndex()`

```kotlin
val names = listOf("Alice", "Bob", "Charlie")

for ((index, name) in names.withIndex()) {
    println("Position $index → $name")
}
// Output:
// Position 0 → Alice
// Position 1 → Bob
// Position 2 → Charlie
```

### Using `forEach` Lambda

```kotlin
val fruits = listOf("🍎 Apple", "🍌 Banana", "🍊 Orange")

// Basic forEach
fruits.forEach { fruit ->
    println("I like $fruit")
}

// Using 'it' (implicit parameter name)
fruits.forEach {
    println("Yummy $it")
}
```

### Using `forEachIndexed`

```kotlin
val winners = listOf("Gold", "Silver", "Bronze")

winners.forEachIndexed { position, medal ->
    println("Rank ${position + 1}: $medal")
}
// Output:
// Rank 1: Gold
// Rank 2: Silver
// Rank 3: Bronze
```

### While Loop with Iterator

```kotlin
val colors = listOf("Red", "Green", "Blue")
val iterator = colors.iterator()

while (iterator.hasNext()) {
    println(iterator.next())
}
```

---

## 🛠️ Common Operations

### Getting Sublists

```kotlin
val numbers = listOf(10, 20, 30, 40, 50, 60)

// Sublist from index 1 (inclusive) to 4 (exclusive)
println(numbers.subList(1, 4))  // [20, 30, 40]

// Take first N elements
println(numbers.take(3))        // [10, 20, 30]

// Take last N elements
println(numbers.takeLast(2))    // [50, 60]

// Drop first N elements
println(numbers.drop(2))        // [30, 40, 50, 60]

// Drop last N elements
println(numbers.dropLast(2))    // [10, 20, 30, 40]
```

### Checking Conditions

```kotlin
val scores = listOf(85, 92, 78, 95, 88)

// All elements satisfy condition?
println(scores.all { it >= 60 })  // true (all are 60+)
println(scores.all { it >= 90 })  // false (not all are 90+)

// Any element satisfies condition?
println(scores.any { it >= 90 })  // true (92 and 95)
println(scores.any { it >= 100 }) // false

// None satisfy condition?
println(scores.none { it >= 100 }) // true
println(scores.none { it >= 90 })  // false
```

### Finding Elements

```kotlin
val numbers = listOf(5, 12, 8, 21, 15, 7)

// Find first matching element
println(numbers.find { it > 10 })     // 12
println(numbers.firstOrNull { it > 10 }) // 12 (same)

// Find last matching element
println(numbers.findLast { it > 10 }) // 15
println(numbers.lastOrNull { it > 10 }) // 15

// Find with predicate (throws NoSuchElementException if none)
println(numbers.first { it > 10 })    // 12
// println(numbers.first { it > 100 }) // Exception!
```

### Counting

```kotlin
val items = listOf("apple", "banana", "apple", "orange", "apple", "grape")

// Count all
println(items.size)           // 6
println(items.count())        // 6 (same)

// Count with condition
println(items.count { it == "apple" })  // 3
println(items.count { it.length > 5 })  // 2 (banana, orange)
```

---

## ⚖️ `listOf` vs `mutableListOf`

This is one of the most important decisions when working with lists!

| Feature | `listOf` (Immutable) | `mutableListOf` |
|---------|---------------------|-----------------|
| **Creation** | `val list = listOf(1,2,3)` | `val list = mutableListOf(1,2,3)` |
| **Add item** | ❌ `list.add(4)` error | ✅ `list.add(4)` |
| **Remove item** | ❌ `list.remove(1)` error | ✅ `list.remove(1)` |
| **Modify item** | ❌ `list[0]=10` error | ✅ `list[0]=10` |
| **Clear list** | ❌ `list.clear()` error | ✅ `list.clear()` |
| **Sort in-place** | ❌ Not possible | ✅ `list.sort()` |
| **Thread-safe?** | ✅ Yes (if items are immutable) | ❌ No (manual synchronization needed) |
| **Performance** | 🚀 Slightly better | 🐢 Slightly slower |
| **Use case** | When data doesn't change | When you need modifications |

### Code Example Comparison

```kotlin
// ✅ IMMUTABLE - listOf
val readOnly = listOf(1, 2, 3)
println(readOnly[0])     // OK: 1
// readOnly.add(4)       // ❌ Compile error!
// readOnly[0] = 10      // ❌ Compile error!
// readOnly.removeAt(0)  // ❌ Compile error!

// ✅ MUTABLE - mutableListOf
val mutable = mutableListOf(1, 2, 3)
mutable.add(4)           // ✅ [1, 2, 3, 4]
mutable[0] = 10          // ✅ [10, 2, 3, 4]
mutable.removeAt(1)      // ✅ [10, 3, 4]
mutable.sort()           // ✅ [3, 4, 10]
```

### Converting Between Types

```kotlin
// From immutable to mutable
val immutable = listOf(1, 2, 3)
val mutable = immutable.toMutableList()
mutable.add(4)  // Now it's mutable

// From mutable to immutable (for safety)
val mutable2 = mutableListOf(1, 2, 3)
val immutable2 = mutable2.toList()  // Read-only view
// immutable2.add(4)  // ❌ Error!
```

> 🧑‍🍳 **Chef's Rule of Thumb:** Use `listOf` by default. Only use `mutableListOf` when you have a **specific reason** to modify the list. Immutable code has fewer bugs and is easier to understand!

---

## 🔄 Transforming Lists (Without Changing Them)

Remember: With `listOf`, you **cannot modify the original list**. But you can **create new lists** based on the original!

### `map` – Transform Each Element

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

// Double each number
val doubled = numbers.map { it * 2 }
println(doubled)  // [2, 4, 6, 8, 10]

// Convert to strings
val strings = numbers.map { "Number: $it" }
println(strings)  // [Number: 1, Number: 2, ...]

// Original unchanged!
println(numbers)  // [1, 2, 3, 4, 5]
```

### `filter` – Keep Only Matching Elements

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// Keep only even numbers
val evens = numbers.filter { it % 2 == 0 }
println(evens)  // [2, 4, 6, 8, 10]

// Keep numbers greater than 5
val bigNumbers = numbers.filter { it > 5 }
println(bigNumbers)  // [6, 7, 8, 9, 10]
```

### `sorted` – Sort the List

```kotlin
val unsorted = listOf(5, 2, 8, 1, 9, 3)

// Ascending order (default)
val ascending = unsorted.sorted()
println(ascending)  // [1, 2, 3, 5, 8, 9]

// Descending order
val descending = unsorted.sortedDescending()
println(descending)  // [9, 8, 5, 3, 2, 1]
```

### `distinct` – Remove Duplicates

```kotlin
val withDuplicates = listOf(1, 2, 2, 3, 3, 3, 4, 1, 5)

val unique = withDuplicates.distinct()
println(unique)  // [1, 2, 3, 4, 5]
```

### Combining Transformations

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// Chain operations together!
val result = numbers
    .filter { it % 2 == 0 }      // Keep evens: [2, 4, 6, 8, 10]
    .map { it * it }              // Square them: [4, 16, 36, 64, 100]
    .filter { it > 50 }           // Keep >50: [64, 100]
    .sortedDescending()           // Sort descending: [100, 64]

println(result)  // [100, 64]
```

### `reduce` and `fold` – Combine All Elements

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

// Sum (reduce doesn't have initial value)
val sum = numbers.reduce { accumulator, element -> accumulator + element }
println(sum)  // 15 (1+2+3+4+5)

// Sum with fold (has initial value)
val sumWithInitial = numbers.fold(10) { acc, elem -> acc + elem }
println(sumWithInitial)  // 25 (10+1+2+3+4+5)

// Join strings
val words = listOf("Kotlin", "is", "fun")
val sentence = words.reduce { acc, word -> "$acc $word" }
println(sentence)  // "Kotlin is fun"
```

---

## ❓ Nullable Lists and Nullable Items

### List of Nullable Items

```kotlin
val items: List<String?> = listOf("Apple", null, "Orange", null, "Banana")

// Count nulls
val nullCount = items.count { it == null }
println("Null items: $nullCount")  // Null items: 2

// Filter out nulls
val nonNullItems = items.filterNotNull()
println(nonNullItems)  // [Apple, Orange, Banana]

// Safe access with null check
items.forEach { item ->
    item?.let {
        println("Length of $it: ${it.length}")
    }
}
```

### Nullable List (The List Itself Could Be Null)

```kotlin
val list: List<Int>? = null

// Safe calls needed!
println(list?.size)      // null (doesn't crash)
println(list?.first())   // null

// Using with let
list?.let {
    println("List has ${it.size} items")
} ?: println("List is null")
```

---

## 🧪 Try It Yourself – Exercises

### 🍜 Beginner Exercises

**Exercise 1: Basic List Creation**
```kotlin
// Create a list of 5 of your favorite movies
// Print the first and last movie
// Print how many movies are in your list
```

**Solution:**
```kotlin
val movies = listOf("Inception", "Matrix", "Interstellar", "Gladiator", "Titanic")
println("First: ${movies.first()}")    // Inception
println("Last: ${movies.last()}")      // Titanic
println("Count: ${movies.size}")       // 5
```

---

**Exercise 2: Loop and Print**
```kotlin
val colors = listOf("Red", "Green", "Blue", "Yellow", "Purple")
// Loop through and print each color in uppercase
```

**Solution:**
```kotlin
colors.forEach { println(it.uppercase()) }
// or
for (color in colors) {
    println(color.uppercase())
}
```

---

### 🥘 Intermediate Exercises

**Exercise 3: Find and Filter**
```kotlin
val scores = listOf(45, 67, 89, 72, 91, 58, 83, 77)

// 1. Find the first score above 80
// 2. Count how many scores are below 60
// 3. Create a list of scores that are 70 or above
// 4. Check if all scores are above 40
```

**Solution:**
```kotlin
println(scores.find { it > 80 })           // 89
println(scores.count { it < 60 })          // 2 (45, 58)
val passing = scores.filter { it >= 70 }   // [89, 72, 91, 83, 77]
println(scores.all { it > 40 })            // true
```

---

**Exercise 4: Transform and Combine**
```kotlin
val temperatures = listOf(32.0, 41.0, 50.0, 59.0, 68.0)

// Convert these temperatures from Fahrenheit to Celsius
// Formula: (F - 32) * 5/9
// Round to 1 decimal place
```

**Solution:**
```kotlin
val celsius = temperatures.map { f ->
    val c = (f - 32) * 5 / 9
    "%.1f".format(c).toDouble()
}
println(celsius)  // [0.0, 5.0, 10.0, 15.0, 20.0]
```

---

### 🔥 Advanced Exercises

**Exercise 5: Word Analyzer**
```kotlin
val words = listOf("kotlin", "programming", "code", "developer", "fun", "amazing")

// 1. Find the longest word
// 2. Create a list of word lengths: [6, 11, 4, 8, 3, 7]
// 3. Group words by their first letter as a Map
// 4. Find words that contain the letter 'e'
```

**Solution:**
```kotlin
// 1. Longest word
println(words.maxByOrNull { it.length })  // "programming"

// 2. Word lengths
val lengths = words.map { it.length }
println(lengths)  // [6, 11, 4, 8, 3, 7]

// 3. Group by first letter
val grouped = words.groupBy { it.first() }
println(grouped)  // {k=[kotlin], p=[programming], c=[code], d=[developer], f=[fun], a=[amazing]}

// 4. Words with 'e'
val withE = words.filter { it.contains('e') }
println(withE)  // [code, developer, amazing]
```

---

**Exercise 6: List of Names (Real-World Example)**
```kotlin
data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Alice", 25),
    Person("Bob", 17),
    Person("Charlie", 32),
    Person("Diana", 19),
    Person("Eve", 16)
)

// 1. Get list of names of adults (age >= 18)
// 2. Calculate average age of all people
// 3. Check if there's anyone under 18
// 4. Create a map of name to age
```

**Solution:**
```kotlin
// 1. Adult names
val adultNames = people.filter { it.age >= 18 }.map { it.name }
println(adultNames)  // [Alice, Charlie, Diana]

// 2. Average age
val avgAge = people.map { it.age }.average()
println("Average age: $avgAge")  // 21.8

// 3. Any minors?
val hasMinors = people.any { it.age < 18 }
println("Has minors: $hasMinors")  // true

// 4. Name to age map
val nameToAge = people.associate { it.name to it.age }
println(nameToAge)  // {Alice=25, Bob=17, Charlie=32, Diana=19, Eve=16}
```

---

## ⚠️ Common Pitfalls

### Pitfall 1: IndexOutOfBoundsException

```kotlin
val list = listOf(1, 2, 3)

// ❌ BAD - This will crash!
// println(list[3])  // IndexOutOfBoundsException

// ✅ GOOD - Safe access
println(list.getOrNull(3))  // null
println(list.getOrElse(3) { -1 })  // -1
```

### Pitfall 2: Confusing `listOf` with `mutableListOf`

```kotlin
// ❌ BAD - Expecting to modify an immutable list
val numbers = listOf(1, 2, 3)
numbers.add(4)  // ERROR: Unresolved reference

// ✅ GOOD - Use mutableListOf when you need modifications
val mutableNumbers = mutableListOf(1, 2, 3)
mutableNumbers.add(4)  // Works!
```

### Pitfall 3: Null Safety with Nullable Items

```kotlin
val items: List<String?> = listOf("Hello", null, "World")

// ❌ BAD - This will crash on null!
// items.forEach { println(it.length) }

// ✅ GOOD - Handle nulls
items.forEach { println(it?.length) }  // 5, null, 5

// ✅ BETTER - Filter out nulls
items.filterNotNull().forEach { println(it.length) }  // 5, 5
```

### Pitfall 4: Modifying List While Iterating

```kotlin
val mutable = mutableListOf(1, 2, 3, 4, 5)

// ❌ BAD - ConcurrentModificationException
// for (item in mutable) {
//     if (item % 2 == 0) mutable.remove(item)  // CRASH!
// }

// ✅ GOOD - Use removeIf or collect to new list
mutable.removeIf { it % 2 == 0 }  // [1, 3, 5]
```

### Pitfall 5: Forgetting That `listOf` Returns Read-Only View

```kotlin
val original = mutableListOf(1, 2, 3)
val readOnly = original.toList()  // Just a view!

original.add(4)
println(readOnly)  // [1, 2, 3] - Wait, it didn't update!

// readOnly is a copy, not a live view!
```

---

## 🧑‍🍳 Real-World Examples

### Example 1: To-Do List Manager

```kotlin
data class Task(val name: String, val isComplete: Boolean)

fun main() {
    val tasks = listOf(
        Task("Buy groceries", true),
        Task("Clean kitchen", false),
        Task("Write code", false),
        Task("Exercise", true)
    )
    
    // Show incomplete tasks
    val pending = tasks.filter { !it.isComplete }
    println("Pending tasks: ${pending.map { it.name }}")
    // Output: Pending tasks: [Clean kitchen, Write code]
    
    // Task completion rate
    val completedCount = tasks.count { it.isComplete }
    val totalCount = tasks.size
    val percent = (completedCount.toDouble() / totalCount) * 100
    println("Progress: $percent%")  // Progress: 50.0%
}
```

### Example 2: Grade Calculator

```kotlin
fun main() {
    val studentGrades = mapOf(
        "Alice" to listOf(85, 92, 78, 88),
        "Bob" to listOf(75, 82, 79, 84),
        "Charlie" to listOf(95, 98, 92, 96)
    )
    
    studentGrades.forEach { (student, grades) ->
        val average = grades.average()
        val highest = grades.maxOrNull()
        val lowest = grades.minOrNull()
        
        println("$student: Avg=${"%.1f".format(average)}, High=$highest, Low=$lowest")
    }
}
// Output:
// Alice: Avg=85.8, High=92, Low=78
// Bob: Avg=80.0, High=84, Low=75
// Charlie: Avg=95.2, High=98, Low=92
```

### Example 3: Data Processing Pipeline

```kotlin
data class Product(val name: String, val price: Double, val category: String)

fun main() {
    val products = listOf(
        Product("Laptop", 999.99, "Electronics"),
        Product("Coffee Maker", 49.99, "Appliances"),
        Product("Phone", 599.99, "Electronics"),
        Product("Book", 19.99, "Media"),
        Product("Headphones", 89.99, "Electronics")
    )
    
    // Find all electronics under $100
    val deals = products
        .filter { it.category == "Electronics" }
        .filter { it.price < 100 }
        .sortedBy { it.price }
    
    println("Electronics under \$100:")
    deals.forEach { println("  ${it.name}: \$${it.price}") }
}
// Output:
// Electronics under $100:
//   Headphones: $89.99
```

---

## 🗺️ What's Next?

Now that you've mastered `listOf`, you're ready for these recipes:

| Recipe | What You'll Learn |
|--------|-------------------|
| **`mutableListOf`** | Adding, removing, and modifying lists |
| **`setOf`** | Unique elements (no duplicates) |
| **`mapOf`** | Key-value pairs (dictionaries) |
| **LambdaFunctions** | Advanced transformations with lambdas |
| **Scope Functions** | `let`, `run`, `apply`, `also`, `with` |

---

## 📝 Recipe Summary

### Quick Reference Card

```kotlin
// CREATE
val list = listOf(1, 2, 3)

// READ
list[0]           // 1
list.first()      // 1
list.last()       // 3
list.size         // 3
list.contains(2)  // true

// LOOP
for (item in list) { }
list.forEach { }
list.forEachIndexed { idx, item -> }

// TRANSFORM (creates new list)
list.map { it * 2 }           // [2, 4, 6]
list.filter { it > 1 }        // [2, 3]
list.sortedDescending()       // [3, 2, 1]

// CHECK
list.all { it > 0 }   // true
list.any { it > 2 }   // true
list.count { it == 2 } // 1
```

### Key Takeaways

1. ✅ `listOf` creates **immutable** (read-only) lists
2. ✅ Use **index** (0-based) to access elements: `list[0]`
3. ✅ **Cannot** add, remove, or modify items
4. ✅ Use `mutableListOf` if you need changes
5. ✅ Transform lists using `map`, `filter`, `sorted` (original stays same)
6. ✅ Always prefer `listOf` over `mutableListOf` when possible
7. ✅ Handle **nulls** carefully with `?.`, `?:`, and `filterNotNull()`

---

## 🎉 Congratulations, Chef!

You've successfully mastered the **List recipe**! 🧑‍🍳

You can now:
- Create read-only lists with confidence
- Access, loop, and transform list data
- Choose between immutable and mutable lists wisely
- Avoid common pitfalls
- Apply lists to real-world problems

**Remember:** A good chef knows their ingredients. A great chef knows when to keep them unchanged. Use `listOf` as your default choice, and your code will be safer and easier to understand!

---

*"Lists are like recipe cards – best when they don't change unexpectedly!"*

— Kotlin Kitchen Wisdom 📚

---

## 🔗 Related Resources

- 📖 [Official Kotlin Collections Documentation](https://kotlinlang.org/docs/collections-overview.html)
- 📖 [List API Reference](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/)
- 🍳 [Next Recipe: mutableListOf →](./mutableListOf.md)
- 🍳 [Previous Recipe: ForStirring.kt →](../Loops/For/ForStirring.kt)

---

**Happy coding, Chef!** 🚀👨‍🍳
