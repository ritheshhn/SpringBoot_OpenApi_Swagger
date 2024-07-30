package com.thantrick.SpringBoot_openapi_Swagger.service;

import com.thantrick.SpringBoot_openapi_Swagger.dto.UserDto;
import com.thantrick.SpringBoot_openapi_Swagger.entity.UserEntity;
import com.thantrick.SpringBoot_openapi_Swagger.repository.UserRepository;
import com.thantrick.SpringBoot_openapi_Swagger.utils.GeneralUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GeneralUtils utils;


    @Override
    public UserDto addUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        UserEntity userByEmail = userRepository.findUserByEmail(user.getEmail());

        if(userByEmail != null){
            throw new RuntimeException("EmailId already registered. Please try login or use another Email Id");
        }

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId(utils.generateUserId(25));

        UserEntity savedUser = userRepository.save(userEntity);

        BeanUtils.copyProperties(savedUser, user);
        return user;
    }

    @Override
    public UserDto getUserById(long id) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRepository.findUserByEmail(email), userDto);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }

}
