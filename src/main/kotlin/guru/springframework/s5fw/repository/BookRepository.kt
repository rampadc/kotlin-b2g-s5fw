package guru.springframework.s5fw.repository

import guru.springframework.s5fw.model.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<Book, Long> {
}