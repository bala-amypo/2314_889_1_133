package example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
@Entity
public class User{
    @Id
    private Long id;
    @Column(name=unique)
    private String email;
    private String password;
    private String role;

    public User(){

    }
    public User(Long id,String email,String password,String role){
        this.id = id;
        this.email= email;
        this.passw
    }
}