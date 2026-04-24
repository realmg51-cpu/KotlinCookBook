
# 🔧 Basic Functions

> *"A function is like a recipe - write it once, use it many times!"*

## What is a Function?

A **function** is a reusable block of code that performs a specific task. Instead of writing the same code multiple times, you write a function once and call it whenever needed.

```kotlin
fun greetChef() {
    println("Hello, Chef! 🍳")
}

// Call the function
greetChef()  // Output: Hello, Chef! 🍳
```

---

## Why Use Functions?

| Benefit | Explanation | Kitchen Analogy |
|---------|-------------|-----------------|
| **Reusability** | Write once, use many times | Same recipe for multiple meals |
| **Organization** | Code is grouped logically | Organized recipe book |
| **Readability** | Easy to understand what code does | Recipe name tells you the dish |
| **Maintainability** | Fix bugs in one place | Update recipe once, not every time |
| **Testing** | Test each part independently | Taste each ingredient separately |

---

## Function Anatomy

```kotlin
fun cookPasta(minutes: Int, sauce: String): String {
//  ^          ^            ^         ^
//  |          |            |         |
//  |          |            |         └── Return type (what it gives back)
//  |          |            └── Parameters (ingredients needed)
//  |          └── Function name (what it does)
//  └── Keyword (tells Kotlin this is a function)

    println("Cooking pasta for $minutes minutes...")
    println("Adding $sauce sauce...")
    
    return "$sauce pasta is ready in $minutes minutes!"
    //     ^^
    //     Return value (the final dish)
}
```

### Parts of a Function

| Part | Example | Description |
|------|---------|-------------|
| **Keyword** | `fun` | Declares a function |
| **Name** | `cookPasta` | Should describe what it does (verb + noun) |
| **Parameters** | `minutes: Int, sauce: String` | Inputs the function needs |
| **Return Type** | `: String` | Type of value returned (optional) |
| **Body** | `{ ... }` | Code that runs when called |
| **Return** | `return ...` | Value sent back to caller |

---

## Types of Basic Functions

### 1. No Parameters, No Return

Simplest function - just does something without needing input or giving output.

```kotlin
fun greetChef() {
    println("Hello, Chef! Welcome to the kitchen! 🍳")
}

// Usage:
greetChef()  // Just call it by name
```

**When to use:** Actions that don't need data, like printing a welcome message.

---

### 2. With Parameters, No Return

Function that needs input but doesn't return anything (just does something).

```kotlin
fun cookDish(dishName: String, minutes: Int) {
    println("🔪 Cooking $dishName for $minutes minutes...")
    println("✅ $dishName is ready!")
}

// Usage:
cookDish("Pasta", 30)
cookDish("Soup", 20)
```

**When to use:** Actions that need ingredients but don't produce a value to use later.

---

### 3. With Return Value

Function that calculates or produces something and gives it back.

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}

fun calculatePrice(pizzas: Int): Double {
    val pricePerPizza = 12.99
    return pizzas * pricePerPizza
}

// Usage:
val total = add(5, 3)           // total = 8
val cost = calculatePrice(2)    // cost = 25.98
```

**When to use:** When you need to compute or transform data.

---

### 4. Default Parameters

Parameters with default values - if caller doesn't provide them, the default is used.

```kotlin
fun makeCoffee(type: String = "Americano", sugar: Int = 1) {
    println("☕ Making $type with $sugar spoon(s) of sugar")
}

// All these work:
makeCoffee()                    // ☕ Making Americano with 1 sugar
makeCoffee("Latte")             // ☕ Making Latte with 1 sugar
makeCoffee("Espresso", 2)       // ☕ Making Espresso with 2 sugar
makeCoffee(sugar = 3)           // ☕ Making Americano with 3 sugar
```

**When to use:** When a parameter has a common default value.

---

### 5. Named Arguments

Call functions by naming parameters - order doesn't matter!

```kotlin
fun bakeCake(flour: Int, sugar: Int, eggs: Int) {
    println("🎂 Flour: ${flour}g, Sugar: ${sugar}g, Eggs: $eggs")
}

