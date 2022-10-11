package com.example.msuserservice.repository;

import com.example.msuserservice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUserId(String userId);

    UserEntity findByEmail(String email);


}
