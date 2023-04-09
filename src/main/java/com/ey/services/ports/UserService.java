package com.ey.services.ports;

import com.ey.domain.dtos.UserDTO;

import java.util.List;

public interface UserService {

    public List<UserDTO> findAll();

    public UserDTO createUser(UserDTO userDto);
}
