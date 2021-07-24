package rs.ac.singidunum.fir.AndroidIspit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.AndroidIspit.model.CategoryBookModel;

@Repository
public interface CategoryBookRepository extends CrudRepository<CategoryBookModel, Integer> {
}
