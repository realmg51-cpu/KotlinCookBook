
# 👨‍🍳 If Chef: Making Decisions in the Kitchen

A chef makes decisions every second:

- *"If the soup is too salty, add water."*
- *"If the customer is vegetarian, don't add bacon."*
- *"If the cake is not baked yet, wait 5 more minutes."*

In Kotlin, you make decisions using **`if`** (and sometimes **`else`**).

But before you can decide, you need to understand **`Boolean`** – the kitchen's yes/no question.

---

## 🔲 Boolean: The Yes/No Question

**Boolean** is a data type that can hold only **two** values:
- `true` (yes, correct, on)
- `false` (no, wrong, off)

Think of it as a **kitchen check**:

| Question | Boolean value |
|----------|---------------|
| "Is the soup hot?" | `true` (if yes) or `false` (if no) |
| "Is the fridge door closed?" | `true` / `false` |
| "Do we have eggs left?" | `true` / `false` |

### How to create a Boolean

```kotlin
val isSoupHot = true
val isFridgeClosed = false
val hasEggs = true
```

You can also get Booleans from **comparisons** (using `>`, `<`, `==`, etc.):

```kotlin
val temperature = 85
val isHot = temperature > 70  // true

val eggsLeft = 2
val hasEggs = eggsLeft > 0    // true

val soupType = "tomato"
val isMushroom = soupType == "mushroom"  // false
```

> 🍳 *Boolean is like asking your sous-chef: "Is the water boiling?" They answer YES (true) or NO (false).*

---

## 🍳 The Basic `if` (A Simple Check)

Now that you have a `true` or `false`, you can use `if` to decide:

```kotlin
val isSoupHot = true

if (isSoupHot == true) {
    println("Soup is hot! 🔥 Serve it carefully.")
}
```

**What happens?**
- If the condition inside `( )` is **true** → run the code inside `{ }`.
- If it's **false** → skip it.

> 🍳 *Like tasting your soup. You only add salt IF it's bland.*

### Shorter way (the chef's shortcut)

Because `isSoupHot` is *already* a Boolean, you don't need `== true`:

```kotlin
val isSoupHot = true

if (isSoupHot) {  // same as "if (isSoupHot == true)"
    println("Soup is hot! 🔥")
}
```

Similarly, to check for `false`:

```kotlin
val isSoupCold = false

if (!isSoupCold) {  // "!" means NOT
    println("Good, soup is not cold!")
}
```

---

## 🔪 `if` + `else` (Two Paths)

Sometimes you need to choose between **two** actions:

```kotlin
val hasEggs = true

if (hasEggs) {
    println("🍳 Let's make an omelette!")
} else {
    println("😭 No eggs. Go to the store first.")
}
```

**How it works:**
- Condition true → run the first block (`if`)
- Condition false → run the second block (`else`)

> 🍳 *Like checking the fridge: IF there's milk, make coffee. ELSE make tea.*

---

## 🧂 `else if` (Many Choices)

When you have more than two possibilities, chain them with `else if`:

```kotlin
val doneness = 75  // 0 = raw, 100 = well done

if (doneness < 40) {
    println("🥩 Too rare! Cook longer.")
} else if (doneness < 70) {
    println("🥩 Medium rare. Perfect!")
} else if (doneness < 90) {
    println("🥩 Medium well. Still good.")
} else {
    println("🥩 Well done. A bit tough, but safe.")
}
```

> 🍳 *Like checking your steak: IF too red → cook more. ELSE IF perfect → serve. ELSE IF overdone → apologize.*

---

## 📊 Boolean Operators (Combining Questions)

Sometimes you need to ask **multiple questions** at once:

| Operator | Meaning | Example | Result |
|----------|---------|---------|--------|
| `&&` | AND (both must be true) | `isHot && hasSalt` | true only if BOTH are true |
| `||` | OR (at least one must be true) | `hasEggs || hasMilk` | true if ANY is true |
| `!` | NOT (flips true/false) | `!isRaining` | true if `isRaining` is false |

### Real kitchen example:

