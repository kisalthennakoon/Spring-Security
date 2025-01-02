package com.kisal.Security.Controller;

import com.kisal.Security.Model.User;
import com.kisal.Security.Service.JwtService;
import com.kisal.Security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        if(userService.verify(user)){
            return ResponseEntity.ok(jwtService.generateToken(user.getUsername()));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
