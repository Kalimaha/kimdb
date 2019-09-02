package blog.guidobarbaglia.kimdb.repositories

import blog.guidobarbaglia.kimdb.models.Greeting
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.transaction.Transactional

@SpringBootTest
@RunWith(SpringRunner::class)
@Transactional
class GreetingRepositoryTest {
    @Autowired
    lateinit var greetingRepository: GreetingRepository

    @Test
    fun `retrieves all the greetings`() {
        assertThat(greetingRepository.findAll()).isEmpty()
    }

    @Test
    fun `retrieves all the greetings 2`() {
        greetingRepository.save(Greeting(null, "spam"))

        assertThat(greetingRepository.findAll().toList().size).isEqualTo(1)
    }
}