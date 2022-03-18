package com.security.controller.user;

import com.security.domain.Account;
import com.security.domain.AccountDto;
import com.security.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/mypage")
    public String myPage() throws Exception {
        return "user/mypage";
    }

    @GetMapping(value = "/users")
    public String users() throws Exception {
        return "user/login/register";
    }

    @PostMapping(value = "/users")
    public String createUser(AccountDto accountDto) throws Exception {
        ModelMapper mapper = new ModelMapper();
        Account account = mapper.map(accountDto, Account.class);
        userService.createUser(account);

        return "redirect:/";
    }
}
