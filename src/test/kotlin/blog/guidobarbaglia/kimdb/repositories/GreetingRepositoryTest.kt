package blog.guidobarbaglia.kimdb.repositories

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class GreetingRepositoryTest {
    @Autowired
    lateinit var greetingRepository: GreetingRepository

    @Test
    fun `retrieves all the greetings`() {
        assertThat(greetingRepository.findAll()).isEmpty()
    }
}