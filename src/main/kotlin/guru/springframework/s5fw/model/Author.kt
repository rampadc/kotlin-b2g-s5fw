package guru.springframework.s5fw.model

import javax.persistence.*

@Entity
data class Author(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var firstName: String,
        var lastName: String,

        @ManyToMany(mappedBy = "authors")
        var books: Set<Book> = mutableSetOf()
)