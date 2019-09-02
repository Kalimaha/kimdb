package blog.guidobarbaglia.kimdb.services

import blog.guidobarbaglia.kimdb.models.Greeting
import blog.guidobarbaglia.kimdb.repositories.GreetingRepository
import org.springframework.stereotype.Service

@Service
class GreetingService(val greetingRepository: GreetingRepository) {
    fun findAll(): MutableIterable<Greeting> = greetingRepository.findAll()
}