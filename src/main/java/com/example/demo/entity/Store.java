import jakarta.persistence.*;

@Entity
public class Store{
    @Id
    private Long id;
    private String storeName;
    private String address;
    private String region;
    private boolean active = true;

    public Store(Long id,String storeName,String address,String region,boolean active){
        this.id = id;
        this.storeName = storeName;
        this.address = address;
        this.region = region;
        this.active = active;
    }

    public void setstoreName(){
        this.storeName = storeName;
    }

    public void setid(){
        this.id = id;
    }
    public void setaddress(){
        this.address = address;
    }
    public void setregion(){
        this.region = region;
    }
    public void setactive(){
        this.active = active;
    }

    public Long getid(Long id){
        return id;
    }
    public String getstoreName(String storeName){
        return storeName;
    }
    public String getaddress(String address){
        return address;
    }
    public getregion(String region){
        return region;
    }
    public getactive(boolean active){
        return active;
    }
}