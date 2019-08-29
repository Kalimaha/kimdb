package blog.guidobarbaglia.kimdb.models

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach

class GreetingTest {
    lateinit var greeting: Greeting

    @BeforeEach
    fun init() {
        greeting = Greeting(name = "Spam")
    }

    @Nested
    inner class ToString {
        @Test
        fun `it formats the output`() {
            assertThat(greeting.toString()).isEqualTo("Hallo, Spam!")
        }
    }
}