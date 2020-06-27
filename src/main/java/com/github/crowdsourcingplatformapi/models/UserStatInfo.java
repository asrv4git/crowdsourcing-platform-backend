package com.github.crowdsourcingplatformapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStatInfo {
    private int registered;
    private int completed;
    private int pending;
    private int failed;
}


