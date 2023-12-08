package com.jnu.ticketapi.api.captcha.model.response;


import com.jnu.ticketdomain.domains.captcha.domain.CaptchaPending;
import lombok.Builder;

public record CaptchaPendingResponse(Long captchaId, String captchaImageUrl) {
    @Builder
    public CaptchaPendingResponse {}

    private static final String CLOUD_FRONT_URL = "d21f52knjh246f.cloudfront.net/";
    private static final String IMAGE_POSTFIX = ".png";

    public static CaptchaPendingResponse of(CaptchaPending captchaPending) {
        return CaptchaPendingResponse.builder()
                .captchaId(captchaPending.getCaptcha().getId())
                .captchaImageUrl(
                        CLOUD_FRONT_URL
                                + captchaPending.getCaptcha().getImageName()
                                + IMAGE_POSTFIX)
                .build();
    }
}
