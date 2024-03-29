package blog.guidobarbaglia.kimdb.models

import java.util.*
import javax.persistence.*

@Entity
data class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(unique = true)
    val title: String,

    val externalId: String? = UUID.randomUUID().toString(),

    @ManyToMany(cascade = [CascadeType.PERSIST])
    @JoinTable(
        name                = "movie_actor",
        joinColumns         = [JoinColumn(name = "movie_id")],
        inverseJoinColumns  = [JoinColumn(name = "actor_id")]
    )
    val actors: List<Actor>? = emptyList()
)