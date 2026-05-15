

## 🍳 Recipe: While Loop - The Automatic Stirrer

> *"Keep stirring until the soup is rBest - that's a while loop!"*

### 📖 What you'll learn:
- How to repeat actions **while a condition is true**
- Difference between `while` and `do-while`
- When to use each type

---

## 🥣 The Basic Recipe

```kotlin
/**
 * Recipe: WhileLoopBasics
 * What you'll learn: Repeat actions while condition is true
 */

fun main() {
    // Like stirring soup: keep stirring while it's NOT ready
    var soupReady = false
    var stirCount = 0
    
    while (!soupReady) {
        stirCount++
        println("Stirring soup... (stir #$stirCount)")
        
        if (stirCount >= 5) {
            soupReady = true
            println("✅ Soup is ready!")
        }
    }
}
```

**Output:**
```
Stirring soup... (stir #1)
Stirring soup... (stir #2)
Stirring soup... (stir #3)
Stirring soup... (stir #4)
Stirring soup... (stir #5)
✅ Soup is ready!
```

---

## 🔄 Two Types of Loops

### 1. **While Loop** - Check First, Then Cook

```kotlin
while (condition) {
    // This runs ONLY IF condition is true
    // Keep running UNTIL condition becomes false
}
```

**Kitchen analogy:** Check if you have eggs BEFORE making an omelette

```kotlin
var eggsInFridge = 3

while (eggsInFridge > 0) {
    println("🥚 Making an omelette...")
    eggsInFridge--  // Use one egg
    println("Eggs left: $eggsInFridge")
}
// When eggsInFridge becomes 0, loop stops
```

### 2. **Do-While Loop** - Cook First, Then Check

```kotlin
do {
    // This runs AT LEAST ONCE
    // Then check condition
} while (condition)
```

**Kitchen analogy:** Taste the soup FIRST, then decide if it needs more salt

```kotlin
var soupTasty = false
var saltAttempts = 0

do {
    println("🧂 Adding salt...")
    saltAttempts++
    
    if (saltAttempts >= 3) {
        soupTasty = true
        println("✅ Soup tastes good now!")
    }
} while (!soupTasty)
```

---

## 📊 While vs Do-While - The Difference

| Feature | `while` | `do-while` |
|---------|---------|-------------|
| **Check timing** | Before first run | After first run |
| **Minimum runs** | 0 (might never run) | 1 (always runs once) |
| **Use when** | Condition might be false initially | Must run at least once |

```kotlin
// WHILE: Might not run at all
var sugar = 0
while (sugar > 0) {
    println("This never prints because sugar is 0")
}

// DO-WHILE: Always runs at least once
do {
    println("This prints once even though sugar is 0")
} while (sugar > 0)
```

---

## 🍲 Real Kitchen Examples

### Example 1: Waiting for Water to Boil

```kotlin
fun waitForWaterToBoil() {
    var waterTemperature = 25  // Starting at 25°C
    val boilingPoint = 100
    
    while (waterTemperature < boilingPoint) {
        println("🌡️ Water at ${waterTemperature}°C - not boiling yet")
        waterTemperature += 15  // Heating up
        Thread.sleep(500)  // Small pause to simulate time
    }
    println("💨 Water is boiling! Time for pasta!")
}

fun main() {
    waitForWaterToBoil()
}
```

### Example 2: Cutting Vegetables

```kotlin
fun chopVegetables() {
    var vegetables = listOf("🥕 Carrot", "🧅 Onion", "🥔 Potato", "🌶️ Pepper")
    var chopped = mutableListOf<String>()
    
    while (vegetables.isNotEmpty()) {
        val current = vegetables.first()
        println("🔪 Chopping $current...")
        chopped.add(current)
        vegetables = vegetables.drop(1)  // Remove chopped vegetable
        
        println("   Remaining: ${vegetables.size} vegetables")
    }
    
    println("✅ All vegetables chopped! $chopped")
}

fun main() {
    chopVegetables()
}
```

### Example 3: Password Check (Do-While)

