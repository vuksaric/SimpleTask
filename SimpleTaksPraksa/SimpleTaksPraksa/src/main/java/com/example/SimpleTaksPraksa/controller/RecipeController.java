package com.example.SimpleTaksPraksa.controller;

import com.example.SimpleTaksPraksa.model.Grocery;
import com.example.SimpleTaksPraksa.model.Recipe;
import com.example.SimpleTaksPraksa.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping(value = "/recipes")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping(value="/getAll")
    public List<Recipe> getAll(){
        return recipeService.getAll();
    }
}
