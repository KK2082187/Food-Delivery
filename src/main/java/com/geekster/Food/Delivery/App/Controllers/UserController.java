package com.geekster.Food.Delivery.App.Controllers;

import com.geekster.Food.Delivery.App.Dto.SignInInput;
import com.geekster.Food.Delivery.App.Dto.SignInOutput;
import com.geekster.Food.Delivery.App.Dto.SignUpOutput;
import com.geekster.Food.Delivery.App.Models.User;
import com.geekster.Food.Delivery.App.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody User signUpInput){
        return userService.signUp(signUpInput);
    }
    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInInput){
        return userService.signIn(signInInput);
    }
}
