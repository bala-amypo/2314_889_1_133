package com.example.demo.service.serviceimpl;
import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storerepo;

    public StoreServiceImpl(StoreRepository storerepo){
        this.storerepo = storerepo;
    }
    @Override
    public Store createStore(Store store){
        if(storerepo.existsByName(store.getName())){
            throw new RuntimeException("Store name already exists");
        }
        return storerepo.save(store);
    }
    @Override
    public Store getStoreById(Long id){
        return storerepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"))
    }
}