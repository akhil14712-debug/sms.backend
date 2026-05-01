package com.student.sms.backend.service;

import com.student.sms.backend.entity.UserEntity;
import com.student.sms.backend.io.ProfileRequest;
import com.student.sms.backend.io.ProfileResponse;
import com.student.sms.backend.mapper.UserMapper;
import com.student.sms.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service

@AllArgsConstructor

public class ProfileServiceImpl implements ProfileService {


    private final UserRepository userRepository;

    private final UserMapper userMapper;




    @Override
    public ProfileResponse createProfile(ProfileRequest profileRequest) {
        UserEntity userEntity = userMapper.convetToUserEntity(profileRequest);
        if(!userRepository.existsByEmail(profileRequest.getEmail())){
            return userMapper.convertToPofileResponse(userRepository.save(userEntity));
        }else{
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exist");
        }
    }
}
