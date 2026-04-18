
# 🔄 For Loop: The Automatic Stirrer

> *"A chef stirs soup 100 times. A smart chef writes a loop to do it for them."*

In the kitchen, you often need to repeat the same action many times:

- *"Stir the soup 50 times"*
- *"Chop 10 carrots"*
- *"Taste each dish on the menu"*

In programming, you do the same thing – but with **loops**.

---

## 🍳 What is a For Loop?

A **for loop** repeats a block of code a specific number of times.

Think of it like an **automatic stirrer**:
- You set how many times to stir
- The machine does the work
- You don't have to write "stir" 50 times!

```kotlin
// This automatic stirrer stirs 5 times
for (i in 1..5) {
    println("Stirring soup... round $i 🥄")
}
```

**Output:**
```
Stirring soup... round 1 🥄
Stirring soup... round 2 🥄
Stirring soup... round 3 🥄
Stirring soup... round 4 🥄
Stirring soup... round 5 🥄
```

> 🍳 *The variable `i` changes each time: 1, then 2, then 3...*

---

## 🔪 Range Types (Different Stirring Speeds)

Kotlin gives you different ways to create ranges:

| Syntax | Meaning | Example | Output |
|--------|---------|---------|--------|
| `x..y` | Includes both ends | `1..3` | 1, 2, 3 |
| `x until y` | Excludes last | `1 until 3` | 1, 2 |
| `step n` | Jump by n | `1..6 step 2` | 1, 3, 5 |
| `downTo` | Count down | `5 downTo 1` | 5, 4, 3, 2, 1 |

### Examples:

```kotlin
// 1 to 5 (includes 5)
for (i in 1..5) {
    print("$i ")
}
// Output: 1 2 3 4 5

// 1 until 5 (excludes 5)
for (i in 1 until 5) {
    print("$i ")
}
// Output: 1 2 3 4

// Step by 2
for (i in 1..10 step 2) {
    print("$i ")
}
// Output: 1 3 5 7 9

// Countdown
for (i in 5 downTo 1) {
    print("$i ")
}
// Output: 5 4 3 2 1
```

---

## 🧂 Looping Through Collections (Your Pantry)

You can loop through any collection – List, Array, Set:

```kotlin
val ingredients = listOf("🧂 Salt", "🌿 Basil", "🧄 Garlic", "🫒 Olive Oil")

println("📋 Shopping list:")
for (ingredient in ingredients) {
    println("  - $ingredient")
}
```

**Output:**
```
📋 Shopping list:
  - 🧂 Salt
  - 🌿 Basil
  - 🧄 Garlic
  - 🫒 Olive Oil
```

---

## 📊 Getting the Index (with `withIndex()`)

Sometimes you need both the **position** and the **value**:

```kotlin
val recipes = listOf("🍝 Pasta", "🍜 Ramen", "🍛 Curry")

for ((index, recipe) in recipes.withIndex()) {
    println("Recipe #${index + 1}: $recipe")
}
```

**Output:**
```
Recipe #1: 🍝 Pasta
Recipe #2: 🍜 Ramen
Recipe #3: 🍛 Curry
```

> 🍳 *`withIndex()` gives you both index and value in one loop!*

---

## 🔥 Using `.indices` (Loop by Position)

When you need to access multiple arrays at the same time:

```kotlin
val dishes = listOf("🍝 Pasta", "🍜 Ramen", "🍛 Curry")
val cookTimes = listOf(15, 10, 25)

for (i in dishes.indices) {
    println("${dishes[i]} takes ${cookTimes[i]} minutes")
}
```

**Output:**
```
🍝 Pasta takes 15 minutes
🍜 Ramen takes 10 minutes
🍛 Curry takes 25 minutes
```

---

## 🧪 Looping Through Strings (Each Character)

Strings are just collections of characters:

```kotlin
val word = "KOTLIN"

print("Spelling: ")
for (char in word) {
    print("$char ")
}
// Output: Spelling: K O T L I N
```

---

