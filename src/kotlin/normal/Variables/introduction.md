
# 🧂 Variables: The Ingredients of Your Program

In Kotlin (and in any kitchen), you need **ingredients** to cook.  
In programming, those ingredients are called **variables**.

But not all ingredients are the same. Some you can change during cooking. Some you cannot.

---

## 📦 Common Variables (The Basics)

A **variable** is just a container that holds a value.

Think of it like a **bowl** in your kitchen. You can put things in it, give it a name, and use it later.

```kotlin
val username = "realmg"
```

Here, `username` is a bowl containing `"realmg"`.

---

## 🔒 Immutable Variables (`val`) – The Family Recipe

**Immutable** means **cannot be changed after cooking**.

In Kotlin, you use the keyword `val` (short for *value*).

```kotlin
val familySecret = "Grandma's Noodles"
```

Once you set it, it stays forever.  
👉 **You cannot recook it.**

```kotlin
familySecret = "My New Recipe"  // ❌ ERROR! Cannot change immutable variable
```

**When to use `val`?**  
- When the value should never change (birthday, name, secret recipe)
- By default – unless you have a good reason to make it mutable

> 🍳 *Immutable = like a family recipe. You follow it. You don't change it.*

---

## 🔄 Mutable Variables (`var`) – The Daily Special

**Mutable** means **can be changed anytime**.

In Kotlin, you use the keyword `var` (short for *variable*).

```kotlin
var soupOfTheDay = "Tomato Soup"
```

You can change it as many times as you want:

```kotlin
soupOfTheDay = "Mushroom Soup"   // ✅ Allowed
soupOfTheDay = "Pumpkin Soup"    // ✅ Allowed again
```

**When to use `var`?**  
- When the value needs to change over time (age, score, daily special)
- When you need to "recook" the ingredient

> 🍳 *Mutable = like the daily special. It changes every day, and that's okay.*

---

## 📊 Quick Comparison

| Type | Keyword | Can you change it? | Kitchen example |
|------|---------|--------------------|-----------------|
| **Immutable** | `val` | ❌ No | Family recipe (never changes) |
| **Mutable** | `var` | ✅ Yes | Daily soup special (changes often) |

---

## 🎯 Best Practice (The Chef's Rule)

> **"Prefer `val` over `var` unless you really need to change it."**

Why?  
- Immutable variables are safer (no unexpected changes)  
- Code is easier to read and understand  
- Fewer bugs (you can't accidentally recook a family recipe!)

---

## 🍳 Try It Yourself

Run this code and see the difference:

```kotlin
fun main() {
    // Immutable - cannot recook
    val secret = "Grandma's Noodles"
    println(secret)
    // secret = "New Recipe"  // ❌ Try uncommenting this line

    // Mutable - can recook
    var special = "Tomato Soup"
    println(special)
    special = "Mushroom Soup"
    println(special)
}
```

---

## 📝 Summary

- **Variable** = ingredient bowl
- **`val`** = immutable → cannot recook (like family recipe)
- **`var`** = mutable → can recook (like daily special)

Remember:  
> *"If you don't need to change it, make it `val`. Your future self will thank you."*

Happy cooking! 👨‍🍳

[👉 Introduction to work with variables](https://github.com/realmg51-cpu/KotlinCookBook/blob/main/src/kotlin/normal/Variables/WorkWithIt/introduction.md)
