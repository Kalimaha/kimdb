package blog.guidobarbaglia.kimdb.repositories

import blog.guidobarbaglia.kimdb.models.Actor
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.transaction.Transactional

@Transactional
@SpringBootTest
@RunWith(SpringRunner::class)
class ActorsRepositoryTest {
    @Autowired
    lateinit var actorsRepository: ActorsRepository

    @Test
    fun `returns an empty array when there are no actors available`() {
        assertThat(actorsRepository.findAll()).isEmpty()
    }

    @Test
    fun `retrieves all the movies`() {
        actorsRepository.save(Actor(firstName = "Terry", lastName = "Gilliam"))

        assertThat(actorsRepository.findAll().toList().size).isEqualTo(1)
    }
}