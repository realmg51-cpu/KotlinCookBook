
# 🔧 Recipe: Scope Functions (`let`, `run`, `with`, `apply`, `also`)

> *"Kitchen tools that let you work with ingredients without taking them out of the bowl!"*

---

## 📋 Table of Contents

1. [What You'll Learn](#-what-youll-learn)
2. [The Kitchen Analogy](#-the-kitchen-analogy)
3. [What are Scope Functions?](#-what-are-scope-functions)
4. [Quick Reference Table](#-quick-reference-table)
5. [`let` - The Safe Handler](#-let---the-safe-handler)
6. [`run` - The Configurator & Calculator](#-run---the-configurator--calculator)
7. [`with` - The Batch Operator](#-with---the-batch-operator)
8. [`apply` - The Builder](#-apply---the-builder)
9. [`also` - The Side-Effect Doer](#-also---the-side-effect-doer)
10. [Comparison Examples](#-comparison-examples)
11. [When to Use Which?](#-when-to-use-which)
12. [Try It Yourself](#-try-it-yourself)
13. [Quick Reference](#-quick-reference)

---

## 🎯 What You'll Learn

- ✅ What are **scope functions** and why they exist
- ✅ The 5 scope functions: `let`, `run`, `with`, `apply`, `also`
- ✅ Difference between `it` and `this`
- ✅ Difference between returning **context object** vs **lambda result**
- ✅ When to use each function
- ✅ Common patterns and best practices

---

## 🍽️ The Kitchen Analogy

Imagine you're cooking a **complex dish** that requires many steps with the same ingredient:

### Without scope functions (traditional way):

```kotlin
val egg = Egg()
egg.crack()
egg.beat()
egg.addSalt()
egg.addPepper()
egg.pourIntoPan()
```

You keep repeating `egg.` over and over. Annoying, right?

### With scope functions (like `apply`):

```kotlin
val egg = Egg().apply {
    crack()
    beat()
    addSalt()
    addPepper()
    pourIntoPan()
}
```

It's like putting the egg in a **mixing bowl** – you work with it directly, then take it out when done!

**The 5 tools in your kitchen:**

| Tool | Analogy | Use Case |
|------|---------|----------|
| `let` | Taste tester – checks if ingredient is good | Null safety, transformations |
| `run` | All-in-one station – configure AND cook | Calculate + configure |
| `with` | Batch processor – do many things with one item | Multiple operations on same object |
| `apply` | Ingredient prep station – set everything up | Object configuration (builder) |
| `also` | Quality check – log, inspect, verify | Side effects (logging, debugging) |

---

## 🔍 What are Scope Functions?

Scope functions create a **temporary scope** where you can work with an object without repeating its name.

**The 5 functions have 2 key differences:**

1. **How you refer to the object:** `it` vs `this`
2. **What they return:** The object itself vs the lambda result

### Reference Type: `it` vs `this`

| Uses `it` (parameter) | Uses `this` (receiver) |
|----------------------|------------------------|
| `let` | `run` |
| `also` | `with` |
| | `apply` |

- `it` = explicit parameter (can rename)
- `this` = implicit, can be omitted

### Return Type: Context Object vs Lambda Result

| Returns context object | Returns lambda result |
|------------------------|----------------------|
| `apply` | `let` |
| `also` | `run` |
| | `with` |

---

## 📊 Quick Reference Table

| Function | Object reference | Return value | Use case |
|----------|-----------------|--------------|----------|
| `let` | `it` | Lambda result | Null safety, transformations |
| `run` | `this` | Lambda result | Configure + compute result |
| `with` | `this` | Lambda result | Multiple calls on same object |
| `apply` | `this` | Context object | Object configuration (builder) |
| `also` | `it` | Context object | Side effects (logging, debug) |

---

## 🔧 `let` - The Safe Handler

**Reference:** `it` | **Returns:** Lambda result

```kotlin
// Basic syntax
val result = object.let {
    // Use 'it' to access the object
    it.someMethod()
    // Last expression is returned
}

// With null safety
nullableObject?.let {
    // Only executes if not null
    println(it)
}
```

### Common Use Cases:

**1. Null safety (most common!)**
```kotlin
val name: String? = "Kotlin"

// Without let (verbose)
if (name != null) {
    println("Length: ${name.length}")
}

// With let (clean)
name?.let {
    println("Length: ${it.length}")
}
```

**2. Transform value**
```kotlin
val number = "42"
val doubled = number.let { it.toInt() * 2 }
println(doubled)  // 84
```

**3. Chain operations**
```kotlin
val result = listOf(1, 2, 3)
    .first()
    .let { it * 2 }
    .let { it + 10 }
println(result)  // (1 * 2) + 10 = 12
```

**4. Rename `it` for clarity**
```kotlin
val user = getUser()
user?.let { u ->
    println(u.name)
    println(u.email)
}
```

---

## 🔧 `run` - The Configurator & Calculator

**Reference:** `this` | **Returns:** Lambda result

```kotlin
// Basic syntax
val result = object.run {
    // 'this' is the object (can be omitted)
    method1()
    method2()
    lastExpression  // Returned
}
```

### Common Use Cases:

**1. Configure and compute**
```kotlin
val fullName = Person().run {
    firstName = "John"
    lastName = "Doe"
    "$firstName $lastName"  // Return this string
}
println(fullName)  // "John Doe"
```

**2. Compute value from object**
```kotlin
val length = "Kotlin".run {
    this.length + 10
}
println(length)  // 6 + 10 = 16
```

**3. Run block on nullable (with safe call)**
```kotlin
val message = name?.run {
    "Hello, $this!"
} ?: "Unknown user"
```

**4. As an expression (without object)**
```kotlin
val hexNumber = run {
    val digits = listOf(1, 2, 3)
    digits.joinToString("") { it.toString(16) }
}
```

---

## 🔧 `with` - The Batch Operator

**Reference:** `this` | **Returns:** Lambda result

```kotlin
// Syntax (different! object is parameter)
val result = with(object) {
    // 'this' is the object
    method1()
    method2()
    lastExpression  // Returned
}
```

### Common Use Cases:

**1. Multiple operations on same object**
```kotlin
val person = Person()
with(person) {
    firstName = "Alice"
    lastName = "Smith"
    age = 30
}
```

**2. Grouping related calls**
```kotlin
with(person) {
    println(name)
    println(age)
    println(email)
}
```

**3. Computing derived values**
```kotlin
val summary = with(user) {
    "$name ($age) - $email"
}
```

**Note:** `with` is the only scope function that is **not called on an object** – it's a regular function that takes the object as parameter.

---

## 🔧 `apply` - The Builder

**Reference:** `this` | **Returns:** Context object (the original!)

```kotlin
val result = object.apply {
    // 'this' is the object
    property1 = value1
    property2 = value2
    // Returns the original object!
}
```

### Common Use Cases:

**1. Object configuration (Builder pattern)**
```kotlin
val person = Person().apply {
    firstName = "Bob"
    lastName = "Johnson"
    age = 25
}
// person is fully configured
```

**2. Initialize complex objects**
```kotlin
val textView = TextView(context).apply {
    text = "Hello"
    textSize = 16f
    setTextColor(Color.BLUE)
}
```

**3. Fluent configuration**
```kotlin
val intent = Intent().apply {
    action = Intent.ACTION_VIEW
    data = Uri.parse("https://kotlinlang.org")
    flags = Intent.FLAG_ACTIVITY_NEW_TASK
}
startActivity(intent)
```

**4. Chain with other operations**
```kotlin
val numbers = mutableListOf<Int>().apply {
    add(1)
    add(2)
    add(3)
}.filter { it > 1 }
println(numbers)  // [2, 3]
```

---

## 🔧 `also` - The Side-Effect Doer

**Reference:** `it` | **Returns:** Context object (the original!)

```kotlin
val result = object.also {
    // Use 'it' to access object
    println(it)
    log(it)
    // Returns original object!
}
```

### Common Use Cases:

**1. Logging and debugging**
```kotlin
val user = getUser().also {
    println("Fetched user: $it")
    log("User ID: ${it.id}")
}
// user is still the original object
```

**2. Validating or inspecting**
```kotlin
val numbers = listOf(1, 2, 3).also {
    require(it.isNotEmpty()) { "List is empty!" }
}
```

**3. Side effects without breaking chain**
```kotlin
val result = listOf(1, 2, 3)
    .map { it * 2 }
    .also { println("After map: $it") }
    .filter { it > 3 }
    .also { println("After filter: $it") }
    .sum()
```

**4. Chaining with `apply`**
```kotlin
val person = Person().apply {
    name = "John"
    age = 30
}.also {
    println("Created person: ${it.name}")
}
```

---

## 📊 Comparison Examples

### Same operation, all 5 functions:

```kotlin
data class Person(var name: String = "", var age: Int = 0)

val person = Person()

// LET - using 'it', returns last line
val letResult = person.let {
    it.name = "Alice"
    it.age = 25
    "Done"  // ← returned
}
println(letResult)  // "Done"
println(person)     // Person(name=Alice, age=25)

// RUN - using 'this', returns last line
val runResult = person.run {
    name = "Bob"
    age = 30
    "Modified"  // ← returned
}
println(runResult)  // "Modified"

// WITH - using 'this', returns last line
val withResult = with(person) {
    name = "Charlie"
    age = 35
    "Updated"  // ← returned
}
println(withResult)  // "Updated"

// APPLY - using 'this', returns original object
val applyResult = person.apply {
    name = "David"
    age = 40
    "Ignored!"  // ← NOT returned
}
println(applyResult)  // Person(name=David, age=40) ← original
println(person)       // Person(name=David, age=40)

// ALSO - using 'it', returns original object
val alsoResult = person.also {
    it.name = "Eve"
    it.age = 45
    "Ignored!"  // ← NOT returned
}
println(alsoResult)  // Person(name=Eve, age=45) ← original
```

---

## 🤔 When to Use Which?

### Decision Flowchart:

```
Do you need to handle null safely?
    YES → use 'let' with ?.
    NO ↓

Do you need to return the object itself?
    YES → are there side effects (logging)?
        YES → use 'also'
        NO → use 'apply'
    NO ↓

Do you need to compute/return something?
    YES → is object available as parameter?
        YES → use 'with'
        NO → use 'run'
```

### Cheat Sheet by Use Case:

| Use Case | Best Choice |
|----------|-------------|
| Null safety + execute code | `let` |
| Transform value | `let` |
| Configure object (builder) | `apply` |
| Logging + chain operations | `also` |
| Validate/inspect | `also` |
| Group calls on same object | `with` |
| Configure + compute result | `run` |
| Execute code block (no object) | `run` |

---

## 🧪 Try It Yourself

### Exercise 1: Null Safety with `let`
```kotlin
val email: String? = "user@example.com"
// Print "Sending email to: user@example.com" only if not null
```

**Solution:**
```kotlin
email?.let {
    println("Sending email to: $it")
}
```

### Exercise 2: Object Configuration with `apply`
```kotlin
data class Car(var brand: String = "", var model: String = "", var year: Int = 0)
// Create a Car with brand="Tesla", model="Model 3", year=2024
```

**Solution:**
```kotlin
val car = Car().apply {
    brand = "Tesla"
    model = "Model 3"
    year = 2024
}
```

### Exercise 3: Chain with `also` for Debugging
```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
// Double the numbers, then filter >5, logging each step
```

**Solution:**
```kotlin
val result = numbers
    .map { it * 2 }
    .also { println("After map: $it") }
    .filter { it > 5 }
    .also { println("After filter: $it") }
```

### Exercise 4: Mix and Match
```kotlin
// Start with null, create person only if not null
// Set name and age, then log creation
```

**Solution:**
```kotlin
val person: Person? = null

val result = person?.run {
    // Only if person not null
    apply {
        name = "John"
        age = 30
    }.also {
        println("Person created: $it")
    }
} ?: Person().apply {
    name = "Default"
    age = 0
}
```

---

## 📝 Quick Reference Card

```kotlin
// LET - null safety, transform
object?.let { it.do() }

// RUN - configure + compute result
object.run { compute() }

// WITH - batch operations
with(object) { doManyThings() }

// APPLY - configure, return object (builder)
object.apply { config() }

// ALSO - side effects, return original
object.also { log(it) }
```

### Memory Tricks:

| Function | Memory Trick |
|----------|--------------|
| `let` | L = "Lets you handle null" |
| `run` | R = "Run and Return" |
| `with` | W = "Work With this object" |
| `apply` | A = "Apply configuration to this" |
| `also` | A = "Also do something extra" |

### Key Rules:

1. **Need null safety?** → `let`
2. **Need the object back?** → `apply` or `also`
3. **Need to compute something?** → `let`, `run`, or `with`
4. **`it` vs `this`:** `it` = parameter (can rename), `this` = receiver (can omit)
5. **Don't overuse!** Scope functions improve readability, but nesting them hurts it.

---

## 🎉 Congratulations!

You've mastered the **Scope Functions** recipe! 🧑‍🍳

**Remember:**
> *"Scope functions are like kitchen tools – use the right one for the right job, and don't use all of them at once!"*

---

**Happy scoping!** 🔧🚀
