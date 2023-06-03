package com.olegnew.jvcboxv1.service.impl;

import com.olegnew.jvcboxv1.model.Role;
import com.olegnew.jvcboxv1.repository.RoleRepository;
import com.olegnew.jvcboxv1.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role create(Role role) {
        return repository.save(role);
    }

    @Override
    public Role findRoleByRoleName(Role.RoleName rolName) {
        return repository.findRoleByRoleName(rolName);
    }

}
