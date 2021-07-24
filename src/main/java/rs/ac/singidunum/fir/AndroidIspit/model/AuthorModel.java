package rs.ac.singidunum.fir.AndroidIspit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class AuthorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private int authorId;

    @Column(name="forename")
    private String forename;

    @Column(name="surname")
    private String surname;

    @JsonIgnore
    @OneToMany(mappedBy = "authorModelId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AuthorBookModel> authorBookModel = new HashSet<AuthorBookModel>();

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<AuthorBookModel> getAuthorBookModel() {
        return authorBookModel;
    }

    public void setAuthorBookModel(Set<AuthorBookModel> authorBookModel) {
        this.authorBookModel = authorBookModel;
    }
}
