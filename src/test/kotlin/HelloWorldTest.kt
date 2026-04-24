import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HelloWorldTest {

    @Test
    fun testGreeting() {
        val message = "Hello, World!"
        assertTrue(message.contains("Hello"))
        assertFalse(message.isEmpty())
    }

    @Test
    fun testMainFunction() {
        // Capture output
        val output = captureOutput {
            main()
        }
        assertTrue(output.contains("Hello"))
    }
}

// Helper to capture println output
fun captureOutput(block: () -> Unit): String {
    val out = java.io.ByteArrayOutputStream()
    System.setOut(java.io.PrintStream(out))
    block()
    System.setOut(System.out)
    return out.toString()
}
