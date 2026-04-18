
# Kotlin CookBook 🍳

![Kotlin Version](https://img.shields.io/badge/Kotlin-2.3.20-blue)
![License](https://img.shields.io/badge/License-Apache-green)
![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen)
![Tests](https://github.com/realmg51-cpu/KotlinCookBook/actions/workflows/ci.yml/badge.svg)
![Stars](https://img.shields.io/github/stars/realmg51-cpu/KotlinCookBook)
![Forks](https://img.shields.io/github/forks/realmg51-cpu/KotlinCookBook)

> *"Learn Kotlin the fun way – one recipe at a time!"*

## What is it?

This is a simple **Kotlin CookBook** that helps you learn Kotlin **easier** and **funner**.

Each "recipe" is a small Kotlin program that teaches you one concept at a time.

> [!IMPORTANT]
> This repo is still incomplete and I'm just learning Kotlin now, so if you can, please help me complete it by **forking** and adding new **recipes**. All code here is **safe** and **stable**.

---

## 👨‍🍳 Who can use it?

**Everyone!** Whether you're a:

| Level | Description |
|-------|-------------|
| 🍝 **Beginner** | Just starting your coding journey |
| 🍜 **Senior** | Need a quick refresher |
| 🥘 **Anyone in between** | Welcome! |

---

## 🍳 Kitchen Tools (Prerequisites)

Before you start cooking, make sure you have:

- **Kotlin** installed (version 2.3.20+)
- A text editor (VS Code, IntelliJ, or even Notepad!)
- A hungry mind 😋

### Install Kotlin quickly:

```bash
# macOS (with Homebrew)
brew install kotlin

# Linux (with SDKMAN)
sdk install kotlin

# Windows (with Chocolatey)
choco install kotlin
```

Verify installation:
```bash
kotlin -version
```

---

## 📚 Recipes so far

| Recipe | What you'll learn | Level | Status |
|--------|-------------------|-------|--------|
| `HelloWorld.kt` | Your first Kotlin program | 🍜 Beginner | ✅ Done |
| `StringSplitter.kt` | String manipulation basics (substringBefore, substringAfter) | 🍜 Beginner | ✅ Done |
| `ImmutableVariables.kt` / `MutableVariables.kt` | `val` vs `var` (why you can't recook) | 🍜 Beginner | ✅ Done |
| `DataTypes.kt` | Int, Char, String, Float, Double | 🍜 Beginner | ✅ Done |
| `IfChef` | `if` and `else` in Kotlin (making decisions) | 🍜 Beginner | ✅ Done |
| `WhenChef` | `when` expression (the spice rack) | 🍜 Beginner | ✅ Done |

### Coming Soon 🔜

| Recipe | What you'll learn | Level |
|--------|-------------------|-------|
| `Loops` | `for`, `while`, `do-while` (automatic stirrer) | 🍜 Beginner |
| `Functions` | Creating your own recipes | 🍜 Beginner |
| `NullSafety` | Handling empty ingredients safely | 🍜 Beginner |
| `Collections` | List, Set, Map (your pantry) | 🥘 Intermediate |
| `Lambdas` | Cooking with shortcuts | 🥘 Intermediate |
| `Classes` | Building your own kitchen tools | 🥘 Intermediate |

---

## 🚀 How to cook (run) these recipes

```bash
# Clone the kitchen
git clone https://github.com/realmg51-cpu/KotlinCookBook
cd KotlinCookBook

# Run a recipe
kotlin src/kotlin/normal/HelloWorld.kt

# Or run with Java (if Kotlin is not in PATH)
kotlinc -script src/kotlin/normal/HelloWorld.kt
```

### Running interactive examples:

Some recipes use `readln()` to get input from you. Just follow the prompts!

---

## 🗺️ Roadmap

### Phase 1: Kotlin Basics (In Progress)
- [x] Hello World
- [x] String manipulation
- [x] Variables (`val` vs `var`)
- [x] Data types (Int, Char, String, Float, Double)
- [x] `if-else` decisions
- [x] `when` expression
- [ ] Loops (`for`, `while`, `do-while`)
- [ ] Functions
- [ ] Null safety (`?`, `?:`, `!!`)

### Phase 2: Intermediate
- [ ] Collections (List, Set, Map)
- [ ] Lambdas and higher-order functions
- [ ] Scope functions (`let`, `run`, `with`, `apply`, `also`)
- [ ] Extension functions

### Phase 3: Advanced
- [ ] Coroutines (async cooking!)
- [ ] Kotlin 2.2.0 features
- [ ] Android development basics
- [ ] Multiplatform Magic

---

## 🤝 How to Contribute

Want to add your own recipe? Awesome! Here's how:

1. **Fork** this repo
2. Add your own recipe (following the style below)
3. Submit a **Pull Request**

### Recipe Template:

```kotlin
/**
 * Recipe: [Name of your recipe]
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

Your recipe should include:
- A `.kt` file with working code
- Clear comments explaining each step
- (Optional) An `introduction.md` for deeper explanation
- Examples or challenges at the end

### Style Guide:
- Use emojis to make it fun 🍳
- Add comments like a chef talking
- Include "Try it yourself" sections
- End with a small challenge

---

## 📖 How to Use This CookBook

1. **Start from the top** – recipes build on each other
2. **Type the code yourself** – don't just copy-paste!
3. **Experiment** – change values and see what happens
4. **Try the challenges** – they make you a better chef
5. **Break things** – then fix them. That's how you learn!

---

## 🆘 Common Mistakes (and how to fix them)

| Mistake | Solution |
|---------|----------|
| `println("Hello)` (missing quote) | Always close your quotes: `"Hello"` |
| `val name = "John"; name = "Jane"` | Use `var` if you need to change it |
| `if (isSalty == true)` | Just write `if (isSalty)` |
| Missing `else` in `when` expression | Add `else -> ...` at the end |
| `Float` without `f` (`3.14`) | Kotlin thinks it's `Double`. Use `3.14f` |
| `Char` with double quotes (`"a"`) | Use single quotes: `'a'` |

---

## 📝 License

**Apache v2.0** – feel free to fork and add your own recipes!

---

## ⭐ Star This Repo

If this cookbook helped you, please **star** ⭐ this repo. It helps others find it too!

---

## 💬 Connect

Have questions? Suggestions? Want to share your own recipe?
- Open an **Issue** on GitHub
- Submit a **Pull Request**
- Fork and make it your own!

---

> *"A good cook never stops learning new recipes. Neither should a good developer."*

> *"Every expert was once a beginner who didn't give up."*

---

**Happy cooking! 👨‍🍳🍳**

Now go cook some Kotlin! 🚀DuuuKotlin
