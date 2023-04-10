package com.ey.services.ports;

import com.ey.model.dtos.UserDTO;
import com.ey.exceptions.GlobalException;

import java.util.List;

public interface UserService {

    public List<UserDTO> findAll();

    public UserDTO createUser(UserDTO userDto) throws GlobalException;
}
