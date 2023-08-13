package com.elinsky.threeonethree.service;

import com.elinsky.threeonethree.model.Role;
import com.elinsky.threeonethree.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoleSrvImpl implements RoleService {

    private final RoleRepo roleRepo;
    @Autowired
    public RoleSrvImpl(RoleRepo roleRepo) {

        this.roleRepo = roleRepo;
    }

    @Override
    public void save(Role role) {

        roleRepo.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return
                roleRepo.findAll();
    }

    @Override
    public Role getOneRole(Long id) {
        Optional<Role> role = roleRepo.findById(id);
        return role.orElse(new Role());
    }
}
