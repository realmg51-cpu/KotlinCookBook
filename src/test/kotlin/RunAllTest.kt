import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import java.io.File

// Helper functions ở top-level
private fun assertFileExists(path: String, message: String? = null) {
    assertTrue(File(path).exists(), message ?: "File not found: $path")
}

private fun assertFileContains(path: String, vararg keywords: String) {
    val content = File(path).readText()
    keywords.forEach { keyword ->
        assertTrue(content.contains(keyword), "File $path missing keyword: '$keyword'")
    }
}

class KotlinCookBookTests {

    // ==================== GETTING STARTED TESTS ====================
    @Nested
    @DisplayName("Getting Started Tests")
    class GettingStartedTests {
        
        @Test
        @DisplayName("HelloWorld.kt exists and has correct syntax")
        fun testHelloWorld() {
            val path = "src/kotlin/normal/GettingStarted/HelloWorld.kt"
            assertFileExists(path)
            assertFileContains(path, "fun main", "println", "Hello")
        }
    }

    // ==================== VARIABLES TESTS ====================
    @Nested
    @DisplayName("Variables Tests")
    class VariablesTests {
        
        @Test
        @DisplayName("ImmutableVariables.kt uses 'val'")
        fun testImmutableVariables() {
            val path = "src/kotlin/normal/Variables/ImmutableVariables.kt"
            assertFileExists(path)
            assertFileContains(path, "val")
        }

        @Test
        @DisplayName("MutableVariables.kt uses 'var'")
        fun testMutableVariables() {
            val path = "src/kotlin/normal/Variables/MutableVariables.kt"
            assertFileExists(path)
            assertFileContains(path, "var")
        }

        @Test
        @DisplayName("CommonVariables.kt has data types")
        fun testCommonVariables() {
            val path = "src/kotlin/normal/Variables/CommonVariables.kt"
            assertFileExists(path)
            assertFileContains(path, "Int", "String", "Double")
        }

        @Test
        @DisplayName("StringSplitter.kt exists and has string functions")
        fun testStringSplitter() {
            val path = "src/kotlin/normal/Variables/WorkWithIt/StringSplitter.kt"
            assertFileExists(path)
            assertFileContains(path, "split", "println")
        }

        @Test
        @DisplayName("StringSplitterv2.kt exists and has string functions")
        fun testStringSplitterV2() {
            val path = "src/kotlin/normal/Variables/WorkWithIt/StringSplitterv2.kt"
            assertFileExists(path)
            assertFileContains(path, "split", "println")
        }
    }

    // ==================== IF CHEF TESTS ====================
    @Nested
    @DisplayName("If Chef Tests")
    class IfChefTests {
        
        @Test
        @DisplayName("IfChef.kt exists and has if-else")
        fun testIfChef() {
            val path = "src/kotlin/normal/IfChef/IfChef.kt"
            assertFileExists(path)
            assertFileContains(path, "if", "else")
        }
    }

    // ==================== WHEN CHEF TESTS ====================
    @Nested
    @DisplayName("When Chef Tests")
    class WhenChefTests {
        
        @Test
        @DisplayName("WhenChef.kt exists and has when expression")
        fun testWhenChef() {
            val path = "src/kotlin/normal/WhenChef/WhenChef.kt"
            assertFileExists(path)
            assertFileContains(path, "when", "->", "else")
        }
    }

    // ==================== LOOPS TESTS ====================
    @Nested
    @DisplayName("Loops Tests")
    class LoopsTests {
        
        @Test
        @DisplayName("ForStirring.kt exists and has for loop")
        fun testForLoop() {
            val path = "src/kotlin/normal/Loops/For/ForStirring.kt"
            assertFileExists(path)
            assertFileContains(path, "for")
        }

        @Test
        @DisplayName("WhileStirring.kt exists and has while loop")
        fun testWhileLoop() {
            val path = "src/kotlin/normal/Loops/While/WhileStirring.kt"
            assertFileExists(path)
            assertFileContains(path, "while")
        }

        @Test
        @DisplayName("DoWhileStirring.kt exists and has do-while loop")
        fun testDoWhileLoop() {
            val path = "src/kotlin/normal/Loops/Do-While/DoWhileStirring.kt"
            assertFileExists(path)
            assertFileContains(path, "do", "while")
        }
    }

    // ==================== BREAK & CONTINUE TESTS ====================
    @Nested
    @DisplayName("Break and Continue Tests")
    class BreakContinueTests {
        
        @Test
        @DisplayName("Break.kt exists and has break keyword")
        fun testBreak() {
            val path = "src/kotlin/normal/BreakAndContinue/Break.kt"
            assertFileExists(path)
            assertFileContains(path, "break")
        }

        @Test
        @DisplayName("Continue.kt exists and has continue keyword")
        fun testContinue() {
            val path = "src/kotlin/normal/BreakAndContinue/Continue.kt"
            assertFileExists(path)
            assertFileContains(path, "continue")
        }
    }

    // ==================== NULL SAFETY TESTS ====================
    @Nested
    @DisplayName("Null Safety Tests")
    class NullSafetyTests {
        
        @Test
        @DisplayName("InputAndNullSafety.kt exists and has null safety operators")
        fun testNullSafety() {
            val path = "src/kotlin/normal/InputAndNullSafety/InputAndNullSafety.kt"
            assertFileExists(path)
            assertFileContains(path, "?.", "?:", "let", "toIntOrNull")
        }
    }

    // ==================== FUNCTIONS TESTS ====================
    @Nested
    @DisplayName("Functions Tests")
    class FunctionsTests {
        
        @Test
        @DisplayName("BasicFunctions.kt exists and has function syntax")
        fun testBasicFunctions() {
            val path = "src/kotlin/normal/Functions/BasicFunctions/BasicFunctions.kt"
            assertFileExists(path)
            assertFileContains(path, "fun", "return")
        }

        @Test
        @DisplayName("LambdaFunctions.kt exists and has lambda syntax")
        fun testLambdaFunctions() {
            val path = "src/kotlin/normal/Functions/LambdaFunctions/LambdaFunctions.kt"
            assertFileExists(path)
            assertFileContains(path, "{", "->", "it")
        }
    }
}
