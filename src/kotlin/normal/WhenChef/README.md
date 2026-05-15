
# 🧂 When Chef: The Spice Rack of Decision Making

You already know `if` and `else`. They work fine for 2-3 choices.

But what if you have **many** choices?

- *"If it's Monday → cook pasta. If Tuesday → cook soup. If Wednesday → cook curry..."*
- *"If the error code is 404 → show 'Not found'. If 500 → 'Server error'. If 401 → 'Unauthorized'..."*

Writing 10 `else if` statements is like using 10 different spoons when you just need a **spice rack**.

In Kotlin, the spice rack is called **`when`**.

---

## 🍳 The Basic `when` (Your First Spice Rack)

```kotlin
val day = "Tuesday"

when (day) {
    "Monday" -> println("🍝 Pasta day!")
    "Tuesday" -> println("🍜 Soup day!")
    "Wednesday" -> println("🍛 Curry day!")
    "Thursday" -> println("🥗 Salad day!")
    "Friday" -> println("🍕 Pizza day!")
    else -> println("🎉 Weekend! Free cooking!")
}
```

**How it works:**
- Look at the value inside `when ( )`
- Compare it with each **branch** (left of `->`)
- When a match is found → execute the code (right of `->`)
- If no match → run `else` (if provided)

> 🍳 *Like a spice rack: you look for "cumin", grab the cumin jar, and use it.*

---

## 🔪 `when` as an Expression (Returning a Value)

Here's where `when` becomes **really powerful** – it can **give back** a value:

```kotlin
val day = "Tuesday"

val meal = when (day) {
    "Monday" -> "🍝 Pasta"
    "Tuesday" -> "🍜 Soup"
    "Wednesday" -> "🍛 Curry"
    "Thursday" -> "🥗 Salad"
    "Friday" -> "🍕 Pizza"
    else -> "🎉 Whatever you like!"
}

println("Today's meal: $meal")
```

> 🍳 *Like asking the spice rack: "What spice goes with chicken?" and it GIVES you the answer.*

---

## 🧂 Matching Multiple Values (One branch, many options)

You can match **several values** with the same result:

```kotlin
val day = "Saturday"

val type = when (day) {
    "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday 😴"
    "Saturday", "Sunday" -> "Weekend 🎉"
    else -> "Not a day?"
}

println("$day is a $type")
```

> 🍳 *Like grouping spices: "oregano, basil, thyme" all go into the "Italian" drawer.*

---

## 📊 Matching Ranges (Numbers)

`when` works beautifully with numbers and ranges:

```kotlin
val temperature = 85

val soupStatus = when (temperature) {
    in 0..30 -> "❄️ Too cold! Heat it up."
    in 31..60 -> "🌡️ Warm, but could be hotter."
    in 61..80 -> "👍 Perfect serving temperature!"
    in 81..100 -> "🔥 Hot! Be careful!"
    else -> "🤔 Is that even soup?"
}

println(soupStatus)
```

> 🍳 *Like a thermometer: "If temp is between 60-80 → perfect. If above 80 → too hot."*

---

## 🔍 Matching Without an Argument (Smart Conditions)

You can also use `when` **without** an argument – each branch becomes a boolean condition:

```kotlin
val eggs = 3
val hasMilk = true
val hasCheese = false

val breakfast = when {
    eggs >= 2 && hasCheese -> "🧀 Cheesy omelette!"
    eggs >= 2 && hasMilk -> "🥛 Scrambled eggs with milk!"
    eggs >= 2 -> "🍳 Plain omelette"
    eggs >= 1 -> "🍳 Fried egg"
    else -> "😭 No eggs. Go to the store!"
}

println(breakfast)
```

> 🍳 *Like asking multiple questions: "Do we have eggs AND cheese? No. Eggs AND milk? Yes → make that!"*

---

## 🔥 Chef's Warning: The `else` Rule (Important!)

When you use `when` as an **expression** (assigning the result to a variable), **`else` is REQUIRED** – unless you have covered *every* possible case.

### ✅ Correct – with `else`

```kotlin
val statusCode = 404

val message = when (statusCode) {
    200 -> "OK"
    404 -> "Not Found"
    else -> "Unknown"  // ✅ else makes it safe!
}
```

### ❌ Wrong – missing `else` (ERROR!)

```kotlin
val statusCode = 404

val message = when (statusCode) {
    200 -> "OK"
    404 -> "Not Found"
    // ❌ ERROR! 'when' expression must be exhaustive
}
```

### ✅ Exception – all cases covered

```kotlin
val isRaining = true

val advice = when (isRaining) {
    true -> "☔ Bring an umbrella!"
    false -> "😎 Enjoy the sun!"
}
// ✅ No else needed – Boolean only has true/false!
```

```kotlin
val day = "Monday"

val type = when (day) {
    "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday"
    "Saturday", "Sunday" -> "Weekend"
}
// ✅ Also fine – every day of the week is covered!
```

### 📊 Summary – `else` Rule

