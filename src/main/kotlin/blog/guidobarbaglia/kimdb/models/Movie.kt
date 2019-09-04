package blog.guidobarbaglia.kimdb.models

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
data class Movie(
    @Id
    @GeneratedValue
    val id: Int? = null,

    val title: String,

    val externalId: String? = UUID.randomUUID().toString(),

    @JsonIgnore
    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name                = "movie_actor",
        joinColumns         = [JoinColumn(name = "movie_id", referencedColumnName = "id")],
        inverseJoinColumns  = [JoinColumn(name = "actor_id", referencedColumnName = "id")]
    )
    val actors: Set<Actor>? = emptySet()
)