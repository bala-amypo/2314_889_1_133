package com.example.demo.service.impl;
import com.example.demo.entity.InventoryLevel;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype,Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryBalanceServiceImpl
implements InventoryBalancerService{
    private final InventoryLevelRRepoitory inventoryRepository;
    public InventoryBalancerServiceImpl(InventoryLevelRepository invntory)
}