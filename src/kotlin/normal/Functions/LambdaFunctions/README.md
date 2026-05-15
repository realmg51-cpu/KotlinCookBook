
# ⚡ Lambda Functions

> *"A lambda is like a quick note - a small recipe you write on the spot!"*

## What is a Lambda?

A **lambda** is an anonymous function that you can pass around like a value.

```kotlin
// Regular function
fun double(x: Int): Int = x * 2

// Lambda (same thing, no name)
val double = { x: Int -> x * 2 }
```

## Lambda Syntax

```kotlin
{ parameter -> body }
```

### Examples

| Lambda | Meaning |
|--------|---------|
| `{ println("Hi") }` | No parameters |
| `{ x: Int -> x * 2 }` | One parameter, returns value |
| `{ a, b -> a + b }` | Two parameters |

## Using 'it' - Single Parameter Shortcut

When lambda has ONE parameter, you can use `it`:

```kotlin
val square = { it: Int -> it * it }
// Same as: val square = { x -> x * x }

val isEven = { it % 2 == 0 }
```

## Higher-Order Functions

Functions that **take another function as parameter**:

```kotlin
// repeat() is a higher-order function
repeat(3) {
    println("Hello!")  // Runs 3 times
}
```

## Common Lambda Operations

| Function | What it does | Example |
|----------|--------------|---------|
| `forEach` | Do something with each | `list.forEach { print(it) }` |
| `map` | Transform each item | `list.map { it * 2 }` |
| `filter` | Keep matching items | `list.filter { it > 5 }` |
| `reduce` | Combine all items | `list.reduce { a,b -> a+b }` |

## Kitchen Analogy

| Programming | Kitchen |
|-------------|---------|
| Regular function | Full recipe card |
| Lambda | Quick sticky note |
| Higher-order function | "For each ingredient, do this..." |
| `map` | "Take each potato and chop it" |

## Practice

```kotlin
// Filter numbers greater than 5
val numbers = listOf(1, 3, 5, 7, 9)
val big = numbers.filter { it > 5 }  // [7, 9]

// Double each number
val doubled = numbers.map { it * 2 }  // [2, 6, 10, 14, 18]

// Sum all numbers
val sum = numbers.reduce { acc, n -> acc + n }  // 25
```

## Related

- `BasicFunction.kt` - Regular functions
- `ForStirring.kt` - Loops
```

---

