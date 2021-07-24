package rs.ac.singidunum.fir.AndroidIspit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.AndroidIspit.model.BookModel;

@Repository
public interface BookRepository extends CrudRepository<BookModel, Integer> {
}