## 📝 Real Recipe: Cooking Multiple Dishes

```kotlin
fun main() {
    val menu = listOf(
        "🍝 Spaghetti" to 15,
        "🍜 Ramen" to 10,
        "🍛 Curry" to 25,
        "🥗 Salad" to 5
    )
    
    println("👨‍🍳 Today's menu:")
    println("━━━━━━━━━━━━━━━━━━━━━━")
    
    for ((dish, time) in menu) {
        println("• $dish (${time} mins)")
        
        // Simulate cooking
        for (minute in 1..time step 5) {
            println("  ⏱️ Cooking... $minute/$time minutes")
        }
        println("  ✅ $dish is ready!\n")
    }
}
```

---

## 🎯 Challenges (Level Up!)

### Challenge 1: Multiplication Table
Print the multiplication table for 5:
```
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
...
5 x 10 = 50
```

### Challenge 2: Sum of Numbers
Calculate the sum of all numbers from 1 to 100.
*Hint: Create a `var total = 0` and add each number*

### Challenge 3: Even Numbers Only
Print all even numbers from 1 to 20.
*Hint: Use `step 2` or check `if (i % 2 == 0)`*

### Challenge 4: FizzBuzz (Classic!)
Print numbers 1 to 30. But:
- Multiple of 3 → print "Fizz"
- Multiple of 5 → print "Buzz"  
- Multiple of both → print "FizzBuzz"
- Otherwise → print the number

### Challenge 5: Reverse a String
Ask user for a word and print it backwards.
*Hint: Loop from `word.length - 1` down to `0`*

---

## 📊 Quick Reference

| You want to... | Use this |
|----------------|----------|
| Loop through numbers | `for (i in 1..10)` |
| Loop excluding last | `for (i in 1 until 10)` |
| Loop with step | `for (i in 1..10 step 2)` |
| Count down | `for (i in 10 downTo 1)` |
| Loop through list | `for (item in list)` |
| Loop with index and value | `for ((i, item) in list.withIndex())` |
| Loop by index position | `for (i in list.indices)` |
| Loop through string | `for (char in "text")` |

---

## 🔥 Chef's Tips

### Tip 1: Use meaningful variable names
```kotlin
// ❌ Not clear
for (x in 1..10) { ... }

// ✅ Clear
for (batch in 1..10) { ... }
for (ingredient in shoppingList) { ... }
```

### Tip 2: Prefer `until` when excluding the last
```kotlin
// If you want 1, 2, 3, 4 (not 5)
for (i in 1 until 5)  // Clearer than 1..4
```

### Tip 3: Don't repeat yourself
```kotlin
// ❌ Don't do this (copy-paste)
println("Stir 1")
println("Stir 2")
println("Stir 3")
// ... 97 more times!

// ✅ Do this (use a loop)
for (i in 1..100) {
    println("Stir $i")
}
```

### Tip 4: `forEach` alternative (functional style)
```kotlin
val items = listOf("🍎", "🍐", "🍊")

// Traditional for loop
for (item in items) {
    println(item)
}

// Functional style (same result)
items.forEach { item ->
    println(item)
}
```

---

## 📚 What's Next?

Now you can repeat tasks automatically! Next, learn about **`while` loops** – keep stirring until the soup is ready!

👉 [While Loops: Keep Going Until Done](src/kotlin/normal/Loops/WhileStirring.md)

---

## 🧂 Summary

| Concept | Kitchen Analogy |
|---------|-----------------|
| **For loop** | Automatic stirrer |
| **Range (`..`)** | "Do this 5 times" |
| **`until`** | "Do this but stop before..." |
| **`step`** | "Skip every other stir" |
| **`downTo`** | "Count down from 10 to 1" |
| **Loop through list** | "Check every ingredient in your pantry" |
| **`withIndex()`** | "Item #1, Item #2, Item #3..." |

---

> *"A good chef knows when to stir. A great chef knows how to loop."*

> *"Don't repeat yourself – let the loop do the heavy lifting."*

Happy looping! 🔄👨‍🍳
