package blog.guidobarbaglia.kimdb.services

import blog.guidobarbaglia.kimdb.models.Greeting
import org.springframework.stereotype.Service

@Service
class GreetingService {
    fun buildGreetingFor(name: String): Greeting = Greeting(name)
}