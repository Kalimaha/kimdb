package blog.guidobarbaglia.kimdb.services

import blog.guidobarbaglia.kimdb.models.Movie
import blog.guidobarbaglia.kimdb.repositories.MoviesRepository
import io.vavr.control.Either
import org.hibernate.exception.ConstraintViolationException
import org.hibernate.exception.GenericJDBCException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class MoviesService(val moviesRepository: MoviesRepository) {
    fun movies(): MutableIterable<Movie> = moviesRepository.findAll()

    fun saveMovie(movie: Movie): Either<Movie, String> =
        try { Either.left(moviesRepository.save(movie)) }
        catch(e: Exception) { Either.right(errorMessage(movie)) }

    private fun errorMessage(movie: Movie): String =
        "A movie with title '${movie.title}' already exists in the DB."
}