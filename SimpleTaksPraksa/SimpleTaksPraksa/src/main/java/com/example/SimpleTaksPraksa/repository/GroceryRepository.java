package com.example.SimpleTaksPraksa.repository;

import com.example.SimpleTaksPraksa.model.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery,Long> {
}
