package com.example.SimpleTaksPraksa.repository;

import com.example.SimpleTaksPraksa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
