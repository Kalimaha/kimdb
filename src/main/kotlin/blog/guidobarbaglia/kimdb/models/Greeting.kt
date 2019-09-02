package blog.guidobarbaglia.kimdb.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "greeting")
data class Greeting(@Id @GeneratedValue val id: Long?, val name: String)