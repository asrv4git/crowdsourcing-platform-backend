package com.github.crowdsourcingplatformapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskStatInfo {
    private int active;
    private int inactive;
}
