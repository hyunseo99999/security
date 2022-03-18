package com.security.service;

import com.security.domain.Account;
import com.security.domain.AccountDto;

public interface UserService {

    void createUser(Account account) throws Exception;
}
