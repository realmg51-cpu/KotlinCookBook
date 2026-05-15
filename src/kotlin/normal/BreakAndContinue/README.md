## 🛑 Continue & Break - The Kitchen Controls

> *"Sometimes you need to skip a bad ingredient, other times you need to stop cooking entirely!"*

---

## 📖 What You'll Learn

- **`break`** - Stop the loop immediately (like turning off the stove)
- **`continue`** - Skip one iteration and keep going (like picking out a bad egg)
- When to use each one
- Labeled breaks for nested loops

---

## 🔪 Break - Turn Off the Stove

**Kitchen analogy:** You're tasting soup spoon by spoon. When it's finally perfect, you STOP tasting.

```kotlin
/**
 * Recipe: BreakExample
 * What you'll learn: Stop loop when condition is met
 */

fun main() {
    var spoonful = 1
    
    while (spoonful <= 10) {
        println("🥄 Tasting spoonful #$spoonful")
        
        if (spoonful == 5) {
            println("✅ Perfect! No more tasting needed!")
            break  // Exit loop immediately
        }
        
        spoonful++
    }
    
    println("Loop stopped at spoonful #$spoonful")
}
```

**Output:**
```
🥄 Tasting spoonful #1
🥄 Tasting spoonful #2
🥄 Tasting spoonful #3
🥄 Tasting spoonful #4
🥄 Tasting spoonful #5
✅ Perfect! No more tasting needed!
Loop stopped at spoonful #5
```

---

## 🥚 Continue - Skip the Bad Egg

**Kitchen analogy:** You're cracking eggs into a bowl. When you find a bad egg, you THROW IT AWAY and CONTINUE with the next egg.

```kotlin
/**
 * Recipe: ContinueExample
 * What you'll learn: Skip bad items and keep going
 */

fun main() {
    val eggs = listOf("🥚 Good", "🥚 Good", "💩 Bad", "🥚 Good", "🥚 Good")
    
    for (egg in eggs.withIndex()) {
        if (egg.value == "💩 Bad") {
            println("🚫 Egg #${egg.index + 1} is bad! Throwing away...")
            continue  // Skip this egg, move to next
        }
        
        println("✅ Adding ${egg.value} egg #${egg.index + 1} to bowl")
    }
    
    println("Finished checking all eggs!")
}
```

**Output:**
```
✅ Adding 🥚 Good egg #1 to bowl
✅ Adding 🥚 Good egg #2 to bowl
🚫 Egg #3 is bad! Throwing away...
✅ Adding 🥚 Good egg #4 to bowl
✅ Adding 🥚 Good egg #5 to bowl
Finished checking all eggs!
```

---

## 📊 Break vs Continue - The Difference

| Keyword | What it does | Kitchen Analogy |
|---------|--------------|-----------------|
| **`break`** | Exits the ENTIRE loop | Turning off the stove completely |
| **`continue`** | Skips ONE iteration | Throwing away one bad ingredient |

```kotlin
// Visual comparison
fun compareBreakAndContinue() {
    println("=== BREAK: Stops entirely ===")
    for (i in 1..5) {
        if (i == 3) break
        println("Processing $i")  // Prints: 1, 2 only
    }
    
    println("\n=== CONTINUE: Skips one ===")
    for (i in 1..5) {
        if (i == 3) continue
        println("Processing $i")  // Prints: 1, 2, 4, 5
    }
}
```

---

## 🍲 Real Kitchen Examples

### Example 1: Break - Found the Recipe!

```kotlin
fun searchRecipeBook() {
    val recipes = listOf(
        "Pasta", "Salad", "Soup", 
        "Secret Family Recipe", "Dessert"
    )
    
    for (recipe in recipes) {
        println("📖 Checking recipe: $recipe")
        
        if (recipe == "Secret Family Recipe") {
            println("🔍 FOUND IT! 🎉")
            println("Stopping search...")
            break  // Found what we need, stop searching
        }
    }
    
    println("Time to cook!")
}

fun main() {
    searchRecipeBook()
}
```

### Example 2: Continue - Filter Allergic Ingredients

