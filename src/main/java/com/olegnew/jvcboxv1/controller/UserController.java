package com.olegnew.jvcboxv1.controller;

import com.olegnew.jvcboxv1.dto.UserRequestDto;
import com.olegnew.jvcboxv1.dto.UserResponseDto;
import com.olegnew.jvcboxv1.model.User;
import com.olegnew.jvcboxv1.service.RoleService;
import com.olegnew.jvcboxv1.service.UserService;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@Tag(name = "User Controller", description = "The controller allows you to create, "
        + "modify, delete a user.\n"
        + "Allows you to get a list of all users, get a user by ID\n +"
        + " Контроллер позволяет создавать, изменять, удалять пользователя.\n"
        + "Позволяет получить список всех пользователей, получить пользователя по ID")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final RoleService roleService;

    @Operation(summary = "Gets all users", tags = "User Controller")
    @Schema(title = "List all users")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "List all Users",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    })
    })
    @GetMapping("/")
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userService.getAllusers();
        List<UserResponseDto> userDto = users.stream()
                .map(e -> modelMapper.map(e, UserResponseDto.class))
                .collect(Collectors.toList());
        return userDto;
    }

    @Operation(summary = "Get user by ID", tags = "User Controller")
    @Schema(title = "Get user by ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found user by Id",
                    content = {
                            @Content(
                                    mediaType = "application/json"),
                    })
    })
    @GetMapping("/{id}")
    public UserResponseDto getById(@Valid @PathVariable
                                       @ApiParam(
                                               name = "User ID",
                                               type = "Long",
                                               value = "ID of the user you are looking for",
                                               example = "1")
                                       Long id) {
        Optional<User> user = userService.getById(id);
        return modelMapper.map(user.get(), UserResponseDto.class);
    }

    @Operation(summary = "Adding a new user", tags = "User Controller")
    @Schema(title = "Adding a new user")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "User ID, User name and ROLE List",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    })
    })
    @PostMapping("/add")
    public UserResponseDto add(@Valid @RequestBody
                                   @ApiParam(
                                           name = "User ",
                                           type = "User",
                                           value = "User name, password and ROLE List")
                                   UserRequestDto userRequestDto) {
        userRequestDto.setRoles(userRequestDto.getRoles().stream()
                .map(r -> roleService.findRoleByRoleName(r.getRoleName()))
                .collect(Collectors.toSet()));
        User user = userService.add(modelMapper.map(userRequestDto, User.class));
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Operation(summary = "Update user by ID", tags = "User Controller")
    @Schema(title = "Update user by ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Updated User name, password and ROLE List",
                    content = {
                            @Content(
                                    mediaType = "application/json"),
                    })
    })
    @PutMapping("/update/{id}")
    public UserResponseDto update(@Valid @PathVariable
                                      @ApiParam(
                                              name = "User ID",
                                              type = "Long",
                                              value = "ID of the user to be upated",
                                              example = "1") Long id,
                                  @RequestBody
                                  @ApiParam(
                                          name = "User",
                                          type = "Long",
                                          value = "User name, password and list of roles",
                                          example = "1")
                                  UserRequestDto userRequestDto) {
        User user = modelMapper.map(userRequestDto, User.class);
        user.setId(id);
        return modelMapper.map(userService.update(user), UserResponseDto.class);
    }

    @Operation(summary = "Delete user by ID", tags = "User Controller")
    @Schema(title = "Delete user by ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ok",
                    content = {
                            @Content(
                                    mediaType = "application/json"),
                    })
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable
                           @ApiParam(
                                   name = "User ID",
                                   type = "Long",
                                   value = "ID of the user to be deleted",
                                   example = "1")
                           Long id) {
        userService.delete(id);
    }
}
