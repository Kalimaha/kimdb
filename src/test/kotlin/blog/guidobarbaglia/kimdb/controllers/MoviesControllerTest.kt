package blog.guidobarbaglia.kimdb.controllers

import blog.guidobarbaglia.kimdb.models.Movie
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import javax.transaction.Transactional


@Transactional
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoviesControllerTest {
    @Autowired
    lateinit var restTemplate: TestRestTemplate

    val url: String = "/movies/"

    @Test
    fun `returns 201 CREATED`() {
        val request = HttpEntity<Movie>(Movie(title = "Spam & Eggs"))
        val movie = restTemplate.postForEntity(url, request, String::class.java)

        assertThat(movie.statusCode).isEqualTo(HttpStatus.CREATED)
    }

    @Test
    fun `formats the response as JSON object`() {
        val mapper = ObjectMapper()
        val request = HttpEntity<Movie>(Movie(title = "Spam & Eggs 2"))
        val json = restTemplate.postForEntity(url, request, String::class.java).body
        val movie = mapper.readValue(json, Movie::class.java)

        assertThat(movie.title).isEqualTo("Spam & Eggs 2")
    }
}