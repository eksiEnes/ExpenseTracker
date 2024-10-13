package com.enes.expensetracker.service.mapper;

import com.enes.expensetracker.model.User;
import com.enes.expensetracker.model.dto.request.User.UserRequest;

import com.enes.expensetracker.model.dto.request.User.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User toUser(UserRequest request){
        if(request == null){
            return null;
        }
        return User.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public UserResponse fromUser(User user){
        return new UserResponse(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

}
