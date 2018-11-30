package guru.springframework.s5fw.controller

import guru.springframework.s5fw.repository.BookRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class BookController(
        val bookRepository: BookRepository) {

    @RequestMapping("/books")
    fun getBooks(model: Model): String {
        // Spring MVC will pass in a model
        model.addAttribute("books", this.bookRepository.findAll())
        return "books"
    }
}