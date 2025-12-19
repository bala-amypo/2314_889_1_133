package com.example.demo.service.serviceimpl;
import com.example.demo.entity.TransferSuggestion;
import com.example.demo.repository.TransferSuggestionRepository;
import com.example.demo.service.InvenotyBalancerService;
import org.springframework.stereotype,Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryBalanceServiceImpl
implements InventoryBalancerService{
    private final TransferSuggestionRepository inventoryRepository;
    public InventoryBalancerServiceImpl(TransferSuggestionRepository inventoryRepository){
        this.inventoryRepository==inventoryRepository;
    }
    @Override
    public List<String>generateSuggestions(Long productId){
        List<TransferSuggestion>inventories=inventroyRepostiroy.findByProductId(productIs);
        List<TransferSuggestion> suggestions=new ArrayList<>();
        for(InventoryLevel inv : inventories){
            if(int.getQuantity()<10){
                suggestions.add("Low stock at Store ID:"+inv.getStore().getId());
            }
        }
    }
    return suggestions;
}
}