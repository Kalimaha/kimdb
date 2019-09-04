package blog.guidobarbaglia.kimdb.models

import junit.framework.Assert.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.transaction.Transactional


@Transactional
@SpringBootTest
@RunWith(SpringRunner::class)
class MovieTest {
    lateinit var movie: Movie

    companion object {
        const val REGEX = "[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}"
    }

    @Before
    fun init() {
        movie = Movie(title = "Life of Brian")
    }

    @Test
    fun `generates an external id`() {
        assertNotNull(Movie(title = "Life of Brian").externalId)
    }

    @Test
    fun `generates an UUID for the external ID`() {
        assertThat(movie.externalId).matches(REGEX)
    }
}