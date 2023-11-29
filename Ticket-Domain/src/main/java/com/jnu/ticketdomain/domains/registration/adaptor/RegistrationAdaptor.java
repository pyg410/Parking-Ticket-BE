package com.jnu.ticketdomain.domains.registration.adaptor;


import com.jnu.ticketcommon.annotation.Adaptor;
import com.jnu.ticketdomain.domains.registration.domain.Registration;
import com.jnu.ticketdomain.domains.registration.out.RegistrationLoadPort;
import com.jnu.ticketdomain.domains.registration.out.RegistrationRecordPort;
import com.jnu.ticketdomain.domains.registration.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adaptor
public class RegistrationAdaptor implements RegistrationLoadPort, RegistrationRecordPort {
    private final RegistrationRepository registrationRepository;

    @Override
    public Registration findByUserId(Long userId) {
        return registrationRepository
                .findByUserId(userId)
                .orElse(null);
    }

    @Override
    public Registration save(Registration registration) {
        return registrationRepository.save(registration);
    }
}
