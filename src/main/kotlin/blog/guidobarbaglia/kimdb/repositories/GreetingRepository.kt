package blog.guidobarbaglia.kimdb.repositories

import blog.guidobarbaglia.kimdb.models.Greeting
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GreetingRepository : CrudRepository<Greeting, Long> {
}