package com.example.nasa.services;

import com.example.nasa.dto.UserDTO;
import com.example.nasa.entities.User;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO deleteUserById(Long id);

    UserDTO editUserById(Long id, User userCommand);

    UserDTO saveUser(User user);
}
