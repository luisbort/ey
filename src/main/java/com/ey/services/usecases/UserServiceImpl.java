package com.ey.services.usecases;

import com.ey.domain.dtos.CityDTO;
import com.ey.domain.dtos.CountryDTO;
import com.ey.domain.dtos.UserDTO;
import com.ey.domain.entities.User;
import com.ey.domain.repository.UserRepository;
import com.ey.services.ports.CityService;
import com.ey.services.ports.CountryService;
import com.ey.services.ports.PhoneService;
import com.ey.services.ports.UserService;
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
    public UserDTO createUser(UserDTO userDto) {

        System.out.println("--UserDTO: " + userDto);

        try {

            if (!ValidationUtil.isValidEmail(userDto.getUserMail())) {
                throw new Exception("Email Error");
            }

            if (!ValidationUtil.isValidPassword(userDto.getUserPasswd())) {
                throw new Exception("Passwd Error");
            }

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

            return userDto;

        } catch (Exception e) {
            System.out.println("--ErrorMessage: " + e.getMessage());
            throw new RuntimeException(e);
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

        System.out.println("--userEnt: " + userEnt);

        return userEnt;
    }

}
