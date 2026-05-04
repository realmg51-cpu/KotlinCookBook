
# 📦 Sealed Classes: The Fixed Menu Restaurant

## 📖 What Are Sealed Classes?

A **sealed class** is a way to create **restricted class hierarchies** - meaning you define all possible subclasses upfront. Think of it as a **fixed menu** at a restaurant: you know exactly what dishes can be ordered, no surprises!

**Key idea:** A sealed class defines a **closed set of types** where all subclasses are known at compile time.

---

## 🍳 Kitchen Analogy

| Concept | Programming | Kitchen |
|---------|------------|---------|
| Sealed Class | A limited set of options | Restaurant menu |
| Subclass | One specific type | A specific dish |
| `when` expression | Waiter asking "What would you like?" | Order taking |
| Exhaustive checking | Waiter knows ALL menu items | No custom orders |

### Why "Sealed"?

In a kitchen:
- ✅ You know ALL dishes on the menu (Pizza, Pasta, Salad, Soup)
- ✅ Each dish has DIFFERENT preparation details
- ❌ Customers can't invent new dishes
- ❌ No secret off-menu items

This makes the kitchen **organized and predictable**!

---

## 🔥 Sealed Class vs Enum

Both represent a limited set of types, but they serve different purposes:

### Enum Class (Simple values)
```kotlin
enum class DishType {
    PIZZA, PASTA, SALAD, SOUP
}
```
- ✅ Good for: Simple constants, no extra data
- ❌ Cannot: Attach different properties to each type
- 📦 Memory: Each enum is a singleton

### Sealed Class (Complex types)
```kotlin
sealed class Dish {
    data class Pizza(val size: String, val toppings: List<String>) : Dish()
    data class Pasta(val sauce: String, val hasCheese: Boolean) : Dish()
    data class Salad(val dressing: String, val isVegan: Boolean) : Dish()
    object SoupOfTheDay : Dish()
}
```
- ✅ Good for: Multiple types with DIFFERENT data
- ✅ Each subtype can have unique properties
- 📦 Memory: Subclasses can be objects, data classes, or regular classes

### Comparison Table

| Feature | Enum | Sealed Class |
|---------|------|-------------|
| Different data per type | ❌ No | ✅ Yes |
| Singleton instances | ✅ Yes (each enum) | ✅ Via `object` |
| Multiple instances | ❌ No | ✅ Via `class` |
| When exhaustive checking | ✅ Yes | ✅ Yes |
| Use when | Simple constants | Complex hierarchies |

---

## 📚 Basic Syntax

### 1. Defining a Sealed Class
```kotlin
sealed class MySealedClass {
    class Subclass1 : MySealedClass()
    class Subclass2(val data: String) : MySealedClass()
    object Subclass3 : MySealedClass()
}
```

### 2. Three Ways to Create Subclasses

```kotlin
sealed class Status

// 1. Object - no extra data, singleton
object Loading : Status()

// 2. Data class - immutable, with data
data class Success(val message: String) : Status()

// 3. Regular class - mutable if needed
class Error(val code: Int, val msg: String) : Status()
```

### 3. Using with `when` (The Magic!)
```kotlin
fun handle(status: Status) = when (status) {
    is Loading -> "Loading..."
    is Success -> "Success: ${status.message}"
    is Error -> "Error ${status.code}: ${status.msg}"
}
// No 'else' needed! Compiler knows all cases covered
```

---

## 🎯 Real-World Examples

### Example 1: UI State (Android / Compose)
```kotlin
sealed class UiState {
    object Loading : UiState()
    data class Success(val users: List<User>) : UiState()
    data class Error(val message: String) : UiState()
}

// In your ViewModel
fun loadUsers() {
    _uiState.value = UiState.Loading
    try {
        val users = api.getUsers()
        _uiState.value = UiState.Success(users)
    } catch (e: Exception) {
        _uiState.value = UiState.Error(e.message ?: "Unknown error")
    }
}

// In your Composable
when (uiState) {
    is UiState.Loading -> ShowProgressBar()
    is UiState.Success -> UserList(uiState.users)
    is UiState.Error -> ErrorMessage(uiState.message)
}
```

### Example 2: Network Result
```kotlin
sealed class NetworkResult<T> {
    class Loading<T> : NetworkResult<T>()
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error<T>(val code: Int, val message: String) : NetworkResult<T>()
}

// Using it
fun fetchData(): NetworkResult<String> {
    return try {
        val result = api.call()
        NetworkResult.Success(result)
    } catch (e: HttpException) {
        NetworkResult.Error(e.code(), e.message())
    }
}
```

### Example 3: Payment Processing
```kotlin
sealed class PaymentResult {
    object Pending : PaymentResult()
    object Processing : PaymentResult()
    data class Success(val transactionId: String, val amount: Double) : PaymentResult()
    data class Failed(val reason: String, val retryable: Boolean) : PaymentResult()
}

fun processPayment(amount: Double): PaymentResult {
    return when {
        amount <= 0 -> PaymentResult.Failed("Invalid amount", false)
        amount > 1000 -> PaymentResult.Failed("Amount too high", true)
        else -> PaymentResult.Success("TXN${System.currentTimeMillis()}", amount)
    }
}
```

---

## 🧠 Smart Casts (No Manual Casting!)

When you check a sealed class type, Kotlin automatically casts it:

