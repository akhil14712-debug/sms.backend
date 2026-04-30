package com.student.sms.backend.service;

import com.student.sms.backend.io.ProfileRequest;
import com.student.sms.backend.io.ProfileResponse;

public interface ProfileService {

    ProfileResponse createProfile(ProfileRequest profileRequest);
}
