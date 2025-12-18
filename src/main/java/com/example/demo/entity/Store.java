import jakarta.persistence.*;

@Entity
public class Store{
    @Id
    private Long id;
    private String storeName;
    private String address;
    private String region;
    private boolean active = true;

    public class Store(Long id,String storeName,String address,String region,boolean active){
        this.id = id;
        this.storeName = storeName;
        this.address = address;
        this.region = region;
        this.active = active;
    }

    public Long setName(){
        this.store
    }
}