package blog.guidobarbaglia.kimdb.services

import blog.guidobarbaglia.kimdb.models.Greeting
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GreetingServiceTest {
    @Autowired
    lateinit var greetingService: GreetingService

    @Nested
    inner class BuildGreetingFor {
        @Test
        fun `it builds a greeting from a name`() {
            assertThat(greetingService.buildGreetingFor("Spam")).isEqualTo(Greeting(name = "Spam"))
        }
    }
}