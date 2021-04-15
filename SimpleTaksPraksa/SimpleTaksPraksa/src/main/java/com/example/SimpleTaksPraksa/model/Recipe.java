package com.example.SimpleTaksPraksa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    private Long id;
    private String userUsername;
    //private List<Grocery> groceryList;
    private String name;
    private String description;
    //private List<Step> stepList;
    private int duration;
    private int price;
    private int caloricValue;

    public Recipe(String userUsername, List<Grocery> groceryList, String name, String description, List<Step> stepList){
        this.userUsername = userUsername;
        //this.groceryList = groceryList;
        this.name = name;
        this.description = description;
        //this.stepList = stepList;
        int time = 0;
        for(Step s : stepList){
            time += s.getDuration();
        }
        this.duration = time;
        int price2 = 0;
        int calories = 0;
        for(Grocery g : groceryList){
            price2 += g.getPrice();
            calories += g.getNutritionalValue();
        }
        this.price = price2;
        this.caloricValue = calories;
    }


}