```kotlin
fun getDescription(dish: Dish): String {
    return when (dish) {
        is Dish.Pizza -> {
            // dish is automatically cast to Pizza type!
            "Pizza with ${dish.toppings} (${dish.size})"
        }
        is Dish.Pasta -> {
            // dish is automatically cast to Pasta type!
            "Pasta with ${dish.sauce} sauce"
        }
        is Dish.Salad -> {
            // dish is automatically cast to Salad type!
            "${dish.dressing} salad"
        }
        is Dish.SoupOfTheDay -> "Today's soup"
    }
}
```

**No need for**: `(dish as Pizza).toppings` - just use `dish.toppings` directly!

---

## 📦 Package and File Structure

Sealed classes can be:
1. **Top-level** in a file (most common)
2. **Inside another class** (nested)
3. **In the same file** as usage (convenient for small hierarchies)

```kotlin
// All subclasses can be in same file
sealed class OrderStatus

// Same file is OK for small hierarchies
class Pending : OrderStatus()
class Completed : OrderStatus()
class Cooking(val minutes: Int) : OrderStatus()
```

**Best practice:** Keep related sealed class subclasses in the same file unless the hierarchy grows too large.

---

## 🚀 Advanced Features

### 1. Sealed Interface (Kotlin 1.5+)
```kotlin
sealed interface Result
class Success(val data: String) : Result
class Error(val message: String) : Result
```

### 2. Generic Sealed Class
```kotlin
sealed class Either<L, R> {
    class Left<L, R>(val value: L) : Either<L, R>()
    class Right<L, R>(val value: R) : Either<L, R>()
}

fun divide(a: Int, b: Int): Either<String, Int> {
    return if (b == 0) {
        Either.Left("Cannot divide by zero")
    } else {
        Either.Right(a / b)
    }
}
```

### 3. Recursive Sealed Class (Tree structures)
```kotlin
sealed class TreeNode {
    class Leaf(val value: Int) : TreeNode()
    class Node(val left: TreeNode, val right: TreeNode) : TreeNode()
}

fun sum(node: TreeNode): Int = when (node) {
    is TreeNode.Leaf -> node.value
    is TreeNode.Node -> sum(node.left) + sum(node.right)
}
```

---

## 💡 Best Practices

### ✅ DO:
```kotlin
// 1. Use sealed class for state management
sealed class ViewState {
    object Loading : ViewState()
    data class Content(val data: List<Item>) : ViewState()
    data class Error(val message: String) : ViewState()
}

// 2. Keep subclasses in same file for small hierarchies
sealed class Action
class ClickAction(val id: Int) : Action()
class LongPressAction(val id: Int) : Action()

// 3. Use object for no-data variations
sealed class Filter
object NoFilter : Filter()
data class RangeFilter(val min: Int, val max: Int) : Filter()
```

### ❌ DON'T:
```kotlin
// 1. Don't use when enum would suffice
sealed class Color {  // Bad - use enum instead!
    object RED : Color()
    object GREEN : Color()
    object BLUE : Color()
}

// 2. Don't create massive hierarchies (>20 subclasses)
sealed class HugeClass {  // Bad - too many!
    class A1 : HugeClass()
    class A2 : HugeClass()
    // ... 50 more
}

// 3. Don't use when you need open/unknown hierarchy
sealed class Animal  // Bad if new animals can be added later
// Use interface or abstract class instead
```

---

## 🎯 When to Use Sealed Classes

### Perfect for:
- ✅ **UI States** (Loading, Success, Error)
- ✅ **API Results** (Success, Error, Loading)
- ✅ **Payment flows** (Pending, Processing, Success, Failed)
- ✅ **Navigation events** (Screen A, Screen B, Screen C)
- ✅ **User actions** (Click, LongPress, Swipe, Drag)
- ✅ **Limited business operations** (Create, Read, Update, Delete results)

### Consider alternatives for:
- ❌ Simple constants → Use **enum**
- ❌ Unknown future types → Use **interface**
- ❌ Large complex hierarchies → Use **abstract class**
- ❌ Need to add types from other modules → Use **interface**

---

## 📊 Quick Reference Card

```kotlin
// Syntax
sealed class Name {
    class Sub1 : Name()
    data class Sub2(val x: Int) : Name()
    object Sub3 : Name()
}

// Usage
when (instance) {
    is Sub1 -> // instance automatically cast
    is Sub2 -> // instance.x available
    is Sub3 -> // singleton instance
}
// No 'else' needed - all cases covered!

// Common pattern: Algebraic Data Types (ADT)
sealed class Option<out T> {
    object None : Option<Nothing>()
    data class Some<T>(val value: T) : Option<T>()
}
```

---

## 🎉 Summary

**Sealed classes = Fixed set of known types + Each type can have different data + Compiler safety**

### Three Main Benefits:
1. **Exhaustive when**: Compiler ensures you handle all cases
2. **Smart casting**: No explicit type casting needed
3. **Type safety**: Can't create unauthorized subclasses

### Memory:
- Each subclass can be **object** (singleton) or **class** (multiple instances)
- Kotlin generates a `.class` file for the sealed class and each subclass

### Related Concepts:
- **Enum** = Simple, no data variation
- **Sealed class** = Complex, data variation per type
- **Abstract class** = Open for extension
- **Interface** = Multiple inheritance

---

**Remember:** If you know ALL possible types at compile time and each type could have DIFFERENT data, reach for `sealed class`! 🎯

*Part of the KotlinCookBook - Learn Kotlin the fun way, one recipe at a time!*
