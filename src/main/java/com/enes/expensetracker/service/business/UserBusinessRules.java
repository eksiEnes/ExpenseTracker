package com.enes.expensetracker.service.business;


import com.enes.expensetracker.exception.type.BusinessException;
import com.enes.expensetracker.model.User;
import com.enes.expensetracker.model.dto.request.User.UserRequest;
import com.enes.expensetracker.model.dto.request.User.UserResponse;
import com.enes.expensetracker.repository.UserRepository;
import com.enes.expensetracker.service.TransactionService;
import com.enes.expensetracker.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserBusinessRules {

    private final UserRepository userRepository;
    private final TransactionService transactionService;
    private final UserMapper mapper;

    public void mergeUser(User user, UserRequest request) {
        if (StringUtils.isNoneBlank(request.firstName())) {
            user.setFirstName(request.firstName());
        }
        if (StringUtils.isNoneBlank(request.lastName())) {
            user.setLastName(request.lastName());
        }
        if (StringUtils.isNoneBlank(request.email())) {
            user.setEmail(request.email());
        }
        if (StringUtils.isNoneBlank(request.password())) {
            user.setPassword(request.password());
        }
    }

    // User nesnesini UserResponse'a dönüştürür
    public UserResponse convertToUserResponse(User user) {
        return mapper.fromUser(user);
    }

    public User getUserIfExist(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BusinessException(String.format("No user found with the provided id: %d", id)));
    }

    // Kullanıcı var mı diye kontrol eder ve UserResponse nesnesini döner
    public UserResponse getUserResponseIfExist(Long id) {
        User user = getUserIfExist(id); // Aynı kontrolü tekrar etmemek için bu metod kullanılır
        return mapper.fromUser(user);
    }


    public void checkIfEmailExists(String email) {
        boolean emailExists = userRepository.existsByEmail(email);
        if (emailExists) {
            throw new BusinessException(String.format("A user with email '%s' already exists.", email));
        }
    }


}
