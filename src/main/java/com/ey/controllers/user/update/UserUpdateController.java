package com.ey.controllers.user.update;

import com.ey.controllers.globalapi.ApiMessage;
import com.ey.exceptions.GlobalException;
import com.ey.model.dtos.UserDTO;
import com.ey.services.ports.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserUpdateController {

    @Autowired
    private UserService userService;

    public UserUpdateController() {
        System.out.println("UserUpdateController Initialized");
    }


    @PostMapping(value = "/updateUser")
    public ResponseEntity<ApiMessage> updateUser(@Valid @RequestBody UserDTO userDto) throws GlobalException {

        int result = userService.updateUser(userDto);
        ApiMessage message = new ApiMessage("SUCCESS");
        return new ResponseEntity<ApiMessage>(message, HttpStatus.CREATED);

    }

}
