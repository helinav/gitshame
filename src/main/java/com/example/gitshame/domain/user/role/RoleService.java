package com.example.gitshame.domain.user.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Resource
    private RoleRepository roleRepository;


    public Role getRolePlayer() {
        return roleRepository.getReferenceById(2);
    }
}
