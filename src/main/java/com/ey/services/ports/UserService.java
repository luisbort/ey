package com.ey.services.ports;

import com.ey.model.dtos.UserDTO;
import com.ey.exceptions.GlobalException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    public List<UserDTO> findAll();

    public UserDTO createUser(UserDTO userDto) throws GlobalException;

    void removeUserByEmail(String userEmail) throws GlobalException;

    int updateUser(UserDTO userDto) throws GlobalException;

    int updateDateLastLogin(Integer userId) throws GlobalException;
}
