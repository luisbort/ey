package com.ey.controllers.user.create;

import com.ey.domain.dtos.UserDTO;
import com.ey.services.ports.CountryService;
import com.ey.services.ports.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserCreateController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private UserService userService;

    public UserCreateController() {
        System.out.println("UserCreateController Initialized");
    }


    @PostMapping(value = "/createUser")
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDto) {
        UserDTO userCreated = userService.createUser(userDto);
        return new ResponseEntity(userCreated, HttpStatus.CREATED);
    }

}
