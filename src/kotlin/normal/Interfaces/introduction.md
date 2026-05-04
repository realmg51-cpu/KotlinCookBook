
# 📋 Interfaces: Job Descriptions for Your Code

## 🍳 What Are Interfaces?

An **interface** is a **contract** that defines **WHAT** a class must do, but **NOT HOW** it does it.

Think of it as a **job description** in a kitchen:
- "Must be able to cook" → `cook()` method
- "Must be able to clean" → `clean()` method
- "Must be able to bake" → `bake()` method

The interface doesn't care HOW you do it, just THAT you can do it!

---

## 🔥 Quick Example

```kotlin
// Define the contract
interface Cookable {
    fun cook()  // No body - must be implemented
}

// Sign the contract
class Chef : Cookable {
    override fun cook() {
        println("👨‍🍳 Cooking delicious food!")
    }
}

// Use it
val chef = Chef()
chef.cook()  // 👨‍🍳 Cooking delicious food!
```

---

## 📚 Key Features

### 1. Default Implementations
Interfaces can provide **default** method bodies:

```kotlin
interface Cleanable {
    fun clean() {
        println("🧹 Default cleaning")  // Has body
    }
}

class Assistant : Cleanable  // No need to override!
```

### 2. Properties
Interfaces can declare properties:

```kotlin
interface Nameable {
    val name: String           // Must override
    val description: String    // Can have default getter
        get() = "Item: $name"
}

class Tool(override val name: String) : Nameable

val knife = Tool("Chef's Knife")
println(knife.description)  // "Item: Chef's Knife"
```

### 3. Multiple Inheritance
A class can implement **many** interfaces:

```kotlin
interface Cookable { fun cook() }
interface Bakeable { fun bake() }
interface Cleanable { fun clean() }

class SuperChef : Cookable, Bakeable, Cleanable {
    override fun cook() = println("Cooking")
    override fun bake() = println("Baking")
    override fun clean() = println("Cleaning")
}
```

---

## 🎯 Real-World Examples

### Example 1: Payment Methods
```kotlin
interface Payable {
    fun pay(amount: Double)
    fun getMethod(): String
}

class CreditCard(val number: String) : Payable {
    override fun pay(amount: Double) = println("Paid $$amount with card $number")
    override fun getMethod(): String = "Credit Card"
}

class PayPal(val email: String) : Payable {
    override fun pay(amount: Double) = println("Paid $$amount with PayPal ($email)")
    override fun getMethod(): String = "PayPal"
}

// Usage
fun checkout(payment: Payable, amount: Double) {
    println("Using ${payment.getMethod()}")
    payment.pay(amount)
}
```

### Example 2: Kitchen Appliances
```kotlin
interface Heatable {
    fun setTemperature(temp: Int)
    fun getTemperature(): Int
}

interface Timable {
    fun setTimer(minutes: Int)
    fun getRemainingTime(): Int
}

class SmartOven : Heatable, Timable {
    private var temp = 0
    private var time = 0
    
    override fun setTemperature(temp: Int) { this.temp = temp }
    override fun getTemperature(): Int = temp
    override fun setTimer(minutes: Int) { this.time = minutes }
    override fun getRemainingTime(): Int = time
}
```

### Example 3: Data Storage
```kotlin
interface Repository<T> {
    fun save(item: T)
    fun findById(id: Int): T?
    fun delete(id: Int)
    fun getAll(): List<T>
}

class UserRepository : Repository<User> {
    private val users = mutableMapOf<Int, User>()
    
    override fun save(user: User) { users[user.id] = user }
    override fun findById(id: Int) = users[id]
    override fun delete(id: Int) { users.remove(id) }
    override fun getAll(): List<User> = users.values.toList()
}
```

---

## 🆚 Interface vs Abstract Class

| Feature | Interface | Abstract Class |
|---------|-----------|----------------|
| **Multiple inheritance** | ✅ Yes (many) | ❌ No (one) |
| **Store state** | ❌ No (no backing fields) | ✅ Yes |
| **Constructor** | ❌ No | ✅ Yes |
| **Default methods** | ✅ Yes | ✅ Yes |
| **When to use** | "Can do" (capability) | "Is a" (identity) |

