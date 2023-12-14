package com.jnu.ticketapi.api.auth.model.request;


import com.jnu.ticketcommon.message.ValidationMessage;
import javax.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ReissueTokenRequest(
        @NotBlank(message = ValidationMessage.MUST_NOT_BLANK) String refreshToken) {}
