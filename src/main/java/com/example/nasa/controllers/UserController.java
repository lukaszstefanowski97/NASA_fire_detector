package com.example.nasa.controllers;

import com.example.nasa.dto.UserDTO;
import com.example.nasa.entities.User;
import com.example.nasa.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllFireNotifications() {
        List<UserDTO> userDTOs = userService.getAllUsers();

        return userDTOs.isEmpty() ? new ResponseEntity<>(userDTOs, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getFireNotificationById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);

        return userDTO != null ? new ResponseEntity<>(userDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> addFireNotification(@RequestBody User user) {
        userService.saveUser(user);
        UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getSurname(), user.getCellPhoneNumber(),
                user.getEmail(), user.getPhoto());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> editFireNotificationById(@PathVariable Long id,
                                                            @RequestBody User user) {

        UserDTO userDTO = userService.editUserById(id, user);

        return userDTO != null ? new ResponseEntity<>(userDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteFireNotificationById(@PathVariable Long id) {
        UserDTO removedUserDTO = userService.deleteUserById(id);

        return removedUserDTO != null ? new ResponseEntity<>(removedUserDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
