package projekti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String showLoginPage(){
        return "index";
    }

    @PostMapping("/signup")
    public String create(@RequestParam String username, @RequestParam String email, @RequestParam String password){
        System.out.println("create user next");
        accountService.createUser(username, email, password);
        return "redirect:/tweets";
    }

    @GetMapping("/users/{username}")
    public String showMyPage(){
        return "myPage";
    }
}