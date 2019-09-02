package blog.guidobarbaglia.kimdb.controllers

import blog.guidobarbaglia.kimdb.models.Greeting
import blog.guidobarbaglia.kimdb.services.GreetingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("greetings")
class GreetingController(val greetingService: GreetingService) {
    @GetMapping("/")
    fun greetings(): MutableIterable<Greeting> = greetingService.findAll()
}