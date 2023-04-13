package com.ey.controllers.user.delete;

import com.ey.controllers.globalapi.ApiMessage;
import com.ey.exceptions.GlobalException;
import com.ey.services.ports.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRemoveController {

    @Autowired
    private UserService userService;

    public UserRemoveController() {
        System.out.println("UserRemoveController Initialized");
    }

    @DeleteMapping(value = "/removeUserByEmail/{email}")
    public ResponseEntity<ApiMessage> removeUserByEmail(@PathVariable String email) throws GlobalException {

        userService.removeUserByEmail(email);
        ApiMessage message = new ApiMessage("SUCCESS");
        return new ResponseEntity<ApiMessage>(message, HttpStatus.CREATED);

    }

}
