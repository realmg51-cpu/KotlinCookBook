
# 🍜 String Splitter: Chopping Ingredients Like a Chef

In the kitchen, you often need to **chop, slice, or separate** ingredients.  
In Kotlin, you do the same with **strings** (pieces of text).

Welcome to the **StringCooker** – where we learn to chop strings like a pro!

---

## 🔪 What is String Splitting?

**String splitting** means cutting a string into smaller parts based on a **delimiter** (a marker that tells you where to cut).

Think of it like cutting a cucumber:
- The whole cucumber = your string
- The knife = the delimiter
- The cucumber slices = the result

```kotlin
val wholeString = "realmg.kt"
val knife = "."
// After cutting → ["realmg", "kt"]
```

---

## 📦 The Basic Tools (Your Kitchen Knives)

Kotlin gives you several "knives" to chop strings:

### 1. `substringBefore(delimiter)`
**Takes everything BEFORE the first delimiter.**

```kotlin
val filename = "realmg.kt"
val name = filename.substringBefore(".")
// Result: "realmg"
```

🍳 *Like cutting off the stem of a tomato – keep the front part.*

### 2. `substringAfter(delimiter)`
**Takes everything AFTER the first delimiter.**

```kotlin
val filename = "realmg.kt"
val extension = filename.substringAfter(".")
// Result: "kt"
```

🍳 *Like removing the skin of an onion – keep what's inside.*

---

## 🔪 Advanced Knives (For Complex Dishes)

### 3. `substringBeforeLast(delimiter)`
**Takes everything BEFORE the LAST delimiter.**

```kotlin
val complex = "backup.2024.04.15.tar.gz"
val name = complex.substringBeforeLast(".")
// Result: "backup.2024.04.15.tar"
```

🍳 *Like cutting a sausage into links – keep everything except the last piece.*

### 4. `substringAfterLast(delimiter)`
**Takes everything AFTER the LAST delimiter.**

```kotlin
val complex = "backup.2024.04.15.tar.gz"
val extension = complex.substringAfterLast(".")
// Result: "gz"
```

🍳 *Like peeling a banana – take only the last part (the fruit inside).*

---

## 📊 Quick Reference (Your Knife Set)

| Function | What it does | Example (using `"a.b.c"`) | Result |
|----------|-------------|---------------------------|--------|
| `substringBefore(".")` | Before **first** dot | `"a.b.c".substringBefore(".")` | `"a"` |
| `substringAfter(".")` | After **first** dot | `"a.b.c".substringAfter(".")` | `"b.c"` |
| `substringBeforeLast(".")` | Before **last** dot | `"a.b.c".substringBeforeLast(".")` | `"a.b"` |
| `substringAfterLast(".")` | After **last** dot | `"a.b.c".substringAfterLast(".")` | `"c"` |

---

## 🧪 Real Recipe: Extracting File Name and Extension

```kotlin
fun main() {
    val filename = "my_awesome_project.tar.gz"
    
    val name = filename.substringBeforeLast(".")
    val extension = filename.substringAfterLast(".")
    
    println("📄 File: $filename")
    println("   Name: $name")
    println("   Extension: $extension")
}
```

**Output:**
```
📄 File: my_awesome_project.tar.gz
   Name: my_awesome_project.tar
   Extension: gz
```

---

## ⚠️ What If the Delimiter Isn't There?

If the delimiter doesn't exist in the string, `substringAfter` returns an **empty string** `""`:

```kotlin
val name = "realmg"
val result = name.substringAfter(".")  // Result: "" (empty)
```

You can also provide a **default value** to use instead:

```kotlin
val name = "realmg"
val result = name.substringAfter(".", missingDelimiterValue = "no extension")
// Result: "no extension"
```

---

## 🍳 Try It Yourself

```kotlin
fun main() {
    val recipes = listOf(
        "pasta.carbonara",
        "soup.tomato",
        "cake.chocolate",
        "backup.2024.04.15.tar.gz"
    )
    
    for (recipe in recipes) {
        val name = recipe.substringBefore(".")
        val ext = recipe.substringAfter(".")
        println("🍽️ $recipe → dish: $name, type: $ext")
    }
}
```

---

## 📝 Summary

| You want to... | Use this |
|----------------|----------|
| Get the part **before** the first dot | `substringBefore(".")` |
| Get the part **after** the first dot | `substringAfter(".")` |
| Get the part **before** the last dot | `substringBeforeLast(".")` |
| Get the part **after** the last dot | `substringAfterLast(".")` |

> 🍳 *Remember: A good chef knows which knife to use. A good Kotlin developer knows which string splitter to use!*

[Next recipe: IfChef](https://github.com/realmg51-cpu/KotlinCookBook/blob/main/src/kotlin/normal/IfChef/introduction.md)

Happy chopping! 🔪
