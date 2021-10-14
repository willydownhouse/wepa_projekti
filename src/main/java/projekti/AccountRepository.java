package projekti;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{
    Account findByUsername(String username);

    // @EntityGraph(attributePaths = {"comments, tweets, seuraajat, seuraan"})
    // List<Account> findAll();
}