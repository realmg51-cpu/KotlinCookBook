/**
 * Recipe: Extension Functions 🔧
 * 
 * What you'll learn:
 * - Add new functions to existing classes WITHOUT inheritance
 * - Make code more readable and natural
 * - Create utility functions that look like built-in methods
 * 
 * Kitchen analogy:
 * Extension functions are like MAGIC STICKERS you can put on kitchen tools!
 * You can add "blend()" to a knife, or "sousVide()" to a pan - 
 * without changing the original tool. The tool still works normally,
 * but now it has EXTRA abilities when YOU use it!
 * 
 * @author Your Name
 * @since April 2026
 */

fun main() {
    println("🔧 EXTENSION FUNCTIONS - Adding Magic Powers to Objects\n")
    
    // ============================================================
    // PART 1: BASIC EXTENSION FUNCTIONS
    // ============================================================
    println("📚 PART 1: Basic Extensions")
    println("-".repeat(50))
    
    // Add extension to String class
    fun String.addEmoji(): String = "$this 🍳"
    fun String.shout(): String = "${this.uppercase()}!!!"
    fun String.firstChar(): Char = this[0]
    
    val dish = "pizza"
    println("Original: $dish")
    println("With emoji: ${dish.addEmoji()}")
    println("Shout: ${dish.shout()}")
    println("First char: ${dish.firstChar()}")
    
    // Add extension to Int class
    fun Int.isEven(): Boolean = this % 2 == 0
    fun Int.square(): Int = this * this
    fun Int.timesWord(word: String): String = word.repeat(this)
    
    println("\nNumber 7 is even? ${7.isEven()}")
    println("5 squared: ${5.square()}")
    println("3 times 'ha': ${3.timesWord("ha")}")
    
    // ============================================================
    // PART 2: EXTENSIONS WITH PARAMETERS
    // ============================================================
    println("\n\n📚 PART 2: Extensions with Parameters")
    println("-".repeat(50))
    
    fun String.repeatTimes(times: Int): String = this.repeat(times)
    fun Int.addAndMultiply(add: Int, multiply: Int): Int = (this + add) * multiply
    
    println("'Yum' x 3: ${"Yum ".repeatTimes(3)}")
    println("(5 + 2) * 3 = ${5.addAndMultiply(2, 3)}")
    
    // ============================================================
    // PART 3: REAL-WORLD USEFUL EXTENSIONS
    // ============================================================
    println("\n\n📚 PART 3: Useful Real-World Extensions")
    println("-".repeat(50))
    
    // String utilities
    fun String.isEmail(): Boolean = this.contains("@") && this.contains(".")
    fun String.reverseWords(): String = this.split(" ").reversed().joinToString(" ")
    
    val email = "chef@kitchen.com"
    val phrase = "Kotlin is awesome"
    
    println("'$email' is email? ${email.isEmail()}")
    println("Reverse words: '${phrase.reverseWords()}'")
    
    // List utilities
    fun <T> List<T>.secondOrNull(): T? = this.getOrNull(1)
    fun <T> List<T>.middle(): T? = this.getOrNull(this.size / 2)
    
    val fruits = listOf("Apple", "Banana", "Cherry", "Date")
    println("Second fruit: ${fruits.secondOrNull()}")
    println("Middle fruit: ${fruits.middle()}")
    
    // Number utilities
    fun Int.isPrime(): Boolean {
        if (this < 2) return false
        for (i in 2 until this) {
            if (this % i == 0) return false
        }
        return true
    }
    
    println("17 is prime? ${17.isPrime()}")
    println("20 is prime? ${20.isPrime()}")
    
    // ============================================================
    // PART 4: EXTENSION PROPERTIES
    // ============================================================
    println("\n\n📚 PART 4: Extension Properties (like fields!)")
    println("-".repeat(50))
    
    // Extension properties (no actual storage, just computed)
    val String.wordCount: Int
        get() = this.trim().split(Regex("\\s+")).size
    
    val Int.isOdd: Boolean
        get() = this % 2 != 0
    
    val List<*>.hasItems: Boolean
        get() = this.isNotEmpty()
    
    val sentence = "The quick brown fox"
    println("'$sentence' has ${sentence.wordCount} words")
    println("7 is odd? ${7.isOdd}")
    println("Empty list has items? ${emptyList<String>().hasItems}")
    
    // ============================================================
    // PART 5: KITCHEN-THEMED EXTENSIONS 🍳
    // ============================================================
    println("\n\n📚 PART 5: Kitchen-Themed Extensions")
    println("-".repeat(50))
    
    // Add cooking methods to String
    fun String.fry(): String = "🔥 Fried $this 🔥"
    fun String.boil(): String = "💧 Boiled $this 💧"
    fun String.grilled(): String = "🌋 Grilled $this 🌋"
    fun String.asEmoji(): String = when (this.lowercase()) {
        "pizza" -> "🍕"
        "burger" -> "🍔"
        "sushi" -> "🍣"
        "pasta" -> "🍝"
        else -> "🍽️"
    }
    
    val ingredient = "potato"
    println(ingredient.fry())
    println(ingredient.boil())
    println("Sushi".grilled())
    println("Pizza".asEmoji())
    
    // Add to List class
    fun List<String>.printMenu(): String {
        return this.mapIndexed { index, item -> 
            "${index + 1}. ${item.asEmoji()} $item"
        }.joinToString("\n")
    }
    
    val menu = listOf("Pizza", "Burger", "Sushi", "Pasta")
    println("\nToday's Menu:\n${menu.printMenu()}")
    
    // ============================================================
    // PART 6: NULLABLE EXTENSIONS (Safe calls)
    // ============================================================
    println("\n\n📚 PART 6: Nullable Extensions")
    println("-".repeat(50))
    
    // Extension on nullable type
    fun String?.orEmpty(default: String): String {
        return this ?: default
    }
    
    val name1: String? = "Chef"
    val name2: String? = null
    
    println("Name1: ${name1.orEmpty("Guest")}")
    println("Name2: ${name2.orEmpty("Guest")}")
    
    // Safe extension
    fun String?.safeLength(): Int = this?.length ?: 0
    
    println("Length of 'Kotlin': ${"Kotlin".safeLength()}")
    println("Length of null: ${(null as String?).safeLength()}")
    
    // ============================================================
    // PART 7: EXTENSION VS MEMBER FUNCTION
    // ============================================================
    println("\n\n📚 PART 7: Extension vs Member Function")
    println("-".repeat(50))
    
    class Recipe(val name: String) {
        fun cook(): String = "Cooking $name normally 🍳"
    }
    
    // Extension function (can't access private members)
    fun Recipe.premiumCook(): String = "🌟 PREMIUM ${this.name} with extra cheese! 🌟"
    
    // Shadowing member function (won't override)
    fun Recipe.cook(): String = "OVERRIDE? No, this is EXTENSION!" // Doesn't override!
    
    val recipe = Recipe("Pasta")
    println(recipe.cook())  // Calls MEMBER function
    println(recipe.premiumCook())  // Calls EXTENSION
    
    // ============================================================
    // PART 8: CHAINING EXTENSIONS
    // ============================================================
    println("\n\n📚 PART 8: Chaining Extensions")
    println("-".repeat(50))
    
    val result = "   hello world   "
        .trim()
        .shout()
        .addEmoji()
    
    println("Chained result: $result")
    
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val processed = numbers
        .filter { it.isEven() }
        .map { it.square() }
        .joinToString(", ")
    
    println("Even numbers squared: $processed")
    
    /* 🍳 TRY IT YOURSELF:
     * 
     * 1. Create extension `String.toSlug()` that converts to url-friendly format:
     *    "Hello World!" -> "hello-world"
     * 
     * 2. Add extension `Int.times()` that repeats a block N times:
     *    5.times { println("Hello") }
     * 
     * 3. Create extension `List<T>.secondLast()` that returns second-to-last element
     * 
     * 4. Add extension property `String.isPalindrome` that checks if string reads same backwards
     * 
     * 5. Extension `Int.seconds` that returns milliseconds (e.g., 5.seconds)
     *    Hint: Create extension property returning Long
     * 
     * 6. Challenge: Create `String.toRecipe()` that parses "name|time|ingredients"
     *    Returns a Recipe data class instance
     */
    
    println("\n" + "=".repeat(60))
    println("🔧 Extension Functions Mastered! You've added magic powers!")
    println("=".repeat(60))
    
    println("""
        
        💡 QUICK TIPS:
        • Extensions DON'T modify original class
        • Can't access PRIVATE members
        • Member functions ALWAYS win over extensions
        • Use for utilities, NOT for core logic
        • Extensions are STATIC under the hood
        
    """.trimIndent())
}
