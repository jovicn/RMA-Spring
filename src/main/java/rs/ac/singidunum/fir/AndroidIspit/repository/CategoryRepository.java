package rs.ac.singidunum.fir.AndroidIspit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.AndroidIspit.model.CategoryModel;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryModel, Integer> {
}
