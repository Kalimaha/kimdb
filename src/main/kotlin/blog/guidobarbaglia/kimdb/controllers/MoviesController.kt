package blog.guidobarbaglia.kimdb.controllers

import blog.guidobarbaglia.kimdb.models.Actor
import blog.guidobarbaglia.kimdb.models.Movie
import blog.guidobarbaglia.kimdb.services.ActorsService
import blog.guidobarbaglia.kimdb.services.MoviesService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("movies")
class MoviesController(val moviesService: MoviesService, val actorsService: ActorsService) {
    @GetMapping("/")
    fun movies(): MutableIterable<Movie> = moviesService.movies()

    @GetMapping("/{movieId}/actors/")
    fun actorsByMovie(@PathVariable movieId: Long): MutableIterable<Actor> = actorsService.actorsByMovieId(movieId)

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveMovie(@RequestBody movie: Movie) = moviesService.saveMovie(movie)
}