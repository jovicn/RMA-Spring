package rs.ac.singidunum.fir.AndroidIspit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.AndroidIspit.model.AuthorBookModel;


@Repository
public interface AuthorBookRepository extends CrudRepository<AuthorBookModel, Integer> {
}
