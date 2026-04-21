
# 🍳 Kitchen Setup Guide

> _"A good chef needs the right tools. Let's set up your Kotlin kitchen!"_

## 📋 What You'll Need

Before we start cooking with Kotlin, let's make sure your kitchen is ready:

| Tool | Purpose |
|------|---------|
| **Kotlin** | Your main cooking ingredient |
| **Java JDK** | The stove that heats everything up |
| **Text Editor** | Your recipe book (where you write code) |
| **Terminal** | Your kitchen counter (where you run commands) |

---

## 🥄 Step 1: Check If You Already Have Kotlin

Open your terminal (Command Prompt on Windows, Terminal on Mac/Linux) and type:

```bash
kotlin -version
```

**If you see something like:** `Kotlin version 2.3.20+` → Great! You're ready to cook! 🎉

**If you see:** `command not found` → No worries! Let's install it below 👇

---

## 🍽️ Step 2: Install Your Kitchen Tools

### Option A: macOS (Homebrew - The Easy Recipe)

```bash
# Install Homebrew first (if you don't have it)
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# Then install Kotlin
brew install kotlin

# Install Java (if needed)
brew install openjdk@17
```

### Option B: Linux (SDKMAN - The Flexible Recipe)

```bash
# Install SDKMAN
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"

# Install Kotlin
sdk install kotlin

# Install Java (Kotlin needs it!)
sdk install java 17-open
```

### Option C: Windows (Chocolatey - The Windows Recipe)

```powershell
# First, install Chocolatey (run as Administrator)
Set-ExecutionPolicy Bypass -Scope Process -Force
[System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072
iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))

# Then install Kotlin
choco install kotlin

# Install Java
choco install openjdk17
```

### Option D: Manual Installation (The "From Scratch" Recipe)

**For any OS:**

1. **Download Kotlin:** Visit [https://github.com/JetBrains/kotlin/releases/latest](https://github.com/JetBrains/kotlin/releases/latest)
2. **Download Java:** Visit [https://adoptium.net/](https://adoptium.net/) (choose JDK 17)
3. **Extract both** to a folder like `C:\kotlin` or `/usr/local/kotlin`
4. **Add to PATH** (environment variables)

---

## 🔥 Step 3: Verify Your Kitchen Works

After installation, run these commands to make sure everything is hot and ready:

```bash
# Check Kotlin
kotlin -version
# Should output: Kotlin version 2.3.20 or higher

# Check Java
java -version
# Should output: openjdk version "17.0.x"

# Check Kotlin compiler
kotlinc -version
# Should output: info: kotlinc-jvm 2.3.20
```

**If all three commands show version numbers → Your kitchen is ready! 🎉**

---

## 📝 Step 4: Choose Your Recipe Book (Text Editor)

You need somewhere to write your Kotlin recipes. Here are the best options:

| Editor | Best For | Install Command |
|--------|----------|-----------------|
| **IntelliJ IDEA** | Professional chefs (full kitchen) | [Download from JetBrains](https://www.jetbrains.com/idea/download/) |
| **VS Code** | Quick recipes & lightweight | `brew install --cask visual-studio-code` (Mac) / [Download](https://code.visualstudio.com/) |
| **Android Studio** | Android cooking | [Download here](https://developer.android.com/studio) |
| **Sublime Text** | Ultra-fast & simple | [Download here](https://www.sublimetext.com/) |
| **Any text editor** | Even Notepad works! | Already installed |

**Pro tip:** For beginners, start with **VS Code** + install the **Kotlin Language** extension!

---

## 🧪 Step 5: Cook Your First Test Recipe

Let's make sure everything works by creating a tiny "Hello, Kitchen!" recipe.

### 5.1 Create a new file
Create a file called `TestKitchen.kt` anywhere on your computer.

### 5.2 Add this code
```kotlin
/**
 * Recipe: TestKitchen
 * What you'll learn: Testing if your kitchen works!
 */

fun main() {
    println("🍳 My Kotlin kitchen is ready!")
    println("Let's cook something delicious!")
    
    // Try changing this line
    val ingredients = listOf("Kotlin", "Java", "Curiosity")
    println("Ingredients I have: $ingredients")
}
```

### 5.3 Run your recipe
Open terminal in the same folder and type:

```bash
kotlin TestKitchen.kt
```

**You should see:**
```
🍳 My Kotlin kitchen is ready!
Let's cook something delicious!
Ingredients I have: [Kotlin, Java, Curiosity]
```

**If you see this → CONGRATULATIONS! 🎊 Your kitchen is fully operational!**

---

## 🚨 Troubleshooting: Common Kitchen Fires

| Problem | What Happened | How to Fix |
|---------|--------------|------------|
| `'kotlin' is not recognized` | Kotlin not in PATH | Reinstall or add to PATH manually |
| `No Java runtime present` | Java missing | Install JDK 17 (see Step 2) |
| `Unsupported class file version` | Java too old/new | Install JDK 17 specifically |
| `Permission denied` | No execute rights | Run: `chmod +x filename.kt` (Mac/Linux) |
| `Error: Could not find or load main class` | Wrong file name | Check spelling/case sensitivity |

---

## 🎯 Quick Setup Checklist

Before moving to the recipes, make sure you can:

- [ ] Type `kotlin -version` and see a version number
- [ ] Type `java -version` and see Java 17+
- [ ] Create a `.kt` file with `fun main()`
- [ ] Run that file with `kotlin filename.kt`
- [ ] See output in your terminal

**All checked?** → You're ready to start cooking! 🍳

---

## 🆘 Still Having Trouble?

Don't worry! Even master chefs burn a few dishes. Try these:

1. **Google the error message** - Someone else has fixed it before!
2. **Check your PATH** - Make sure Kotlin's `bin` folder is in your system PATH
3. **Reinstall everything** - Sometimes starting fresh helps
4. **Open an Issue** - Ask for help in this repo's Issues section

---

## 🎓 What's Next?

Now that your kitchen is ready, head back to the main README and start cooking:

- Start with **`HelloWorld.kt`** - Your first bite of Kotlin
- Try **`StringSplitter.kt`** - Learn to chop strings
- Experiment with **`val` vs `var`** - Understand when ingredients can change

---

## 💬 Need Help?

- 📖 Check the main [README.md](./README.md)
- 🐛 Open an [Issue](https://github.com/realmg51-cpu/KotlinCookBook/issues)
- 🔧 See [CONTRIBUTING.md](./CONTRIBUTING.md) to add your own tips

---

> *"A well-prepared kitchen is the first step to a delicious meal. Now let's cook some Kotlin!"* 🚀

**Happy coding, chef! 👨‍🍳👩‍🍳**