// All these work the same:
bakeCake(500, 200, 3)                    // Positional (order matters)
bakeCake(flour = 500, sugar = 200, eggs = 3)    // Named
bakeCake(eggs = 3, flour = 500, sugar = 200)    // Any order with names
```

**When to use:** When functions have many parameters or default values.

---

### 6. Single-Expression Functions

Functions that contain only one expression - can use shorter syntax.

```kotlin
// Regular way (with braces)
fun double(x: Int): Int {
    return x * 2
}

// Single-expression (without braces, using =)
fun double(x: Int): Int = x * 2

// Even shorter - return type inferred
fun double(x: Int) = x * 2

// More examples:
fun square(x: Int) = x * x
fun circleArea(radius: Double) = Math.PI * radius * radius
fun isAdult(age: Int) = age >= 18
```

**When to use:** Simple calculations that fit on one line.

---

## Kitchen Analogy: Functions as Recipe Cards

| Programming | Kitchen |
|-------------|---------|
| **Function** | Recipe card |
| **Function name** | Dish name (e.g., "Pasta Carbonara") |
| **Parameters** | Ingredients needed (e.g., "pasta", "cheese", "eggs") |
| **Return value** | The final dish |
| **Calling a function** | Following the recipe to cook |
| **Reusing a function** | Cooking the same dish again |
| **Default parameter** | "Use regular salt if not specified" |
| **Named arguments** | "Add ingredients in any order" |

---

## Complete Example: Pizza Order System

```kotlin
// Function with default parameter
fun orderPizza(size: String = "medium", topping: String = "cheese"): Double {
    val basePrice = when (size.lowercase()) {
        "small" -> 8.99
        "medium" -> 10.99
        "large" -> 13.99
        else -> 10.99
    }
    
    val toppingPrice = when (topping.lowercase()) {
        "cheese" -> 0.0
        "pepperoni" -> 2.0
        "mushroom" -> 1.5
        else -> 1.0
    }
    
    return basePrice + toppingPrice
}

fun printReceipt(items: List<String>, total: Double) {
    println("\n📋 RECEIPT")
    println("==========")
    items.forEach { println("   • $it") }
    println("==========")
    println("💰 Total: $${"%.2f".format(total)}")
}

fun main() {
    // Using functions
    val pizza1 = orderPizza()                    // medium cheese: $10.99
    val pizza2 = orderPizza("large", "pepperoni") // large pepperoni: $15.99
    val pizza3 = orderPizza(topping = "mushroom") // medium mushroom: $12.49
    
    val total = pizza1 + pizza2 + pizza3
    val items = listOf("Cheese Pizza", "Large Pepperoni", "Mushroom Pizza")
    
    printReceipt(items, total)
}
```

---

## Naming Conventions

```kotlin
// ✅ Good names (verb + noun, describes what it does)
fun calculateTotal()
fun getUserName()
fun saveToDatabase()
fun isValidEmail()
fun convertToCelsius()

// ⚠️ Bad names
fun calc()      // Too vague, what does it calculate?
fun do()        // Invalid (reserved keyword)
fun process()   // Doesn't describe what it processes
fun data()      // Not a verb, doesn't describe action
```

### Naming Rules

| Rule | Example |
|------|---------|
| Start with lowercase letter | `cookPasta`, not `CookPasta` |
| Use camelCase (no spaces) | `calculatePrice`, not `calculate_price` |
| Use verb + noun | `getTotal`, `saveUser` |
| Be descriptive | `findUserById`, not `find` |
| Don't use reserved keywords | `fun`, `if`, `when`, `class` |

---

## Common Mistakes

| ❌ Wrong | ✅ Correct | Why |
|----------|-----------|-----|
| `fun cook() { return "Pasta" }` | `fun cook(): String { return "Pasta" }` | Missing return type declaration |
| `fun add(a, b) { return a+b }` | `fun add(a: Int, b: Int): Int = a + b` | Parameters need types |
| Forgetting to call: `cookPasta` | `cookPasta()` | Need parentheses to call |
| Return mismatched type: `return "text"` in `: Int` function | Return correct type | Return type must match |
| `fun getName { return name }` | `fun getName(): String { return name }` | Missing return type annotation |

---

## Practice Challenges

### Challenge 1: Greeting Function
Write a function that takes a name and returns a greeting.

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
fun greet(name: String): String {
    return "Hello, $name! Welcome to Kotlin!"
}

// Or as single-expression:
fun greet(name: String) = "Hello, $name! Welcome to Kotlin!"

// Usage:
println(greet("Chef"))
```
</details>

