package com.abouerp.zsc.register.repository;

import com.abouerp.zsc.register.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Abouerp
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

    Optional<Role> findFirstByIsDefault(Boolean isDefault);
}
