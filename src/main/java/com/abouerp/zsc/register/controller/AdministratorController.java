package com.abouerp.zsc.register.controller;

import com.abouerp.zsc.register.bean.ResultBean;
import com.abouerp.zsc.register.domain.Administrator;
import com.abouerp.zsc.register.domain.Role;
import com.abouerp.zsc.register.mapper.AdministratorMapper;
import com.abouerp.zsc.register.service.AdministratorService;
import com.abouerp.zsc.register.service.RoleService;
import com.abouerp.zsc.register.vo.AdministratorVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.Set;


/**
 * @author Abouerp
 */
@RestController
@RequestMapping("/api/user")
public class AdministratorController {

    private final AdministratorService administratorService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public AdministratorController(AdministratorService administratorService,
                                   RoleService roleService,
                                   PasswordEncoder passwordEncoder) {
        this.administratorService = administratorService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public ResultBean findByMobile(@RequestParam String mobile) {
        return ResultBean.ok(administratorService.existsByUserName(mobile));
    }

    @PostMapping("/register")
    public ResultBean register(@RequestBody AdministratorVO administratorVO) {
        Role role = roleService.findFirstByIsDefault(true);
        if (role == null) {
            return ResultBean.of(200, "Can't find default role");
        }
        Administrator administrator = AdministratorMapper.INSTANCE.toAdmin(administratorVO);
        administrator.setPassword(passwordEncoder.encode(administratorVO.getPassword()));
        administrator.setCreateBy("anonymous");
        administrator.setUpdateBy(administratorVO.getUsername());
        Set<Role> roles = Collections.singleton(roleService.findFirstByIsDefault(true));
        administrator.setRoles(roles);
        administratorService.save(administrator);
        return ResultBean.ok();
    }
}
