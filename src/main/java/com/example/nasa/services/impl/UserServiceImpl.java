package com.example.nasa.services.impl;

import com.example.nasa.dto.UserDTO;
import com.example.nasa.entities.User;
import com.example.nasa.repositories.UserRepository;
import com.example.nasa.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(new UserDTO(user.getId(), user.getName(), user.getSurname(), user.getCellPhoneNumber(),
                    user.getEmail(), user.getPhoto(), user.getNotificationRangeInMeters(), user.getX(),user.getY()));
        }

        return userDTOs;
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.map(value -> new UserDTO(value.getId(), value.getName(), value.getSurname(),
                value.getCellPhoneNumber(), value.getEmail(),
                value.getPhoto(), value.getNotificationRangeInMeters(), value.getX(),value.getY())).orElse(null);

    }

    @Override
    public UserDTO deleteUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.deleteById(id);
            return new UserDTO(user.get().getId(), user.get().getName(), user.get().getSurname(),
                    user.get().getCellPhoneNumber(), user.get().getEmail(),
                    user.get().getPhoto(), user.get().getNotificationRangeInMeters(), user.get().getX(),user.get().getY());
        }

        return null;
    }

    @Override
    public UserDTO editUserById(Long id, User userCommand) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.deleteById(id);
            return new UserDTO(userRepository.save(userCommand).getId(), userCommand.getName(), userCommand.getSurname(),
                    userCommand.getCellPhoneNumber(), userCommand.getEmail(),
                    userCommand.getPhoto(), userCommand.getNotificationRangeInMeters(),userCommand.getX(),userCommand.getY());
        }
        return null;
    }

    @Override
    public UserDTO saveUser(User user) {
        userRepository.save(user);
        return new UserDTO(user.getId(), user.getName(), user.getSurname(),
                user.getCellPhoneNumber(), user.getEmail(), user.getPhoto(),
                user.getNotificationRangeInMeters(),user.getX(),user.getY());
    }
}
