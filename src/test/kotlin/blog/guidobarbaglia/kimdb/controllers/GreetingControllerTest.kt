package blog.guidobarbaglia.kimdb.controllers

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerTest {
    @Autowired
    lateinit var restTemplate: TestRestTemplate

    val url: String = "/greetings/Mario"

    @Test
    @Ignore
    fun `returns 200 OK`() {
        assertThat(restTemplate.getForEntity(url, String::class.java).statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    @Ignore
    fun `formats the response as JSON object`() {
        assertThat(restTemplate.getForEntity(url, String::class.java).body).isEqualTo("{\"name\":\"Mario\"}")
    }
}