package com.abouerp.zsc.register.repository;

import com.abouerp.zsc.register.domain.Administrator;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Abouerp
 */
@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer>{
    @EntityGraph(attributePaths = "roles.authorities")
    Optional<Administrator> findFirstByUsername(String username);

    @EntityGraph(attributePaths = "roles.authorities")
    Optional<Administrator> findFirstByMobile(String mobile);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByMobile(String mobile);
}
