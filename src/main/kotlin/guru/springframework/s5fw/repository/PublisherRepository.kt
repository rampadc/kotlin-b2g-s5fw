package guru.springframework.s5fw.repository

import guru.springframework.s5fw.model.Publisher
import org.springframework.data.repository.CrudRepository

interface PublisherRepository: CrudRepository<Publisher, Long> {
}