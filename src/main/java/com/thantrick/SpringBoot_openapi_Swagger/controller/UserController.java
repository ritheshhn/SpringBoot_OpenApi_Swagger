package com.thantrick.SpringBoot_openapi_Swagger.controller;

import com.thantrick.SpringBoot_openapi_Swagger.dto.UserDto;
import com.thantrick.SpringBoot_openapi_Swagger.model.UserDetailsRequestModel;
import com.thantrick.SpringBoot_openapi_Swagger.model.UserResponseModel;
import com.thantrick.SpringBoot_openapi_Swagger.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Adding a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created"),
            @ApiResponse(responseCode = "500", description = "User already registered")
    })
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDetailsRequestModel userDetails){

        UserDto user = new UserDto();
        BeanUtils.copyProperties(userDetails, user);

        UserDto createdUser = userService.addUser(user);

        UserResponseModel userResponse = new UserResponseModel();
        BeanUtils.copyProperties(createdUser, userResponse);

        return new ResponseEntity<UserResponseModel>(userResponse,HttpStatus.CREATED);
    }

    @Operation(summary = "Fetching a user by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/id/{id}")
    public UserDetailsRequestModel getUserById(@PathVariable long id){
        userService.getUserById(id);
        return null;
    }

    @Operation(summary = "Fetching a user by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/email/{email}")
    public UserResponseModel getUserById(@PathVariable String email){
        UserDto userByEmail = userService.getUserByEmail(email);
        UserResponseModel userResponseModel = new UserResponseModel();
        BeanUtils.copyProperties(userByEmail, userResponseModel);
        return userResponseModel;
    }


    @Operation(summary = "Fetching all users")
    @ApiResponse(responseCode = "200", description = "Users found")
    @GetMapping
    public List<UserDetailsRequestModel> getAllUsers(){
        userService.getAllUsers();
        return null;
    }

    @Operation(summary = "Updating a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PutMapping
    public UserDetailsRequestModel updateUser(@RequestBody UserDetailsRequestModel user){
        //userService.updateUser(user);
        return null;
    }

    @Operation(summary = "Deleting a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }

}