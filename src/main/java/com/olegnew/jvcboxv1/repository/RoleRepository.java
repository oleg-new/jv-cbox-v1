package com.olegnew.jvcboxv1.repository;

import com.olegnew.jvcboxv1.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(Role.RoleName rolName);
}

