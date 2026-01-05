package com.crudcliente.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class CustomErrorDTO {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
