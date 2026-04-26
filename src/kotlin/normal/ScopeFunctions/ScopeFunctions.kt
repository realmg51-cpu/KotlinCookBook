/**
 * Recipe: Scope Functions - let, run, with, apply, also
 * 
 * Learn: Write cleaner code by creating temporary scopes
 * 
 * @author Kotlin CookBook
 */

fun main() {
    println("=" .repeat(60))
    println("🔧 KOTLIN SCOPE FUNCTIONS")
    println("=" .repeat(60))
    
    data class Person(var name: String = "", var age: Int = 0, var email: String = "")
    
    // ========== 1. LET - Null Safety & Transform ==========
    println("\n1️⃣ LET - null safety & transform")
    
    val nullableName: String? = "Kotlin"
    
    // Without let (verbose)
    if (nullableName != null) {
        println("Length: ${nullableName.length}")
    }
    
    // With let (clean and safe)
    nullableName?.let {
        println("Length: ${it.length}")
    }
    
    // Transform value
    val doubled = "42".let { it.toInt() * 2 }
    println("42 doubled: $doubled")
    
    // Chain operations
    val result = listOf(1, 2, 3)
        .first()
        .let { it * 2 }
        .let { it + 10 }
    println("Chain result: $result")  // 12
    
    // ========== 2. RUN - Configure + Compute ==========
    println("\n2️⃣ RUN - configure and compute")
    
    val fullName = Person().run {
        name = "John"
        age = 30
        "$name (age $age)"  // Returns this string
    }
    println("Full name: $fullName")
    
    // Compute from object
    val lengthInfo = "Kotlin".run {
        "Length: ${this.length}"
    }
    println(lengthInfo)
    
    // ========== 3. WITH - Batch operations ==========
    println("\n3️⃣ WITH - batch operations")
    
    val person = Person()
    with(person) {
        name = "Alice"
        age = 25
        email = "alice@example.com"
    }
    println("Person after with: $person")
    
    val summary = with(person) {
        "$name ($age) - $email"
    }
    println("Summary: $summary")
    
    // ========== 4. APPLY - Builder pattern ==========
    println("\n4️⃣ APPLY - object configuration")
    
    val car = mutableMapOf<String, Any>().apply {
        put("brand", "Tesla")
        put("model", "Model 3")
        put("year", 2024)
    }
    println("Car: $car")
    
    val numbers = mutableListOf<Int>().apply {
        add(1)
        add(2)
        add(3)
    }.filter { it > 1 }
    println("Numbers after apply + filter: $numbers")
    
    // ========== 5. ALSO - Side effects ==========
    println("\n5️⃣ ALSO - logging and side effects")
    
    val user = Person().apply {
        name = "Bob"
        age = 35
    }.also {
        println("Created user: ${it.name}, age ${it.age}")
        // Can add logging, validation, etc.
    }
    
    // Chain with logging
    val processed = listOf(1, 2, 3, 4, 5)
        .map { it * 2 }
        .also { println("After map: $it") }
        .filter { it > 5 }
        .also { println("After filter: $it") }
        .sum()
    println("Sum: $processed")
    
    // ========== 6. COMPARISON (same operation, all 5) ==========
    println("\n6️⃣ COMPARISON - same operation different results")
    
    val p = Person()
    
    val letResult = p.let {
        it.name = "Let"
        "Returned by let"
    }
    println("let returns: '$letResult', person: $p")
    
    val runResult = p.run {
        name = "Run"
        "Returned by run"
    }
    println("run returns: '$runResult', person: $p")
    
    val withResult = with(p) {
        name = "With"
        "Returned by with"
    }
    println("with returns: '$withResult', person: $p")
    
    val applyResult = p.apply {
        name = "Apply"
        "Returned by apply (ignored)"
    }
    println("apply returns: $applyResult, person: $p")
    
    val alsoResult = p.also {
        it.name = "Also"
        "Returned by also (ignored)"
    }
    println("also returns: $alsoResult, person: $p")
    
    // ========== 7. REAL EXAMPLES ==========
    println("\n7️⃣ REAL EXAMPLES")
    
    // Example 1: Building a config
    val config = mutableMapOf<String, String>().apply {
        put("host", "localhost")
        put("port", "8080")
        put("debug", "true")
    }
    println("Config: $config")
    
    // Example 2: Safe API call
    val data: String? = getDataOrNull()
    data?.let {
        println("Processing: $it")
        processData(it)
    } ?: println("No data available")
    
    // Example 3: Logging chain
    val total = listOf(10, 20, 30)
        .filter { it > 10 }
        .also { println("Filtered: $it") }
        .sum()
        .also { println("Total: $it") }
    
    // Example 4: Object initialization
    val rectangle = Rectangle().apply {
        width = 10
        height = 20
    }.also {
        println("Rectangle area: ${it.width * it.height}")
    }
}

// Helper classes
data class Rectangle(var width: Int = 0, var height: Int = 0)

fun getDataOrNull(): String? = if (System.currentTimeMillis() > 0) "Sample data" else null

fun processData(data: String) {
    println("Processing: $data")
}

/* 🍳 TRY IT YOURSELF:
1. Use `let` to safely print a nullable string's length
2. Use `apply` to create and configure a Person object
3. Use `also` to log each step in a chain of operations
4. Use `run` to calculate the sum of squares of a list
*/
