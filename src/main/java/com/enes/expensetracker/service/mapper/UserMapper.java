package com.enes.expensetracker.service.mapper;

import com.enes.expensetracker.model.User;
import com.enes.expensetracker.model.dto.request.user.UserRequest;

import com.enes.expensetracker.model.dto.response.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserRequest request);

    UserResponse toUserResponse(User user);


}
