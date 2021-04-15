package com.example.SimpleTaksPraksa.service;

import com.example.SimpleTaksPraksa.model.Grocery;
import com.example.SimpleTaksPraksa.model.User;
import com.example.SimpleTaksPraksa.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    @Autowired
    GroceryRepository groceryRepository;

    public List<Grocery> findAll() { return groceryRepository.findAll(); }

    public void save(Grocery grocery) { groceryRepository.save(grocery); }

    public void delete(String id){ groceryRepository.deleteById(Long.parseLong(id));}

    public Grocery findOne(String id){ return groceryRepository.findById(Long.getLong(id)).orElse(null);}


    public List<Grocery> getAll() {
        return findAll();
    }

    public void newGrocery(Grocery grocery) {
        save(grocery);
    }

    public void deleteGrocery(String id) {
        delete(id);
    }

    public void updateGrocery(String id, Grocery grocery) {
        save(grocery);  // moraju se sa fronta poslati svi podaci
    }
}