```kotlin
fun prepareMeal(allergicTo: String) {
    val ingredients = listOf("🥜 Nuts", "🥛 Milk", "🍞 Bread", "🥜 More Nuts", "🍎 Apple")
    
    println("Preparing meal (allergic to: $allergicTo)")
    println("-".repeat(40))
    
    for (ingredient in ingredients) {
        if (ingredient.contains(allergicTo)) {
            println("⚠️ Skipping $ingredient (contains allergen)")
            continue  // Skip allergic ingredients
        }
        
        println("✅ Adding $ingredient to meal")
    }
    
    println("✅ Meal prepared safely!")
}

fun main() {
    prepareMeal("Nuts")
}
```

### Example 3: Break in While Loop - Temperature Control

```kotlin
fun heatOven() {
    var temperature = 0
    val targetTemp = 350
    
    while (temperature < targetTemp) {
        temperature += 25
        println("🔥 Oven heating: ${temperature}°F")
        
        if (temperature >= targetTemp) {
            println("✅ Oven ready at ${temperature}°F!")
            break  // Exit once we reach target
        }
        
        // Simulate heating time
        Thread.sleep(500)
    }
}

fun main() {
    heatOven()
}
```

---

## 🏷️ Labeled Break & Continue - Multiple Stoves

**Kitchen analogy:** You have 3 pots on the stove. You want to stop cooking in a SPECIFIC pot, not all of them!

```kotlin
/**
 * Recipe: LabeledBreaks
 * What you'll learn: Control nested loops with labels
 */

fun searchMultiplePots() {
    // Searching for a golden spoon in multiple pots
    val pots = listOf("Pot A", "Pot B", "Pot C")
    val contents = listOf(
        listOf("🥄", "🍜", "🥕"),     // Pot A
        listOf("🍲", "🥄", "🌿"),     // Pot B (has golden spoon!)
        listOf("🍛", "🍚", "🥄")      // Pot C
    )
    
    potLoop@ for (i in pots.indices) {
        println("\nSearching in ${pots[i]}:")
        
        itemLoop@ for (j in contents[i].indices) {
            val item = contents[i][j]
            
            if (item == "🥄" && pots[i] == "Pot B") {
                println("🔱 Found GOLDEN SPOON in ${pots[i]} at position ${j + 1}!")
                break@potLoop  // Stop searching all pots entirely
            }
            
            println("   Checking item: $item")
        }
    }
    
    println("\n✅ Search complete!")
}

fun main() {
    searchMultiplePots()
}
```

### Another Labeled Break Example

```kotlin
fun findExpiredIngredient() {
    val fridge = mapOf(
        "Shelf 1" to listOf("🥛 Milk", "🥚 Eggs", "🧀 Cheese"),
        "Shelf 2" to listOf("🥬 Lettuce", "💀 Expired Yogurt", "🥕 Carrots"),
        "Shelf 3" to listOf("🍎 Apples", "🍌 Bananas")
    )
    
    shelfLoop@ for ((shelf, items) in fridge) {
        println("\nChecking $shelf:")
        
        for (item in items) {
            if (item.contains("Expired")) {
                println("⚠️ Found EXPIRED item: $item")
                println("🛑 Stopping search - need to clean fridge!")
                break@shelfLoop  // Exit outer loop
            }
            println("   ✅ $item is fresh")
        }
    }
    
    println("\nClean the expired item now!")
}

fun main() {
    findExpiredIngredient()
}
```

---

## 🎯 Try It Yourself!

### Challenge 1: First Negative Number
Given a list of numbers, stop when you find the first negative number.

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
fun findFirstNegative() {
    val numbers = listOf(5, 3, 8, -2, 7, -1, 4)
    
    for (num in numbers) {
        if (num < 0) {
            println("❌ Found first negative number: $num")
            println("Stopping search!")
            break
        }
        println("✅ $num is positive")
    }
}
```
</details>

### Challenge 2: Skip Weekends
Print days of the week, but skip Saturday and Sunday.

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
fun skipWeekends() {
    val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    
    for (day in days) {
        if (day == "Saturday" || day == "Sunday") {
            println("🎉 Skipping $day (weekend!)")
            continue
        }
        println("📅 Working on $day")
    }
}
```
</details>

### Challenge 3: Find First Prime Number
Loop through numbers and stop at the first prime number.

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2 until n) {
        if (n % i == 0) return false
    }
    return true
}

