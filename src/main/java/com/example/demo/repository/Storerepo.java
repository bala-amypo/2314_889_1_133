package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Store;

@Repository
public interface Storerepo extends JpaRepository<Store,Long>{

}