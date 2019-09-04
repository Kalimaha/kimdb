package blog.guidobarbaglia.kimdb.controllers

import blog.guidobarbaglia.kimdb.models.Actor
import blog.guidobarbaglia.kimdb.services.ActorsService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("actors")
class ActorsController(val actorsService: ActorsService) {
    @GetMapping("/")
    fun actors(): MutableIterable<Actor> = actorsService.actors()

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveActor(@RequestBody actor: Actor) = actorsService.saveActor(actor)
}