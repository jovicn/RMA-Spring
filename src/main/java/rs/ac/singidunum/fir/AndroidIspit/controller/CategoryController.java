package rs.ac.singidunum.fir.AndroidIspit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.AndroidIspit.model.CategoryModel;
import rs.ac.singidunum.fir.AndroidIspit.repository.CategoryRepository;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired(required = false)
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public List<CategoryModel> showCategories(){
        return (List<CategoryModel>) categoryRepository.findAll();
    }

    @GetMapping(path="/category/{id}")
    public CategoryModel showCategory(@PathVariable int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @PostMapping(path = "/category")
    public CategoryModel createCategory(@RequestBody CategoryModel cat){
        return categoryRepository.save(cat);
    }

    @DeleteMapping("/category/{id]")
    public boolean delete(@PathVariable String id){
        int catId = Integer.parseInt(id);
        categoryRepository.deleteById(catId);
        return true;
    }

    @PutMapping(path = "/category/{id}")
    public CategoryModel updateCategory(@PathVariable int id, @RequestBody CategoryModel cm){
        CategoryModel ca = categoryRepository.findById(id).orElse(null);
        ca.setName(cm.getName());

        return categoryRepository.save(ca);
    }

}
