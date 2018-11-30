package guru.springframework.s5fw.model

import javax.persistence.*

@Entity
data class Author(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var firstName: String,
        var lastName: String,

        @ManyToMany(mappedBy = "authors")
        var books: MutableSet<Book> = mutableSetOf()
) {
        override fun hashCode(): Int {
                return this.id.hashCode()
        }

        override fun equals(other: Any?): Boolean = this.id ==  (other as Author).id
}