package com.ey.controllers.user.create;

import com.ey.controllers.globalapi.ApiMessage;
import com.ey.model.dtos.UserDTO;
import com.ey.exceptions.GlobalException;
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
    private UserService userService;

    public UserCreateController() {
        System.out.println("UserCreateController Initialized");
    }


    @PostMapping(value = "/createUser")
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDto) throws GlobalException {

        UserDTO userCreated = userService.createUser(userDto);
        ApiMessage message = new ApiMessage("SUCCESS");
        return new ResponseEntity<UserDTO>(userCreated, HttpStatus.CREATED);

    }

}
