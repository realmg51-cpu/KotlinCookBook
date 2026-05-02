
# 👨‍🍳 Classes: Recipe Templates for Your Code

## 📖 What Are Classes?

A **class** is a blueprint or template for creating objects. Think of it as a **recipe**:

- **Class** = Recipe template (describes how to make a dish)
- **Object** = Actual dish (made from the template)

One recipe can make many dishes, just like one class can create many objects!

---

## 🍳 Kitchen Analogy

| Concept | Programming | Kitchen |
|---------|------------|---------|
| Class | Blueprint | Recipe card |
| Object | Instance | Actual cooked dish |
| Property | Variable | Ingredient amount |
| Method | Function | Cooking instruction |

---

## 🔥 Basic Class Syntax

```kotlin
class Chef {
    var name: String = ""        // Property
    fun cook() {                 // Method
        println("$name is cooking!")
    }
}

// Create object
val chef = Chef()
chef.name = "Gordon"
chef.cook()
```

---

## 📚 Types of Classes

### 1. Primary Constructor
```kotlin
class Dish(val name: String, val price: Double)

val pizza = Dish("Pizza", 15.99)
println(pizza.name)  // Pizza
```

### 2. With init Block
```kotlin
class RecipeBook(val title: String) {
    init {
        println("Creating: $title")  // Runs when object created
    }
}
```

### 3. Secondary Constructor
```kotlin
class Kitchen(val name: String) {
    constructor(name: String, size: String) : this(name) {
        println("$name kitchen, size: $size")
    }
}
```

### 4. Data Class (Auto methods)
```kotlin
data class Ingredient(val name: String, val amount: Double)

val egg = Ingredient("Egg", 2.0)
println(egg)                    // toString()
val egg2 = egg.copy()           // copy()
val (name, qty) = egg           // destructuring
```

### 5. Inner Class (Nested)
```kotlin
class Restaurant(val name: String) {
    inner class Table(val number: Int) {
        fun reserve() = println("Table $number reserved at $name")
    }
}
```

---

## 🎯 Practical Example

```kotlin
class Order(val id: Int) {
    private val items = mutableListOf<String>()
    
    fun add(item: String) = items.add(item)
    fun total() = items.size
    fun display() = println("Order #$id: ${items.joinToString()}")
}

val order = Order(1001)
order.add("Pizza")
order.add("Salad")
order.display()  // Order #1001: Pizza, Salad
```

---

## 💡 Best Practices

### ✅ DO:
- Use `data class` for simple data holders
- Use `private` for internal state
- Use `init` for validation
- Keep classes focused (single responsibility)

### ❌ DON'T:
- Put too much logic in `init`
- Expose mutable collections directly
- Create giant classes (God objects)

---

## 🎓 Exercises

1. **Basic**: Create `Recipe` class with name, time, ingredients
2. **Data Class**: Create `MenuItem` with name, price, calories
3. **Intermediate**: Build `Pantry` with ingredient inventory management
4. **Advanced**: Create `Cookbook` with searchable recipes

---

**Classes = Templates for your objects!** 🎉
