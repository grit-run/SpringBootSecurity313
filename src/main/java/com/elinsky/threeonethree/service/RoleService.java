package com.elinsky.threeonethree.service;

import com.elinsky.threeonethree.model.Role;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    void save(Role role);

    List<Role> getAllRoles();

    Role getOneRole(Long id);
}
