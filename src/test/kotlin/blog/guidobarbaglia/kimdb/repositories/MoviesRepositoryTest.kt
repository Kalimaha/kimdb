package blog.guidobarbaglia.kimdb.repositories

import blog.guidobarbaglia.kimdb.models.Movie
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
class MoviesRepositoryTest {
    @Autowired
    lateinit var moviesRepository: MoviesRepository

    @Test
    fun `returns an empty array when there are no movies available`() {
        assertThat(moviesRepository.findAll()).isEmpty()
    }

    @Test
    fun `retrieves all the movies`() {
        moviesRepository.save(Movie(title = "spam"))

        assertThat(moviesRepository.findAll().toList().size).isEqualTo(1)
    }
}