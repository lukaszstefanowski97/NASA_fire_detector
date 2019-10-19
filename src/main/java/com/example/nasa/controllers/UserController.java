package com.example.nasa.controllers;

import com.example.nasa.dto.UserDTO;
import com.example.nasa.entities.User;
import com.example.nasa.messages.UserMessages;
import com.example.nasa.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userService.getAllUsers();

        log.info(UserMessages.GETTING_ALL_USERS);

        return userDTOs.isEmpty() ? new ResponseEntity<>(userDTOs, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);

        log.info(UserMessages.USER_BY_ID);

        return userDTO != null ? new ResponseEntity<>(userDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> addUser(@RequestBody User user) {
        userService.saveUser(user);
        UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getSurname(), user.getCellPhoneNumber(),
                user.getEmail(), user.getPhoto());

        log.info(UserMessages.ADDED_USER + userDTO.toString());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> editUserById(@PathVariable Long id,
                                                @RequestBody User user) {

        UserDTO userDTO = userService.editUserById(id, user);

        log.info(UserMessages.EDITED_USER + userDTO);

        return userDTO != null ? new ResponseEntity<>(userDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUserById(@PathVariable Long id) {
        UserDTO removedUserDTO = userService.deleteUserById(id);

        log.info(UserMessages.DELETED_USER + id);

        return removedUserDTO != null ? new ResponseEntity<>(removedUserDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
