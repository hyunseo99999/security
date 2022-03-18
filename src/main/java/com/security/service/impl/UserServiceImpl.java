package com.security.service.impl;

import com.security.domain.Account;
import com.security.domain.AccountDto;
import com.security.repository.UserRepository;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(Account account) throws Exception {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        userRepository.save(account);
    }
}
