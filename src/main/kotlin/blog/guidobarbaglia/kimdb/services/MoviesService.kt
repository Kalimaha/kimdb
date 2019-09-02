package blog.guidobarbaglia.kimdb.services

import blog.guidobarbaglia.kimdb.models.Movie
import blog.guidobarbaglia.kimdb.repositories.MoviesRepository
import org.springframework.stereotype.Service

@Service
class MoviesService(val moviesRepository: MoviesRepository) {
    fun movies(): MutableIterable<Movie> = moviesRepository.findAll()

    fun saveMovie(movie: Movie): Movie = moviesRepository.save(movie)
}