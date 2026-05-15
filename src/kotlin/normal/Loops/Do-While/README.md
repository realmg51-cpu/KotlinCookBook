
# 🔄 Do-While Loop

> *"Taste the soup FIRST, then decide if it needs more salt!"*

## What is Do-While?

A **do-while loop** is a control flow statement that executes a block of code **at least once**, then repeatedly executes it as long as a given condition remains true.

```kotlin
do {
    // Code block (runs at least once)
} while (condition)
```

---

## How It Works

| Step | Action |
|------|--------|
| 1 | Execute the code block inside `do { }` |
| 2 | Check the condition in `while (condition)` |
| 3 | If condition is `true`, go back to step 1 |
| 4 | If condition is `false`, exit the loop |

**Key difference from regular while loop:** The condition is checked **AFTER** the code runs, not before.

---

## While vs Do-While

| Feature | While | Do-While |
|---------|-------|----------|
| **When condition checked** | Before execution | After execution |
| **Minimum executions** | 0 (may never run) | 1 (always runs once) |
| **Use when** | Condition may be false initially | Must run at least once |

### Code Comparison

```kotlin
// WHILE: Checks first, may not run
var temperature = 25
while (temperature < 100) {
    println("Heating...")  // Will run until 100
    temperature += 25
}
// If temperature started at 100, this would never run!

// DO-WHILE: Runs once before checking
var soupReady = false
do {
    println("Tasting soup...")  // Always runs at least once
    soupReady = true
} while (!soupReady)
```

---

## Kitchen Analogy

| Loop Type | Kitchen Meaning |
|-----------|-----------------|
| **While loop** | "Check if you have eggs BEFORE making an omelette" |
| **Do-while loop** | "Taste the soup FIRST, then decide if it needs more salt" |

### Real Kitchen Example

```kotlin
var needsMoreSalt = true
var tasteCount = 0

do {
    tasteCount++
    println("👨‍🍳 Taste test #$tasteCount")
    
    if (tasteCount >= 3) {
        needsMoreSalt = false
        println("✅ Soup is perfect!")
    } else {
        println("🧂 Adding more salt...")
    }
} while (needsMoreSalt)
```

**Output:**
```
👨‍🍳 Taste test #1
🧂 Adding more salt...
👨‍🍳 Taste test #2
🧂 Adding more salt...
👨‍🍳 Taste test #3
✅ Soup is perfect!
```

---

## When to Use Do-While

| Scenario | Why Do-While? | Example |
|----------|---------------|---------|
| 🥣 **Tasting food** | Must taste before deciding | Soup, sauce, coffee |
| 📋 **Menu selection** | Show menu at least once | Restaurant ordering |
| 🔐 **Password prompt** | Ask for password at least once | Login screen |
| 🎲 **Dice game** | Play at least one round | Board games |
| 📝 **Input validation** | Get input before validating | Form submission |

### Real Code Examples

#### Example 1: Menu Selection

```kotlin
var choice = 0

do {
    println("\n--- Kitchen Menu ---")
    println("1. 🍳 Cook Recipe")
    println("2. 📖 View Stats")
    println("3. 🚪 Exit")
    print("Your choice: ")
    
    choice = readln().toIntOrNull() ?: 0
    
    when (choice) {
        1 -> println("🔪 Cooking...")
        2 -> println("📊 You've learned 5 recipes!")
        3 -> println("👋 Goodbye!")
        else -> println("❌ Invalid choice!")
    }
} while (choice != 3)
```

#### Example 2: Password Check

```kotlin
val secret = "cook123"
var input: String
var attempts = 0

do {
    print("🔐 Enter password: ")
    input = readln()
    attempts++
    
    if (input != secret) {
        println("❌ Wrong! Attempts: $attempts/3")
    }
} while (input != secret && attempts < 3)

if (input == secret) {
    println("✅ Access granted! Welcome chef!")
} else {
    println("🔒 Too many attempts! Kitchen locked!")
}
```

#### Example 3: Dice Game

```kotlin
val random = kotlin.random.Random
var roll: Int
var attempts = 0

do {
    roll = random.nextInt(1, 7)
    attempts++
    println("🎲 Rolled: $roll")
} while (roll != 6)

println("🎉 Got a 6 after $attempts tries!")
```

---

## Common Mistakes

| ❌ Wrong | ✅ Correct | Why |
|----------|-----------|-----|
| `do { } while (condition);` (semicolon after while) | `do { } while (condition)` | No semicolon needed |
| Forgetting to update condition | Update variable inside loop | Prevents infinite loop |
| Using do-while when while is enough | Use while if 0 iterations possible | Better readability |

---

## Practice Challenges

### Challenge 1: Number Guessing
Create a do-while loop that:
- Generates a random number between 1-10
- Lets the user guess
- Continues until they guess correctly

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
val secret = (1..10).random()
var guess: Int

do {
    print("Guess a number (1-10): ")
    guess = readln().toIntOrNull() ?: 0
    
    if (guess < secret) println("⬆️ Too low!")
    else if (guess > secret) println("⬇️ Too high!")
    else println("🎉 Correct!")
} while (guess != secret)
```
</details>

### Challenge 2: Temperature Converter
Create a do-while loop that:
- Shows a menu (Celsius → Fahrenheit, Fahrenheit → Celsius, Exit)
- Runs until user chooses exit

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
var choice: Int

do {
    println("\n🌡️ Temperature Converter")
    println("1. Celsius → Fahrenheit")
    println("2. Fahrenheit → Celsius")
    println("3. Exit")
    print("Choose: ")
    
    choice = readln().toIntOrNull() ?: 0
    
    when (choice) {
        1 -> {
            print("Enter Celsius: ")
            val c = readln().toDoubleOrNull() ?: 0.0
            val f = c * 9.0 / 5.0 + 32
            println("📊 $c°C = $f°F")
        }
        2 -> {
            print("Enter Fahrenheit: ")
            val f = readln().toDoubleOrNull() ?: 0.0
            val c = (f - 32) * 5.0 / 9.0
            println("📊 $f°F = $c°C")
        }
        3 -> println("👋 Goodbye!")
        else -> println("❌ Invalid choice!")
    }
} while (choice != 3)
```
</details>

---

## Summary

```kotlin
// Syntax
do {
    // Code runs at least once
} while (condition)

// Key points
// ✓ Executes AT LEAST once
// ✓ Condition checked AFTER execution
// ✓ Perfect for menus, validation, taste-testing
// ✓ No semicolon after while
```

### Quick Reference

| Need | Use |
|------|-----|
| Run code at least once | ✅ do-while |
| May need to skip entirely | ✅ while |
| Known number of iterations | ✅ for |

---

## Related Recipes

- 📖 [`ForStirring.kt`](ForStirring.kt) - For loop (batch cooking)
- 📖 [`WhileStirring.kt`](WhileStirring.kt) - While loop (check first)
- 📖 [`Break.kt`](../../BreakAndContinue/Break.kt) - Stop loop early
- 📖 [`Continue.kt`](../../BreakAndContinue/Continue.kt) - Skip iteration

---

> *"A good chef tastes before adding salt. A good developer tests before shipping!"* 👨‍🍳

**Ready to cook? Run `DoWhileStirring.kt` and start practicing!** 🚀
