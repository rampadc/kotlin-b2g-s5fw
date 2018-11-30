package guru.springframework.s5fw.controller

import guru.springframework.s5fw.repository.AuthorRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class AuthorController(
        val authorRepository: AuthorRepository) {

    @RequestMapping("/authors")
    fun getAuthors(model: Model): String {
        // Spring MVC will pass in a model
        model.addAttribute("authors", this.authorRepository.findAll())
        return "authors"
    }
}