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
}