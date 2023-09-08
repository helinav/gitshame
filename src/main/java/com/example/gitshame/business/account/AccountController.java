package com.example.gitshame.business.account;

import com.example.gitshame.business.account.dto.AccountRequest;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account")
    public void addAccount(@RequestBody AccountRequest request) {
        accountService.addAccount(request);
    }
}
