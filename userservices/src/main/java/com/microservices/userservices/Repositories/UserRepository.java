package com.microservices.userservices.Repositories;

import com.microservices.userservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {



}
