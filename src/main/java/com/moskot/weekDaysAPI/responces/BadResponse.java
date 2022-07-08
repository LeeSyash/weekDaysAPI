package com.moskot.weekDaysAPI.responces;

import lombok.Getter;

@Getter
public class BadResponse implements ResponseTemplate {
    private String reason;

    public BadResponse(String reason) {
        this.reason = reason;
    }
}
