package rs.ac.singidunum.fir.AndroidIspit.model;

import javax.persistence.*;

@Entity
@Table(name="author_book")
public class AuthorBookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_book_id")
    private int authorBookId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorModel authorModelId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookModel bookModelId;

    public int getAuthorBookId() {
        return authorBookId;
    }

    public void setAuthorBookId(int authorBookId) {
        this.authorBookId = authorBookId;
    }

    public AuthorModel getAuthorModelId() {
        return authorModelId;
    }

    public void setAuthorModelId(AuthorModel authorModelId) {
        this.authorModelId = authorModelId;
    }

    public BookModel getBookModelId() {
        return bookModelId;
    }

    public void setBookModelId(BookModel bookModelId) {
        this.bookModelId = bookModelId;
    }
}
