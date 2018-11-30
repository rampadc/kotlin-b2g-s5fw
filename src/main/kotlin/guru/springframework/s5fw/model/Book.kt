package guru.springframework.s5fw.model

import javax.persistence.*

@Entity
data class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var title: String,
        var isbn: String,
        var publisher: String,

        @ManyToMany
        @JoinTable(name="author_book", joinColumns = [JoinColumn(name="book_id")], inverseJoinColumns = [JoinColumn(name="author_id")])
        var authors: MutableSet<Author> = mutableSetOf()
) {
        override fun hashCode(): Int {
                return this.id.hashCode()
        }

        override fun equals(other: Any?): Boolean = this.id ==  (other as Book).id
}