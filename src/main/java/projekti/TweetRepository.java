package projekti;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long>{

    List<Tweet> findByAccount(Account account);

    @EntityGraph(attributePaths = {"account"})
    List<Tweet> findAll();

}
