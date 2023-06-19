package com.example.springedu3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    PasswordEncoder pe;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String encodePW = pe.encode("1234"); // 패스워드는 테스트의 편의를 위해 1234 로 통일
        UserDetails user;
        if (username.equals("dooly")) {
            user = User.builder()
                    .username("dooly")
                    .password(encodePW)
                    .authorities(AuthorityUtils.createAuthorityList("ROLE_USER"))
                    .build();
        } else if (username.equals("aaa")) {
            user = User.builder()
                    .username("aaa")
                    .password(encodePW)
                    .authorities(AuthorityUtils.createAuthorityList("ROLE_A"))
                    //.roles("A")
                    .build();
        } else if (username.equals("bbb")) {
            user = User.builder()
                    .username("bbb")
                    .password(encodePW)
                    .authorities(AuthorityUtils.createAuthorityList("ROLE_B"))
                    //.roles("B")
                    .build();
        } else {
            throw new UsernameNotFoundException(username+" 명의 유저가 없음!!");
        }
        System.out.println(user);
        return user;
    }

}
