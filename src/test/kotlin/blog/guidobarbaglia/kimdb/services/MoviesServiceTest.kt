package blog.guidobarbaglia.kimdb.services

import blog.guidobarbaglia.kimdb.models.Movie
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.transaction.Transactional
import kotlin.test.assertTrue

@Transactional
@SpringBootTest
@RunWith(SpringRunner::class)
class MoviesServiceTest {
    @Autowired
    lateinit var moviesService: MoviesService

    @Test
    fun `protects against data integrity exceptions`() {
        assertTrue {  moviesService.saveMovie(Movie(title = "Life of Brian")).isLeft }
        assertTrue {  moviesService.saveMovie(Movie(title = "Life of Brian")).isRight }
        assertThat(moviesService.saveMovie(Movie(title = "Life of Brian")).get())
            .isEqualTo("A movie with title 'Life of Brian' already exists in the DB.")
    }
}