package projekti;




import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account extends AbstractPersistable<Long>{
    
    private String username;
    private String email;
    @JsonIgnore
    private String password;


}


