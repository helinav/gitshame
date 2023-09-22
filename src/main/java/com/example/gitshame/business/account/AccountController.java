package com.example.gitshame.business.account;

import com.example.gitshame.business.account.dto.AccountRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @Operation(summary = "Uue kasutaja loomine",
            description = """
                Kasutaja sisestab parooli, emaili, kasutajanime ning valib avatari. Süsteemi lisatakse user tabelisse
                uus kasutaja ning player tabelisse luuakse uus profiil. Kui kasutajanimi või email on juba kasutusel
                saadab süsteem vastu vea error codega 222 või 223""")
    @PostMapping("/account")
    public void addAccount(@RequestBody AccountRequest request) {
        accountService.addAccount(request);
    }
}
