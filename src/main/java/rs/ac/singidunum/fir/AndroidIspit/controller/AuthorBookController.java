package rs.ac.singidunum.fir.AndroidIspit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.AndroidIspit.model.AuthorBookModel;
import rs.ac.singidunum.fir.AndroidIspit.repository.AuthorBookRepository;

import java.util.List;

@RestController
public class AuthorBookController {

    @Autowired(required = false)
    private AuthorBookRepository authorBookRepository;

    @GetMapping("/author-book")
    public List<AuthorBookModel> showAuthorBooks(){
        return (List<AuthorBookModel>) authorBookRepository.findAll();
    }

    @GetMapping("/author-book/{id}")
    public AuthorBookModel showAuthorBook(@PathVariable int id) {
        return authorBookRepository.findById(id).orElse(null);
    }

    @PostMapping("/author-book")
    public AuthorBookModel createAuthorBook(@RequestBody AuthorBookModel authorBookModel){
        return authorBookRepository.save(authorBookModel);
    }

    @DeleteMapping("/author-book/{id}")
    public boolean delete(@PathVariable int id){
        authorBookRepository.deleteById(id);
        return true;
    }

    @PutMapping("/author-book/{id}")
    public AuthorBookModel updateAuthorBook(@PathVariable int id, @RequestBody AuthorBookModel newAuthorBook){
        AuthorBookModel autBook = authorBookRepository.findById(id).orElse(null);
        autBook.setBookModelId(newAuthorBook.getBookModelId());
        autBook.setAuthorModelId(newAuthorBook.getAuthorModelId());

        return authorBookRepository.save(autBook);
    }

}

