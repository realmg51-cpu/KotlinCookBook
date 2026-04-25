import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import java.io.File
import java.io.ByteArrayOutputStream
import java.io.PrintStream

// ==================== TOP-LEVEL HELPER FUNCTIONS ====================

/**
 * Chạy một file Kotlin và trả về output
 */
private fun runKotlinFile(path: String, input: String = ""): String {
    return try {
        val process = ProcessBuilder("kotlin", path)
            .start()
        
        if (input.isNotEmpty()) {
            process.outputStream.write(input.toByteArray())
            process.outputStream.flush()
            process.outputStream.close()
        }
        
        process.waitFor()
        process.inputStream.bufferedReader().readText()
    } catch (e: Exception) {
        "Error: ${e.message}"
    }
}

/**
 * Kiểm tra file có thể compile được không
 */
private fun isKotlinFileCompilable(path: String): Boolean {
    return try {
        val process = ProcessBuilder("kotlinc", "-script", path)
            .redirectError(ProcessBuilder.Redirect.DISCARD)
            .start()
        process.waitFor() == 0
    } catch (e: Exception) {
        false
    }
}

private fun assertFileExists(path: String) {
    assertTrue(File(path).exists(), "File not found: $path")
}

// ==================== TEST CLASSES ====================

@Nested
@DisplayName("Getting Started Tests")
class GettingStartedTests {
    
    @Test
    @DisplayName("HelloWorld.kt can run and prints something")
    fun testHelloWorld() {
        val path = "src/kotlin/normal/GettingStarted/HelloWorld.kt"
        assertFileExists(path)
        
        val output = runKotlinFile(path)
        assertTrue(output.isNotBlank(), "Program should print something")
        assertTrue(isKotlinFileCompilable(path), "File should be compilable")
    }
}

@Nested
@DisplayName("Variables Tests")
class VariablesTests {
    
    @Test
    @DisplayName("ImmutableVariables.kt exists and compiles")
    fun testImmutableVariables() {
        val path = "src/kotlin/normal/Variables/ImmutableVariables.kt"
        assertFileExists(path)
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }

    @Test
    @DisplayName("MutableVariables.kt exists and compiles")
    fun testMutableVariables() {
        val path = "src/kotlin/normal/Variables/MutableVariables.kt"
        assertFileExists(path)
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }

    @Test
    @DisplayName("CommonVariables.kt exists and compiles")
    fun testCommonVariables() {
        val path = "src/kotlin/normal/Variables/CommonVariables.kt"
        assertFileExists(path)
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }

    @Test
    @DisplayName("StringSplitter.kt runs successfully")
    fun testStringSplitter() {
        val path = "src/kotlin/normal/Variables/WorkWithIt/StringSplitter.kt"
        assertFileExists(path)
        
        val output = runKotlinFile(path)
        assertTrue(output.isNotEmpty(), "Program should produce output")
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }

    @Test
    @DisplayName("StringSplitterv2.kt runs successfully")
    fun testStringSplitterV2() {
        val path = "src/kotlin/normal/Variables/WorkWithIt/StringSplitterv2.kt"
        assertFileExists(path)
        
        val output = runKotlinFile(path)
        assertTrue(output.isNotEmpty(), "Program should produce output")
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }
}

@Nested
@DisplayName("If Chef Tests")
class IfChefTests {
    
    @Test
    @DisplayName("IfChef.kt exists and compiles")
    fun testIfChef() {
        val path = "src/kotlin/normal/IfChef/IfChef.kt"
        assertFileExists(path)
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }
}

@Nested
@DisplayName("When Chef Tests")
class WhenChefTests {
    
    @Test
    @DisplayName("WhenChef.kt exists and compiles")
    fun testWhenChef() {
        val path = "src/kotlin/normal/WhenChef/WhenChef.kt"
        assertFileExists(path)
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }
}

@Nested
@DisplayName("Loops Tests")
class LoopsTests {
    
    @Test
    @DisplayName("ForStirring.kt runs successfully")
    fun testForLoop() {
        val path = "src/kotlin/normal/Loops/For/ForStirring.kt"
        assertFileExists(path)
        
        val output = runKotlinFile(path)
        assertTrue(output.isNotEmpty(), "Program should produce output")
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }

    @Test
    @DisplayName("WhileStirring.kt runs successfully")
    fun testWhileLoop() {
        val path = "src/kotlin/normal/Loops/While/WhileStirring.kt"
        assertFileExists(path)
        
        val output = runKotlinFile(path)
        assertTrue(output.isNotEmpty(), "Program should produce output")
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }

    @Test
    @DisplayName("DoWhileStirring.kt runs successfully")
    fun testDoWhileLoop() {
        val path = "src/kotlin/normal/Loops/Do-While/DoWhileStirring.kt"
        assertFileExists(path)
        
        val output = runKotlinFile(path)
        assertTrue(output.isNotEmpty(), "Program should produce output")
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }
}

@Nested
@DisplayName("Break and Continue Tests")
class BreakContinueTests {
    
    @Test
    @DisplayName("Break.kt exists and compiles")
    fun testBreak() {
        val path = "src/kotlin/normal/BreakAndContinue/Break.kt"
        assertFileExists(path)
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }

    @Test
    @DisplayName("Continue.kt exists and compiles")
    fun testContinue() {
        val path = "src/kotlin/normal/BreakAndContinue/Continue.kt"
        assertFileExists(path)
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }
}

@Nested
@DisplayName("Null Safety Tests")
class NullSafetyTests {
    
    @Test
    @DisplayName("InputAndNullSafety.kt compiles successfully")
    fun testNullSafety() {
        val path = "src/kotlin/normal/InputAndNullSafety/InputAndNullSafety.kt"
        assertFileExists(path)
        
        // Chỉ kiểm tra compile, không chạy vì có readln() cần input
        val compiles = isKotlinFileCompilable(path)
        assertTrue(compiles, "Code should compile without errors")
    }
}

@Nested
@DisplayName("Functions Tests")
class FunctionsTests {
    
    @Test
    @DisplayName("BasicFunctions.kt runs successfully")
    fun testBasicFunctions() {
        val path = "src/kotlin/normal/Functions/BasicFunctions/BasicFunctions.kt"
        assertFileExists(path)
        
        val output = runKotlinFile(path)
        assertTrue(output.isNotEmpty(), "Program should produce output")
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }

    @Test
    @DisplayName("LambdaFunctions.kt runs successfully")
    fun testLambdaFunctions() {
        val path = "src/kotlin/normal/Functions/LambdaFunctions/LambdaFunctions.kt"
        assertFileExists(path)
        
        val output = runKotlinFile(path)
        assertTrue(output.isNotEmpty(), "Program should produce output")
        assertTrue(isKotlinFileCompilable(path), "Code should compile")
    }
}
