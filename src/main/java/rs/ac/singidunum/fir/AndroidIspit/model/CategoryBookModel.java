package rs.ac.singidunum.fir.AndroidIspit.model;

import javax.persistence.*;

@Entity
@Table(name = "category_book")
public class CategoryBookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_book_id")
    private int categoryBookId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel categoryBoId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookModel bookCatId;

    public int getCategoryBookId() {
        return categoryBookId;
    }

    public void setCategoryBookId(int categoryBookId) {
        this.categoryBookId = categoryBookId;
    }

    public CategoryModel getCategoryBoId() {
        return categoryBoId;
    }

    public void setCategoryBoId(CategoryModel categoryBoId) {
        this.categoryBoId = categoryBoId;
    }

    public BookModel getBookCatId() {
        return bookCatId;
    }

    public void setBookCatId(BookModel bookCatId) {
        this.bookCatId = bookCatId;
    }
}
