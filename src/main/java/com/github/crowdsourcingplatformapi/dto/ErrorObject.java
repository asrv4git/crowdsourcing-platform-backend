package com.github.crowdsourcingplatformapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorObject {
    private int status;
    private String message;

    public ErrorObject(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
