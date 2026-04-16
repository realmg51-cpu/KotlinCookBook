
# 👋 Hello, World! – Your First Dish in the Kotlin Kitchen

Every chef starts with a simple dish.  
Every programmer starts with **"Hello, World!"**

This is your first recipe in the **Kotlin CookBook**. Let's cook it together!

---

## 🍳 What is "Hello, World!"?

**"Hello, World!"** is a tiny program that prints a message on the screen.  
It's like boiling an egg – simple, but it teaches you the basics of your kitchen.

In Kotlin, it looks like this:

```kotlin
fun main() {
    println("Hello, World!")
}
```

That's it. That's your first dish.

---

## 🔪 Breaking Down the Recipe

Let's look at each **ingredient**:

| Ingredient | What it means | Kitchen analogy |
|------------|---------------|-----------------|
| `fun` | Short for *function* (a block of code that does something) | A **recipe** – a set of instructions |
| `main` | The name of the function. **Every Kotlin program starts here** | The **main stove** – where cooking begins |
| `()` | Where you put ingredients (parameters) – empty here | Your **cutting board** (empty for now) |
| `{ }` | Curly braces – wrap the code inside | The **pot** – everything inside gets cooked |
| `println(...)` | Print a line of text to the screen | The **serving plate** – shows your dish to the world |
| `"Hello, World!"` | The text you want to print (in double quotes) | The **ingredient** – what you're serving |

---

## 🍜 Try It Yourself

Type this code and run it:

```kotlin
fun main() {
    println("Hello, World!")
}
```

**Expected output:**
```
Hello, World!
```

Congratulations! You just cooked your first Kotlin dish! 🎉

---

## 🧂 Adding More Ingredients

Once your first dish works, try changing the message:

```kotlin
fun main() {
    println("Welcome to my Kotlin kitchen!")
    println("I'm learning to cook code!")
}
```

**Output:**
```
Welcome to my Kotlin kitchen!
I'm learning to cook code!
```

Each `println` prints on a **new line**.  
If you want to print on the same line, use `print` instead:

```kotlin
fun main() {
    print("Hello, ")
    print("World!")
}
// Output: Hello, World!
```

---

## 📝 What You Learned

| Concept | What it does |
|---------|---------------|
| `fun main()` | The entry point of every Kotlin program |
| `println()` | Print text and move to a new line |
| `print()` | Print text and stay on the same line |
| `"text"` | A string (text ingredient) |

---

## 🎯 Challenge (Level Up!)

Try these small challenges to master your first recipe:

1. **Print your name:**
   ```kotlin
   fun main() {
       println("My name is [your name]")
   }
   ```

2. **Print a poem** (3 lines):
   ```kotlin
   fun main() {
       println("Roses are red,")
       println("Violets are blue,")
       println("Kotlin is fun,")
       println("And so are you!")
   }
   ```

3. **Print without line breaks** (use `print`):
   ```kotlin
   fun main() {
       print("One ")
       print("Two ")
       print("Three ")
   }
   // Output: One Two Three
   ```

---

## 🔥 Fun Fact

The "Hello, World!" tradition started in 1972 with the book *"The C Programming Language"*.  
Since then, almost every programmer has cooked this dish in every language they learn.

**Now you're part of that tradition!** 👨‍🍳

---

## 📚 Next Recipe

Now that you can print messages, it's time to learn about **variables** – the ingredients you can store and reuse.

👉 [Introduction to Variables]([src/kotlin/normal/Variables/introduction.md](https://github.com/realmg51-cpu/KotlinCookBook/blob/main/src/kotlin/normal/Variables/introduction.md))

---

> *"A journey of a thousand miles begins with a single step.  
> A journey of a thousand programs begins with Hello, World!"*

Happy cooking! 🍳

