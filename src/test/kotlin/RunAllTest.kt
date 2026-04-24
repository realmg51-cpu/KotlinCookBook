/**
 * Run all tests for KotlinCookBook
 * Tests top-level functions and code structure
 */

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.io.File

fun captureOutput(block: () -> Unit): String {
    val out = ByteArrayOutputStream()
    System.setOut(PrintStream(out))
    block()
    System.setOut(System.out)
    return out.toString()
}

fun testFileExists(path: String): Boolean {
    return File(path).exists()
}

fun testFileContains(path: String, vararg keywords: String): Boolean {
    val content = File(path).readText()
    return keywords.all { content.contains(it) }
}

// ===== HELLOWORLD TESTS =====

fun testHelloWorld() {
    val path = "src/kotlin/normal/GettingStarted/HelloWorld.kt"
    
    assert(testFileExists(path)) { "HelloWorld.kt not found" }
    assert(testFileContains(path, "fun main", "println", "Hello")) {
        "HelloWorld.kt missing required content"
    }
}

// ===== VARIABLES TESTS =====

fun testVariables() {
    val paths = listOf(
        "src/kotlin/normal/Variables/ImmutableVariables.kt",
        "src/kotlin/normal/Variables/MutableVariables.kt",
        "src/kotlin/normal/Variables/CommonVariables.kt"
    )
    
    for (path in paths) {
        assert(testFileExists(path)) { "File not found: $path" }
    }
    
    assert(testFileContains(paths[0], "val")) { "ImmutableVariables missing 'val'" }
    assert(testFileContains(paths[1], "var")) { "MutableVariables missing 'var'" }
    assert(testFileContains(paths[2], "Int", "String", "Double")) {
        "CommonVariables missing data types"
    }
}

// ===== LOOPS TESTS =====

fun testLoops() {
    val paths = listOf(
        "src/kotlin/normal/Loops/For/ForStirring.kt",
        "src/kotlin/normal/Loops/While/WhileStirring.kt",
        "src/kotlin/normal/Loops/Do-While/DoWhileStirring.kt",
        "src/kotlin/normal/BreakAndContinue/Break.kt",
        "src/kotlin/normal/BreakAndContinue/Continue.kt"
    )
    
    for (path in paths) {
        assert(testFileExists(path)) { "File not found: $path" }
    }
    
    assert(testFileContains(paths[0], "for")) { "ForStirring missing 'for'" }
    assert(testFileContains(paths[1], "while")) { "WhileStirring missing 'while'" }
    assert(testFileContains(paths[2], "do")) { "DoWhileStirring missing 'do'" }
    assert(testFileContains(paths[3], "break")) { "Break missing 'break'" }
    assert(testFileContains(paths[4], "continue")) { "Continue missing 'continue'" }
}

// ===== NULL SAFETY TESTS =====

fun testNullSafety() {
    val path = "src/kotlin/normal/InputAndNullSafety/InputAndNullSafety.kt"
    
    assert(testFileExists(path)) { "InputAndNullSafety.kt not found" }
    assert(testFileContains(path, "?.", "?:", "let", "toIntOrNull")) {
        "InputAndNullSafety missing null safety operators"
    }
}

// ===== FUNCTIONS TESTS =====

fun testFunctions() {
    val paths = listOf(
        "src/kotlin/normal/Functions/BasicFunctions/BasicFunctions.kt",
        "src/kotlin/normal/Functions/LambdaFunctions/LambdaFunctions.kt"
    )
    
    for (path in paths) {
        assert(testFileExists(path)) { "File not found: $path" }
    }
    
    assert(testFileContains(paths[0], "fun", "return")) {
        "BasicFunction missing function syntax"
    }
    
    assert(testFileContains(paths[1], "{", "->", "it")) {
        "LambdaFunction missing lambda syntax"
    }
}

// ===== MAIN TEST RUNNER =====

fun main() {
    println("🧪 KotlinCookBook - Running All Tests")
    println("======================================")
    
    val tests = mapOf(
        "HelloWorld" to ::testHelloWorld,
        "Variables" to ::testVariables,
        "Loops" to ::testLoops,
        "NullSafety" to ::testNullSafety,
        "Functions" to ::testFunctions
    )
    
    var passed = 0
    var failed = 0
    
    for ((name, test) in tests) {
        print("Testing $name... ")
        try {
            test()
            println("✅ PASS")
            passed++
        } catch (e: Exception) {
            println("❌ FAIL")
            println("   Error: ${e.message}")
            failed++
        }
    }
    
    println("\n" + "=".repeat(50))
    println("📊 Results: $passed passed, $failed failed")
    
    if (failed > 0) {
        println("💥 Some tests failed!")
        error("Test suite failed with $failed failures")
    } else {
        println("🎉 All tests passed!")
    }
}
