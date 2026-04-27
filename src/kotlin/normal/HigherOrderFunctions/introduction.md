
# 🎯 Higher-Order Functions: The Master Chef's Toolkit

## 📖 What Are Higher-Order Functions?

In Kotlin, a **Higher-Order Function (HOF)** is a function that can:
- **Take other functions as parameters** (like passing a recipe to a chef)
- **Return a function** (like a chef who specializes in different cooking styles)

Regular functions work with data (strings, numbers, lists).  
**Higher-Order Functions work with BEHAVIOR!** 🧠

---

## 🍳 Kitchen Analogy

### Regular Function = Simple Kitchen Tool
```kotlin
fun chopVegetables(veg: String): String {
    return "Chopped $veg"
}
```
A knife does ONE thing - chop. Nothing else.

### Higher-Order Function = Master Chef
```kotlin
fun cook(ingredient: String, method: (String) -> String): String {
    return method(ingredient)
}
```
The chef accepts ANY cooking method and applies it to ANY ingredient!

---

## 🔥 Why Are HOFs Powerful?

### Without HOF (Copy-paste code):
```kotlin
fun fryRice(rice: String) = "Fried $rice 🔥"
fun steamRice(rice: String) = "Steamed $rice 💨"
fun boilRice(rice: String) = "Boiled $rice 💧"

fryRice("Jasmine")   // Fried Jasmine 🔥
steamRice("Jasmine") // Steamed Jasmine 💨
boilRice("Jasmine")  // Boiled Jasmine 💧
```

### With HOF (DRY - Don't Repeat Yourself):
```kotlin
fun cook(rice: String, method: (String) -> String) = method(rice)

val fry = { r: String -> "Fried $r 🔥" }
val steam = { r: String -> "Steamed $r 💨" }
val boil = { r: String -> "Boiled $r 💧" }

cook("Jasmine", fry)   // Fried Jasmine 🔥
cook("Jasmine", steam) // Steamed Jasmine 💨
cook("Jasmine", boil)  // Boiled Jasmine 💧
```

**Same structure, different behavior!** That's the magic ✨

---

## 📚 Real-World Examples

### 1. Collection Operations (Kotlin Built-in)
```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

numbers.map { it * 2 }      // [2, 4, 6, 8, 10]
numbers.filter { it > 3 }   // [4, 5]
numbers.fold(0) { sum, n -> sum + n }  // 15
```

### 2. Timer with Callbacks
```kotlin
fun timer(seconds: Int, onTick: (Int) -> Unit) {
    for (i in seconds downTo 1) {
        onTick(i)
        Thread.sleep(1000)
    }
}

timer(3) { remaining ->
    println("$remaining seconds left...")
}
```

### 3. Retry Mechanism
```kotlin
fun retry(times: Int, action: () -> Unit) {
    repeat(times) {
        try {
            action()
            return
        } catch (e: Exception) {
            println("Retry ${it + 1}/$times failed")
        }
    }
}
```

---

## 🎯 Common Built-in HOFs

| Function | What it does | Example |
|----------|-------------|---------|
| `.map{}` | Transform each element | `list.map { it * 2 }` |
| `.filter{}` | Keep matching elements | `list.filter { it > 5 }` |
| `.forEach{}` | Do something with each | `list.forEach { println(it) }` |
| `.fold{}` | Accumulate values | `list.fold(0) { sum, n -> sum + n }` |
| `.any{}` | Check if ANY match | `list.any { it > 10 }` |
| `.all{}` | Check if ALL match | `list.all { it > 0 }` |

---

## 🤔 Lambda vs Higher-Order Function

**Lambda** = Anonymous function (the "what")
```kotlin
val add = { a: Int, b: Int -> a + b }
```

**Higher-Order Function** = Function that uses lambdas (the "how")
```kotlin
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)  // ← HOF accepts lambda
}

calculate(5, 3, add)  // 8
```

**Analogy:**
- **Lambda** = A recipe card (the instructions)
- **HOF** = A chef who can FOLLOW any recipe card

---

## 💡 Pro Tips

### 1. Use trailing lambda syntax for cleaner code
```kotlin
// Normal
calculate(5, 3, { a, b -> a + b })

// Kotlin style (if lambda is last parameter)
calculate(5, 3) { a, b -> a + b }
```

### 2. Use `it` for single-parameter lambdas
```kotlin
numbers.filter { it > 5 }  // instead of { num -> num > 5 }
```

### 3. Use function references for existing functions
```kotlin
numbers.map(Int::toString)  // instead of { it.toString() }
```

### 4. `inline` for performance
```kotlin
inline fun repeat(times: Int, action: (Int) -> Unit) { ... }
```
Small HOFs should be `inline` to avoid object creation overhead.

---

## 🎓 Exercises to Master HOFs

### Beginner
1. Create `measureTime { }` that prints how long a block takes
2. Write `applyDiscount(price, discount)` where discount is `(Double) -> Double`

### Intermediate
3. Implement `retry(times) { }` that retries failed operations
4. Create `pipeline(vararg steps: (String) -> String)` that chains transformations

### Advanced
5. Build a simple "Strategy Pattern" using HOFs
6. Create `compose(f, g)` that returns `f(g(x))` (function composition)

---

## 📖 Related Recipes

- **LambdaFunctions.kt** - Learn to CREATE anonymous functions
- **ScopeFunctions.kt** - Use `let`, `apply`, `run` with HOFs
- **Collections.kt** - Master `.map`, `.filter`, `.fold`

---

## 🔗 Quick Reference

```kotlin
// Function type syntax
(String) -> Int           // Takes String, returns Int
(Int, Int) -> String      // Takes two Ints, returns String
() -> Unit                // Takes nothing, returns nothing

// Higher-Order Function examples
fun execute(action: () -> Unit) { action() }
fun transform(s: String, f: (String) -> String): String = f(s)
fun multiplier(factor: Int): (Int) -> Int = { it * factor }
```

---

## 🎉 Summary

| Concept | Analogy |
|---------|---------|
| Regular function | Simple tool (knife, pan) |
| Higher-Order Function | Master chef who can use ANY tool |
| Lambda | Recipe card (instructions) |
| HOF + Lambda | Chef following a recipe |

**Remember:** HOFs let you **pass behavior as data**, making your code:
- ✅ **Reusable** (write once, use many ways)
- ✅ **Flexible** (change behavior without changing structure)
- ✅ **Expressive** (code reads like plain English)

---

**Happy cooking with Higher-Order Functions!** 🍳🚀

*Part of the KotlinCookBook - Learn Kotlin the fun way, one recipe at a time!*
