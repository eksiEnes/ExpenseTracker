package com.enes.expensetracker.service;


import com.enes.expensetracker.model.dto.request.User.UserRequest;
import com.enes.expensetracker.model.dto.request.User.UserResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {


    UserResponse createUser(@Valid UserRequest request);

    List<UserResponse> findAllUsers();

    UserResponse findById(Long id);

    UserResponse updateUser(Long userId, @Valid UserRequest request);

    void deleteUser(Long userId);
}
