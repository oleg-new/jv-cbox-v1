package com.olegnew.jvcboxv1.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.olegnew.jvcboxv1.model.User;
import com.olegnew.jvcboxv1.repository.UserRepository;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#getByName(String)}
     */
    @Test
    void testGetByName() {
        User user = new User();
        user.setId(1L);
        user.setLocked(true);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        when(userRepository.findByName(Mockito.<String>any())).thenReturn(user);
        assertSame(user, userServiceImpl.getByName("Name"));
        verify(userRepository).findByName(Mockito.<String>any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getAllusers()}
     */
    @Test
    void testGetAllusers() {
        ArrayList<User> userList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userList);
        List<User> actualAllusers = userServiceImpl.getAllusers();
        assertSame(userList, actualAllusers);
        assertTrue(actualAllusers.isEmpty());
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link UserServiceImpl#getById(Long)}
     */
    @Test
    void testGetById() {
        User user = new User();
        user.setId(1L);
        user.setLocked(true);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Optional<User> actualById = userServiceImpl.getById(1L);
        assertSame(ofResult, actualById);
        assertTrue(actualById.isPresent());
        verify(userRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link UserServiceImpl#add(User)}
     */
    @Test
    void testAdd() {
        User user = new User();
        user.setId(1L);
        user.setLocked(true);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        when(userRepository.save(Mockito.<User>any())).thenReturn(user);
        when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

        User user2 = new User();
        user2.setId(1L);
        user2.setLocked(true);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setRoles(new HashSet<>());
        assertSame(user, userServiceImpl.add(user2));
        verify(userRepository).save(Mockito.<User>any());
        verify(passwordEncoder).encode(Mockito.<CharSequence>any());
        assertEquals("secret", user2.getPassword());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(User)}
     */
    @Test
    void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setLocked(true);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        when(userRepository.save(Mockito.<User>any())).thenReturn(user);
        when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

        User user2 = new User();
        user2.setId(1L);
        user2.setLocked(true);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setRoles(new HashSet<>());
        assertSame(user, userServiceImpl.update(user2));
        verify(userRepository).save(Mockito.<User>any());
        verify(passwordEncoder).encode(Mockito.<CharSequence>any());
        assertEquals("secret", user2.getPassword());
    }

    /**
     * Method under test: {@link UserServiceImpl#delete(Long)}
     */
    @Test
    void testDelete() {
        doNothing().when(userRepository).deleteById(Mockito.<Long>any());
        userServiceImpl.delete(1L);
        verify(userRepository).deleteById(Mockito.<Long>any());
    }
}

