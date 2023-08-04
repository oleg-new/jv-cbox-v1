package com.olegnew.jvcboxv1.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.olegnew.jvcboxv1.model.Role;
import com.olegnew.jvcboxv1.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RoleServiceImpl.class})
@ExtendWith(SpringExtension.class)
class RoleServiceImplTest {
    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    /**
     * Method under test: {@link RoleServiceImpl#create(Role)}
     */
    @Test
    void testCreate() {
        Role role = new Role();
        role.setId(1L);
        role.setRoleName(Role.RoleName.ROLE_ADMIN);
        when(roleRepository.save(Mockito.<Role>any())).thenReturn(role);

        Role role2 = new Role();
        role2.setId(1L);
        role2.setRoleName(Role.RoleName.ROLE_ADMIN);
        assertSame(role, roleServiceImpl.create(role2));
        verify(roleRepository).save(Mockito.<Role>any());
    }

    /**
     * Method under test: {@link RoleServiceImpl#findRoleByRoleName(Role.RoleName)}
     */
    @Test
    void testFindRoleByRoleName() {
        Role role = new Role();
        role.setId(1L);
        role.setRoleName(Role.RoleName.ROLE_ADMIN);
        when(roleRepository.findRoleByRoleName(Mockito.<Role.RoleName>any())).thenReturn(role);
        assertSame(role, roleServiceImpl.findRoleByRoleName(Role.RoleName.ROLE_ADMIN));
        verify(roleRepository).findRoleByRoleName(Mockito.<Role.RoleName>any());
    }

    /**
     * Method under test: {@link RoleServiceImpl#findRoleByRoleName(Role.RoleName)}
     */
    @Test
    void testFindRoleByRoleName2() {
        Role role = new Role();
        role.setId(1L);
        role.setRoleName(Role.RoleName.ROLE_ADMIN);
        when(roleRepository.findRoleByRoleName(Mockito.<Role.RoleName>any())).thenReturn(role);
        assertSame(role, roleServiceImpl.findRoleByRoleName(Role.RoleName.ROLE_OPERATOR));
        verify(roleRepository).findRoleByRoleName(Mockito.<Role.RoleName>any());
    }

    /**
     * Method under test: {@link RoleServiceImpl#findRoleByRoleName(Role.RoleName)}
     */
    @Test
    void testFindRoleByRoleName3() {
        Role role = new Role();
        role.setId(1L);
        role.setRoleName(Role.RoleName.ROLE_ADMIN);
        when(roleRepository.findRoleByRoleName(Mockito.<Role.RoleName>any())).thenReturn(role);
        assertSame(role, roleServiceImpl.findRoleByRoleName(Role.RoleName.ROLE_USER));
        verify(roleRepository).findRoleByRoleName(Mockito.<Role.RoleName>any());
    }
}

