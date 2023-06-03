package com.olegnew.jvcboxv1.service;

import com.olegnew.jvcboxv1.model.Role;

public interface RoleService {
    Role create(Role role);

    Role findRoleByRoleName(Role.RoleName rolName);
}
