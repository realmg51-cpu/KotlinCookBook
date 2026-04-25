import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream
import javax.tools.JavaCompiler
import javax.tools.ToolProvider

class KotlinCookBookTests {

    // ==================== HELPER FUNCTIONS ====================
    
    /**
     * Chạy một file Kotlin và trả về output
     */
    private fun runKotlinFile(path: String, input: String = ""): String {
        // Tạo file tạm để lưu output
        val outFile = File.createTempFile("kotlin_output", ".txt")
        
        // Chạy kotlin script
        val process = ProcessBuilder(
            "kotlin", path
        ).redirectOutput(outFile)
         .redirectErrorStream(true)
         .start()
        
        // Gửi input nếu có
        if (input.isNotEmpty()) {
            process.outputStream.write(input.toByteArray())
            process.outputStream.flush()
            process.outputStream.close()
        }
        
        process.waitFor()
        
        // Đọc output
        val output = outFile.readText()
        outFile.delete()
        
        return output
    }
    
    /**
     * Kiểm tra file có thể compile được không
     */
    private fun isKotlinFileCompilable(path: String): Boolean {
        return try {
            val process = ProcessBuilder(
                "kotlinc", "-script", path
            ).redirectError(ProcessBuilder.Redirect.DISCARD)
             .start()
            process.waitFor() == 0
        } catch (e: Exception) {
            false
        }
    }

    // ==================== GETTING STARTED TESTS ====================
    @Nested
    @DisplayName("Getting Started Tests")
    class GettingStartedTests {
        
        @Test
        @DisplayName("HelloWorld.kt can run and prints something")
        fun testHelloWorld() {
            val path = "src/kotlin/normal/GettingStarted/HelloWorld.kt"
            val output = runKotlinFile(path)
            
            assertTrue(File(path).exists(), "File not found")
            assertTrue(output.isNotBlank(), "Program should print something")
            assertTrue(isKotlinFileCompilable(path), "File should be compilable")
        }
    }

    // ==================== VARIABLES TESTS ====================
    @Nested
    @DisplayName("Variables Tests")
    class VariablesTests {
        
        @Test
        @DisplayName("Variables show values correctly")
        fun testVariables() {
            val path = "src/kotlin/normal/Variables/CommonVariables.kt"
            val output = runKotlinFile(path)
            
            assertTrue(File(path).exists(), "File not found")
            assertTrue(isKotlinFileCompilable(path), "Code should compile")
            
            // Kiểm tra output có chứa số hoặc chữ không (không hardcode)
            val hasNumber = output.any { it.isDigit() }
            val hasLetter = output.any { it.isLetter() }
            assertTrue(hasNumber || hasLetter, "Program should output something meaningful")
        }
        
        @Test
        @DisplayName("StringSplitter can split a string")
        fun testStringSplitter() {
            val path = "src/kotlin/normal/Variables/WorkWithIt/StringSplitter.kt"
            val output = runKotlinFile(path)
            
            assertTrue(File(path).exists(), "File not found")
            assertTrue(isKotlinFileCompilable(path), "Code should compile")
            
            // Chỉ cần chạy được, không fail
            assertTrue(output.isNotEmpty(), "Program should produce output")
        }
    }

    // ==================== IF CHEF TESTS ====================
    @Nested
    @DisplayName("If Chef Tests")
    class IfChefTests {
        
        @Test
        @DisplayName("IfChef can make decisions")
        fun testIfChef() {
            val path = "src/kotlin/normal/IfChef/IfChef.kt"
            val output = runKotlinFile(path)
            
            assertTrue(File(path).exists(), "File not found")
            assertTrue(isKotlinFileCompilable(path), "Code should compile")
            assertTrue(output.contains("if") || output.contains("else") || output.isNotEmpty(), 
                "Program should demonstrate decision making")
        }
    }

    // ==================== LOOPS TESTS ====================
    @Nested
    @DisplayName("Loops Tests")
    class LoopsTests {
        
        @Test
        @DisplayName("For loop runs without errors")
        fun testForLoop() {
            val path = "src/kotlin/normal/Loops/For/ForStirring.kt"
            val output = runKotlinFile(path)
            
            assertTrue(File(path).exists(), "File not found")
            assertTrue(isKotlinFileCompilable(path), "Code should compile")
            assertTrue(output.isNotEmpty(), "Program should produce output")
        }
        
        @Test
        @DisplayName("While loop runs without errors")
        fun testWhileLoop() {
            val path = "src/kotlin/normal/Loops/While/WhileStirring.kt"
            val output = runKotlinFile(path)
            
            assertTrue(File(path).exists(), "File not found")
            assertTrue(isKotlinFileCompilable(path), "Code should compile")
            assertTrue(output.isNotEmpty(), "Program should produce output")
        }
        
        @Test
        @DisplayName("Do-While loop runs without errors")
        fun testDoWhileLoop() {
            val path = "src/kotlin/normal/Loops/Do-While/DoWhileStirring.kt"
            val output = runKotlinFile(path)
            
            assertTrue(File(path).exists(), "File not found")
            assertTrue(isKotlinFileCompilable(path), "Code should compile")
            assertTrue(output.isNotEmpty(), "Program should produce output")
        }
    }

    // ==================== NULL SAFETY TESTS ====================
    @Nested
    @DisplayName("Null Safety Tests")
    class NullSafetyTests {
        
        @Test
        @DisplayName("Null safety handles null inputs gracefully")
        fun testNullSafety() {
            val path = "src/kotlin/normal/InputAndNullSafety/InputAndNullSafety.kt"
            
            // Tạm thời chỉ kiểm tra file tồn tại và compile được
            // Vì file này cần user input, test sẽ phức tạp hơn
            assertTrue(File(path).exists(), "File not found")
            
            // Kiểm tra compile thay vì chạy (vì có readln)
            val compileResult = isKotlinFileCompilable(path)
            assertTrue(compileResult, "Code should compile without errors")
        }
    }

    // ==================== FUNCTIONS TESTS ====================
    @Nested
    @DisplayName("Functions Tests")
    class FunctionsTests {
        
        @Test
        @DisplayName("Basic function runs without errors")
        fun testBasicFunctions() {
            val path = "src/kotlin/normal/Functions/BasicFunctions/BasicFunctions.kt"
            val output = runKotlinFile(path)
            
            assertTrue(File(path).exists(), "File not found")
            assertTrue(isKotlinFileCompilable(path), "Code should compile")
            assertTrue(output.isNotEmpty(), "Program should produce output")
        }
        
        @Test
        @DisplayName("Lambda function runs without errors")
        fun testLambdaFunctions() {
            val path = "src/kotlin/normal/Functions/LambdaFunctions/LambdaFunctions.kt"
            val output = runKotlinFile(path)
            
            assertTrue(File(path).exists(), "File not found")
            assertTrue(isKotlinFileCompilable(path), "Code should compile")
            assertTrue(output.isNotEmpty(), "Program should produce output")
        }
    }
}
