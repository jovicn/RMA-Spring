package rs.ac.singidunum.fir.AndroidIspit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.AndroidIspit.model.AuthorModel;
import rs.ac.singidunum.fir.AndroidIspit.repository.AuthorRepository;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired(required = false)
    private AuthorRepository authorRepository;

    @GetMapping("/author")
    public List<AuthorModel> showAuthors(){
        return (List<AuthorModel>) authorRepository.findAll();
    }

    @GetMapping("/author/{id}")
    public AuthorModel showAuthor(@PathVariable int id){
        return authorRepository.findById(id).orElse(null);
    }

    @PostMapping(path="author")
    public AuthorModel createAuthor(@RequestBody AuthorModel aut){
        return authorRepository.save(aut);
    }

    @DeleteMapping("/author/{id}")
    public boolean delete(@PathVariable String id){
        int authorId = Integer.parseInt(id);
        authorRepository.deleteById(authorId);
        return true;
    }

    @PutMapping(path = "/author/{id}")
    public AuthorModel updateAuthor(@PathVariable int id, @RequestBody AuthorModel au){
        AuthorModel authModel = authorRepository.findById(id).orElse(null);
        authModel.setForename(au.getForename());
        authModel.setSurname(au.getSurname());

        return authorRepository.save(authModel);
    }

}

