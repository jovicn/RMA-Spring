package rs.ac.singidunum.fir.AndroidIspit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.AndroidIspit.model.OrderBookModel;

@Repository
public interface OrderBookRepository extends CrudRepository<OrderBookModel, Integer> {
}
