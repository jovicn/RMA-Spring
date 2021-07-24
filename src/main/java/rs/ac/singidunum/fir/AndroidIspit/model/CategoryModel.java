package rs.ac.singidunum.fir.AndroidIspit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private int categoryId;

    @Column(name="name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "categoryBoId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CategoryBookModel> categoryBookModel = new HashSet<CategoryBookModel>();

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CategoryBookModel> getCategoryBookModel() {
        return categoryBookModel;
    }

    public void setCategoryBookModel(Set<CategoryBookModel> categoryBookModel) {
        this.categoryBookModel = categoryBookModel;
    }
}

