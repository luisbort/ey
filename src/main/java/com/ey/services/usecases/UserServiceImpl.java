package com.ey.services.usecases;

import com.ey.exceptions.GlobalException;
import com.ey.model.dtos.CityDTO;
import com.ey.model.dtos.CountryDTO;
import com.ey.model.dtos.UserDTO;
import com.ey.model.entities.User;
import com.ey.model.repository.UserRepository;
import com.ey.services.ports.CityService;
import com.ey.services.ports.CountryService;
import com.ey.services.ports.PhoneService;
import com.ey.services.ports.UserService;
import com.ey.util.ToolsUtil;
import com.ey.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> findAll() {

        Iterable<User> usersDB = userRepository.findAll();
        List<UserDTO> list = new ArrayList<>();
        usersDB.forEach(c -> {
            UserDTO userDTO = modelMapper.map(c, UserDTO.class);
            list.add(userDTO);
        });

        return list;
    }

    @Override
    public UserDTO createUser(UserDTO userDto) throws GlobalException {

        System.out.println("--create User: " + userDto);

        if (!ValidationUtil.isValidEmail(userDto.getUserMail())) {
            throw new GlobalException("Email Error: Is Not Valid Email");
        }

        if (!ValidationUtil.isValidPassword(userDto.getUserPasswd())) {
            throw new GlobalException("Passwd Error: Is Not Valid Password");
        }

        try {

            User uTmp = getUserEnt(userDto);

            userRepository.save(uTmp);

            UserDTO uDTO = modelMapper.map(uTmp, UserDTO.class);

            userDto.getPhones().stream().forEach(phone -> {

                CityDTO cDto = cityService.findCityByCityCode(phone.getCityCode());
                phone.setCityDTO(cDto);

                CountryDTO countryDTO = countryService.findByCountryCode(phone.getCountryCode());
                phone.setCountryDTO(countryDTO);

                phone.setUserDTO(uDTO);

                phoneService.savePhone(phone);
            });

            uDTO.setPhones(userDto.getPhones());
            return uDTO;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error: " + e.getLocalizedMessage());
            throw new GlobalException("DataBase Error");
        }

    }

    public User getUserEnt(UserDTO userDto) {
        User userEnt = new User();
        userEnt.setUserName(userDto.getUserName());
        userEnt.setUserMail(userDto.getUserMail().toLowerCase());
        userEnt.setUserPasswd(userDto.getUserPasswd());
        userEnt.setDateCreation(Calendar.getInstance().getTime());
        userEnt.setDateUpdate(Calendar.getInstance().getTime());
        userEnt.setDateLastLogin(Calendar.getInstance().getTime());
        userEnt.setIsActive("1");
        userEnt.setUserUuid(ToolsUtil.getUuid());

        System.out.println("--userEnt: " + userEnt);

        return userEnt;
    }

}
