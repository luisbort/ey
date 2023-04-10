package com.ey.controllers.user.read;

import com.ey.model.dtos.UserDTO;
import com.ey.services.ports.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserReadController {

    @Autowired
    private UserService userService;

    public UserReadController() {
        System.out.println("UserReadController Initialized");
    }

    @GetMapping("/findAllUsers")
    public List<UserDTO> findAllUsers(){

        return userService.findAll();
    }

}
