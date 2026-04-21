
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

<details>
<summary>🐞 Hidden Bug</summary>

**Bug:** Forgetting to handle negative numbers or zero
```kotlin
// ❌ Wrong: If number = 0, nothing prints
for (i in 1..number) { ... }

// ✅ Correct: Check edge cases
if (number <= 0) {
    println("Please enter a positive number")
    return
}
```
</details>

---

### Challenge 2: Sum of Numbers
Calculate the sum of all numbers from 1 to 100. (Answer: 5050)

<details>
<summary>🐞 Hidden Bug</summary>

**Bug:** Forgetting to initialize `total = 0`
```kotlin
// ❌ Wrong: total not initialized
var total
for (i in 1..100) {
    total += i  // ERROR!
}

// ✅ Correct: Always initialize counter
var total = 0  // ← Important!
for (i in 1..100) {
    total += i
}
println("Total: $total")  // 5050
```
</details>

---

### Challenge 3: Even Numbers Only
Print all even numbers from 1 to 20.

<details>
<summary>🐞 Hidden Bug</summary>

**Bug 1:** Using `step 1` + checking `% 2` is slower
```kotlin
// ❌ Slower (runs 20 times, checks 20 times)
for (i in 1..20) {
    if (i % 2 == 0) print("$i ")
}

// ✅ Faster (runs only 10 times, no check needed)
for (i in 2..20 step 2) {
    print("$i ")
}
// Output: 2 4 6 8 10 12 14 16 18 20
```

**Bug 2:** Wrong use of `until`
```kotlin
// ❌ Wrong: 20 is NOT printed
for (i in 2 until 20 step 2) { ... }

// ✅ Correct: Use .. to include 20
for (i in 2..20 step 2) { ... }
```
</details>

---

### Challenge 4: FizzBuzz (Classic!)
Print numbers 1 to 30. But:
- Multiple of 3 → print "Fizz"
- Multiple of 5 → print "Buzz"  
- Multiple of **both** → print "FizzBuzz"
- Otherwise → print the number

<details>
<summary>🐞 Hidden Bug</summary>

**Bug:** Wrong order – checking 3 and 5 first
```kotlin
// ❌ WRONG: 15 will print "Fizz" (checks 3 first)
for (i in 1..30) {
    if (i % 3 == 0) println("Fizz")
    else if (i % 5 == 0) println("Buzz")
    else if (i % 15 == 0) println("FizzBuzz")  // Never runs!
    else println(i)
}

// ✅ CORRECT: Check 15 (both) FIRST
for (i in 1..30) {
    when {
        i % 15 == 0 -> println("FizzBuzz")  // Check both FIRST!
        i % 3 == 0 -> println("Fizz")
        i % 5 == 0 -> println("Buzz")
        else -> println(i)
    }
}
```

**Expected output:**
```
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz  ← If order is wrong, this prints "Fizz"
...
```
</details>

---

### Challenge 5: Reverse a String
Ask user for a word and print it backwards.
*Example: "Kotlin" → "nilt oK"*

<details>
<summary>🐞 Hidden Bug</summary>

**Bug:** `readln()` can throw exception on EOF (Ctrl+D)
```kotlin
// ❌ May throw exception on EOF
val word = readln()
val reversed = word.reversed()
println(reversed)

// ✅ Safer: Use readlnOrNull()
val word = readlnOrNull()
if (word.isNullOrEmpty()) {
    println("No input provided!")
    return
}
val reversed = word.reversed()
println(reversed)

// ✅ Manual reverse (without .reversed())
fun reverseString(str: String): String {
    var result = ""
    for (i in str.length - 1 downTo 0) {
        result += str[i]
    }
    return result
}
```
</details>

---

### Challenge 6: Prime Number Checker (Bonus!)
Check if a number is prime.

<details>
<summary>🐞 Hidden Bug</summary>

**Bug:** Forgetting to handle 1 and negative numbers
```kotlin
// ❌ Wrong: 1 is NOT a prime number
fun isPrime(n: Int): Boolean {
    for (i in 2 until n) {
        if (n % i == 0) return false
    }
    return true  // n=1 → true (WRONG!)
}

// ✅ Correct: Handle edge cases
fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    
    // Only need to check up to sqrt(n)
    for (i in 3..Math.sqrt(n.toDouble()).toInt() step 2) {
        if (n % i == 0) return false
    }
    return true
}
```
</details>

---

## 📊 Hidden Bugs Summary

| Challenge | Hidden Bug | Fix |
|-----------|-----------|-----|
| **Challenge 2** | Forgot to initialize `total = 0` | `var total = 0` |
| **Challenge 3** | Using `step 1` + `% 2` check (slower) | Use `step 2` for performance |
| **Challenge 4** | Wrong order (checking 3 & 5 first) | Check `% 15 == 0` first |
| **Challenge 5** | `readln()` may throw exception | Use `readlnOrNull()` + null check |
| **Challenge 6** | Forgot to handle 1 and negative numbers | `if (n <= 1) return false` |

---

## 🔥 Chef's Warning

> **"Code that runs is not necessarily code that's correct. Always test edge cases!"**

```kotlin
// Always ask 3 questions when writing loops:
// 1. Is the counter initialized?
// 2. Is the stop condition correct?
// 3. Are edge cases (0, 1, empty, null) handled?
```

---

## 📚 What's Next?

Now you can repeat tasks automatically! Next, learn about **`while` loops** – keep stirring until the soup is ready!

👉 [While Loops: Keep Going Until Done](https://github.com/realmg51-cpu/KotlinCookBook/blob/main/src/kotlin/normal/Loops/While/introduction.md)

---

> *"A good chef knows when to stir. A great chef knows how to loop."*

> *"Don't repeat yourself – let the loop do the heavy lifting."*

Happy looping! 🔄👨‍🍳
