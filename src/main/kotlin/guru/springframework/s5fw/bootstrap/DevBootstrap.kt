package guru.springframework.s5fw.bootstrap

import guru.springframework.s5fw.model.Author
import guru.springframework.s5fw.model.Book
import guru.springframework.s5fw.model.Publisher
import guru.springframework.s5fw.repository.AuthorRepository
import guru.springframework.s5fw.repository.BookRepository
import guru.springframework.s5fw.repository.PublisherRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class DevBootstrap(
        val authorRepository: AuthorRepository,
        val bookRepository: BookRepository,
        val publisherRepository: PublisherRepository
): ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        initData()
    }

    fun initData() {
        val hc = Publisher(name = "Harper Collins")
        val eric = Author(firstName = "Eric", lastName = "Evans")
        val ddd = Book(title = "Domain Driven Design", isbn = "1234", publisher = hc)
        eric.books.add(ddd)
        ddd.authors.add(eric)

        authorRepository.save(eric)
        bookRepository.save(ddd)
        publisherRepository.save(hc)

        val worx = Publisher(name = "Worx")
        val rod = Author(firstName = "Rod", lastName = "Johnson")
        val noEJB = Book(title = "J2EE Development without EJB", isbn = "2344", publisher = worx)
        rod.books.add(noEJB)

        authorRepository.save(rod)
        bookRepository.save(noEJB)
        publisherRepository.save(worx)
    }
}