
# 📖 Recipe: Working with Maps (`mapOf` and `mutableMapOf`)

> *"A recipe book where every dish name points to its ingredients – that's a Map!"*

---

## 📋 Table of Contents

1. [What You'll Learn](#-what-youll-learn)
2. [The Kitchen Analogy](#-the-kitchen-analogy)
3. [What is a Map?](#-what-is-a-map)
4. [`mapOf` - Immutable Map](#-mapof---immutable-map)
5. [`mutableMapOf` - Mutable Map](#-mutablemapof---mutable-map)
6. [Common Operations](#-common-operations)
7. [Looping Through Maps](#-looping-through-maps)
8. [Map vs List](#-map-vs-list)
9. [Try It Yourself](#-try-it-yourself)
10. [Quick Reference](#-quick-reference)

---

## 🎯 What You'll Learn

- ✅ What is a **Map** (key-value pairs)
- ✅ Create immutable maps with `mapOf`
- ✅ Create mutable maps with `mutableMapOf`
- ✅ Add, remove, and update entries
- ✅ Access values by key
- ✅ Loop through keys, values, or both
- ✅ When to use Map vs List

---

## 🍽️ The Kitchen Analogy

Imagine you have a **recipe book**:

```
┌─────────────────────────────────┐
│         MY RECIPE BOOK          │
├─────────────────────────────────┤
│ "Pizza"     → "Flour, Cheese..." │
│ "Soup"      → "Broth, Veggies..." │
│ "Salad"     → "Lettuce, Tomato..."│
│ "Cake"      → "Eggs, Sugar..."    │
└─────────────────────────────────┘
```

- **Key** = Recipe name (unique, like "Pizza")
- **Value** = Ingredients (what the key points to)

**Key rules:**
- Each key appears **only once** (no duplicate recipe names)
- One key points to **one value** (but value can be anything)
- You can **look up** a value instantly if you know the key

This is exactly how **Map** works in Kotlin!

---

## 🔍 What is a Map?

A **Map** stores **key-value pairs**. Each key is unique and maps to exactly one value.

**Syntax:**
```kotlin
mapOf(key1 to value1, key2 to value2, ...)
mutableMapOf(key1 to value1, key2 to value2, ...)
```

**Key characteristics:**

| Property | Description |
|----------|-------------|
| **Key-Value pairs** | Each entry has a key and a value |
| **Unique keys** | No duplicate keys (values CAN duplicate) |
| **Fast lookup** | Get value by key instantly |
| **Ordered** | Maintains insertion order (in most implementations) |

---

## 📖 `mapOf` - Immutable Map (Read-Only)

```kotlin
// Create immutable map
val recipeBook = mapOf(
    "Pizza" to "Flour, Cheese, Tomato",
    "Soup" to "Broth, Carrots, Celery",
    "Salad" to "Lettuce, Tomato, Cucumber"
)

// Access values
println(recipeBook["Pizza"])     // Flour, Cheese, Tomato
println(recipeBook.get("Soup"))  // Broth, Carrots, Celery
println(recipeBook["Burger"])    // null (key doesn't exist)

// Safe access
println(recipeBook.getOrDefault("Burger", "Not found"))  // Not found

// Check if key exists
println("Pizza" in recipeBook)   // true
println("Sushi" in recipeBook)   // false

// Get all keys or values
println(recipeBook.keys)     // [Pizza, Soup, Salad]
println(recipeBook.values)   // [Flour, Cheese..., Broth..., Lettuce...]

// Size
println(recipeBook.size)     // 3
```

**Cannot modify:**
```kotlin
// recipeBook["Burger"] = "Patty, Bun"  // ❌ Error!
// recipeBook.put("Pasta", "Noodles")   // ❌ Error!
```

---

## ✏️ `mutableMapOf` - Mutable Map (Can Change)

```kotlin
// Create mutable map
val menu = mutableMapOf(
    "Pizza" to 10.99,
    "Pasta" to 8.99,
    "Salad" to 5.99
)

// ADD or UPDATE entries
menu["Burger"] = 7.99        // Add new entry
menu["Pizza"] = 11.99        // Update existing value
menu.put("Soup", 4.99)       // Alternative way

println(menu)  // {Pizza=11.99, Pasta=8.99, Salad=5.99, Burger=7.99, Soup=4.99}

// REMOVE entries
menu.remove("Salad")          // Remove by key
menu.remove("Pasta", 8.99)    // Remove only if key+value match

// Add multiple at once
menu.putAll(mapOf("Steak" to 19.99, "Fish" to 14.99))

// Clear all
// menu.clear()

// Check
println(menu.containsKey("Pizza"))  // true
println(menu.containsValue(7.99))   // true
```

---

## 🛠️ Common Operations

### Accessing Values

```kotlin
val capitals = mapOf(
    "France" to "Paris",
    "Japan" to "Tokyo",
    "Vietnam" to "Hanoi"
)

// Different ways to get
println(capitals["France"])           // Paris
println(capitals.get("Japan"))        // Tokyo
println(capitals.getOrDefault("USA", "Unknown"))  // Unknown
println(capitals.getOrElse("Germany") { "N/A" })  // N/A
```

### Checking Existence

```kotlin
println("France" in capitals)      // true (key exists)
println("Paris" in capitals)       // false (checks keys, not values)
println("Paris" in capitals.values) // true (check values)
println(capitals.containsValue("Hanoi"))  // true
```

### Getting Keys and Values

```kotlin
println(capitals.keys)     // [France, Japan, Vietnam]
println(capitals.values)   // [Paris, Tokyo, Hanoi]
println(capitals.entries)  // [France=Paris, Japan=Tokyo, Vietnam=Hanoi]
```

### Default Values with `withDefault`

```kotlin
val mapWithDefault = mutableMapOf<String, Int>().withDefault { 0 }
mapWithDefault["Apple"] = 5
println(mapWithDefault["Apple"])   // 5
println(mapWithDefault["Orange"])  // 0 (default, not null)
```

---

## 🔄 Looping Through Maps

```kotlin
val scores = mapOf(
    "Alice" to 95,
    "Bob" to 87,
    "Charlie" to 92
)

// Loop through all entries
for ((name, score) in scores) {
    println("$name scored $score")
}

// Loop through keys
for (name in scores.keys) {
    println("Student: $name")
}

// Loop through values
for (score in scores.values) {
    println("Score: $score")
}

// Using forEach
scores.forEach { (name, score) ->
    println("$name → $score")
}

// Using forEach with entry
scores.entries.forEach { entry ->
    println("${entry.key}: ${entry.value}")
}
```

---

## ⚖️ Map vs List

| Scenario | Use Map | Use List |
|----------|---------|----------|
| Lookup by ID/name | ✅ Perfect | ❌ Slow (need to search) |
| Unique keys required | ✅ Enforced | ❌ No guarantee |
| Ordered collection | ✅ Yes | ✅ Yes |
| Simple list of items | ❌ Overkill | ✅ Perfect |
| Key-value pairs | ✅ Best | ❌ Not designed for this |

**When to use Map:**
- Phone book (name → number)
- Dictionary (word → definition)
- Shopping cart (product ID → quantity)
- Configuration (setting → value)
- Cache (key → cached data)

**When to use List:**
- Simple list of names
- Queue of tasks
- History of actions
- Any ordered collection without keys

---

## 🧪 Try It Yourself

### Exercise 1: Phone Book
```kotlin
// Create a mutable phone book (name → phone number)
// Add 3 contacts
// Update one number
// Remove one contact
// Print all contacts
```

**Solution:**
```kotlin
val phoneBook = mutableMapOf(
    "Alice" to "123-4567",
    "Bob" to "234-5678"
)
phoneBook["Charlie"] = "345-6789"
phoneBook["Alice"] = "999-8888"  // Update
phoneBook.remove("Bob")
println(phoneBook)  // {Alice=999-8888, Charlie=345-6789}
```

### Exercise 2: Word Counter
```kotlin
val sentence = "apple banana apple orange banana apple"
// Count how many times each word appears
// Expected: {apple=3, banana=2, orange=1}
```

**Solution:**
```kotlin
val words = sentence.split(" ")
val wordCount = mutableMapOf<String, Int>()

for (word in words) {
    wordCount[word] = wordCount.getOrDefault(word, 0) + 1
}
println(wordCount)
```

### Exercise 3: Student Grades
```kotlin
val grades = mutableMapOf(
    "Alice" to 85,
    "Bob" to 92,
    "Charlie" to 78
)

// Add 5 bonus points to everyone
// Print the updated grades
```

**Solution:**
```kotlin
for (student in grades.keys) {
    grades[student] = grades[student]!! + 5
}
println(grades)  // {Alice=90, Bob=97, Charlie=83}
```

---

## 📝 Quick Reference

```kotlin
// CREATE
val immutable = mapOf("a" to 1, "b" to 2)
val mutable = mutableMapOf("a" to 1, "b" to 2)

// READ
immutable["a"]                    // 1
immutable.getOrDefault("c", 0)    // 0
"a" in immutable                  // true

// ADD/UPDATE (mutable only)
mutable["c"] = 3                  // Add
mutable["a"] = 10                 // Update
mutable.putAll(mapOf("d" to 4))

// REMOVE (mutable only)
mutable.remove("b")
mutable.clear()

// LOOP
for ((k, v) in map) { }
map.forEach { k, v -> }

// CONVERT
val fromList = listOf("a" to 1, "b" to 2).toMap()
val toList = map.toList()  // List of Pairs
```

---

## 🎉 Congratulations!

You've mastered the **Map** recipe! 🧑‍🍳

**Remember:**
> *"A Map is like a dictionary – look up anything instantly if you know the key!"*

---

**Happy mapping!** 🗺️🚀
