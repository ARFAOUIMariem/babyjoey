package com.example.pok.demo.pok.DTO;


import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ProcessInstanceResponse {
    String processId;
    boolean isEnded;
}
