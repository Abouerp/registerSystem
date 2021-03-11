package com.abouerp.zsc.register.service;

import com.abouerp.zsc.register.domain.Role;
import com.abouerp.zsc.register.repository.RoleRepository;
import org.springframework.stereotype.Service;


/**
 * @author Abouerp
 */
@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findFirstByIsDefault(Boolean isDefault) {
        return roleRepository.findFirstByIsDefault(isDefault).orElse(null);
    }
}
