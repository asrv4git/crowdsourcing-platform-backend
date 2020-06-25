package com.github.crowdsourcingplatformapi.entity;

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


