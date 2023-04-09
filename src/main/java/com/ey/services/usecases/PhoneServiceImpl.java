package com.ey.services.usecases;

import com.ey.domain.dtos.PhoneDTO;
import com.ey.domain.entities.Phone;
import com.ey.domain.repository.PhoneRepository;
import com.ey.services.ports.PhoneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PhoneDTO savePhone(PhoneDTO phoneDTO) {

        Phone phone = modelMapper.map(phoneDTO, Phone.class);

        phoneRepository.save(phone);

        return phoneDTO;
    }
}
