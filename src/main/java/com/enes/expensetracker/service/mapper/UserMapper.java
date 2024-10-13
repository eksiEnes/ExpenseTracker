package com.enes.expensetracker.service.mapper;

import com.enes.expensetracker.model.User;
import com.enes.expensetracker.model.dto.request.User.UserRequest;

import com.enes.expensetracker.model.dto.request.User.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserRequest request);

    UserResponse toUserResponse(User user);


}
