package blog.guidobarbaglia.kimdb.models

data class Greeting(val name: String) {
    override fun toString(): String = "Hallo, $name!"
}