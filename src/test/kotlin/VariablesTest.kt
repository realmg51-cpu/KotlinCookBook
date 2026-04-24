import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class VariablesTest {

    @Test
    fun testValVsVar() {
        val immutable = "cannot change"
        // immutable = "new" // compile error - can't change
        
        var mutable = "can change"
        mutable = "changed"
        assertEquals("changed", mutable)
    }

    @Test
    fun testDataTypes() {
        val intNum: Int = 10
        val doubleNum: Double = 3.14
        val charLetter: Char = 'A'
        val stringText: String = "Kotlin"
        
        assertEquals(10, intNum)
        assertEquals(3.14, doubleNum, 0.01)
        assertEquals('A', charLetter)
        assertEquals("Kotlin", stringText)
    }

    @Test
    fun testStringManipulation() {
        val text = "Hello, Kotlin!"
        
        assertEquals("Hello", text.substringBefore(","))
        assertEquals(" Kotlin!", text.substringAfter(","))
        assertEquals(14, text.length)
    }
}
