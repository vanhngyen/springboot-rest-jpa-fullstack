package com.example.auth.service;


import com.example.auth.model.Role;
import com.example.auth.model.User;
import com.example.auth.repository.RoleRepository;
import com.example.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
   @Autowired
    private UserRepository userRepository;
   @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username){
       User user = userRepository.findByUsername(username);
       if(user == null) throw new UsernameNotFoundException(username);

       Set<GrantedAuthority> granteAuthorities = new HashSet<>();
       for (Role role : user.getRoles()){
           granteAuthorities.add(new SimpleGrantedAuthority(role.getName()));

       }
       return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),granteAuthorities);

   }
}
