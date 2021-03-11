package com.abouerp.zsc.register.service;

import com.abouerp.zsc.register.domain.Administrator;
import com.abouerp.zsc.register.repository.AdministratorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Abouerp
 */
@Service
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public Administrator save(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public boolean existsByUserName(String username) {
//        Boolean flag1 = administratorRepository.existsByUsername(username);
//        Boolean flag2 = administratorRepository.existsByEmail(username);
        Boolean flag3 = administratorRepository.existsByMobile(username);
//        if (Boolean.FALSE.equals(flag1) && flag1.equals(flag2) && flag2.equals(flag3)) {
        if (Boolean.FALSE.equals(flag3)) {
            return false;
        }
        return true;
    }

}
