package com.educonnect.rithikraj.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.educonnect.rithikraj.dto.request.RegisterRequest;
import com.educonnect.rithikraj.dto.request.UpdatePassRequest;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.dto.response.UserResponse;
import com.educonnect.rithikraj.model.User;
import com.educonnect.rithikraj.repository.UserRepository;
import com.educonnect.rithikraj.service.UserService;
import com.educonnect.rithikraj.utils.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public MessageResponse register(RegisterRequest request) {
        Optional<User> isUser = userRepository.findByEmail(request.getEmail());
        

        if (isUser.isPresent()) {
            return MessageResponse.builder()
                                    .message("User already exists with email " + request.getEmail())
                                    .build();
        }

        var user = User.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .mobile(request.getMobile())
                        .build();

        userRepository.save(user);

        return MessageResponse.builder().message("User registered successfully").build();
    }

    @Override
    public UserResponse getById(String id) throws UserNotFoundException {
        Optional<User> isUser = userRepository.findById(id);

        if (isUser.isEmpty()) {
            throw new UserNotFoundException("User not found with id " + id);
        }

        return UserResponse.builder()
                            .name(isUser.get().getName())
                            .email(isUser.get().getEmail())
                            .mobile(isUser.get().getMobile())
                            .password(isUser.get().getPassword())
                            .build();
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .mobile(user.getMobile())
                .build())
                .collect(Collectors.toList());
        // return users.map(user -> UserResponse.builder().name(user.getName()).email(user.getEmail()).build());
    }

    @Override
    public MessageResponse delete(String id) {
        Optional<User> isUser = userRepository.findById(id);

        if (isUser.isEmpty()) {
            return MessageResponse.builder().message("User not found with id " + id).build();
        }

        userRepository.delete(isUser.get());

        return MessageResponse.builder().message("User deleted successfully").build();
    }

    @Override
    public MessageResponse updatePassword(UpdatePassRequest request) {
        Optional<User> isUser = userRepository.findByEmail(request.getEmail());

        if (isUser.isEmpty()) {
            return MessageResponse.builder().message("User not found with email " + request.getEmail()).build();
        }

        var user = User.builder().name(isUser.get().getName()).email(isUser.get().getEmail()).mobile(isUser.get().getMobile()).role(isUser.get().getRole()).password(request.getNewPassword()).build();

        userRepository.save(user);

        return MessageResponse.builder().message("Password updated successfully").build();
    }
}
