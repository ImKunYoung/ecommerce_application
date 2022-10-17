package com.example.msuserservice.middle;

import com.example.msuserservice.inner.service.domain.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUserId(String userId);

    UserEntity findByEmail(String email);


}