```kotlin
val hasTomato = true
val hasOnion = false
val hasGarlic = true

// Can I make pasta sauce?
val canMakeSauce = hasTomato && (hasOnion || hasGarlic)
// hasTomato is true, AND (hasOnion OR hasGarlic is true) → true

if (canMakeSauce) {
    println("🍝 Let's make pasta sauce!")
} else {
    println("Need more ingredients...")
}
```

---

## 📊 Comparison Table (Your Decision Knife)

You need to **compare** things to make Booleans. Here are your tools:

| Operator | Meaning | True example | False example |
|----------|---------|--------------|----------------|
| `>` | greater than | `10 > 5` ✅ | `3 > 5` ❌ |
| `<` | less than | `3 < 10` ✅ | `10 < 3` ❌ |
| `>=` | greater or equal | `5 >= 5` ✅ | `4 >= 5` ❌ |
| `<=` | less or equal | `3 <= 5` ✅ | `6 <= 5` ❌ |
| `==` | equal to | `"salt" == "salt"` ✅ | `"salt" == "sugar"` ❌ |
| `!=` | not equal to | `"salt" != "sugar"` ✅ | `"salt" != "salt"` ❌ |

> ⚠️ Remember: `=` is for **assignment** (put value into variable).  
> `==` is for **comparison** (check if two things are the same).

---

## 🧪 Real Recipe: Kitchen Temperature Checker

```kotlin
fun main() {
    val fridgeTemp = 4
    val isFridgeWarm = fridgeTemp > 8
    val isFridgeFreezing = fridgeTemp < 0

    if (isFridgeWarm) {
        println("⚠️ Fridge is too warm! Food may spoil.")
    } else if (isFridgeFreezing) {
        println("❄️ Fridge is freezing! Move some items.")
    } else {
        println("✅ Fridge temperature is good.")
    }
}
```

---

## 🎯 Challenges (Level Up!)

### Challenge 1: Boolean Practice
What are the results of these expressions?

```kotlin
val a = 10
val b = 20
val c = 10

a == b        // ?
a == c        // ?
a < b         // ?
a > b         // ?
a != b        // ?
```

### Challenge 2: Grade Checker
Write a program that prints:
- `"Excellent!"` if score >= 90
- `"Good job!"` if score >= 70
- `"You can do better!"` if score >= 50
- `"Need to study more."` otherwise

### Challenge 3: Even or Odd
Ask the user for a number (use `readln().toInt()`) and print whether it's **even** or **odd**.

*Hint: A number is even if `number % 2 == 0` (that's a Boolean!).*

### Challenge 4: Can I make pancakes?
You need: `hasEggs && hasFlour && hasMilk`.  
Ask the user (yes/no) for each ingredient, then tell them if they can make pancakes.

---

## 📝 Summary

| You want to... | Use this |
|----------------|----------|
| Store a yes/no value | `val isSomething = true / false` |
| Compare numbers | `>`, `<`, `>=`, `<=` |
| Compare text or exact values | `==`, `!=` |
| Combine conditions (AND) | `&&` |
| Combine conditions (OR) | `\|\|` |
| Flip true/false | `!` |
| Do something only if condition is true | `if (condition) { ... }` |
| Choose between two actions | `if (condition) { ... } else { ... }` |
| Choose between many actions | `if (a) { ... } else if (b) { ... } else { ... }` |

---

## 🔥 Chef's Tip

> **"A Boolean is the simplest ingredient – but without it, you can't make any decisions."**

Always name your Booleans like a **yes/no question**:
- ✅ `isHot`, `hasEggs`, `canCook`, `isReady`
- ❌ `hot`, `eggs`, `cook`, `ready`

This makes your code read like English:  
`if (isHot)` → "if it is hot"  
`if (hasEggs)` → "if it has eggs"

---

## 📚 Next Recipe

Now you can make decisions with `if` and Booleans. Next, we'll learn about **`when`** – the spice rack that makes multiple choices cleaner and more delicious!

👉 [The Spice Rack: When Expression](https://github.com/realmg51-cpu/KotlinCookBook/blob/main/src/kotlin/normal/WhenChef/introduction.md)

---

> *"A Boolean a day keeps the confusion away.  
> An `if` a day keeps the bugs away..."*

Happy decision-making! 👨‍🍳
