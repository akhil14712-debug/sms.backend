package com.student.sms.backend.service;

import com.student.sms.backend.entity.UserEntity;
import com.student.sms.backend.io.ProfileRequest;
import com.student.sms.backend.io.ProfileResponse;
import com.student.sms.backend.mapper.UserMapper;
import com.student.sms.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {


    private final UserRepository userRepository;
    @Override
    public ProfileResponse createProfile(ProfileRequest profileRequest) {
        UserEntity userEntity = UserMapper.convetToUserEntity(profileRequest);
        return UserMapper.convertToPofileResponse(userRepository.save(userEntity));
    }
}
