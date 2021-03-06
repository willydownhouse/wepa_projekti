package projekti;



import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long>{

    Picture findByAccount(Account account);
    void deleteByAccount(Account account);
    
}
