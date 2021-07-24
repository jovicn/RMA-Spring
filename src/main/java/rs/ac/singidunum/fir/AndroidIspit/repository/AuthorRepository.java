package rs.ac.singidunum.fir.AndroidIspit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.AndroidIspit.model.AuthorModel;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorModel, Integer> {
}
