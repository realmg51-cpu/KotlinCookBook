



# 🤝 Contributing to Kotlin CookBook 🍳

> *"The best recipes come from many cooks sharing their secrets."*

First off, thank you for considering contributing to Kotlin CookBook! 🎉

This document contains guidelines for contributing to this project. Please read it before submitting a pull request.

---

## 🍳 What is Kotlin CookBook?

Kotlin CookBook is a **fun, beginner-friendly** guide to learning Kotlin. Each "recipe" is a small Kotlin program that teaches one concept at a time – with kitchen analogies! 🥘

---

## 🎯 How Can I Contribute?

### 1. 🍝 Add a New Recipe

Have an idea for a new Kotlin concept? Create a recipe!

**Recipe template:**

```kotlin
/**
 * 🍳 [Recipe Name]
 * 
 * What you'll learn:
 * - Concept 1
 * - Concept 2
 * 
 * Kitchen analogy:
 * [Explain it like you're in a kitchen]
 */

fun main() {
    // Your code here with clear comments
}
```

**Requirements:**
- ✅ Must have `fun main()`
- ✅ Must compile and run without errors
- ✅ Include clear comments (like a chef talking)
- ✅ Use emojis to make it fun 🍳
- ✅ Include a "Try it yourself" or "Challenge" section

**Where to put it:**
```
src/kotlin/normal/[Category]/[RecipeName].kt
```

Example:
```
src/kotlin/normal/Loops/ForStirring.kt
```

### 2. 📝 Improve Documentation

- Fix typos or grammar in `README.md` or `introduction.md`
- Add better explanations or examples
- Translate content (if you're multilingual)

### 3. 🐛 Report Bugs

Found a bug? Open an issue with:
- What you expected to happen
- What actually happened
- Steps to reproduce
- Your Kotlin version (`kotlinc -version`)

### 4. ⭐ Suggest Enhancements

Have an idea for a new feature or recipe? Open an issue with the label `enhancement`.

---

## 🔧 Development Setup

### Prerequisites

- **Kotlin** 2.0.20 or higher
- **Java** 17 or higher
- Git

### Clone and Run

```bash
# Clone your fork
git clone https://github.com/YOUR_USERNAME/KotlinCookBook
cd KotlinCookBook

# Run a recipe
kotlinc -script src/kotlin/normal/GettingStarted/HelloWorld.kt

# Or compile and run
kotlinc src/kotlin/normal/GettingStarted/HelloWorld.kt -include-runtime -d hello.jar
java -jar hello.jar
```

### Run All Tests Locally

```bash
# Run all recipes
for file in $(grep -l "fun main" $(find src -name "*.kt" -type f)); do
    echo "Testing: $file"
    kotlinc -script "$file"
done
```

---

## 📝 Pull Request Guidelines

### Before Submitting

1. **Test your recipe** – Make sure it runs without errors
2. **Check style** – Follow the existing code style (emojis, comments, spacing)
3. **Update README** – If adding a new recipe, update the "Recipes so far" table
4. **Keep it simple** – One recipe per pull request

### Pull Request Template

```markdown
## 🍳 Recipe: [Name]

**What it teaches:** [Brief description]

**Category:** [Basics/Loops/Functions/Collections/etc.]

## Checklist

- [ ] Code compiles and runs without errors
- [ ] Comments are clear and helpful
- [ ] Includes emojis and kitchen analogy
- [ ] Has a "Try it yourself" or challenge section
- [ ] Updated README.md (if adding new recipe)

## Screenshot (optional)

[Add output screenshot if helpful]
```

### Branch Naming

Use clear branch names:

| Type | Format | Example |
|------|--------|---------|
| New recipe | `feat/recipe-name` | `feat/while-loop` |
| Bug fix | `fix/bug-description` | `fix/hello-world-typo` |
| Documentation | `docs/what-changed` | `docs/update-readme` |
| CI/CD | `ci/what-changed` | `ci/fix-cache-key` |

---

## 🎨 Style Guide

### Code Style

```kotlin
// ✅ Good
fun main() {
    val ingredients = listOf("🧂 Salt", "🌿 Basil")
    
    for (ingredient in ingredients) {
        println("Adding: $ingredient")
    }
}

// ❌ Bad (no comments, no emojis)
fun main(){val x=listOf("Salt");for(i in x){println(i)}}
```

### Comments

```kotlin
// ✅ Good – Explains WHY
// Stir the soup 5 times to mix all ingredients
for (i in 1..5) {
    println("Stirring... round $i 🥄")
}

// ❌ Bad – States the obvious
// Loop from 1 to 5
for (i in 1..5) {
    println("Stirring... round $i 🥄")
}
```

### Emojis to Use

| Emoji | Meaning |
|-------|---------|
| 🍳 | Recipe / Cooking |
| 🔪 | Getting started / Action |
| 🧂 | Tip / Extra |
| 🔥 | Important / Pro tip |
| ✅ | Correct / Success |
| ❌ | Wrong / Error |
| 🎯 | Challenge |
| 📚 | Next steps |

---

## 🧪 CI/CD Expectations

When you submit a pull request, GitHub Actions will automatically:

1. ✅ Compile all recipes
2. ✅ Run each recipe
3. ✅ Generate test output artifacts
4. ✅ Report pass/fail status

**Your PR will only be merged if all tests pass!** 🟢

---

## 📄 License

By contributing, you agree that your contributions will be licensed under the **MIT License**.

---

## 🙏 Thank You!

Every contribution – big or small – helps make Kotlin CookBook better for everyone.

- 🍝 **New recipe** = Someone learns a new concept
- 📝 **Better docs** = Someone understands faster
- 🐛 **Bug report** = Someone avoids frustration

**You are awesome!** 🌟

---

## 📞 Questions?

- Open an [Issue](https://github.com/realmg51-cpu/KotlinCookBook/issues)
- Or reach out via GitHub Discussions (coming soon)

---

> *"The best way to learn is to teach. The best way to grow is to share."*

Happy cooking! 👨‍🍳
