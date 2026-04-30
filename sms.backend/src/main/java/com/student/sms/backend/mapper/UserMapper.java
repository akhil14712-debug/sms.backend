package com.student.sms.backend.mapper;

import com.student.sms.backend.entity.UserEntity;
import com.student.sms.backend.io.ProfileRequest;
import com.student.sms.backend.io.ProfileResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    public static UserEntity convetToUserEntity(ProfileRequest profileRequest){

        return UserEntity.builder()
                .email(profileRequest.getEmail())
                .userId(UUID.randomUUID().toString())
                .name(profileRequest.getName())
                .password(profileRequest.getPassword())
                .isAccountVerified(false)
                .resetOtpExpireAt(0L)
                .verifyOtp(null)
                .verifyOtpExpireAt(0L)
                .resetOtp(null)
                .build();

    }

    public static ProfileResponse convertToPofileResponse(UserEntity userEntity){
        return ProfileResponse.builder()
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .userId(userEntity.getUserId())
                .isAccountVerified(userEntity.getIsAccountVerified())
                .build();
    }
}
