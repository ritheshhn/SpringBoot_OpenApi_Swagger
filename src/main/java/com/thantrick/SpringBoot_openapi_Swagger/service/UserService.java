package com.thantrick.SpringBoot_openapi_Swagger.service;

import com.thantrick.SpringBoot_openapi_Swagger.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto addUser(UserDto user);

    UserDto getUserById(long id);

    UserDto getUserByEmail(String email);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(long id);

}
