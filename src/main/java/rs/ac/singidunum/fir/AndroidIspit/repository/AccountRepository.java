package rs.ac.singidunum.fir.AndroidIspit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.AndroidIspit.model.AccountModel;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Integer> {

    Optional<AccountModel> findByEmail(String email);
}
