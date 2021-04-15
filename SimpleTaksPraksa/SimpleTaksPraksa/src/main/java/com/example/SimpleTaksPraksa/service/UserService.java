package com.example.SimpleTaksPraksa.service;

import com.example.SimpleTaksPraksa.dto.UserDTO;
import com.example.SimpleTaksPraksa.dto.UserLoginDTO;
import com.example.SimpleTaksPraksa.model.User;
import com.example.SimpleTaksPraksa.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtService jwtService;


    public void save(User user) { userRepository.save(user); }

    public User findOne(long id) {
        return userRepository.findById(id).orElseGet(null);
    }

    public UserDTO registration(User user) {
        float bmi = (float) (user.getWeight() / Math.sqrt((user.getHeight()/100)));
        user.setBmi(bmi);
        save(user);
        return mapUserToResponse(user);

    }

    private UserDTO mapUserToResponse(User user) {
        UserDTO userDTO = new UserDTO();
        if(user.getUsername() != null)
            userDTO.setUsername(user.getUsername());
        if(user.getName() != null)
            userDTO.setName(user.getName());
        if(user.getSurname() != null)
            userDTO.setSurname(user.getSurname());
        userDTO.setAge(user.getAge());
        userDTO.setHeight(user.getHeight());
        userDTO.setWeight(user.getWeight());
        if(user.getEmail() != null)
            userDTO.setEmail(user.getEmail());
        if(user.getPhone() != null)
            userDTO.setPhone(user.getPhone());
        userDTO.setBmi(user.getBmi());

        return userDTO;
    }


    public UserDTO login(UserLoginDTO user) {
        List<User> users;
        users = userRepository.findAll();
        for(User user2: users){
            if(user.getPassword().equals(user2.getPassword()) && user.getUsername().equals(user2.getUsername())){
                UserDTO userDTO = mapUserToResponse(user2);
                userDTO.setToken(jwtService.generateJWT(user2));
                return userDTO;
            }
        }
        return null;
    }

    public void logout(){
        // ???
        // na klijentskoj strani token unistiti posle logout
        // treba autentifikaciju za jwt token uraditi svuda (na frontu proveriti da li je subject USER)
        //
    }
}
