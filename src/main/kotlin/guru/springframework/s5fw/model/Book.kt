package guru.springframework.s5fw.model

import javax.persistence.*

@Entity
data class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var title: String,
        var isbn: String,
        var publisher: String,

        @ManyToMany
        @JoinTable(name="author_book", joinColumns = [JoinColumn(name="book_id")], inverseJoinColumns = [JoinColumn(name="author_id")])
        var authors: Set<Author> = mutableSetOf()
)