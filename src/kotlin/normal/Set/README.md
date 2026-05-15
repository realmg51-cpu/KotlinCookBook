
# 🃏 Recipe: Working with Sets (`setOf` and `mutableSetOf`)

> *"A box of unique ingredients – no duplicates allowed!"*

---

## 📋 Table of Contents

1. [What You'll Learn](#-what-youll-learn)
2. [The Kitchen Analogy](#-the-kitchen-analogy)
3. [What is a Set?](#-what-is-a-set)
4. [`setOf` - Immutable Set](#-setof---immutable-set)
5. [`mutableSetOf` - Mutable Set](#-mutableSetOf---mutable-set)
6. [Common Operations](#-common-operations)
7. [Set Operations](#-set-operations)
8. [Looping Through Sets](#-looping-through-sets)
9. [Set vs List vs Map](#-set-vs-list-vs-map)
10. [Try It Yourself](#-try-it-yourself)
11. [Quick Reference](#-quick-reference)

---

## 🎯 What You'll Learn

- ✅ What is a **Set** (unique elements, no duplicates)
- ✅ Create immutable sets with `setOf`
- ✅ Create mutable sets with `mutableSetOf`
- ✅ Add and remove elements
- ✅ Perform **set operations**: union, intersect, subtract
- ✅ When to use Set vs List vs Map

---

## 🍽️ The Kitchen Analogy

Imagine you have a **spice rack** where each spice appears **only once**:

```
┌─────────────────────────────┐
│         SPICE RACK          │
├─────────────────────────────┤
│  🌶️  Chili Powder           │
│  🧂  Salt                   │
│  🌿  Oregano                │
│  🍃  Basil                  │
│  🧄  Garlic Powder          │
└─────────────────────────────┘
```

**Rules of the spice rack:**
- Each spice appears **only once** (no duplicate bottles)
- Order doesn't matter (you just know what you have)
- You can quickly **check** if you have a spice
- You can **add** a new spice (if not already there)
- You can **remove** a spice

This is exactly how a **Set** works in Kotlin!

**Key difference from List:**
- List: `[Salt, Salt, Pepper]` ✅ (duplicates allowed)
- Set: `[Salt, Pepper]` ✅ (duplicates automatically removed)

---

## 🔍 What is a Set?

A **Set** is a collection that contains **unique elements** – no duplicates allowed.

**Syntax:**
```kotlin
setOf(element1, element2, element3, ...)
mutableSetOf(element1, element2, ...)
```

**Key characteristics:**

| Property | Description |
|----------|-------------|
| **Unique elements** | No duplicates allowed |
| **Unordered** | Order is not guaranteed (but LinkedHashSet maintains order) |
| **Fast lookup** | Check if element exists is very fast |
| **No index** | Cannot access by position (no `set[0]`) |

---

## 📖 `setOf` - Immutable Set (Read-Only)

```kotlin
// Create immutable set
val uniqueNumbers = setOf(1, 2, 3, 2, 1, 4, 2, 5)
println(uniqueNumbers)  // [1, 2, 3, 4, 5] (duplicates removed!)

val spices = setOf("Salt", "Pepper", "Oregano", "Salt")
println(spices)  // [Salt, Pepper, Oregano]

// Check if element exists
println("Salt" in spices)     // true
println("Sugar" in spices)    // false
println(spices.contains("Pepper"))  // true

// Size (count of unique elements)
println(spices.size)  // 3

// Check if empty
println(spices.isEmpty())  // false

// Get all elements (but cannot access by index!)
// println(spices[0])  // ❌ Error! Set has no index

// Convert to list if you need index access
val spiceList = spices.toList()
println(spiceList[0])  // ✅ Works!
```

**Cannot modify:**
```kotlin
// spices.add("Sugar")     // ❌ Error!
// spices.remove("Salt")   // ❌ Error!
```

---

## ✏️ `mutableSetOf` - Mutable Set (Can Change)

```kotlin
// Create mutable set
val tags = mutableSetOf("kotlin", "programming", "tutorial")
println(tags)  // [kotlin, programming, tutorial]

// ADD elements (duplicates ignored)
tags.add("coding")
tags.add("kotlin")  // Won't be added (already exists)
println(tags)  // [kotlin, programming, tutorial, coding]

// REMOVE elements
tags.remove("tutorial")
println(tags)  // [kotlin, programming, coding]

// Add multiple
tags.addAll(setOf("android", "java", "kotlin"))
println(tags)  // [kotlin, programming, coding, android, java]

// Remove multiple
tags.removeAll(setOf("java", "coding"))
println(tags)  // [kotlin, programming, android]

// Remove if condition
tags.removeIf { it.startsWith("a") }
println(tags)  // [kotlin, programming]

// Clear all
// tags.clear()
```

---

## 🛠️ Common Operations

### Checking Existence

```kotlin
val fruits = setOf("Apple", "Banana", "Orange")

println("Apple" in fruits)        // true
println(fruits.contains("Banana")) // true
println(fruits.containsAll(setOf("Apple", "Orange")))  // true
println(fruits.containsAll(setOf("Apple", "Grape")))   // false
```

### Size and Emptiness

```kotlin
val empty = setOf<String>()
println(empty.isEmpty())   // true
println(empty.isNotEmpty()) // false

val numbers = setOf(1, 2, 3)
println(numbers.size)  // 3
```

### Converting

```kotlin
// Set → List (to get index access)
val set = setOf("A", "B", "C")
val list = set.toList()
println(list[1])  // B

// Set → MutableSet
val mutable = set.toMutableSet()
mutable.add("D")

// List → Set (removes duplicates)
val listWithDuplicates = listOf(1, 2, 2, 3, 3, 3, 4)
val unique = listWithDuplicates.toSet()
println(unique)  // [1, 2, 3, 4]
```

---

## 🔢 Set Operations (Union, Intersect, Subtract)

Sets support mathematical set operations!

```kotlin
val setA = setOf(1, 2, 3, 4, 5)
val setB = setOf(4, 5, 6, 7, 8)

// UNION - all elements from both sets
val union = setA.union(setB)
println("Union: $union")  // [1, 2, 3, 4, 5, 6, 7, 8]

// INTERSECTION - elements in both sets
val intersect = setA.intersect(setB)
println("Intersection: $intersect")  // [4, 5]

// SUBTRACT (difference) - in A but not in B
val subtract = setA.subtract(setB)
println("Subtract (A - B): $subtract")  // [1, 2, 3]

// Also works with operator syntax
println(setA + setB)   // Union: [1,2,3,4,5,6,7,8]
println(setA - setB)   // Difference: [1,2,3]
```

### Real-world example: User permissions

```kotlin
val adminPermissions = setOf("read", "write", "delete", "manage_users")
val editorPermissions = setOf("read", "write", "edit_content")
val viewerPermissions = setOf("read")

// What can an admin do that an editor can't?
val adminOnly = adminPermissions subtract editorPermissions
println("Admin only: $adminOnly")  // [delete, manage_users]

// What can both do?
val common = adminPermissions intersect editorPermissions
println("Common: $common")  // [read, write]

// All permissions combined
val all = adminPermissions union editorPermissions union viewerPermissions
println("All: $all")  // [read, write, delete, manage_users, edit_content]
```

---

## 🔄 Looping Through Sets

```kotlin
val colors = setOf("Red", "Green", "Blue", "Yellow")

// For loop
for (color in colors) {
    println(color)
}

// forEach
colors.forEach { println(it) }

// forEachIndexed (convert to list first)
colors.toList().forEachIndexed { index, color ->
    println("$index: $color")
}

// Using iterator
val iterator = colors.iterator()
while (iterator.hasNext()) {
    println(iterator.next())
}
```

---

## ⚖️ Set vs List vs Map

| Feature | Set | List | Map |
|---------|-----|------|-----|
| **Duplicates** | ❌ Not allowed | ✅ Allowed | Keys: ❌, Values: ✅ |
| **Order** | Usually no (but LinkedHashSet does) | ✅ Yes | ✅ Yes (insertion order) |
| **Index access** | ❌ No | ✅ Yes (`list[0]`) | ❌ No (uses keys) |
| **Fast lookup** | ✅ Yes (`element in set`) | ❌ Slow (O(n)) | ✅ Yes (by key) |
| **Use case** | Unique items, tags, permissions | Ordered list, queue, stack | Key-value pairs, dictionary |

### When to use Set:

| Scenario | Example |
|----------|---------|
| **Tags/Categories** | `setOf("kotlin", "java", "android")` |
| **Unique IDs** | `setOf(101, 102, 103)` |
| **Permissions** | `setOf("read", "write")` |
| **Removing duplicates** | `listWithDupes.toSet()` |
| **Set math operations** | `union`, `intersect`, `subtract` |
| **Fast membership check** | `if (item in allowedItems)` |

---

## 🧪 Try It Yourself

### Exercise 1: Unique Tags
```kotlin
val blogTags = listOf("kotlin", "programming", "kotlin", "tutorial", "programming", "android")
// Convert to Set to get unique tags
// Print: [kotlin, programming, tutorial, android]
```

**Solution:**
```kotlin
val uniqueTags = blogTags.toSet()
println(uniqueTags)
```

### Exercise 2: Friend Suggestions
```kotlin
val myFriends = setOf("Alice", "Bob", "Charlie")
val aliceFriends = setOf("Bob", "David", "Eve")
val bobFriends = setOf("Charlie", "Frank", "Alice")

// Find friends of friends that I'm not already friends with
// (People I might know)
```

**Solution:**
```kotlin
val friendsOfFriends = aliceFriends.union(bobFriends)
val suggestions = friendsOfFriends.subtract(myFriends)
println("Suggestions: $suggestions")  // [David, Eve, Frank]
```

### Exercise 3: Duplicate Remover
```kotlin
val emails = listOf(
    "user1@email.com",
    "user2@email.com", 
    "user1@email.com",
    "user3@email.com",
    "user2@email.com"
)
// Remove duplicates and print unique emails
```

**Solution:**
```kotlin
val uniqueEmails = emails.toSet()
println(uniqueEmails)  // [user1@email.com, user2@email.com, user3@email.com]
```

### Exercise 4: Permission Checker
```kotlin
val userPermissions = mutableSetOf("read", "write")
val requiredPermissions = setOf("read", "write", "delete")

// Check if user has all required permissions
// Add missing permissions
```

**Solution:**
```kotlin
val hasAll = userPermissions.containsAll(requiredPermissions)
println("Has all permissions? $hasAll")  // false

val missing = requiredPermissions.subtract(userPermissions)
println("Missing: $missing")  // [delete]

userPermissions.addAll(missing)
println("Updated: $userPermissions")  // [read, write, delete]
```

---

## 📝 Quick Reference

```kotlin
// CREATE
val immutable = setOf(1, 2, 3, 2, 1)     // [1, 2, 3]
val mutable = mutableSetOf(1, 2, 3)

// READ (only check, no index)
immutable.contains(2)     // true
2 in immutable            // true
immutable.size            // 3

// ADD (mutable only)
mutable.add(4)            // Adds 4
mutable.add(2)            // Ignored (already exists)
mutable.addAll(setOf(5, 6))

// REMOVE (mutable only)
mutable.remove(3)
mutable.removeIf { it > 4 }
mutable.clear()

// SET OPERATIONS
setA.union(setB)          // All elements
setA.intersect(setB)      // Common elements
setA.subtract(setB)       // In A but not B

// CONVERT
list.toSet()              // List → Set (removes dupes)
set.toList()              // Set → List
mutable.toSet()           // Mutable → Immutable
```

---

## 🎉 Congratulations!

You've mastered the **Set** recipe! 🧑‍🍳

**Remember:**
> *"A Set is like a VIP list – each person can only be on it once!"*

---

**Happy setting!** 🃏🚀
