package guru.springframework.s5fw.repository

import guru.springframework.s5fw.model.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository: CrudRepository<Author, Long> {
}