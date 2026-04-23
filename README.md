
# Kotlin CookBook 🍳

[![Release](https://img.shields.io/github/v/release/realmg51-cpu/KotlinCookBook)](https://github.com/realmg51-cpu/KotlinCookBook/releases)
[![Docker CI](https://github.com/realmg51-cpu/KotlinCookBook/actions/workflows/docker-ci.yml/badge.svg)](https://github.com/realmg51-cpu/KotlinCookBook/actions/workflows/docker-ci.yml)
![Kotlin Version](https://img.shields.io/badge/Kotlin-2.3.20-blue)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](LICENSE)
![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen)
![Tests](https://github.com/realmg51-cpu/KotlinCookBook/actions/workflows/ci.yml/badge.svg)
![Stars](https://img.shields.io/github/stars/realmg51-cpu/KotlinCookBook)
![Forks](https://img.shields.io/github/forks/realmg51-cpu/KotlinCookBook)
![Progress](https://img.shields.io/badge/Progress-50%25-orange)

> *"Learn Kotlin the fun way – one recipe at a time!"*

## What is it?

This is a simple **Kotlin CookBook** that helps you learn Kotlin **easier** and **funner**.

Each "recipe" is a small Kotlin program that teaches you one concept at a time.

> [!NOTE]
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

For detailed setup instructions, see [InstallAndSetup.md](https://github.com/realmg51-cpu/KotlinCookBook/blob/main/src/kotlin/normal/GettingStarted/InstallAndSetup.md)

---

## 📚 Recipes so far

| Recipe | What you'll learn | Level | Status |
|--------|-------------------|-------|--------|
| `HelloWorld.kt` | Your first Kotlin program | 🍜 Beginner | ✅ Done |
| `StringSplitter.kt` | String manipulation basics | 🍜 Beginner | ✅ Done |
| `ImmutableVariables.kt` / `MutableVariables.kt` | `val` vs `var` | 🍜 Beginner | ✅ Done |
| `DataTypes.kt` | Int, Char, String, Float, Double | 🍜 Beginner | ✅ Done |
| `IfChef.kt` | `if` and `else` (making decisions) | 🍜 Beginner | ✅ Done |
| `WhenChef.kt` | `when` expression (the spice rack) | 🍜 Beginner | ✅ Done |
| `ForStirring.kt` | `for` loop (batch cooking) | 🍜 Beginner | ✅ Done |
| `WhileStirring.kt` | `while` loop (automatic stirrer) | 🍜 Beginner | ✅ Done |
| `DoWhileStirring.kt` | `do-while` loop (taste first) | 🍜 Beginner | ✅ Done |
| `Break.kt` | Control your loops (stop) | 🍜 Beginner | ✅ Done |
| `Continue.kt` | Control your loops (skip) | 🍜 Beginner | ✅ Done |
| `InputAndNullSafety.kt` | User input & null safety | 🍜 Beginner | ✅ Done |
| `BasicFunction.kt` | Creating basic functions | 🍜 Beginner | ✅ Done |
| `LambdaFunction.kt` | Lambda expressions | 🥘 Intermediate | ✅ Done |

> 
---

## 🚀 How to cook (run) these recipes

```bash
# Clone the kitchen
git clone https://github.com/realmg51-cpu/KotlinCookBook
cd KotlinCookBook

# Run a recipe
kotlin src/kotlin/normal/GettingStarted/HelloWorld.kt

# Or run with script mode
kotlinc -script src/kotlin/normal/GettingStarted/HelloWorld.kt
```

### Running interactive examples:

Some recipes use `readln()` to get input from you. Just follow the prompts!

---

## ⏰ 30-Minute Quick Start

- **5 min** - Setup kitchen ([InstallAndSetup.md](https://github.com/realmg51-cpu/KotlinCookBook/blob/main/src/kotlin/normal/GettingStarted/InstallAndSetup.md))
- **5 min** - Cook `HelloWorld.kt`
- **5 min** - Understand `val` vs `var`
- **5 min** - Play with `DataTypes.kt`
- **5 min** - Make decisions with `IfChef.kt`
- **5 min** - Loop it with `ForLoop.kt`

**Total:** 30 minutes to basic Kotlin fluency!

---

---

<!-- STRUCTURE_START -->
## 📁 Project Structure

```
src/kotlin/normal/
├── BreakAndContinue/
│   ├── Break.kt
│   └── Continue.kt
├── Funcions/
│   └── BasicFuncions/
│       └── BasicFuncion.kt
├── GettingStarted/
│   ├── HelloWorld.kt
├── IfChef/
│   └── IfChef.kt
├── InputAndNullSafety/
│   └── InputAndNullSafety.kt
├── Loops/
│   ├── Do-While/
│   │   └── DoWhileStirring.kt
│   ├── For/
│   │   └── ForStirring.kt
│   └── While/
│       └── WhileStirring.kt
├── Variables/
│   ├── WorkWithIt/
│   │   ├── StringSplitter.kt
│   │   └── StringSplitterv2.kt
│   ├── CommonVariables.kt
│   ├── ImmutableVariables.kt
│   └── MutableVariables.kt
└── WhenChef/
    └── WhenChef.kt
```

## 📊 Statistics

| Metric | Value |
|--------|-------|
| 🍳 **Total Recipes** | `15` Kotlin files |
| 📁 **Categories** | `8` folders |
| 🆕 **Latest update** | 2026-04-23 |

<img src=".github/avatars/bot.svg" width="30">

*Auto-updated: 2026-04-23 13:37:38 UTC*
<!-- STRUCTURE_END -->

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

## 🏆 Kitchen Wall of Fame

*Amazing chefs who added recipes:*

| Chef | Recipe | Date |
|------|--------|------|
| @realmg51-cpu | HelloWorld, StringSplitter, Variables, DataTypes, IfChef, WhenChef, ForLoop | Apr 2026 |
| @sunnn338 | WhileLoop, Break and Continue | Apr 2026 |

---

## 📖 How to Use This CookBook

1. **Start from the top** – recipes build on each other
2. **Type the code yourself** – don't just copy-paste!
3. **Experiment** – change values and see what happens
4. **Try the challenges** – they make you a better chef
5. **Break things** – then fix them. That's how you learn!

---

## 🗺️ Roadmap

### Phase 1: Kotlin Basics (In Progress)
- [x] Hello World
- [x] String manipulation
- [x] Variables (`val` vs `var`)
- [x] Data types (Int, Char, String, Float, Double)
- [x] `if-else` decisions
- [x] `when` expression
- [x] Loops (`for`, `while`, `do-while`)
- [x] Break and Continue
- [ ] Functions
- [x] Null safety (`?`, `?:`, `!!`)

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

## 🆘 Common Mistakes (and how to fix them)

| Mistake | Solution |
|---------|----------|
| `println("Hello)` (missing quote) | Always close your quotes: `"Hello"` |
| `val name = "John"; name = "Jane"` | Use `var` if you need to change it |
| `if (isSalty == true)` | Just write `if (isSalty)` |
| Missing `else` in `when` expression | Add `else -> ...` at the end |
| `Float` without `f` (`3.14`) | Kotlin thinks it's `Double`. Use `3.14f` |
| `Char` with double quotes (`"a"`) | Use single quotes: `'a'` |
| Infinite loop | Make sure condition eventually becomes `false` |
| Using `=` instead of `==` | Use `==` for comparison |

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


### 📖 Recipe Appendix



For a complete list of all recipes, check out the [**Full Recipe Appendix**](APPENDIX.md) 📚



> 💡 **Tip:** The appendix contains every recipe with direct links to source code!


**Happy cooking! 👨‍🍳🍳**

Now go cook some Kotlin! 🚀

