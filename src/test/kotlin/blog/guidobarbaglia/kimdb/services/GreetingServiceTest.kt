package blog.guidobarbaglia.kimdb.services

import blog.guidobarbaglia.kimdb.models.Greeting
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class GreetingServiceTest {
    @Autowired
    lateinit var greetingService: GreetingService

    @Test
    fun `it builds a greeting from a name`() {
        assertThat(greetingService.buildGreetingFor("Spam")).isEqualTo(Greeting(name = "Spam"))
    }
}