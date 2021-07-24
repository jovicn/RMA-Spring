package rs.ac.singidunum.fir.AndroidIspit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.AndroidIspit.model.OrderModel;

@Repository
public interface OrderRepository extends CrudRepository<OrderModel, Integer> {
}
