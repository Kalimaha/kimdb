package blog.guidobarbaglia.kimdb.repositories

import blog.guidobarbaglia.kimdb.models.Actor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ActorsRepository : CrudRepository<Actor, Long>