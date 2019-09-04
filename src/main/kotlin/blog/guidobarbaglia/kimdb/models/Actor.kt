package blog.guidobarbaglia.kimdb.models

import com.fasterxml.jackson.annotation.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Actor(
    @Id
    @GeneratedValue
    val id: Int? = null,

    val firstName: String? = null,

    val lastName: String? = null,

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    val movies: Set<Movie>? = emptySet()
)