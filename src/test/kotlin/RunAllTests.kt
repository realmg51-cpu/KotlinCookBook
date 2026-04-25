import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import java.io.File

// ==================== TOP-LEVEL HELPER FUNCTIONS ====================

private fun assertFileExists(path: String) {
    assertTrue(File(path).exists(), "File not found: $path")
}

private fun assertFileIsReadable(path: String) {
    val file = File(path)
    assertTrue(file.exists(), "File not found: $path")
    assertTrue(file.canRead(), "File is not readable: $path")
    assertTrue(file.length() > 0, "File is empty: $path")
}

// ==================== TEST CLASSES ====================

@Nested
@DisplayName("Getting Started Tests")
class GettingStartedTests {
    
    @Test
    @DisplayName("HelloWorld.kt exists and is readable")
    fun testHelloWorld() {
        val path = "src/kotlin/normal/GettingStarted/HelloWorld.kt"
        assertFileExists(path)
        assertFileIsReadable(path)
    }
}

@Nested
@DisplayName("Variables Tests")
class VariablesTests {
    
    @Test
    @DisplayName("ImmutableVariables.kt exists")
    fun testImmutableVariables() {
        val path = "src/kotlin/normal/Variables/ImmutableVariables.kt"
        assertFileExists(path)
    }

    @Test
    @DisplayName("MutableVariables.kt exists")
    fun testMutableVariables() {
        val path = "src/kotlin/normal/Variables/MutableVariables.kt"
        assertFileExists(path)
    }

    @Test
    @DisplayName("CommonVariables.kt exists")
    fun testCommonVariables() {
        val path = "src/kotlin/normal/Variables/CommonVariables.kt"
        assertFileExists(path)
    }

    @Test
    @DisplayName("StringSplitter.kt exists")
    fun testStringSplitter() {
        val path = "src/kotlin/normal/Variables/WorkWithIt/StringSplitter.kt"
        assertFileExists(path)
    }

    @Test
    @DisplayName("StringSplitterv2.kt exists")
    fun testStringSplitterV2() {
        val path = "src/kotlin/normal/Variables/WorkWithIt/StringSplitterv2.kt"
        assertFileExists(path)
    }
}

@Nested
@DisplayName("If Chef Tests")
class IfChefTests {
    
    @Test
    @DisplayName("IfChef.kt exists")
    fun testIfChef() {
        val path = "src/kotlin/normal/IfChef/IfChef.kt"
        assertFileExists(path)
    }
}

@Nested
@DisplayName("When Chef Tests")
class WhenChefTests {
    
    @Test
    @DisplayName("WhenChef.kt exists")
    fun testWhenChef() {
        val path = "src/kotlin/normal/WhenChef/WhenChef.kt"
        assertFileExists(path)
    }
}

@Nested
@DisplayName("Loops Tests")
class LoopsTests {
    
    @Test
    @DisplayName("ForStirring.kt exists")
    fun testForLoop() {
        val path = "src/kotlin/normal/Loops/For/ForStirring.kt"
        assertFileExists(path)
    }

    @Test
    @DisplayName("WhileStirring.kt exists")
    fun testWhileLoop() {
        val path = "src/kotlin/normal/Loops/While/WhileStirring.kt"
        assertFileExists(path)
    }

    @Test
    @DisplayName("DoWhileStirring.kt exists")
    fun testDoWhileLoop() {
        val path = "src/kotlin/normal/Loops/Do-While/DoWhileStirring.kt"
        assertFileExists(path)
    }
}

@Nested
@DisplayName("Break and Continue Tests")
class BreakContinueTests {
    
    @Test
    @DisplayName("Break.kt exists")
    fun testBreak() {
        val path = "src/kotlin/normal/BreakAndContinue/Break.kt"
        assertFileExists(path)
    }

    @Test
    @DisplayName("Continue.kt exists")
    fun testContinue() {
        val path = "src/kotlin/normal/BreakAndContinue/Continue.kt"
        assertFileExists(path)
    }
}

@Nested
@DisplayName("Null Safety Tests")
class NullSafetyTests {
    
    @Test
    @DisplayName("InputAndNullSafety.kt exists")
    fun testNullSafety() {
        val path = "src/kotlin/normal/InputAndNullSafety/InputAndNullSafety.kt"
        assertFileExists(path)
    }
}

@Nested
@DisplayName("Functions Tests")
class FunctionsTests {
    
    @Test
    @DisplayName("BasicFunctions.kt exists")
    fun testBasicFunctions() {
        val path = "src/kotlin/normal/Functions/BasicFunctions/BasicFunctions.kt"
        assertFileExists(path)
    }

    @Test
    @DisplayName("LambdaFunctions.kt exists")
    fun testLambdaFunctions() {
        val path = "src/kotlin/normal/Functions/LambdaFunctions/LambdaFunctions.kt"
        assertFileExists(path)
    }
}
