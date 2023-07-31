package com.olegnew.jvcboxv1.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olegnew.jvcboxv1.dto.UserRequestDto;
import com.olegnew.jvcboxv1.dto.UserResponseDto;
import com.olegnew.jvcboxv1.model.Role;
import com.olegnew.jvcboxv1.model.User;
import com.olegnew.jvcboxv1.service.RoleService;
import com.olegnew.jvcboxv1.service.UserService;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private RoleService roleService;

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#getById(String)}
     */
    @Test
    void testGetById() throws Exception {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId("42");
        userResponseDto.setName("Name");
        userResponseDto.setRoles(new HashSet<>());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserResponseDto>>any())).thenReturn(userResponseDto);

        User user = new User();
        user.setId(1L);
        user.setLocked(true);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user);
        when(userService.getById(Mockito.<String>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/user/{id}", "42");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":\"42\",\"name\":\"Name\",\"roles\":[]}"));
    }

    /**
     * Method under test: {@link UserController#add(UserRequestDto)}
     */
    @Test
    void testAdd() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setLocked(true);
        user.setName("?");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(user);

        User user2 = new User();
        user2.setId(1L);
        user2.setLocked(true);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setRoles(new HashSet<>());
        when(userService.add(Mockito.<User>any())).thenReturn(user2);

        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setName("?");
        userRequestDto.setPassword("iloveyou");
        userRequestDto.setRoles(new HashSet<>());
        String content = (new ObjectMapper()).writeValueAsString(userRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link UserController#delete(Long)}
     */
    @Test
    void testDelete() throws Exception {
        doNothing().when(userService).delete(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/user/{id}", 1L);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UserController#delete(Long)}
     */
    @Test
    void testDelete2() throws Exception {
        doNothing().when(userService).delete(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/user/{id}", 1L);
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UserController#getAllUsers()}
     */
    @Test
    void testGetAllUsers() throws Exception {
        when(userService.getAllusers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/user/");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserController#getAllUsers()}
     */
    @Test
    void testGetAllUsers2() throws Exception {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId("42");
        userResponseDto.setName("Name");
        userResponseDto.setRoles(new HashSet<>());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserResponseDto>>any())).thenReturn(userResponseDto);

        User user = new User();
        user.setId(1L);
        user.setLocked(true);
        user.setName("?");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userService.getAllusers()).thenReturn(userList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/user/");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":\"42\",\"name\":\"Name\",\"roles\":[]}]"));
    }

    /**
     * Method under test: {@link UserController#getAllUsers()}
     */
    @Test
    void testGetAllUsers3() throws Exception {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId("42");
        userResponseDto.setName("Name");
        userResponseDto.setRoles(new HashSet<>());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserResponseDto>>any())).thenReturn(userResponseDto);

        User user = new User();
        user.setId(1L);
        user.setLocked(true);
        user.setName("?");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        User user2 = new User();
        user2.setId(2L);
        user2.setLocked(false);
        user2.setName("Name");
        user2.setPassword("?");
        user2.setRoles(new HashSet<>());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user2);
        userList.add(user);
        when(userService.getAllusers()).thenReturn(userList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/user/");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":\"42\",\"name\":\"Name\",\"roles\":[]},{\"id\":\"42\",\"name\":\"Name\",\"roles\":[]}]"));
    }

    /**
     * Method under test: {@link UserController#update(Long, UserRequestDto)}
     */
  /*  @Test
    @Disabled("TODO: Complete this test")
    void testUpdate() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ClassCastException: class com.olegnew.jvcboxv1.model.User cannot be cast to class com.olegnew.jvcboxv1.dto.UserResponseDto (com.olegnew.jvcboxv1.model.User and com.olegnew.jvcboxv1.dto.UserResponseDto are in unnamed module of loader com.diffblue.cover.f.g @35fbfd82)
        //       at com.olegnew.jvcboxv1.controller.UserController.update(UserController.java:60)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:684)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVars = new Object[]{1L};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/v1/user/update/{id}", uriVars)
                .contentType(MediaType.APPLICATION_JSON);

        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setName("Name");
        userRequestDto.setPassword("iloveyou");
        HashSet<Role> roles = new HashSet<>();
        userRequestDto.setRoles(roles);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(userRequestDto));
        Object[] controllers = new Object[]{userController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }*/
}

