package blog.guidobarbaglia.kimdb.controllers

import blog.guidobarbaglia.kimdb.services.GreetingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("greetings")
class GreetingController(val greetingService: GreetingService) {
    @GetMapping("/{name}")
    fun hello(@PathVariable("name") name: String) = greetingService.buildGreetingFor(name)
}