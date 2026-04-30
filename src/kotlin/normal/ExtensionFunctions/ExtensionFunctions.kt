/**
 * Recipe: Extension Functions 🔧
 * 
 * Learn: Add new functions to existing classes without inheritance
 * 
 * Kitchen analogy: Magic stickers that add abilities to any kitchen tool!
 * 
 * @author realmg51-cpu
 * @since April 2026
 */

// Extension properties must be at TOP LEVEL (outside main)
val String.wordCount: Int
    get() = this.trim().split(Regex("\\s+")).size

val Int.isOdd: Boolean
    get() = this % 2 != 0

val <T> List<T>.hasItems: Boolean
    get() = this.isNotEmpty()

fun main() {
    println("🔧 EXTENSION FUNCTIONS\n")
    
    // PART 1: Basic Extensions
    fun String.addEmoji() = "$this 🍳"
    fun String.shout() = "${this.uppercase()}!!!"
    fun Int.square() = this * this
    
    println("pizza".addEmoji())
    println("hello".shout())
    println("5 squared = ${5.square()}")
    
    // PART 2: Extensions with parameters
    fun String.repeatTimes(times: Int) = this.repeat(times)
    fun Int.addAndMultiply(add: Int, multiply: Int) = (this + add) * multiply
    
    println("Yum ".repeatTimes(3))
    println("(5+2)*3 = ${5.addAndMultiply(2, 3)}")
    
    // PART 3: Useful real-world extensions
    fun String.isEmail() = contains("@") && contains(".")
    fun String.reverseWords() = split(" ").reversed().joinToString(" ")
    
    println("chef@kitchen.com is email? ${"chef@kitchen.com".isEmail()}")
    println("Kotlin is awesome".reverseWords())
    
    // PART 4: Generic extensions
    fun <T> List<T>.secondOrNull() = getOrNull(1)
    fun <T> List<T>.middle() = getOrNull(size / 2)
    
    val fruits = listOf("Apple", "Banana", "Cherry")
    println("Second fruit: ${fruits.secondOrNull()}")
    println("Middle fruit: ${fruits.middle()}")
    
    // PART 5: Extension properties (from top level)
    val sentence = "The quick brown fox"
    println("'$sentence' has ${sentence.wordCount} words")
    println("7 is odd? ${7.isOdd}")
    println("Empty list has items? ${emptyList<String>().hasItems}")
    
    // PART 6: Kitchen-themed extensions 🍳
    fun String.fry() = "🔥 Fried $this 🔥"
    fun String.boil() = "💧 Boiled $this 💧"
    fun String.asEmoji() = when (lowercase()) {
        "pizza" -> "🍕"
        "burger" -> "🍔"
        "sushi" -> "🍣"
        else -> "🍽️"
    }
    
    println("potato".fry())
    println("Sushi".asEmoji())
    
    // PART 7: List extension
    fun List<String>.printMenu(): String {
        return this.mapIndexed { index, item -> 
            "${index + 1}. ${item.asEmoji()} $item"
        }.joinToString("\n")
    }
    
    val menu = listOf("Pizza", "Burger", "Sushi")
    println("\nMenu:\n${menu.printMenu()}")
    
    // PART 8: Nullable extensions
    fun String?.orEmpty(default: String) = this ?: default
    fun String?.safeLength() = this?.length ?: 0
    
    val name: String? = null
    println("Name: ${name.orEmpty("Guest")}")
    println("Null length: ${(null as String?).safeLength()}")
    
    // PART 9: Extension vs member function
    class Recipe(val name: String) {
        fun cook() = "Cooking $name 🍳"
    }
    
    fun Recipe.premiumCook() = "🌟 PREMIUM ${this.name} 🌟"
    
    val recipe = Recipe("Pasta")
    println(recipe.cook())  // Member function
    println(recipe.premiumCook())  // Extension
    
    /* 🍳 TRY IT YOURSELF:
     * 1. Create String.toSlug() -> "Hello World!" -> "hello-world"
     * 2. Create Int.isPrime() checking prime numbers
     * 3. Create List<T>.secondLast() returning second-to-last element
     * 4. Create String.isPalindrome extension property
     */
    
    println("\n✅ Extension Functions Mastered! 🔧")
}
