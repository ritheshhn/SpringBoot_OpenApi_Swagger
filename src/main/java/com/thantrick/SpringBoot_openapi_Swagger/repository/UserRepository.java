package com.thantrick.SpringBoot_openapi_Swagger.repository;

import com.thantrick.SpringBoot_openapi_Swagger.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserByEmail(String email);
}
