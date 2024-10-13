package com.enes.expensetracker.service.impl;

import com.enes.expensetracker.model.dto.request.user.UserRequest;
import com.enes.expensetracker.model.dto.response.user.UserResponse;
import com.enes.expensetracker.repository.UserRepository;
import com.enes.expensetracker.service.UserService;
import com.enes.expensetracker.service.business.UserBusinessRules;
import com.enes.expensetracker.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserBusinessRules userBusinessRules;


    @Override
    public UserResponse createUser(UserRequest request) {
        // E-posta ile aynı kullanıcı var mı kontrolü
        userBusinessRules.checkIfEmailExists(request.email());

        var user = userRepository.save(UserMapper.INSTANCE.toUser(request));
        return UserMapper.INSTANCE.toUserResponse(user);
    }

    @Override
    public List<UserResponse> findAllUsers() {
        return  userRepository.findAll()
                .stream()
                .map(UserMapper.INSTANCE::toUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(Long id) {
        return userBusinessRules.getUserResponseIfExist(id);
    }

    @Override
    public UserResponse updateUser(Long userId, UserRequest request) {
        var user = userBusinessRules.getUserIfExist(userId);
        userBusinessRules.mergeUser(user, request);
        userRepository.save(user);
        return userBusinessRules.convertToUserResponse(user);
    }

    @Override
    public void deleteUser(Long userId) {
        var user = userBusinessRules.getUserIfExist(userId);
        userRepository.delete(user);
    }


}
