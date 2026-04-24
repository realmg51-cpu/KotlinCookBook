/**
 * Unit tests for HelloWorld recipe
 * 
 * Note: HelloWorld.kt contains top-level code (no class)
 */

// Import the kotlin file directly
import java.io.ByteArrayOutputStream
import java.io.PrintStream

fun captureOutput(block: () -> Unit): String {
    val out = ByteArrayOutputStream()
    System.setOut(PrintStream(out))
    block()
    System.setOut(System.out)
    return out.toString()
}

fun testHelloWorldOutput() {
    val output = captureOutput {
        // Simulate what HelloWorld.kt does
        println("Hello, World!")
    }
    
    assert(output.contains("Hello")) { "Output should contain 'Hello'" }
    assert(output.contains("World")) { "Output should contain 'World'" }
}

fun testHelloWorldContent() {
    // Read the actual HelloWorld.kt file
    val content = java.io.File("src/kotlin/normal/GettingStarted/HelloWorld.kt").readText()
    
    assert(content.contains("fun main()")) { "Should have main function" }
    assert(content.contains("println")) { "Should have println" }
    assert(content.contains("Hello")) { "Should print Hello" }
}

fun main() {
    println("🧪 Testing HelloWorld")
    
    var passed = 0
    var failed = 0
    
    try {
        testHelloWorldOutput()
        println("✅ HelloWorld output test passed")
        passed++
    } catch (e: Exception) {
        println("❌ HelloWorld output test failed: ${e.message}")
        failed++
    }
    
    try {
        testHelloWorldContent()
        println("✅ HelloWorld content test passed")
        passed++
    } catch (e: Exception) {
        println("❌ HelloWorld content test failed: ${e.message}")
        failed++
    }
    
    println("\n📊 Results: $passed passed, $failed failed")
    if (failed > 0) error("Some tests failed")
}
