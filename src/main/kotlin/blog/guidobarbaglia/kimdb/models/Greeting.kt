package blog.guidobarbaglia.kimdb.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "greeting")
data class Greeting(@Id @GeneratedValue(generator = "UUID") val id: String, val name: String) {
    override fun toString(): String = "Hallo, $name!"
}