| Type of `when` | `else` required? | Example |
|----------------|------------------|---------|
| `when` as **statement** (no assignment) | ❌ Not required | `when (x) { 1 -> print("one") }` |
| `when` as **expression** (assigned to variable) | ✅ REQUIRED (unless all cases covered) | `val result = when (x) { ... }` |
| All cases covered (Boolean, Enum) | ❌ No `else` needed | `when (bool) { true->... false->... }` |

### 🍳 Kitchen Example

```kotlin
fun main() {
    val eggs = 3
    
    // ✅ Correct – has else
    val dish = when (eggs) {
        1 -> "🍳 Fried egg"
        2 -> "🍳 Double fried egg"
        else -> "🍳 Omelette!"  // eggs = 3,4,5,... all go here
    }
    
    // ❌ This would cause an ERROR:
    // val wrong = when (eggs) {
    //     1 -> "One egg"
    //     2 -> "Two eggs"
    // } // ERROR! eggs could be 3,4,5...
}
```

> 🍳 *Remember: `Int` can be ANY number from -2 billion to 2 billion. You can't write 4 billion branches. That's why `else` is required!*

---

## 📊 Quick Reference (Your Spice Rack)

| You want to... | Use this |
|----------------|----------|
| Match one value against many options | `when (value) { option1 -> ... option2 -> ... }` |
| Return a value from `when` | `val result = when (value) { ... }` |
| Match multiple values together | `"A", "B", "C" -> ...` |
| Match a range of numbers | `in 1..10 -> ...` |
| Match with complex conditions | `when { condition1 -> ... condition2 -> ... }` |
| Provide a default | `else -> ...` |

---

## 🧪 Real Recipe: Kitchen Helper

```kotlin
fun main() {
    println("What ingredient do you have?")
    val ingredient = readln().lowercase()
    
    val dish = when (ingredient) {
        "tomato", "tomatoes" -> "🍝 Spaghetti with tomato sauce!"
        "egg", "eggs" -> "🍳 Omelette or scrambled eggs!"
        "chicken" -> "🍗 Roasted chicken with herbs!"
        "potato", "potatoes" -> "🥔 Mashed potatoes or fries!"
        "rice" -> "🍚 Fried rice or plain steamed rice!"
        else -> "🤔 Hmm... with $ingredient, try searching for a recipe online!"
    }
    
    println(dish)
}
```

---

## 🎯 Challenges (Level Up!)

### Challenge 1: Number to Word
Write a program that takes a number (1-5) and prints its word form:

```
Input: 1 → Output: "One"
Input: 2 → Output: "Two"
Input: 3 → Output: "Three"
Input: 4 → Output: "Four"
Input: 5 → Output: "Five"
Else → "Number out of range"
```

### Challenge 2: Simple Calculator (with `when`)
Ask the user for two numbers and an operator (`+`, `-`, `*`, `/`).  
Use `when` to perform the correct operation.

### Challenge 3: Temperature Advisor
Ask for temperature in Celsius. Use `when` with ranges to advise:

| Temperature | Advice |
|-------------|--------|
| Below 0 | "🥶 Freezing! Stay inside." |
| 0 to 15 | "🧥 Cold. Wear a jacket." |
| 16 to 25 | "😊 Perfect weather!" |
| 26 to 35 | "🥵 Hot! Drink water." |
| Above 35 | "🔥 Heatwave! Stay in AC." |

### Challenge 4: Fridge Checker (without argument)
Create a program that checks multiple conditions using `when` (no argument):

- If `hasEggs && hasMilk` → "You can make custard!"
- If `hasEggs && hasFlour` → "You can make pasta!"
- If `hasMilk && hasFlour` → "You can make pancakes!"
- Else → "Need more ingredients!"

---

## 📝 Summary

| `if-else` | `when` |
|-----------|--------|
| Good for 2-3 conditions | Best for 3+ conditions |
| Can be hard to read when long | Very clean and readable |
| Each condition is separate | All conditions in one structure |
| Cannot return value easily | Can return value naturally |

---

## 🔥 Chef's Tip

> **"If you see more than 3 `else if` statements in a row, it's time to use `when`."**

`when` is not just for numbers and strings – it works with:
- `Int`, `String`, `Char`, `Boolean`
- Enums (we'll learn later)
- Custom types (advanced)

**The Golden Rule:** *"If you're putting the `when` result into a variable, always add `else` – unless you're 100% sure you've covered every possibility."*

```kotlin
// ✅ Safe – has else
val result = when (value) {
    // branches...
    else -> "default"
}

// ❌ Dangerous – might crash!
val result = when (value) {
    // branches... but no else
}
```

**Pro tip:** Kotlin's `when` is more powerful than `switch` in Java or C – it can match ranges, multiple values, and even complex conditions!

---

## 📚 Next Recipe

Now you can make complex decisions cleanly with `when`. Next, we'll learn about **loops** – doing things repeatedly without writing the same code 100 times!

👉 [For Loop: The Automatic Stirrer](https://github.com/realmg51-cpu/KotlinCookBook/blob/main/src/kotlin/normal/Loops/For/introduction.md)

---

> *"A chef with a spice rack cooks faster than a chef with 20 spoons."*
> 
> *"A Kotlin developer with `when` writes cleaner code than one with 20 `else if`s."*

Happy spicing! 👨‍🍳
