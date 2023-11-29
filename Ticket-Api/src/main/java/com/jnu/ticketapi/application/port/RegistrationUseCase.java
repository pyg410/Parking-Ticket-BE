package com.jnu.ticketapi.application.port;


import com.jnu.ticketapi.api.registration.model.request.TemporarySaveRequest;
import com.jnu.ticketapi.api.registration.model.response.TemporarySaveResponse;
import com.jnu.ticketapi.dto.*;
import com.jnu.ticketdomain.domains.registration.domain.Registration;

public interface RegistrationUseCase {
    Registration findByUserId(Long userId);
    GetRegistrationResponseDto getRegistration(Long userId, String email);
    TemporarySaveResponse temporarySave(TemporarySaveRequest requestDto);
    Registration save(Registration registration);
}
