package com.example.SimpleTaksPraksa.controller;

import com.example.SimpleTaksPraksa.model.Grocery;
import com.example.SimpleTaksPraksa.model.User;
import com.example.SimpleTaksPraksa.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.util.List;

@RestController

@RequestMapping(value = "/groceries")
public class GroceryController {

    @Autowired
    GroceryService groceryServices;

    @GetMapping(value="/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Grocery> getAll(){
        return groceryServices.getAll();
    }

    @PostMapping(value="/newGrocery", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void newGrocery(@RequestBody Grocery grocery){
        groceryServices.newGrocery(grocery);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value="/delete/{id}")
    public void deleteGrocery(@PathVariable("id") String id){
        System.out.println(id);
        groceryServices.deleteGrocery(id);
    }

    @PutMapping(value="/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateGrocery(@PathVariable String id, @RequestBody Grocery grocery){
        groceryServices.updateGrocery(id,grocery);
    }
}
