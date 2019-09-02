package blog.guidobarbaglia.kimdb.repositories

import blog.guidobarbaglia.kimdb.models.Movie
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MoviesRepository : CrudRepository<Movie, Long>