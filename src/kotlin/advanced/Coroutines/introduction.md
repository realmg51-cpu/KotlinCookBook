
# 🚀 Coroutines: Efficient Kitchen Management

## 🍳 What Are Coroutines?

**Coroutines** are **lightweight threads** that can be suspended and resumed.

Think of them as **efficient chefs** who never waste time waiting!

| Without Coroutines | With Coroutines |
|-------------------|-----------------|
| Chef starts boiling water and STANDS there watching 😴 | Chef starts boiling water, CHOPs vegetables while waiting 🏃‍♂️ |
| Wastes CPU time waiting | Uses time efficiently |
| Blocking operations | Non-blocking operations |

---

## 🔥 Quick Example

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delay(1000)
        println("Water is boiling!")
    }
    
    launch {
        delay(500)
        println("Chopping vegetables!")
    }
    
    println("Tasks launched!")
}

// Output:
// Tasks launched!
// Chopping vegetables!
// Water is boiling!
```

---

## 📚 Main Coroutine Builders

| Builder | Returns | Use Case |
|---------|---------|----------|
| `launch` | Job | Fire and forget (no return value) |
| `async` | Deferred<T> | Need a result back |
| `runBlocking` | T | Bridge between normal and coroutine code |

---

## 🎯 Key Functions

### `delay()` vs `Thread.sleep()`

| Feature | `delay()` | `Thread.sleep()` |
|---------|-----------|------------------|
| Blocking | ❌ No (suspends only coroutine) | ✅ Yes (blocks entire thread) |
| Resource | Efficient | Wastes CPU |
| Use in | Coroutines only | Anywhere |

```kotlin
// ❌ Bad: Blocking
Thread.sleep(1000)

// ✅ Good: Non-blocking
delay(1000)
```

---

## 🏃 Real Example: Restaurant Orders

```kotlin
suspend fun cook(dish: String, time: Long): String {
    delay(time)
    return "$dish ready!"
}

fun main() = runBlocking {
    val pizza = async { cook("🍕 Pizza", 2000) }
    val pasta = async { cook("🍝 Pasta", 1500) }
    val salad = async { cook("🥗 Salad", 1000) }
    
    println(pizza.await())
    println(pasta.await())
    println(salad.await())
}
// All cook CONCURRENTLY!
// Total time: ~2 seconds (not 4.5 seconds!)
```

---

## 💡 Best Practices

### ✅ DO:
- Use `launch` for background tasks
- Use `async` when you need return values
- Use `withTimeout` to auto-cancel slow tasks
- Call `.join()` or `.await()` to wait for completion

### ❌ DON'T:
- Use `Thread.sleep()` in coroutines (use `delay()`)
- Forget to handle cancellation
- Use `runBlocking` in production (testing only)

---

## 📊 Performance Comparison

| Task Count | Threads | Coroutines |
|------------|---------|------------|
| 1,000 | ✅ OK | ✅ OK |
| 10,000 | ⚠️ High memory | ✅ Still fine |
| 100,000 | ❌ Out of memory | ✅ Runs fine |
| Memory per task | ~1 MB | ~few KB |

---

## 🎯 Coroutine Dispatchers

| Dispatcher | Use For |
|------------|---------|
| `Dispatchers.Default` | CPU-intensive work (sorting, complex calculations) |
| `Dispatchers.IO` | Network, file operations, database |
| `Dispatchers.Main` | UI updates (Android) |
| `Dispatchers.Unconfined` | Not recommended (unpredictable) |

```kotlin
launch(Dispatchers.IO) {
    // Network call
    val data = fetchFromApi()
    
    withContext(Dispatchers.Main) {
        // Update UI
        showData(data)
    }
}
```

---

## 🔧 Cancellation

```kotlin
val job = launch {
    repeat(100) { i ->
        delay(100)
        println("Step $i")
    }
}

delay(500)
job.cancel()  // Stop the coroutine
println("Cancelled!")
```

---

## 🆚 Coroutine vs Thread

| Feature | Thread | Coroutine |
|---------|--------|-----------|
| Creation cost | Expensive | Cheap |
| Memory | ~1 MB | ~few KB |
| Blocking | Blocks thread | Non-blocking |
| Cancellation | Hard | Easy |
| Number possible | Limited (thousands) | Almost unlimited |

---

## 📝 Setup (build.gradle.kts)

```kotlin
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}
```

---

## 🎓 Exercises

### Beginner
```kotlin
// 1. Create two coroutines that run concurrently
//    One prints "Hello", another prints "World"
//    Use delay() to stagger them
```

### Intermediate
```kotlin
// 2. Use async to fetch 3 recipes simultaneously
//    Each recipe takes different time
//    Display when all are ready
```

### Advanced
```kotlin
// 3. Create a kitchen automation system
//    - 3 chefs working concurrently
//    - Each chef prepares 2 dishes
//    - Track total time vs sequential time
```

---

## 💡 Quick Reference

```kotlin
// Launch (fire and forget)
launch {
    delay(1000)
    println("Done")
}

// Async (get result)
val result = async {
    delay(1000)
    "Result"
}
println(result.await())

// Timeout
withTimeout(2000) {
    lengthyOperation()
}

// Different dispatcher
withContext(Dispatchers.IO) {
    // Network call
}
```

---

## 🎉 Summary

**Coroutines = Efficient, non-blocking, concurrent code!**

### When to use:
- ✅ Network calls
- ✅ Database operations
- ✅ File I/O
- ✅ Any task that waits

### Benefits:
- **Lightweight** (thousands of coroutines)
- **Non-blocking** (no wasted CPU)
- **Easy cancellation**
- **Sequential-looking code** (easier to read)

---

**Remember: Coroutines don't wait. They work while waiting!** 🚀

*Part of the KotlinCookBook - Learn Kotlin the fun way, one recipe at a time!*
