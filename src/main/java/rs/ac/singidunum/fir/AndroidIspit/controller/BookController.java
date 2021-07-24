package rs.ac.singidunum.fir.AndroidIspit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.AndroidIspit.model.AuthorModel;
import rs.ac.singidunum.fir.AndroidIspit.model.BookModel;
import rs.ac.singidunum.fir.AndroidIspit.model.CategoryModel;
import rs.ac.singidunum.fir.AndroidIspit.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired(required = false)
    private BookRepository bookRepository;

    @GetMapping("/book")
    public List<BookModel> showBooks(){
        return (List<BookModel>) bookRepository.findAll();
    }

    @GetMapping(path = "/book/{id}")
    public BookModel showBook(@PathVariable int id){
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping(path="/book")
    public BookModel createBook(@RequestBody BookModel book){
        return bookRepository.save(book);
    }

    @DeleteMapping(path= "/book/{id}")
    public boolean delete(@PathVariable String id){
        int bookId = Integer.parseInt(id);
        bookRepository.deleteById(bookId);
        return true;
    }

    @PutMapping(path="/book/{id}")
    public BookModel updateBook(@PathVariable int id, @RequestBody BookModel bm){
        BookModel bo = bookRepository.findById(id).orElse(null);
        bo.setName(bm.getName());
        bo.setNumberOfPages(bm.getNumberOfPages());
        bo.setYearOfIssue(bm.getYearOfIssue());
        bo.setDescription(bm.getDescription());
        bo.setPrice(bm.getPrice());

        return bookRepository.save(bo);
    }

    @GetMapping(path="/book/{id}/authors")
    public List<AuthorModel> getAuthorsForBook(@PathVariable int id){
        List<AuthorModel> autorsOfBook = new ArrayList<>();
        Optional<BookModel> book = bookRepository.findById(id);
        if(book.isPresent()){
            autorsOfBook = book.get().getAuthorBookModel().stream().map(authorBookModel -> authorBookModel.getAuthorModelId()).collect(Collectors.toList());
        }
        return autorsOfBook;
    }

    @GetMapping(path="/book/{id}/categories")
    public List<CategoryModel> getCategoriesForBook(@PathVariable int id){
        List<CategoryModel> categoriesOfBook = new ArrayList<>();
        Optional<BookModel> book = bookRepository.findById(id);
        if(book.isPresent()){
            categoriesOfBook = book.get().getCategoryBookModel().stream().map(categoryBookModel -> categoryBookModel.getCategoryBoId()).collect(Collectors.toList());
        }
        return categoriesOfBook;
    }

}

