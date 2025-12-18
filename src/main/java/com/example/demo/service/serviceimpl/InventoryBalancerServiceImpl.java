package com.example.demo.service.serviceimpl;
import com.example.demo.entity.Transfer;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype,Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryBalanceServiceImpl
implements InventoryBalancerService{
    private final InventoryLevelRRepoitory inventoryRepository;
    public InventoryBalancerServiceImpl(InventoryLevelRepository inventoryRepository){
        this.inventoryRepository==inventoryRepository;
    }
    @Override
    public List<String>generateSuggestions(Long productId){
        List<InventoryLevel>inventories=inventroyRepostiroy.findByProductId(productIs);
        List<String> suggestions=new ArrayList<>();
        for(InventoryLevel inv : inventories){
            if(int.getQuantity()<10){
                suggestions.add("Low stock at Store ID:"+inv.getStore().getId());
            }
        }
    }
    return suggestions;
}
}