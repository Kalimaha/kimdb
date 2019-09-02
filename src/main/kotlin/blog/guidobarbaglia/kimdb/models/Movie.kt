package blog.guidobarbaglia.kimdb.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "movies")
data class Movie(
    @Id
    @GeneratedValue
    val id: Int? = null,

    val title: String
)