```kotlin
fun secretRecipeAccess() {
    val secretCode = "cook123"
    var attempts = 0
    var input: String
    
    do {
        println("🔐 Enter secret recipe code (attempt ${attempts + 1}/3):")
        input = readln()
        attempts++
        
        if (input != secretCode) {
            println("❌ Wrong code!")
        }
    } while (input != secretCode && attempts < 3)
    
    if (input == secretCode) {
        println("📖 Access granted! Here's the secret recipe...")
    } else {
        println("🚫 Too many attempts! Kitchen locked!")
    }
}
```

---

## 🎯 Try It Yourself!

### Challenge 1: Countdown Timer
Create a countdown from 10 to 1, then print "🎉 Happy Cooking!"

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
fun countdown() {
    var timer = 10
    while (timer > 0) {
        println("⏰ $timer...")
        timer--
        Thread.sleep(1000)
    }
    println("🎉 Happy Cooking!")
}
```
</details>

### Challenge 2: Guess the Ingredient
Generate a random number (1-5) representing an ingredient. Let user guess until correct.

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
fun guessIngredient() {
    val secret = (1..5).random()
    var guess = 0
    
    println("Guess the ingredient number (1-5):")
    
    while (guess != secret) {
        print("Your guess: ")
        guess = readln().toInt()
        
        if (guess < secret) println("⬆️ Too low! Try higher")
        else if (guess > secret) println("⬇️ Too high! Try lower")
        else println("🎉 Correct! That's the secret ingredient!")
    }
}
```
</details>

### Challenge 3: Recipe Cost Calculator
Keep adding ingredient costs until user types "done", then show total.

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
fun calculateCost() {
    var total = 0.0
    var input: String
    
    println("💰 Enter ingredient costs (type 'done' to finish):")
    
    do {
        print("Cost: ")
        input = readln()
        
        if (input.lowercase() != "done") {
            val cost = input.toDoubleOrNull()
            if (cost != null && cost > 0) {
                total += cost
                println("   Added: $$cost (Total: $$total)")
            } else {
                println("   ❌ Invalid amount! Use numbers like 2.99")
            }
        }
    } while (input.lowercase() != "done")
    
    println("💵 Total recipe cost: $$total")
}
```
</details>

---

## 🚨 Common Mistakes (Kitchen Fires)

| Mistake | What Happens | How to Fix |
|---------|--------------|------------|
| **Infinite loop** | Code runs forever! 😱 | Make sure condition eventually becomes `false` |
| ```kotlin while (true) { println("Stuck!") } ``` | Never stops | Add a way to break or change condition |
| **Forgetting to update** | Condition never changes | Update your variable inside the loop |
| ```kotlin var count = 0 while (count < 5) { // forgot count++ } ``` | Infinite loop! | Add `count++` |
| **Wrong condition** | Loop never runs | Check your logic (use `>`, `<`, `==`, `!=`) |
| **Using `=` instead of `==`** | Assignment, not comparison | Use `==` for comparison |

---

## 💡 Pro Tips

1. **Always have an exit strategy** - Ensure your condition will eventually become false
2. **Use `break` for emergencies** - Exit loop immediately if something goes wrong
3. **Use `continue` to skip** - Jump to next iteration without finishing current
4. **When in doubt, add print statements** - Debug by printing values each iteration

```kotlin
// Emergency break example
var attempts = 0
while (true) {  // Looks infinite, but...
    if (attempts >= 10) {
        println("Too many attempts! Breaking out!")
        break  // Emergency exit!
    }
    attempts++
}
```

---

## 🍽️ When to Use While vs Other Loops

| Situation | Best Choice | Why |
|-----------|-------------|-----|
| Unknown number of iterations | `while` | Keep going until condition met |
| Must run at least once | `do-while` | Check after first run |
| Known number of iterations | `for` loop | Cleaner syntax |
| Loop through collection | `for` or `forEach` | More readable |
| Infinite until event | `while(true)` + `break` | Clear intent |

---

## 📚 What's Next?

Now that you know how to stir automatically (while loops), you're ready to learn:
- **For loops** - When you know exactly how many times to stir
- **Break & Continue** - How to stop early or skip steps
- **Nested loops** - Stirring multiple pots at once!

---

> *"A good chef knows when to keep stirring and when to stop. Now you know while loops!"* 🚀

**Happy cooking with loops, chef! 👨‍🍳👩‍🍳**
