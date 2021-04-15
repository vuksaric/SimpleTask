package com.example.SimpleTaksPraksa.dto;

import com.example.SimpleTaksPraksa.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private int height; //u cm
    private int weight; // kg
    private int age;
    private String email;
    private String phone;
    private float bmi;
    private String token;


    /*public UserDTO(User user){
        //this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.username = user.getUsername();
        this.height = user.getHeight();
        this.weight = user.getWeight();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.bmi = user.getBmi();
    }*/
}
