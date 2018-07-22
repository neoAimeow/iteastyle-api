package com.aimeow.iteastyle.Authorities;

import com.aimeow.iteastyle.Authorities.entity.AdminUser;
import com.aimeow.iteastyle.Authorities.entity.JWTUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class JwtAdminUserDetailsServiceImpl implements UserDetailsService {
    private IAdminUserDAO userRepository;

    @Autowired
    public JwtAdminUserDetailsServiceImpl(IAdminUserDAO userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return new JWTUser(user.getUsername(), user.getPassword(), user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        }
    }
}
