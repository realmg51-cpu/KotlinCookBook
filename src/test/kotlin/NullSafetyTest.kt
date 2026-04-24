import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NullSafetyTest {

    @Test
    fun testNullableTypes() {
        var nullable: String? = null
        assertNull(nullable)
        
        nullable = "Hello"
        assertNotNull(nullable)
    }

    @Test
    fun testSafeCall() {
        val text: String? = null
        val length = text?.length
        assertNull(length)
        
        val text2: String? = "Kotlin"
        val length2 = text2?.length
        assertEquals(6, length2)
    }

    @Test
    fun testElvisOperator() {
        val text: String? = null
        val result = text ?: "default"
        assertEquals("default", result)
        
        val text2: String? = "real"
        val result2 = text2 ?: "default"
        assertEquals("real", result2)
    }

    @Test
    fun testLetScope() {
        var executed = false
        val text: String? = "test"
        
        text?.let {
            executed = true
            assertEquals("test", it)
        }
        
        assertTrue(executed)
    }
}
