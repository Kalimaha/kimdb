package blog.guidobarbaglia.kimdb.models

import org.junit.jupiter.api.Nested
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.BeforeEach

class GreetingTest {
    lateinit var greeting: Greeting

    @BeforeEach
    fun init() {
        greeting = Greeting(id = "74b335a2-c996-43d6-873d-cd390633db59", name = "Spam")
    }

    @Nested
    inner class ToString {
        @Test
        fun `it formats the output`() {
            assertThat(greeting.toString()).isEqualTo("Hallo, Spam!")
        }
    }
}