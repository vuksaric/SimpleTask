package com.example.SimpleTaksPraksa.repository;

import com.example.SimpleTaksPraksa.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
}
