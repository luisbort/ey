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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        } catch (DataIntegrityViolationException ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new GlobalException("El correo ya registrado");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new GlobalException("DataBase Error");
        }

    }

    @Override
    public void removeUserByEmail(String userEmail) throws GlobalException {

        User uDB = userRepository.findByUserMail(userEmail.toLowerCase());

        if (null != uDB) {
            userRepository.delete(uDB);
        } else {
            throw new GlobalException("User Not Found by Email. Please verify.");
        }
    }

    @Transactional
    @Override
    public int updateUser(UserDTO userDto) throws GlobalException {

        User uDB = userRepository.findByUserMail(userDto.getUserMail());
        if (null != uDB) {
            try {
                return userRepository.updateUser(userDto.getUserName(), userDto.getUserMail(), userDto.getUserPasswd(),
                        Calendar.getInstance().getTime(), uDB.getUserId());
            } catch (Exception e) {
                throw new GlobalException("Error in Database. Please verify.");
            }

        } else {
            throw new GlobalException("User Not Found by Email. Please verify.");
        }
    }

    public User getUserEnt(UserDTO userDto) {
        User userEnt = new User();

        if (null != userDto.getUserName() && !userDto.getUserName().isEmpty())
            userEnt.setUserName(userDto.getUserName());

        if (null != userDto.getUserMail() && !userDto.getUserMail().isEmpty())
            userEnt.setUserMail(userDto.getUserMail().toLowerCase());

        if (null != userDto.getUserPasswd() && !userDto.getUserPasswd().isEmpty())
            userEnt.setUserPasswd(userDto.getUserPasswd());

        if (null == userDto.getDateCreation())
            userEnt.setDateCreation(Calendar.getInstance().getTime());

        userEnt.setDateUpdate(Calendar.getInstance().getTime());

        if (null == userDto.getDateLastLogin())
            userEnt.setDateLastLogin(Calendar.getInstance().getTime());

        if (null == userDto.getIsActive() || userDto.getIsActive().isEmpty())
            userEnt.setIsActive("1");

        if (null == userDto.getUserUuid() || userDto.getUserUuid().isEmpty())
            userEnt.setUserUuid(ToolsUtil.getUuid());

        System.out.println("--userEnt: " + userEnt);

        return userEnt;
    }

}
