package blog.guidobarbaglia.kimdb.services

import blog.guidobarbaglia.kimdb.models.Actor
import blog.guidobarbaglia.kimdb.repositories.ActorsRepository
import org.springframework.stereotype.Service

@Service
class ActorsService(val actorsRepository: ActorsRepository) {
    fun actors(): MutableIterable<Actor> = actorsRepository.findAll()

    fun saveActor(actor: Actor): Actor = actorsRepository.save(actor)
}