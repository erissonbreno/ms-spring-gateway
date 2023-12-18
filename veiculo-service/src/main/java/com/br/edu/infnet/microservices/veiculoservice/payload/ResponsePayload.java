package com.br.edu.infnet.microservices.veiculoservice.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsePayload {
    private String message;
    private LocalDateTime timeStamp;
}
