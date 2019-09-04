package blog.guidobarbaglia.kimdb.controllers

import blog.guidobarbaglia.kimdb.models.Actor
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
class ActorsControllerTest {
    @Autowired
    lateinit var restTemplate: TestRestTemplate

    val url: String = "/actors/"

    @Test
    fun `returns 201 CREATED`() {
        val request = HttpEntity<Actor>(Actor(firstName = "Terry", lastName = "Gilliam"))
        val actor   = restTemplate.postForEntity(url, request, String::class.java)

        assertThat(actor.statusCode).isEqualTo(HttpStatus.CREATED)
    }

    @Test
    fun `formats the response as JSON object`() {
        val mapper  = ObjectMapper()
        val request = HttpEntity<Actor>(Actor(firstName = "Terry", lastName = "Gilliam"))
        val json    = restTemplate.postForEntity(url, request, String::class.java).body
        val actor   = mapper.readValue(json, Actor::class.java)

        assertThat(actor.firstName).isEqualTo("Terry")
    }
}