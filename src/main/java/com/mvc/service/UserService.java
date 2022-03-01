package com.mvc.service;

import com.mvc.model.AppUser;
import com.mvc.repo.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Transactional

public class UserService implements IAppUserService, UserDetailsService {
    @Autowired
    private IAppUserRepo userRepo;

    @Override
    public AppUser getUserByUserName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = getUserByUserName(username);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(user.getRole());
        UserDetails userDetails = new User(user.getName(), user.getPassword(), authorityList);
        return userDetails;
    }
}