### When to use Interface:
- Different types of objects share **behavior** (Flyable, Swimable)
- You need **multiple capabilities** (Cookable + Cleanable)
- Defining a **contract** for multiple implementations

### When to use Abstract Class:
- Objects share **common state** (has name, age, id)
- You need a **base implementation** with shared code
- Classes are **closely related** (Animal → Dog, Cat)

---

## 💡 Interface Inheritance

Interfaces can inherit from other interfaces:

```kotlin
interface Appliance {
    fun turnOn()
    fun turnOff()
}

interface SmartAppliance : Appliance {
    fun connectToWifi()
    fun getStatus(): String
}

class SmartFridge : SmartAppliance {
    override fun turnOn() = println("Fridge on")
    override fun turnOff() = println("Fridge off")
    override fun connectToWifi() = println("Connected to WiFi")
    override fun getStatus() = "Fridge is cooling"
}
```

---

## ⚔️ Resolving Method Conflicts

When implementing multiple interfaces with the same method:

```kotlin
interface ChefA {
    fun cook() = println("ChefA: Using spices")
}

interface ChefB {
    fun cook() = println("ChefB: Using herbs")
}

class MasterChef : ChefA, ChefB {
    // MUST resolve the conflict
    override fun cook() {
        super<ChefA>.cook()  // Call ChefA's version
        super<ChefB>.cook()  // Call ChefB's version
        println("MasterChef: Combining both!")
    }
}
```

---

## ✅ Best Practices

### DO:
```kotlin
// ✅ Keep interfaces small and focused
interface Flyable { fun fly() }
interface Swimmable { fun swim() }

// ✅ Use meaningful names (ending with -able, -ible)
interface Clickable
interface Draggable
interface Serializable

// ✅ Provide default implementations when useful
interface Loggable {
    fun log(message: String) = println("[LOG] $message")
}
```

### DON'T:
```kotlin
// ❌ Don't create god interfaces
interface GodInterface {
    fun cook(), clean(), bake(), fry(), boil(), ...  // Too many!
}

// ❌ Don't put state in interfaces
interface BadExample {
    var count: Int  // Avoid - interfaces shouldn't have mutable state
}
```

---

## 🎓 Exercises

### Beginner
1. Create interface `Playable` with `play()`, `pause()`, `stop()`
2. Create class `MusicPlayer` that implements it

### Intermediate
3. Create `Scalable` with `scale(factor: Double)` and `Resizable` with `resize(width: Int, height: Int)`
4. Create class `Image` that implements both

### Advanced
5. Create interface `Thermometer` with property `temperature: Double` and default method `getReading()`
6. Create `CelsiusThermometer` and `FahrenheitThermometer` implementations

---

## 📊 Quick Reference Card

```kotlin
// Declaration
interface Name {
    fun method()                    // Abstract
    fun default() = println("OK")   // Default
    val prop: String                // Property
}

// Implementation
class MyClass : Interface1, Interface2 {
    override fun method() { ... }
    override val prop = "value"
}

// Usage
fun example(obj: MyInterface) {
    obj.method()
    println(obj.prop)
}
```

---

## 🎉 Summary

**Interface = Contract that defines WHAT, not HOW**

### Remember:
- ✅ Use for **capabilities** (Flyable, Swimmable, Cookable)
- ✅ Class can implement **multiple** interfaces
- ✅ Can have **default** method bodies
- ✅ Can declare **properties** (no backing fields)
- ❌ Cannot have **constructors**
- ❌ Cannot store **state** (mutable fields)

### Real-world uses:
- Android: `Clickable`, `Focusable`, `Checkable`
- Java/Kotlin: `Comparable`, `Serializable`, `Runnable`
- Your code: `Payable`, `Loggable`, `Exportable`

**Interfaces say WHAT. Classes say HOW!** 🎯

---

*Part of the KotlinCookBook - Learn Kotlin the fun way, one recipe at a time!*