### Challenge 2: Discount Calculator
Write a function that calculates price after discount.

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
fun applyDiscount(price: Double, discountPercent: Double): Double {
    val discount = price * discountPercent / 100
    return price - discount
}

// Single-expression version:
fun applyDiscount(price: Double, discountPercent: Double) = 
    price - (price * discountPercent / 100)

// Usage:
val finalPrice = applyDiscount(100.0, 20.0)  // 80.0
```
</details>

### Challenge 3: Rectangle Calculator
Write a function that calculates area and perimeter of a rectangle.

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
fun rectangleArea(width: Double, height: Double) = width * height

fun rectanglePerimeter(width: Double, height: Double) = 2 * (width + height)

fun describeRectangle(width: Double, height: Double) {
    println("📐 Rectangle $width x $height")
    println("   Area: ${rectangleArea(width, height)}")
    println("   Perimeter: ${rectanglePerimeter(width, height)}")
}

// Usage:
describeRectangle(5.0, 3.0)
```
</details>

### Challenge 4: Temperature Converter
Write a function that converts Celsius to Fahrenheit with a default rounding option.

<details>
<summary>👨‍🍳 Click for solution</summary>

```kotlin
fun celsiusToFahrenheit(celsius: Double, round: Boolean = true): String {
    val fahrenheit = celsius * 9.0 / 5.0 + 32
    return if (round) "${fahrenheit.toInt()}°F" else "${fahrenheit}°F"
}

// Usage:
println(celsiusToFahrenheit(25.0))           // 77°F
println(celsiusToFahrenheit(25.0, false))   // 77.0°F
```
</details>

---

## Quick Reference Card

```kotlin
// 1. No parameters, no return
fun greet() { println("Hello") }

// 2. With parameters
fun cook(dish: String) { println("Cooking $dish") }

// 3. With return value
fun add(a: Int, b: Int): Int = a + b

// 4. Default parameters
fun order(dish: String = "Pizza", qty: Int = 1) { }

// 5. Named arguments
fun bake(flour: Int, sugar: Int) { }
bake(sugar = 200, flour = 500)

// 6. Single-expression
fun double(x: Int) = x * 2

// Calling functions
greet()
cook("Pasta")
val result = add(5, 3)
order()  // Uses defaults
order("Burger", 2)
```

---

## Summary

| You want to... | Use this |
|----------------|----------|
| Group reusable code | ✅ Function |
| Provide default values | ✅ Default parameters |
| Call in any order | ✅ Named arguments |
| One-line calculation | ✅ Single-expression |
| Return a value | ✅ Return type |
| Do something without returning | ✅ Unit (or no return type) |

---

## Related Recipes

- 📖 [`HelloWorld.kt`](../../GettingStarted/HelloWorld.kt) - First program
- 📖 [`CommonVariables.kt`](../../Variables/CommonVariables.kt) - Variable types
- 📖 [`IfChef.kt`](../../IfChef/IfChef.kt) - Making decisions
- 📖 [`LambdaFunction/`](../LambdaFunction/) - Advanced lambda functions

---

> *"A great chef has a collection of trusted recipes. A great programmer has a collection of well-written functions!"* 👨‍🍳

**Ready to cook? Run `BasicFunction.kt` and start creating your own functions!** 🚀
