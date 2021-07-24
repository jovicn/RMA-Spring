package rs.ac.singidunum.fir.AndroidIspit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private int bookId;

    @Column(name="name")
    private String name;

    @Column(name="number_of_pages")
    private String numberOfPages;

    @Column(name="year_of_issue")
    private String yearOfIssue;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private String price;

    @JsonIgnore
    @OneToMany(mappedBy = "bookModelId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AuthorBookModel> authorBookModel = new HashSet<AuthorBookModel>();

    @JsonIgnore
    @OneToMany(mappedBy = "bookCatId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CategoryBookModel> categoryBookModel = new HashSet<CategoryBookModel>();

    @JsonIgnore
    @OneToMany(mappedBy = "bookOrderId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderBookModel> orderBookModel = new HashSet<OrderBookModel>();

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(String yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Set<AuthorBookModel> getAuthorBookModel() {
        return authorBookModel;
    }

    public void setAuthorBookModel(Set<AuthorBookModel> authorBookModel) {
        this.authorBookModel = authorBookModel;
    }

    public Set<CategoryBookModel> getCategoryBookModel() {
        return categoryBookModel;
    }

    public void setCategoryBookModel(Set<CategoryBookModel> categoryBookModel) {
        this.categoryBookModel = categoryBookModel;
    }

    public Set<OrderBookModel> getOrderBookModel() {
        return orderBookModel;
    }

    public void setOrderBookModel(Set<OrderBookModel> orderBookModel) {
        this.orderBookModel = orderBookModel;
    }
}
