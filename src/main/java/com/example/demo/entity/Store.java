import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String storeName;
    private String address;
    private String region;
    private boolean active = true;
    public Store(Long id, String storeName, String address, String region, boolean active) {
        this.id = id;
        this.storeName = storeName;
        this.address = address;
        this.region = region;
        this.active = active;
    }

   
    public Long getId(Long id) {
        return id;
    }

    public String getStoreName(String storeName) {
        return storeName;
    }

    public String getAddress(String address) {
        return address;
    }

    public String getRegion(String region) {
        return region;
    }

    public boolean getActive(boolean active) {
        return active;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
