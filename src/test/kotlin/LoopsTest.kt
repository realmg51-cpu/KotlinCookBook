import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LoopsTest {

    @Test
    fun testForLoop() {
        var sum = 0
        for (i in 1..5) {
            sum += i
        }
        assertEquals(15, sum)
    }

    @Test
    fun testWhileLoop() {
        var count = 0
        while (count < 5) {
            count++
        }
        assertEquals(5, count)
    }

    @Test
    fun testDoWhileLoop() {
        var count = 5
        do {
            count++
        } while (count < 3)  // Condition false, but runs once
        
        assertEquals(6, count)
    }

    @Test
    fun testBreakAndContinue() {
        var result = ""
        
        for (i in 1..5) {
            if (i == 3) continue
            if (i == 5) break
            result += i
        }
        
        assertEquals("124", result)
    }
}
