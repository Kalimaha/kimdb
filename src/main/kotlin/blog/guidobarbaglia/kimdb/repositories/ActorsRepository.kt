package blog.guidobarbaglia.kimdb.repositories

import blog.guidobarbaglia.kimdb.models.Actor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface ActorsRepository : CrudRepository<Actor, Long> {
    @Query("SELECT * FROM actor AS a, movie_actor AS ma WHERE ma.movie_id = :movieId", nativeQuery = true)
    fun actorsByMovieId(@Param("movieId") movieId: Long): MutableIterable<Actor>
}