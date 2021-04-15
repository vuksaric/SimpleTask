package com.example.SimpleTaksPraksa.service;

import com.example.SimpleTaksPraksa.model.Grocery;
import com.example.SimpleTaksPraksa.model.Recipe;
import com.example.SimpleTaksPraksa.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public List<Recipe> findAll() { return recipeRepository.findAll(); }

    public void save(Recipe recipe) { recipeRepository.save(recipe); }

    public List<Recipe> getAll() {
        return findAll();
    }
}
