package rs.ac.singidunum.fir.AndroidIspit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.AndroidIspit.model.CategoryBookModel;
import rs.ac.singidunum.fir.AndroidIspit.repository.CategoryBookRepository;

import java.util.List;

@RestController
public class CategoryBookController {

    @Autowired(required = false)
    private CategoryBookRepository categoryBookRepository;

    @GetMapping("/category-book")
    public List<CategoryBookModel> showCategoryBooks(){
        return (List<CategoryBookModel>) categoryBookRepository.findAll();
    }

    @GetMapping("/category-book/{id}")
    public CategoryBookModel showCategoryBook(@PathVariable int id) {
        return categoryBookRepository.findById(id).orElse(null);
    }

    @PostMapping("/category-book")
    public CategoryBookModel createCategoryBook(@RequestBody CategoryBookModel categoryBookModel){
        return categoryBookRepository.save(categoryBookModel);
    }

    @DeleteMapping("/category-book/{id}")
    public boolean delete(@PathVariable int id){
        categoryBookRepository.deleteById(id);
        return true;
    }

    @PutMapping("/category-book/{id}")
    public CategoryBookModel updateCategoryBook(@PathVariable int id, @RequestBody CategoryBookModel newCategoryBook){
        CategoryBookModel catBook = categoryBookRepository.findById(id).orElse(null);
        catBook.setCategoryBoId(newCategoryBook.getCategoryBoId());
        catBook.setBookCatId(newCategoryBook.getBookCatId());

        return categoryBookRepository.save(catBook);
    }

}
