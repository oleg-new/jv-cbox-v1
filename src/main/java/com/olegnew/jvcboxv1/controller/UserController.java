package com.olegnew.jvcboxv1.controller;

import com.olegnew.jvcboxv1.dto.UserRequestDto;
import com.olegnew.jvcboxv1.dto.UserResponseDto;
import com.olegnew.jvcboxv1.model.Role;
import com.olegnew.jvcboxv1.model.User;
import com.olegnew.jvcboxv1.service.RoleService;
import com.olegnew.jvcboxv1.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/")
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userService.getAllusers();
        List<UserResponseDto> userDto = users.stream()
                .map(e -> modelMapper.map(e, UserResponseDto.class))
                .collect(Collectors.toList());
        return userDto;
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@Valid @PathVariable String id) {
        Optional<User> user = userService.getById(id);
        return modelMapper.map(user.get(), UserResponseDto.class);
    }

    @PostMapping("/add")
    public UserResponseDto add(@Valid @RequestBody UserRequestDto userRequestDto) {
        userRequestDto.setRoles(userRequestDto.getRoles().stream()
                .map(r -> roleService.findRoleByRoleName(r.getRoleName()))
                .collect(Collectors.toSet()));
        User user = userService.add(modelMapper.map(userRequestDto, User.class));
        return modelMapper.map(user, UserResponseDto.class);
    }

    @PutMapping("/update/{id}")
    public UserResponseDto update(@Valid @PathVariable Long id,
                                  @RequestBody UserRequestDto userRequestDto) {
        User user = modelMapper.map(userRequestDto, User.class);
        user.setId(id);
        return modelMapper.map(userService.update(user), UserResponseDto.class);
    }

    @GetMapping("/inject")
    public User inject() {
        Role testRole2 = roleService.findRoleByRoleName(Role.RoleName.USER);
        Set setRoles = new HashSet<>();
        setRoles.add(testRole2);
        User testUser = new User();
        testUser.setName("User");
        testUser.setPassword("admin");
        testUser.setRoles(setRoles);
        testUser.setLocked(false);
        return userService.add(testUser);
    }
}
