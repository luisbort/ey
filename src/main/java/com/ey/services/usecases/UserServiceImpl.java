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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        //if (usersDB != null || usersDB.)

        List<UserDTO> list = new ArrayList<>();

        usersDB.forEach(c -> {
            UserDTO userDTO = modelMapper.map(c,UserDTO.class);
            list.add(userDTO);

            /*System.out.println("User: " + c.getUserId() + "-" + c.getUserName());
            System.out.println("Phones: " + c.getPhones().size());
            System.out.println("Country: " + c.getPhones().get(0).getCountry().getCountryName());*/
        });

        return list;
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {

        System.out.println("--UserDTO--: " + userDto);

        User userEnt = new User();
        userEnt.setUserName(userDto.getUserName());
        userEnt.setUserMail(userDto.getUserMail());
        userEnt.setUserPasswd(userDto.getUserPasswd());

        userRepository.save(userEnt);

        System.out.println("** userEnt **: " + userEnt);

        UserDTO uDTO = modelMapper.map(userEnt, UserDTO.class);


        userDto.getPhones().stream().forEach(phone -> {

            CityDTO cDto = cityService.findCityByCityCode(phone.getCityCode());
            phone.setCityDTO(cDto);

            CountryDTO countryDTO = countryService.findByCountryCode(phone.getCountryCode());
            phone.setCountryDTO(countryDTO);

            phone.setUserDTO(uDTO);

            phoneService.savePhone(phone);
        });

        return userDto;
    }
}
