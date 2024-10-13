package com.enes.expensetracker.controller;

import com.enes.expensetracker.model.dto.request.user.UserRequest;
import com.enes.expensetracker.model.dto.response.user.UserResponse;
import com.enes.expensetracker.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @RequestBody @Valid UserRequest request
    ){
        return ResponseEntity.ok(userService.createUser(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponse> findUserByIdl(
            @PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PutMapping("/{user-id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable("user-id") Long userId,
            @RequestBody @Valid UserRequest request
    ) {
        return ResponseEntity.ok(userService.updateUser(userId, request));
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable("user-id") Long userId
    ) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build(); // 204 No Content döner, başarılı silme işleminde içerik dönmez
    }

}
