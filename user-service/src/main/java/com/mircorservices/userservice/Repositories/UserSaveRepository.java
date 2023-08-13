package com.mircorservices.userservice.Repositories;

import com.mircorservices.userservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSaveRepository extends JpaRepository<Users, Integer> {
}

