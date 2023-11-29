package com.jnu.ticketapi.api.registration.controller;


import com.jnu.ticketapi.api.registration.model.request.FinalSaveRequest;
import com.jnu.ticketapi.api.registration.model.request.TemporarySaveRequest;
import com.jnu.ticketapi.api.registration.model.response.FinalSaveResponseDto;
import com.jnu.ticketapi.api.registration.model.response.TemporarySaveResponse;
import com.jnu.ticketapi.application.port.RegistrationUseCase;
import com.jnu.ticketapi.application.port.UserUseCase;
import com.jnu.ticketapi.common.aop.GetEmail;
import com.jnu.ticketapi.dto.GetRegistrationResponseDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "access-token")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationUseCase registrationUseCase;
    private final UserUseCase userUseCase;

    @GetMapping("/registration")
    public ResponseEntity<GetRegistrationResponseDto> getRegistration(@GetEmail String email) {
        Long userId = userUseCase.findByEmail2(email).getId();
        GetRegistrationResponseDto responseDto = registrationUseCase.getRegistration(userId, email);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/registration/false")
    public ResponseEntity<TemporarySaveResponse> temporarySave(
            @RequestBody TemporarySaveRequest requestDto) {
        TemporarySaveResponse responseDto = registrationUseCase.temporarySave(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/registration/true")
    public ResponseEntity<FinalSaveResponseDto> finalSave(
            @RequestBody FinalSaveRequest requestDto) {
        FinalSaveResponseDto responseDto = registrationUseCase.finalSave(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
