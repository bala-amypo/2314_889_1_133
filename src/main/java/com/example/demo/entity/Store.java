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

    public Long getid(){
        return id;
    }
    public String getstoreName(){
        return storeName;
    }
    public String getaddress(){
        return address;
    }
    public getregion(){
        return region;
    }
    public getactive(){
        return active;
    }
}