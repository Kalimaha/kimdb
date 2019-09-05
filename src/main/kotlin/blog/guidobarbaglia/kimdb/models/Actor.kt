package blog.guidobarbaglia.kimdb.models

import com.fasterxml.jackson.annotation.*
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Actor(
    @Id
    @GeneratedValue
    val id: Int? = null,

    val externalId: String? = UUID.randomUUID().toString(),

    val firstName: String? = null,

    val lastName: String? = null,

    @JsonIgnore
    @ManyToMany(mappedBy = "actors")
    val movies: Set<Movie>? = emptySet()
)