fun findFirstPrime() {
    val numbers = listOf(4, 6, 8, 9, 10, 11, 12, 13)
    
    for (num in numbers) {
        if (isPrime(num)) {
            println("🔢 Found first prime number: $num")
            break
        }
        println("$num is not prime")
    }
}
```
</details>

### Challenge 4: Labeled Break Challenge
Search a 3x3 grid for the number 5. Stop all loops when found.

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
fun searchGrid() {
    val grid = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    
    searchLoop@ for (row in grid.indices) {
        for (col in grid[row].indices) {
            if (grid[row][col] == 5) {
                println("🎯 Found 5 at position ($row, $col)!")
                break@searchLoop
            }
        }
    }
}
```
</details>

---

## 🚨 Common Mistakes (Kitchen Fires)

| Mistake | What Happens | How to Fix |
|---------|--------------|------------|
| **Using `break` when you mean `continue`** | Loop stops too early | Use `continue` to skip, not stop |
| **Forgetting labels in nested loops** | Only breaks inner loop | Use `@label` and `break@label` |
| **`break` outside a loop** | Compilation error | Only use `break` inside loops |
| **Infinite loop with `continue`** | Loop never progresses | Update condition BEFORE `continue` |

```kotlin
// WRONG - Infinite loop!
var x = 0
while (x < 10) {
    if (x == 5) continue  // x never increments when x==5!
    x++
}

// RIGHT - Update before continue
var x = 0
while (x < 10) {
    x++
    if (x == 5) continue  // x is already 5, will become 6 next loop
    println(x)
}
```

---

## 💡 Pro Tips

### 1. Use `break` for efficiency
```kotlin
// Instead of checking all items when found early
fun findItem(items: List<String>, target: String): Boolean {
    for (item in items) {
        if (item == target) return true  // Early return (implicit break)
    }
    return false
}
```

### 2. Use `continue` for cleaner code
```kotlin
// WITHOUT continue (harder to read)
for (item in items) {
    if (isValid(item)) {
        // 10 lines of processing
    }
}

// WITH continue (clearer)
for (item in items) {
    if (!isValid(item)) continue  // Skip invalid early
    // 10 lines of processing (indented less)
}
```

### 3. Label naming convention
```kotlin
// Use descriptive labels
outer@ for (i in 1..3) {
    inner@ for (j in 1..3) {
        if (condition) break@outer
    }
}

// Better: meaningful names
searchGrid@ for (row in 0..2) {
    searchRow@ for (col in 0..2) {
        if (found) break@searchGrid
    }
}
```

---

## 📚 Quick Reference Card

```kotlin
// BREAK - Stop completely
for (i in 1..10) {
    if (i == 5) break  // Stops at 5
}

// CONTINUE - Skip one
for (i in 1..10) {
    if (i % 2 == 0) continue  // Skips even numbers
    println(i)  // Prints only odd numbers
}

// LABELED BREAK - Break outer loop
outer@ for (i in 1..3) {
    for (j in 1..3) {
        if (i == 2 && j == 2) break@outer
    }
}

// LABELED CONTINUE - Continue outer loop
outer@ for (i in 1..3) {
    for (j in 1..3) {
        if (j == 2) continue@outer  // Skip to next i
    }
}
```

---

## 🍽️ When to Use What

| Scenario | Best Choice | Why |
|----------|-------------|-----|
| Found what you're looking for | `break` | No need to keep searching |
| Skip invalid/bad items | `continue` | Process only good items |
| Emergency stop (oven on fire!) | `break` | Stop everything immediately |
| Filter out unwanted data | `continue` | Skip and move on |
| Multiple nested loops | Labeled `break` | Exit exactly where needed |
| Search in 2D grid | Labeled `break` | Stop all searches when found |

---

## 🎓 What's Next?

Now you know how to control your loops like a pro chef! Next recipes:
- **Nested Loops** - Loops inside loops (multiple pots!)
- **For Loops** - When you know exactly how many times to repeat
- **ForEach** - The modern way to loop through collections

---

> *"A smart chef knows when to stop cooking and when to just skip the bad ingredients. Now you control the kitchen!"* 🚀

**Keep practicing, chef! 👨‍🍳👩‍🍳**
